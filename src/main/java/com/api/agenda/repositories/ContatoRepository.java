package com.api.agenda.repositories;

import com.api.agenda.entities.Contato;
import com.api.agenda.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface ContatoRepository extends JpaRepository<Contato, Long> {
}
