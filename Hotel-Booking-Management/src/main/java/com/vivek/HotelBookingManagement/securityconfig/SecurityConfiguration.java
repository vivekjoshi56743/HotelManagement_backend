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
@EnableMethodSecurity(securedEnabled = true,prePostEnabled = true)
public class SecurityConfiguration {
	
	@Autowired
    private UserDetailsService userDetailsService;

    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider
                 = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        return  provider;
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
    	http.csrf().disable();
    	http
        .authorizeHttpRequests()
        	.requestMatchers("/").permitAll()
        	.requestMatchers(HttpMethod.POST,"/hotels/**").hasAuthority("admin")
        	.requestMatchers("/hotels/remove/**").hasAuthority("admin")
            .requestMatchers("/hotels/**").permitAll()
            
            .requestMatchers("room/add").hasAuthority("admin")
            .requestMatchers("/room/delete/**").hasAuthority("admin")
            .requestMatchers("/room/**").permitAll()
            
            .requestMatchers("/user/delete/**").hasAuthority("admin")
            .requestMatchers("user/**").permitAll()
            
            .requestMatchers("/bookings").hasAnyAuthority("admin")
            .requestMatchers("bookings/{booking_id}").hasAnyAuthority("user","admin")
            .requestMatchers("bookings/user/{user_id}").hasAnyAuthority("user","admin")
            .requestMatchers("/bookings/delete/{booking_id}").hasAnyAuthority("admin","user")
            .requestMatchers("/bookings/add").hasAnyAuthority("user","admin")
            .anyRequest().authenticated().and().httpBasic();
        
    return http.build();
    	
    
    }

}
