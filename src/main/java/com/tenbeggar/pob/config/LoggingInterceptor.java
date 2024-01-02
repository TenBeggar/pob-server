package com.tenbeggar.pob.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Objects;
import java.util.StringJoiner;
import java.util.stream.Collectors;

@Slf4j
public class LoggingInterceptor implements ClientHttpRequestInterceptor {

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        displayRequest(request, body);
        ClientHttpResponse response = execution.execute(request, body);
        return displayResponse(response);
    }

    private void displayRequest(HttpRequest request, byte[] body) {
        log.debug("==================== request info ====================");
        log.debug("URI:         {}", request.getURI());
        log.debug("Method:      {}", request.getMethod());
        log.debug("Headers:     {}", headersToString(request.getHeaders()));
        log.debug("Body:        {}", Objects.isNull(body) ? "" : new String(body).getBytes(StandardCharsets.UTF_8));
    }

    private ClientHttpResponse displayResponse(ClientHttpResponse response) throws IOException {
        log.debug("==================== response info ====================");
        log.debug("Status code: {}", response.getStatusCode());
        log.debug("Status text: {}", response.getStatusText());
        log.debug("Headers:     {}", headersToString(response.getHeaders()));
        BufferedClientHttpResponseWrapper bufferedClientHttpResponseWrapper = new BufferedClientHttpResponseWrapper(response);
        log.debug("Body:        {}", httpInputMessageToString(bufferedClientHttpResponseWrapper));
        return bufferedClientHttpResponseWrapper;
    }

    private String headersToString(HttpHeaders httpHeaders) {
        if (Objects.isNull(httpHeaders)) {
            return "[]";
        }
        return httpHeaders.entrySet().stream()
                .map(e -> {
                    List<String> values = e.getValue();
                    return "\"" + e.getKey() + "\" : " + values.stream().map(v -> "\"" + v + "\"").collect(Collectors.joining(", "));
                })
                .collect(Collectors.joining(", \n", "[\n", "\n]"));
    }

    private String httpInputMessageToString(BufferedClientHttpResponseWrapper bufferedClientHttpResponseWrapper) throws IOException {
        StringJoiner stringJoiner = new StringJoiner("\n");
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(bufferedClientHttpResponseWrapper.getBody(), StandardCharsets.UTF_8))) {
            String line;
            while (Objects.nonNull(line = bufferedReader.readLine())) {
                stringJoiner.add(line);
            }
        }
        return stringJoiner.toString();
    }

    private static class BufferedClientHttpResponseWrapper implements ClientHttpResponse {
        private final ClientHttpResponse clientHttpResponse;
        private byte[] body;

        public BufferedClientHttpResponseWrapper(ClientHttpResponse clientHttpResponse) {
            this.clientHttpResponse = clientHttpResponse;
        }

        @Override
        public HttpStatusCode getStatusCode() throws IOException {
            return this.clientHttpResponse.getStatusCode();
        }

        @Override
        public String getStatusText() throws IOException {
            return this.clientHttpResponse.getStatusText();
        }

        @Override
        public void close() {
            this.clientHttpResponse.close();
        }

        @Override
        public InputStream getBody() throws IOException {
            if (Objects.isNull(this.body)) {
                this.body = StreamUtils.copyToByteArray(this.clientHttpResponse.getBody());
            }
            return new ByteArrayInputStream(this.body);
        }

        @Override
        public HttpHeaders getHeaders() {
            return this.clientHttpResponse.getHeaders();
        }
    }
}
