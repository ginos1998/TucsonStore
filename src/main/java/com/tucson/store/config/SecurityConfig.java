package com.tucson.store.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
@Slf4j
public class SecurityConfig {

  private final String[] publicRequestMatchers = new String[]{
       // resources
      "/css/**", "/js/**", "/img/**", "/scss/**", "/vendor/**",
      // content
      "/register", "/registerUser",
  };

  private final String [] privateRequestMatchers = new String[] {
      "/", "/index", "/adminPage"
  };
  /**
   * Authentication login.
   * @return UserLoginDetailsService object.
   */
  @Bean
  public UserDetailsService userDetailsService() {
    return new UserLoginDetailsService();
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
    return http.csrf()
        .disable()
        .authorizeHttpRequests()
          .requestMatchers(publicRequestMatchers).permitAll()
        .and()
        .authorizeHttpRequests()
          .requestMatchers(privateRequestMatchers)
          .authenticated()
        .and()
        .formLogin()
          .loginPage("/login")
          .permitAll()
        .and()
        .logout()
          .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
          .logoutSuccessUrl("/login")
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

  @Bean
  public AuthenticationProvider authenticationProvider() {
    DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
    authenticationProvider.setUserDetailsService(userDetailsService());
    authenticationProvider.setPasswordEncoder(passwordEncoder());
    return authenticationProvider;
  }
}
