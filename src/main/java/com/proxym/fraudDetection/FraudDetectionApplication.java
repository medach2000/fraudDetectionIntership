package com.proxym.fraudDetection;

import com.proxym.fraudDetection.entities.ApplicationUser;
import com.proxym.fraudDetection.entities.Role;
import com.proxym.fraudDetection.repositories.AuthUserRepository;
import com.proxym.fraudDetection.repositories.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@ComponentScan({"com.proxym.fraudDetection"})
@EntityScan("com.proxym..fraudDetection.entities")
@EnableJpaRepositories("com.proxym.fraudDetection.repositories")
@SpringBootApplication
public class FraudDetectionApplication {
	Random random= new Random(1000001);
	public static void main(String[] args) {
		SpringApplication.run(FraudDetectionApplication.class, args);
	}
	@Bean
	CommandLineRunner run(RoleRepository roleRepository, AuthUserRepository userRepository, PasswordEncoder passwordEncoder){

		return args ->{
			if(roleRepository.findByAuthority("ADMIN").isPresent()) return;
			Role adminRole = roleRepository.save(new Role("ADMIN"));

			roleRepository.save(new Role("USER"));

			Set<Role> roles=new HashSet<>();
			roles.add(adminRole);


			ApplicationUser admin=new ApplicationUser(1,"admin",passwordEncoder.encode("password"),roles);

			userRepository.save(admin);
		};
	}
}
