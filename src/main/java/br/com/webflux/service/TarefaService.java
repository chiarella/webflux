package br.com.webflux.service;

import br.com.webflux.document.Tarefa;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface TarefaService {

    Flux<Tarefa> findAll();

    Mono<Tarefa> findById(String id);

    Mono<Tarefa> save(Tarefa lista);
}
