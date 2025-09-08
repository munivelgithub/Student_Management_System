package com.Munivel.Student_Management.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration // sayint to spring this class is an configuration class
// now we need to say spring security dont go to the default security i want to do this
// configuration in this class
@EnableWebSecurity
public class Security {

  // how to bubass the filter chain
  // now we need an object of security filter chain // build method will give that object of the
  // security filter chain
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    // by default no filetchain applied
    // now how to disable the csrf token
    // http.csrf(customizer -> customizer.disable());
    // but after that without authenticcation it all every one to login
    // to prevent that
    // by sayiing this it will authorized
    // http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
    // but the above line we told that need to autorizese an every request but we are puted our
    // username and password in the post
    // but we are not used that in the configuration class
    // to use that we need to enable the form page for the browse

    // http.formLogin(Customizer.withDefaults());// Customize will pick the form
    // but if you go to the post main hit hte request it will display the form elemtsts
    // to avoid that
    // http.httpBasic(Customizer.withDefaults());

    // how to make http as a stateless
    // http.sessionManagement(
    //        session ->
    //                session.sessionCreationPolicy
    //                        (SessionCreationPolicy.STATELESS));
    // but when you write this line you cannot get login throught the web page, every requeste you
    // need to send an jwt token it will
    // but in postman it is possible
    // now how to make it work on webpage by disable the formlogin  using basic it will display the
    // popup
    // ti will work.

    return http.csrf(customizer -> customizer.disable())
        .authorizeHttpRequests(request -> request.anyRequest())
        .httpBasic(Customizer.withDefaults())
        .sessionManagement(
            session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .build();
    // the http is an security filter chain objiect in tha build method will return
    // the filter chain object
  }

  // now i need to confige the differrnte user authentication
  @Bean
  public UserDetailsService userDetailsService() {
    // how to return different object or user
    UserDetails user1 =
        User.withDefaultPasswordEncoder()
            .username("kiran")
            .password("munivel@123")
            .roles("USER")
            .build(); // this builld will return the obj of user details
    // we can create multiple user

    UserDetails user2 =
        User.withDefaultPasswordEncoder()
            .username("kiran")
            .password("Pradeep@343")
            .roles("USER")
            .build();
    // still we not conneted to database
    return new InMemoryUserDetailsManager(
        user1, user2); // we are simply returning an object i will work it will not r
  }
}
