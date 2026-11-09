package courses.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration(proxyBeanMethods = false)
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http, UserDetailsService userDetailsService) {
        http
                .csrf(csrf -> csrf.disable())
                .userDetailsService(userDetailsService)
                .authorizeHttpRequests(
                        registry -> registry
                                .requestMatchers("/api/employees", "/api/employees/*")
                                .hasRole("HR")
                                .requestMatchers("/api/courses", "/api/courses/**")
                                .hasRole("COURSE_ADMIN")
                                .anyRequest()
                                .denyAll()
                )
                .httpBasic(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public UserDetailsService users() {
        var users = User.builder();
        var user = users
                .username("hr")
                .password("{noop}hr")
                .roles("HR")
                .build();
        var admin = users
                .username("courseadmin")
                .password("{noop}courseadmin")
                .roles("COURSE_ADMIN")
                .build();
        return new InMemoryUserDetailsManager(user, admin);
    }


}
