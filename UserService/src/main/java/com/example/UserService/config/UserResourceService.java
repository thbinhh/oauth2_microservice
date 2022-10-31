package com.example.UserService.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

import javax.ws.rs.HttpMethod;

@Configuration
@EnableResourceServer
public class UserResourceService extends ResourceServerConfigurerAdapter {
    private static final String RESOURCE_ID = "user-resource";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID).stateless(false);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.
                anonymous().disable()
                .csrf().disable()
                .cors().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/home").hasAuthority("READ_USER") //phan theo permisson
                .antMatchers("/admin","/users").hasAuthority("ROLE_ADMIN") //phan theo role
                .and().httpBasic()
                .and().formLogin()
                ;
//                .anyRequest().authenticated()


//                .antMatchers(HttpMethod.GET,"/users/**").hasAuthority("read_users")
//                .antMatchers(HttpMethod.POST,"/users/**").hasAuthority("create_user")
//                .antMatchers(HttpMethod.DELETE,"/users/**").hasAuthority("delete_user")
//                .antMatchers(HttpMethod.PUT,"/users/**").hasAuthority("update_user")
//                .anyRequest()
//                .authenticated()
//                .and().exceptionHandling().accessDeniedHandler(new OAuth2AccessDeniedHandler());
    }
}
