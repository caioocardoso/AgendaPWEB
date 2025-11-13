package com.api.agenda.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "contatos")
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String sobrenome;
    private String email;

    @Column(name = "data_criacao")
    private LocalDate dataCriacao;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @OneToMany(mappedBy = "contato", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Telefone> telefones = new ArrayList<>();

    public Contato() {}

    public Contato(String nome, String sobrenome, String email) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.dataCriacao = LocalDate.now();
    }
}
