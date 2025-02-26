//package container.therapy;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class SecurityConfig {
//
//	@Bean
//	public PasswordEncoder passwordEncoder() {
//		return new BCryptPasswordEncoder();
//	}
//
//	@Bean
//	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		http.csrf(csrf -> csrf.disable()) // Disable CSRF
//				.authorizeHttpRequests(auth -> auth.requestMatchers("/register").permitAll() // Allow public access to
//																								// /register
//						.anyRequest().authenticated() // Secure other endpoints
//				);
//
//		return http.build();
//	}
//}

//		user.setUserPassword(passwordEncoder.encode(password));

//		<dependency>
//    		<groupId>org.springframework.boot</groupId>
//    		<artifactId>spring-boot-starter-security</artifactId>
//		</dependency>

//  security:
//    user:
//      name: admin
//      password: admin123
//    

// Class, dependency and use to be included later