package com.api.agenda.services;

import com.api.agenda.dtos.ContatoDTO;
import com.api.agenda.dtos.UsuarioDTO;
import com.api.agenda.entities.Contato;
import com.api.agenda.repositories.ContatoRepository;
import com.api.agenda.repositories.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ContatoService {
    private ContatoRepository contatoRepository;

    public Contato criarContato(ContatoDTO dadosContato) {
        var contato = new Contato(dadosContato);
        return contatoRepository.save(contato);
    }

    public List<Contato> listarTodos(){
        return contatoRepository.findAll();
    }

}
