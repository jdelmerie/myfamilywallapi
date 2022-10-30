package fr.delmerie.familywallapi;

import fr.delmerie.familywallapi.entities.Role;
import fr.delmerie.familywallapi.services.impl.RoleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class FamilywallapiApplication implements CommandLineRunner {

	@Autowired
	RoleServiceImpl roleService;


	public static void main(String[] args) {
		SpringApplication.run(FamilywallapiApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("BACK BIEN EN ROUTE");
		Role admin = roleService.save(new Role(null, "ADMIN"));
		Role user = roleService.save(new Role(null, "USER"));
	}
}
