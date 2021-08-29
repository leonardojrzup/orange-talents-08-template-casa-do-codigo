package br.com.leonardo.casadocodigo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


//@ComponentScan(basePackages = {"br.com.leonardo.casadocodigo.repositorio"})
//@ComponentScan(basePackages = {"br.com.leonardo.casadocodigo.repositorio"} )
@SpringBootApplication
public class CasadocodigoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CasadocodigoApplication.class, args);
	}

}
