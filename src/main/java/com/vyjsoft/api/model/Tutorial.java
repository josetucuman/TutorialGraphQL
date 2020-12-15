package com.vyjsoft.api.model;


import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor

@Entity
public class Tutorial {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_tutorial")
    private Integer idTutorial;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false, updatable = false)
    private Author author;

    public Tutorial(String titulo, String descripcion, Author autor){

        this.author = autor;
        this.title = titulo;
        this.description = descripcion;
    }

}
