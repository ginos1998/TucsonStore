package com.tucson.store.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Bean
  public UserDetailsService userDetailsService(PasswordEncoder encoder) {
    UserDetails admin = User.withUsername("gino")
        .password(encoder.encode("demo"))
        .roles("ADMIN")
        .build();

    UserDetails user = User.withUsername("luis")
        .password(encoder.encode("demo"))
        .roles("USER")
        .build();

    return new InMemoryUserDetailsManager(admin, user);
  }

  /**
   * Se define el tipo de autorizacion requerida para permitirle al usuario ver una pagina.
   * En este ejemplo, tenemos
   *  - welcome/home autorizado para toodos
   *  - products/** requiere autorizacion para ingresar.
   *                la expresion '/**' indica todos los path 'hijos'
   * @param http request.
   * @return security filter chain.
   * @throws Exception e.
   */
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http.csrf().disable()
                  .authorizeHttpRequests()
                  .requestMatchers("/home/welcome").permitAll()
                .and()
                  .authorizeHttpRequests()
                  .requestMatchers("products/**")
                  .authenticated()
                .and()
                  .formLogin()
                .and()
                  .build();
  }

  /**
   * Service interface for encoding passwords.
   * The preferred implementation is BCryptPasswordEncoder.
   * @return BCryptPasswordEncoder object.
   */
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
