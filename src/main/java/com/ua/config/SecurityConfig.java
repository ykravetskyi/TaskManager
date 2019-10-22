package com.ua.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.provisioning.InMemoryUserDetailsManagerConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@ComponentScan("com.ua")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    @Qualifier("userServiceImpl")
    private UserDetailsService userDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }


    private InMemoryUserDetailsManagerConfigurer<AuthenticationManagerBuilder> inMemoryConfigurer() {
        return new InMemoryUserDetailsManagerConfigurer<>();
    }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder manager,
                                AuthenticationProvider provider) throws Exception {

        inMemoryConfigurer()
                .withUser("admin")
                .password("admin")
                .roles("ADMIN")
                .and()
                .configure(manager);
        manager.authenticationProvider(provider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/login").anonymous()
                .antMatchers("/registration").anonymous()
                .antMatchers("/").hasAnyRole("USER", "ADMIN")
                .antMatchers("/home").hasAnyRole("USER", "ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .successForwardUrl("/login")
                .defaultSuccessUrl("/home")
                .and()
                .logout().permitAll().logoutUrl("/logout").logoutSuccessUrl("/login")
                .and()
                .csrf();
    }
}