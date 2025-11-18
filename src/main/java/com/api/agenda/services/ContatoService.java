package com.api.agenda.services;

import com.api.agenda.dtos.ContatoDTO;
import com.api.agenda.dtos.UsuarioDTO;
import com.api.agenda.entities.Contato;
import com.api.agenda.entities.Telefone;
import com.api.agenda.entities.Usuario;
import com.api.agenda.repositories.ContatoRepository;
import com.api.agenda.repositories.UsuarioRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ContatoService {
    private final ContatoRepository contatoRepository;
    private final UsuarioRepository usuarioRepository;

    public ContatoService(ContatoRepository contatoRepository, UsuarioRepository usuarioRepository) {
        this.contatoRepository = contatoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public Contato criarContato(ContatoDTO dadosContato) {
        Usuario usuario = (Usuario) usuarioRepository.findByUsername(dadosContato.dadosUsuario().username());
        if (usuario == null)
            throw new IllegalArgumentException("Usuário logado não encontrado.");

        Contato contato = new Contato(dadosContato);
        contato.setUsuario(usuario);

        if (contato.getTelefones() != null && !contato.getTelefones().isEmpty()) {
            for (Telefone telefone : contato.getTelefones()) {
                telefone.setContato(contato);
            }
        }

        return contatoRepository.save(contato);
    }

    public List<Contato> listarTodos(){
        return contatoRepository.findAll();
    }

}
