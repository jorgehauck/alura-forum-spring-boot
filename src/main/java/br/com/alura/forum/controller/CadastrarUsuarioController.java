package br.com.alura.forum.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.config.security.AutenticacaoService;
import br.com.alura.forum.controller.dto.UsuarioDto;
import br.com.alura.forum.modelo.Usuario;

@RestController
@RequestMapping("/cadastrar")
public class CadastrarUsuarioController {

	@Autowired
	private AutenticacaoService autenticacaoService;
	
	@PostMapping
	@Transactional
	public ResponseEntity<UsuarioDto> cadastrarUsuario(@RequestBody UsuarioDto usuarioDto) {
		Usuario user = usuarioDto.converter();
		
		autenticacaoService.cadastrarUsuario(user);
		return ResponseEntity.ok(new UsuarioDto(user));
	}
}
