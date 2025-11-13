package com.api.agenda.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "contatos")
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String sobrenome;
    private String email;
    private Date dataCriacao;

    @ManyToOne
    @JoinTable(
            name = "contato-usuarios",
            joinColumns = @JoinColumn(name = "usuarios_id"),
            inverseJoinColumns = @JoinColumn(name = "contato_id")
    )
    private Usuario usuario;

    @OneToMany
    @JoinTable(
            name = "contato-telefones",
            joinColumns = @JoinColumn(name = "usuarios_id"),
            inverseJoinColumns = @JoinColumn(name = "contato_id")
    )
    private Telefone telefone;
}
