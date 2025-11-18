package com.api.agenda.entities;

import com.api.agenda.dtos.ContatoDTO;
import com.api.agenda.dtos.TelefoneDTO;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "contatos")
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
    @JsonManagedReference
    private List<Telefone> telefones = new ArrayList<>();

    public Contato() {}

    public Contato(Contato contato) {
        this.id = contato.id;
        this.nome = contato.nome;
        this.sobrenome = contato.sobrenome;
        this.email = contato.email;
        this.dataCriacao = contato.dataCriacao;
        this.usuario = contato.usuario;
        this.telefones = contato.telefones;
    }

    public Contato(ContatoDTO contatoDTO) {
        this.nome = contatoDTO.nome();
        this.email = contatoDTO.email();
        for (TelefoneDTO telefoneDTO : contatoDTO.telefones()) {
            Telefone telefone = new Telefone(telefoneDTO);
            this.telefones.add(telefone);
        }
    }

    public Contato(String nome, String sobrenome, String email) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.dataCriacao = LocalDate.now();
    }

    public void adicionarTelefone(Telefone telefone) {
        telefones.add(telefone);
        telefone.setContato(this);
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }
}
