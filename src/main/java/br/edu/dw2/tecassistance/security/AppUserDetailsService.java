package br.edu.dw2.tecassistance.security;

import br.edu.dw2.tecassistance.model.Usuario;
import br.edu.dw2.tecassistance.repository.UsuarioRepository;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class AppUserDetailsService implements UserDetailsService{

	@Autowired
	private UsuarioRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<Usuario> userOptional = userRepository.findByEmail(email);
		Usuario usuario = userOptional.orElseThrow(()-> new UsernameNotFoundException("user or password invalid"));
		return new User(email, usuario.getSenha(), getPermissoes(usuario));
	}

	private Collection<? extends GrantedAuthority> getPermissoes(Usuario usuario) {
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		usuario.getPermissoes().forEach(p-> authorities.add(new SimpleGrantedAuthority(p.getDescription().toUpperCase())));
		return authorities;
	}

}
