package com.vivek.HotelBookingManagement.securityconfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
//(securedEnabled = true,prePostEnabled = true)
public class SecurityConfiguration {

	@Autowired
	private UserDetailsService userDetailsService;

	@Bean
	AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(new BCryptPasswordEncoder());
		return provider;
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//    	http.authorizeHttpRequests()
//        .requestMatchers( "/hotel/**")
//        .permitAll()
//        .anyRequest()
//        .authenticated()
//        .and()
//        .httpBasic();
//    	
//    	return http.build();

//    	System.out.println("filterchain executed");
//    	
		http.cors().disable();

		http.csrf().disable();
		http.authorizeHttpRequests()
			.requestMatchers("/").permitAll()
			.requestMatchers(HttpMethod.POST, "/hotels/**").hasAuthority("admin")
			.requestMatchers(HttpMethod.DELETE,"/hotels/remove/**").hasAuthority("admin")
			.requestMatchers("/hotels/**").permitAll()

			.requestMatchers(HttpMethod.POST,"room/add").hasAuthority("admin")
			.requestMatchers(HttpMethod.DELETE,"/room/delete/**").hasAuthority("admin")
			.requestMatchers("/room/**").permitAll()
			
			
			.requestMatchers(HttpMethod.DELETE,"/user/delete/**").hasAuthority("admin")
			.requestMatchers(HttpMethod.GET,"/user").hasAuthority("admin")
			.requestMatchers("user/**").permitAll()

			

			.requestMatchers(HttpMethod.GET,"/bookings/all").hasAuthority("admin")
			.requestMatchers(HttpMethod.POST,"/bookings/add").hasAuthority("user")
//			.requestMatchers(HttpMethod.GET,"/bookings/id/{booking_id}").hasAuthority("admin")
			.requestMatchers(HttpMethod.GET,"/bookings/user/{user_id}").hasAuthority("user")
			.requestMatchers(HttpMethod.DELETE,"/bookings/delete/{booking_id}").hasAnyAuthority("admin","user")
			.requestMatchers("/bookings/**").permitAll()

			.requestMatchers("/login").permitAll()
			.anyRequest().authenticated().and().httpBasic();

		return http.build();

	}

}
