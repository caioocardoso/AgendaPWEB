package com.api.agenda.dtos;

import com.api.agenda.entities.Telefone;

import java.util.List;

public record ContatoDTO(String nome, String email, List<TelefoneDTO> telefones, UsuarioDTO dadosUsuario) {
}