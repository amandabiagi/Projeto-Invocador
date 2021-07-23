package api.riot.Consulta.de.invocador.controllers;
import api.riot.Consulta.de.invocador.domain.RotacaoGratis;
import api.riot.Consulta.de.invocador.services.ApiRiotGames;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/rotacao-gratis")
public class RotacaoGratisController {

    @Autowired
    ApiRiotGames apiRiotGames;

    @GetMapping
    public ResponseEntity consultarRotacao(){
        RotacaoGratis campeoesGratuitos = apiRiotGames.getRotacaoGratis();
        return ResponseEntity.ok(campeoesGratuitos);

    }
}
