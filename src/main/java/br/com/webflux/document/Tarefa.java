package br.com.webflux.document;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Tarefa {

    @Id
    private String id;
    private String item;

}
