//package com.yejun.app.config;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
//
//@Configuration
//@EnableWebSecurity
//public class AppSecurityConfig {
//	@Autowired
//	private PasswordEncoder passwordEncoder;
//	
//	protected AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//		return authenticationConfiguration.getAuthenticationManager();
//	}
//	
//	protected SecurityFilterChain webSecurityFilterChain(HttpSecurity http) throws Exception {
//		http.cors(cors -> cors.disable()).csrf(csrf -> csrf.disable())
//			.authorizeHttpRequests(auth -> auth.requestMatchers(new AntPathRequestMatcher("/user/**")).permitAll()
//					.requestMatchers(new AntPathRequestMatcher("/")).permitAll()
//					.requestMatchers(new AntPathRequestMatcher("/login")).permitAll()
//					.anyRequest().authenticated());
//		
//		return http.build();
//	}
//}
