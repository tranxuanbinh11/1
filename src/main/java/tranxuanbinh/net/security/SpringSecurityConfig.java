package tranxuanbinh.net.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class SpringSecurityConfig {

	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.csrf((csrf) -> csrf.disable())

                .authorizeHttpRequests((authorize) ->

                        authorize

                                .requestMatchers("/").permitAll()

//                                .requestMatchers("/webjars/**", "/assets/**").permitAll()

//                                .requestMatchers("/product").hasAnyAuthority("USER", "ADMIN")

                                .requestMatchers("/product/view").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")

                                .requestMatchers("/product/addnew").hasAuthority("ROLE_ADMIN")

                                .requestMatchers("/product/save").hasAuthority("ROLE_ADMIN")

                                .requestMatchers("/shoppingcart").hasAuthority("ROLE_USER,ROLE_ADMIN")

                                .requestMatchers("/shoppingcart/view").hasAnyAuthority("ROLE_ADMIN", "ROLE_USER")

                                .requestMatchers("/shoppingcart/add/**").hasAuthority("ROLE_USER")

                                .requestMatchers("/shoppingcart/clear").hasAuthority("ROLE_USER")

                                .requestMatchers("/shoppingcart/remove/**").hasAuthority("ROLE_USER")

                                .requestMatchers("/shoppingcart/update").hasAuthority("ROLE_USER")

                                .anyRequest().authenticated()




                ).formLogin(

                        form -> form

                                .loginPage("/login")

                                .loginProcessingUrl("/login")

                                .defaultSuccessUrl("/welcome")

                                .permitAll()

                ).logout(

                        logout -> logout

                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))

                                .permitAll()

                );

        return http.build();

    }
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}
}
