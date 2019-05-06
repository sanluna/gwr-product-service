package com.sanluna;

import com.sanluna.security.principal.GWRTokenConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

@SpringBootApplication
@EnableResourceServer
@Import({BeansAndConfigurations.class})
public class ProductServiceStarter {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceStarter.class, args);
    }

    @Autowired
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    public void setJwtAccessTokenConverter(JwtAccessTokenConverter jwtAccessTokenConverter) {
        JwtAccessTokenConverter tokenConverter = new GWRTokenConverter();
        jwtAccessTokenConverter.setAccessTokenConverter(tokenConverter);
    }

    @Configuration
    public class SecurityConfig extends ResourceServerConfigurerAdapter {

        @Override
        public void configure(HttpSecurity http) throws Exception {
            http
                    .cors().and()
                    .authorizeRequests()
                    .antMatchers(HttpMethod.GET, "/products/**", "/status/**").permitAll()
                    .anyRequest().authenticated();
        }
    }

}
