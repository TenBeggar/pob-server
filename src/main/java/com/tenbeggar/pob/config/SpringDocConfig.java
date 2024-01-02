package com.tenbeggar.pob.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(title = "POB API", description = "Player OB server.", version = "0.0.1-SNAPSHOT"),
        servers = @Server(url = "${pob.path}:${server.port}"))
public class SpringDocConfig {
}
