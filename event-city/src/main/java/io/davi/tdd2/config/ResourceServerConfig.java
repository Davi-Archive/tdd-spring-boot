package io.davi.tdd2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private Environment env;

    @Autowired
    private JwtTokenStore tokenStore;

    private static final String[] PUBLIC =
            {"/oauth/token", "/h2-console/**"};

    private static final String[] PUBLIC_GET =
            {"/cities/**", "/events/**"};

    private static final String[] CLIENT_OR_ADMIN =
            {"/events/**"};

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(tokenStore);
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        if (Arrays.asList(env.getActiveProfiles()).contains("test")) {
            http.headers().frameOptions().disable();
        }

        http.authorizeRequests()
                .antMatchers(PUBLIC).permitAll()
                .antMatchers(HttpMethod.GET, PUBLIC_GET).permitAll()
                .antMatchers(HttpMethod.POST,CLIENT_OR_ADMIN).hasAnyRole("CLIENT", "ADMIN")
                .anyRequest().hasAnyRole("ADMIN");
    }
}
