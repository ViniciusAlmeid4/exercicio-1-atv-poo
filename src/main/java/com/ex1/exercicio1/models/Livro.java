package com.ex1.exercicio1.models;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_livro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titulo_livro")
    private String titulo;

    @Column(name = "autor_livro")
    private String autor;

    private Integer anoPublicacao;
}
