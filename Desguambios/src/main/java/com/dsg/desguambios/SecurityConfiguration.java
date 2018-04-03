package com.dsg.desguambios;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	
	@Autowired
    public DesguaceRepositoryAuthenticationProvider authenticationProvider;
	
	
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
        // Public pages
        http.authorizeRequests().antMatchers("/").permitAll();
        //http.authorizeRequests().antMatchers("/index").permitAll();
        http.authorizeRequests().antMatchers("/pdfFavoritos").permitAll();
        http.authorizeRequests().antMatchers("/login").permitAll();
        http.authorizeRequests().antMatchers("/loginError").permitAll();
        http.authorizeRequests().antMatchers("/registro").permitAll();
        http.authorizeRequests().antMatchers("/nuevoRegistro").permitAll();
        http.authorizeRequests().antMatchers("/registroCorrecto").permitAll();
        http.authorizeRequests().antMatchers("/cache").permitAll();
        
        http.authorizeRequests().antMatchers("/buscadorPrincipal").permitAll();
        http.authorizeRequests().antMatchers("/resultadoBuscador").permitAll();
        
        
        http.authorizeRequests().antMatchers("/favoritos/*").permitAll();
        
        http.authorizeRequests().antMatchers("/guardadoFavorito").permitAll();
        http.authorizeRequests().antMatchers("/resultadoFavoritos").permitAll();
        http.authorizeRequests().antMatchers("/favoritos").permitAll();
        

        // Private pages (all other pages)
        http.authorizeRequests().anyRequest().authenticated();

        // Login form
        http.formLogin().loginPage("/login");
        http.formLogin().usernameParameter("usuario");
        http.formLogin().passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/subirEliminarEditar");
        http.formLogin().failureUrl("/loginError");

        // Logout
        http.logout().logoutUrl("/logout"); 
        http.logout().logoutSuccessUrl("/");
        
    }

    
    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        // Database authentication provider
        auth.authenticationProvider(authenticationProvider);
    }
}
