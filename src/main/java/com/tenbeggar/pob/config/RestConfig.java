package com.tenbeggar.pob.config;

import com.tenbeggar.pob.properties.RiotProperties;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.config.ConnectionConfig;
import org.apache.hc.client5.http.config.RequestConfig;
import org.apache.hc.client5.http.impl.DefaultConnectionKeepAliveStrategy;
import org.apache.hc.client5.http.impl.DefaultHttpRequestRetryStrategy;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.client5.http.impl.io.PoolingHttpClientConnectionManager;
import org.apache.hc.client5.http.socket.ConnectionSocketFactory;
import org.apache.hc.client5.http.socket.PlainConnectionSocketFactory;
import org.apache.hc.client5.http.ssl.SSLConnectionSocketFactory;
import org.apache.hc.core5.http.config.Registry;
import org.apache.hc.core5.http.config.RegistryBuilder;
import org.apache.hc.core5.http.message.BasicHeader;
import org.apache.hc.core5.util.TimeValue;
import org.apache.hc.core5.util.Timeout;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.List;

@Configuration
public class RestConfig {

    @Bean
    public RestTemplate restTemplate(ClientHttpRequestFactory clientHttpRequestFactory) {
        RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
        restTemplate.setInterceptors(List.of(new LoggingInterceptor()));
        return restTemplate;
    }

    @Bean
    public ClientHttpRequestFactory clientHttpRequestFactory(HttpClient httpClient) {
        return new HttpComponentsClientHttpRequestFactory(httpClient);
    }

    @Bean
    public HttpClient httpClient(RiotProperties riotProperties) {
        Registry<ConnectionSocketFactory> registry = RegistryBuilder.<ConnectionSocketFactory>create()
                .register("http", PlainConnectionSocketFactory.getSocketFactory())
                .register("https", SSLConnectionSocketFactory.getSocketFactory())
                .build();
        //配置Connection
        ConnectionConfig connectionConfig = ConnectionConfig.custom()
                .setConnectTimeout(Timeout.of(Duration.ofMinutes(2)))//客户端和服务器建立TCP连接（三次握手）的超时时间，超时抛异常
                .setSocketTimeout(Timeout.of(Duration.ofSeconds(5)))//已经建立TCP连接，等待两个数据包之间的间隔，超时抛异常
                .setValidateAfterInactivity(TimeValue.ofMinutes(20))//空闲连接的过期时间
                .build();
        //配置Http连接池
        PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager(registry);
        poolingHttpClientConnectionManager.setMaxTotal(500);//最大连接数
        poolingHttpClientConnectionManager.setDefaultMaxPerRoute(100);//同路由（域名）最大连接数（并发数）
        poolingHttpClientConnectionManager.setDefaultConnectionConfig(connectionConfig);
        //配置Request
        RequestConfig requestConfig = RequestConfig.custom()
                .setResponseTimeout(Timeout.of(Duration.ofSeconds(30)))//等待服务器响应(response)的时间，超时抛异常
                .setConnectionRequestTimeout(Timeout.of(Duration.ofMinutes(3)))//从连接池获取连接的时间，超时抛异常 org.apache.http.conn.ConnectionPoolTimeoutException: Timeout waiting for connection from pool
                .build();
        //设置默认请求头
        List<BasicHeader> headers = List.of(
                //Accept-Charset
                new BasicHeader("Accept-Charset", "application/json; charset=UTF-8"),
                //Riot Token
                new BasicHeader("X-Riot-Token", riotProperties.getToken())
        );
        //创建Http连接工厂
        return HttpClientBuilder.create()
                .setDefaultRequestConfig(requestConfig)
                .setConnectionManager(poolingHttpClientConnectionManager)
                .setDefaultHeaders(headers)
                .setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy())//保持长连接设置，需要在请求头添加 Keep-Alive
                .setRetryStrategy(new DefaultHttpRequestRetryStrategy(3, TimeValue.ofSeconds(5)))//失败重试策略，重试3次，每次间隔2秒
                .build();
    }
}
