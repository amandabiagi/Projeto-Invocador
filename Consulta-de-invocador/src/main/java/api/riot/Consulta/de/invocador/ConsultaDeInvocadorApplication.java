package api.riot.Consulta.de.invocador;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@EnableFeignClients
@SpringBootApplication
public class ConsultaDeInvocadorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsultaDeInvocadorApplication.class, args);
	}

}
