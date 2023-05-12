package net.aspanc.bootcamp.springmvc.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.httpBasic()
                .and()
                .authorizeRequests()
                .antMatchers("/game/new", "/game/edit/**", "/game/delete/**", "/game/rest/**")
                .hasRole("REGISTERED")
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll();
    }
}
