package br.com.alura.forum.config.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.alura.forum.modelo.Usuario;
import br.com.alura.forum.repository.UsuarioRepository;

@Service
public class AutenticacaoService implements UserDetailsService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired    
	private PasswordEncoder encoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<Usuario> usuario = usuarioRepository.findByEmail(username);
		if(usuario.isPresent()) {
			return usuario.get();
		}	
		throw new UsernameNotFoundException("Dados inválidos!");
	}
	
	public UserDetails cadastrarUsuario(Usuario usuario) throws UsernameNotFoundException {
		Optional<Usuario> user = usuarioRepository.findByEmail(usuario.getEmail());
		
		if(user.isEmpty()) {
			Usuario u = new Usuario();
			u.setEmail(usuario.getEmail());
			u.setNome(usuario.getNome());
			u.setSenha(encoder.encode(usuario.getSenha()));
			usuarioRepository.save(u);
			return u;
		}	
		throw new UsernameNotFoundException("Usuário existente");
	}
}
