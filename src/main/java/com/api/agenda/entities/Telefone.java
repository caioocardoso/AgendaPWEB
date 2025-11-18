package com.api.agenda.entities;

import com.api.agenda.dtos.TelefoneDTO;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity(name = "telefones")
public class Telefone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String numero;
    private CategoriaTelefone categoria;
    private Boolean principal;

    @ManyToOne
    @JoinColumn(name = "contato_id")
    @JsonBackReference
    private Contato contato;

    Telefone(){}

    Telefone(TelefoneDTO telefoneDTO){
        this.numero = telefoneDTO.numero();
        this.categoria = telefoneDTO.categoria();
        this.principal = telefoneDTO.principal();
    }

    public void setContato(Contato contato){
        this.contato = contato;
    }
}
