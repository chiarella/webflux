package br.com.webflux.config;

import br.com.webflux.document.Tarefa;
import br.com.webflux.service.TarefaService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.ok;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;



@Component
public class TarefaHandler {

    private final TarefaService tarefaService;
    public TarefaHandler(TarefaService tarefaService) {
        this.tarefaService = tarefaService;
    }

    //Implementado o Find All - pega a toda a lista e devolve em um elemento

    public Mono<ServerResponse> findAll(ServerRequest request) {
    return ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(tarefaService.findAll(), Tarefa.class);
    }

    public Mono<ServerResponse> findById(ServerRequest request) {
        String id = request.pathVariable("id");
    return ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(tarefaService.findById(id), Tarefa.class);
    }

    public Mono<ServerResponse> save(ServerRequest request) {
        final Mono<Tarefa> tarefa = request.bodyToMono(Tarefa.class);
    return ok()
            .contentType(MediaType.APPLICATION_JSON)
            .body(fromPublisher(tarefa.flatMap(tarefaService::save), Tarefa.class));
    }
}
