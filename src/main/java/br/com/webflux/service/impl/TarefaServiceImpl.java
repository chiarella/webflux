package br.com.webflux.service.impl;

import br.com.webflux.document.Tarefa;
import br.com.webflux.repository.TarefaRepository;
import br.com.webflux.service.TarefaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class TarefaServiceImpl implements TarefaService {

    private final TarefaRepository repository;

    @Override
    public Flux<Tarefa> findAll() {
        return repository.findAll();
    }

    @Override
    public Mono<Tarefa> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public Mono<Tarefa> save(Tarefa lista) {
        return repository.save(lista);
    }
}
