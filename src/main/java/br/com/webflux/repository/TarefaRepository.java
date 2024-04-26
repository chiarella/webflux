package br.com.webflux.repository;

import br.com.webflux.document.Tarefa;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TarefaRepository extends ReactiveMongoRepository<Tarefa, String> {


}
