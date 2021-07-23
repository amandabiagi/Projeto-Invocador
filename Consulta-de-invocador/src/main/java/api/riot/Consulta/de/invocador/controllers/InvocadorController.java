package api.riot.Consulta.de.invocador.controllers;
import api.riot.Consulta.de.invocador.domain.*;
import api.riot.Consulta.de.invocador.domain.DTO.CampeaoDTO;
import api.riot.Consulta.de.invocador.domain.DTO.MaestriaDTO;
import api.riot.Consulta.de.invocador.services.ApiRiotGames;
import api.riot.Consulta.de.invocador.services.CampeaoService;
import api.riot.Consulta.de.invocador.services.MaestriaService;
import api.riot.Consulta.de.invocador.services.RanqueadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping(value = "/invocador")
public class InvocadorController {

    @Autowired
    ApiRiotGames apiRiotGames;

    @Autowired
    RanqueadaService ranqueadaService;

    @Autowired
    MaestriaService maestriaService;

    @Autowired
    CampeaoService campeaoService;

    @GetMapping("nick-name/{nickName}")
    public ResponseEntity getInvocador(@PathVariable String nickName) {
        Invocador invocador = ranqueadaService.getInvocador(nickName);
        return ResponseEntity.ok(invocador);
    }

    @GetMapping("ranqueada-flex/nick-name/{nickName}")
    public ResponseEntity getInvocadorRanqueadaFlex(@PathVariable String nickName) {
        Invocador invocador = ranqueadaService.getInvocador(nickName);
        Ranqueada rF = ranqueadaService.getRanqueadaFlex(invocador.getId());
        if (rF != null) {
            return ResponseEntity.ok(rF);
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("ranqueada-solo-duo/nick-name/{nickName}")
    public ResponseEntity getInvocadorRanqueadaSoloDuo(@PathVariable String nickName) {
        Invocador invocador = ranqueadaService.getInvocador(nickName);
        Ranqueada rF = ranqueadaService.getRanqueadaSoloDuo(invocador.getId());
        if (rF != null) {
            return ResponseEntity.ok(rF);
        }
        return ResponseEntity.noContent().build();

    }

    @GetMapping("maestrias/nick-name/{nickName}")
    public ResponseEntity getTop3Maestrias(@PathVariable String nickName) {
        Invocador invocador = ranqueadaService.getInvocador(nickName);
        List<Maestria> maestrias = maestriaService.getTop3Maestrias(invocador.getId());

        return ResponseEntity.ok(maestrias);
    }

    @GetMapping("todos-campeoes")
    public ResponseEntity getTodosCampeoes() {
        List<CampeaoDTO> todos = campeaoService.todosCampeosDTO();
        System.out.println(todos);
        return ResponseEntity.ok(todos);

    }

    @GetMapping("/todas-maestrias/nickname/{nick}")
    public ResponseEntity getTodasMaestrias(@PathVariable String nick) {
        Invocador invocador = ranqueadaService.getInvocador(nick);
        List<Maestria> maestrias = maestriaService.getMaestrias(invocador.getId());
        return ResponseEntity.ok(maestrias);

    }

    @GetMapping("/baus-disponiveis/nickname/{nick}")
    public ResponseEntity getBausDisponiveis(@PathVariable String nick) {
        Invocador invocador = ranqueadaService.getInvocador(nick);
        List<Maestria> maestrias = maestriaService.getBauDisponivel(invocador.getId());


        return ResponseEntity.ok(MaestriaDTO.converter(maestrias));
    }

}

