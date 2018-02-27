package com.dsg.desguambios;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        
    	// Public pages
        http.authorizeRequests().antMatchers("/index").permitAll();
        http.authorizeRequests().antMatchers("/login").permitAll();
        http.authorizeRequests().antMatchers("/loginError").permitAll();
        //http.authorizeRequests().antMatchers("/logout").permitAll();
        http.authorizeRequests().antMatchers("/registro").permitAll();
        http.authorizeRequests().antMatchers("/registroCorrecto").permitAll();
        http.authorizeRequests().antMatchers("/guardadoFavorito").permitAll();
        http.authorizeRequests().antMatchers("/resultadoFavorito").permitAll();

        // Private pages (all other pages)
        http.authorizeRequests().anyRequest().authenticated();

        // Login form
        http.formLogin().loginPage("/login");
        http.formLogin().usernameParameter("usuario");
        http.formLogin().passwordParameter("password");
        http.formLogin().defaultSuccessUrl("/subirEliminarEditar");
        http.formLogin().failureUrl("/loginError");

        // Logout
        http.logout().logoutUrl("/logout");  //Falta por poner el campo logoout con el boton correspondiente de deslogarse, en los html que queramos que habiliten esa opcion
        http.logout().logoutSuccessUrl("/index");
        
        // Disable CSRF at the moment
        http.csrf().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        
    	// User
        auth.inMemoryAuthentication().withUser("user").password("pass").roles("USER");
        auth.inMemoryAuthentication().withUser("Pepe").password("pepe").roles("USER");
    }

}
