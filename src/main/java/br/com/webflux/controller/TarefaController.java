package br.com.webflux.controller;

import br.com.webflux.document.Tarefa;
import br.com.webflux.service.TarefaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//@RestController
//@RequestMapping(value = "/api/v1/tarefa")
@RequiredArgsConstructor
public class TarefaController {

    private final TarefaService tarefaService;

    @GetMapping(value = "/tarefa")
    public Flux<Tarefa> getTarefas(){
    return tarefaService.findAll(); }

    @GetMapping(value = "/{id}")
    public Mono<Tarefa> getTarefaId(@PathVariable String id){
    return tarefaService.findById(id); }

    @PostMapping(value = "/tarefa")
    public Mono<Tarefa> save(@RequestBody Tarefa tarefa) {
    return tarefaService.save(tarefa); }

}

