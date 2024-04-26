package br.com.webflux.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class TarefaRouter {

    @Bean
    public RouterFunction<ServerResponse> route(TarefaHandler tarefaHandler) {
    return RouterFunctions
            .route(GET("/tarefa").and(accept(MediaType.APPLICATION_JSON)), tarefaHandler::findAll)
            .andRoute(GET("/tarefa/{id}").and(accept(MediaType.APPLICATION_JSON)), tarefaHandler::findById)
            .andRoute(POST("/tarefa").and(accept(MediaType.APPLICATION_JSON)), tarefaHandler::save);
    }

}
