package com.api.agenda.dtos;

import com.api.agenda.entities.CategoriaTelefone;

public record TelefoneDTO(String numero, CategoriaTelefone categoria, Boolean principal) {
}
