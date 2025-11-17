package com.api.agenda.controllers;

import com.api.agenda.dtos.ContatoDTO;
import com.api.agenda.dtos.LoginDTO;
import com.api.agenda.dtos.TokenDTO;
import com.api.agenda.dtos.UsuarioDTO;
import com.api.agenda.entities.Contato;
import com.api.agenda.entities.Usuario;
import com.api.agenda.services.ContatoService;
import com.api.agenda.services.JWTokenService;
import com.api.agenda.services.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contatos")
public class ContatoController {

	private AuthenticationManager manager;
	private ContatoService service;
	private JWTokenService tokenService;

	public ContatoController(AuthenticationManager manager, JWTokenService tokenService, ContatoService service) {
		this.manager = manager;
		this.tokenService = tokenService;
		this.service = service;
	}

	@PostMapping
	public ResponseEntity criarContato(@RequestBody ContatoDTO dadosContato) {
		var contato = service.criarContato(dadosContato);
		return ResponseEntity.ok(contato);
	}

	@GetMapping
	public List<Contato> listarContatos(){
		return service.listarTodos();
	}
	
}