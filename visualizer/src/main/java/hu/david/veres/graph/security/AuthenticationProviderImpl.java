package hu.david.veres.graph.security;

import hu.david.veres.graph.dto.UserDTO;
import hu.david.veres.graph.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuthenticationProviderImpl implements AuthenticationProvider {

	@Autowired
	private UserService userService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {

		String username = authentication.getName();
		String password = authentication.getCredentials().toString();

		UserDTO userDTO = userService.getUserByUsername(username);

		if (userDTO == null) {
			throw new BadCredentialsException("Invalid username or password!");
		}

		if (!bCryptPasswordEncoder.matches(password, userDTO.getPassword())) {
			throw new BadCredentialsException("Invalid username or password!");
		}

		return new UsernamePasswordAuthenticationToken(username, password, simpleUserAuthorities());

	}

	@Override
	public boolean supports(Class<?> aClass) {
		return aClass.equals(UsernamePasswordAuthenticationToken.class);
	}

	private List<SimpleGrantedAuthority> simpleUserAuthorities() {

		List<SimpleGrantedAuthority> simpleGrantedAuthorities = new ArrayList<>();

		simpleGrantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));

		return simpleGrantedAuthorities;

	}

}
