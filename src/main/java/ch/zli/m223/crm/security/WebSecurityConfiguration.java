package ch.zli.m223.crm.security;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import ch.zli.m223.crm.role.Roles;

@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
	UserDetailsService userDetailsService;
	BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		configureWeb(http);
		//configureRest(http);
	}

	private void configureRest(HttpSecurity http) throws Exception{
		http
			.csrf().disable()
			.cors().disable()
			.sessionManagement()
		;
	}

	private void configureWeb(HttpSecurity http) throws Exception{
		http.authorizeRequests()
			.antMatchers("/**").permitAll()
			.antMatchers("/web/users").hasAuthority(Roles.ADMIN)
			.anyRequest().authenticated()
		;
	}
}
