package br.com.webflux.config;

import br.com.webflux.document.Tarefa;
import br.com.webflux.repository.TarefaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Component
public class CarregaBanco implements CommandLineRunner {

	private final TarefaRepository tarefaRepository;

    private CarregaBanco(TarefaRepository tarefaRepository) {
        this.tarefaRepository = tarefaRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        tarefaRepository.deleteAll()
                .thenMany(
                        Flux.just("Ir ao correio",
                                        "Ir ao mercado",
                                        "Ir a farmacia",
                                        "Ir ao shopping",
                                        "Ir ao cinema",
                                        "Ir a academia",
                                        "Ir ao trabalho")
                                .map(item -> new Tarefa(UUID.randomUUID().toString(), item))
                                .flatMap(tarefaRepository::save))
                .subscribe(System.out::println);
    }
}