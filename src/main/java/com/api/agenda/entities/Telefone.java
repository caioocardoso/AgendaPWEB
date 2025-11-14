package com.api.agenda.entities;

import jakarta.persistence.*;

@Entity(name = "telefones")
public class Telefone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;
    private CategoriaTelefone categoria;
    private Boolean principal;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contato_id", nullable = false)
    private Contato contato;

    public void setContato(Contato contato){
        this.contato = contato;
    }

}
