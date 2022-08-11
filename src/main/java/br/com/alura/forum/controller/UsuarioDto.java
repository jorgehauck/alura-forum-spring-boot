package br.com.alura.forum.controller;

import br.com.alura.forum.modelo.Usuario;

public class UsuarioDto {

	
	private String nome;
	private String email;
	private String senha;
	
	public UsuarioDto() {}
	
	public UsuarioDto(String nome, String email, String senha) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	public UsuarioDto(Usuario usuario) {
		this.nome = usuario.getNome();
		this.email = usuario.getEmail();
		this.senha = usuario.getSenha();
	}
	
	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public Usuario converter() {
		Usuario user = new Usuario();
		user.setNome(nome);
		user.setEmail(email);
		user.setSenha(senha);
		return user;
	}
}
