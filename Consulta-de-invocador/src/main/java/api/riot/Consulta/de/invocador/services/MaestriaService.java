package api.riot.Consulta.de.invocador.services;

import api.riot.Consulta.de.invocador.domain.Campeao;
import api.riot.Consulta.de.invocador.domain.DTO.MaestriaDTO;
import api.riot.Consulta.de.invocador.domain.Maestria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MaestriaService {

    @Autowired
    ApiRiotGames apiRiotGames;
    @Autowired
    CampeaoService campeaoService;

    public List<Maestria> getTop3Maestrias(String id){
        List<Maestria> todas = getNomear(id);
        List<Maestria> top3Maestrias = new ArrayList<>();
            for (Integer contador = 0; contador < 3; contador ++ ) {
                Maestria maestria = todas.get(contador);
                top3Maestrias.add(maestria);
            }
    return top3Maestrias;
    }

    public List<Maestria> getMaestrias(String id) {
        List<Maestria> todasMaestriasComNome = getNomear(id);
        return todasMaestriasComNome;
    }

    public List<Maestria> getBauDisponivel(String id){
        List<Maestria>  todasMaestrias = getMaestrias(id);
        List<Maestria>  bausDisponiveis =
                 todasMaestrias
                         .stream()
                         .filter(maestria -> maestria.getChestGranted() == false)
                         .collect(Collectors.toList());
       return bausDisponiveis;
    }

    public List<Maestria> getNomear(String id) {
        List<Maestria> todasMaestriasComNome = new ArrayList<>();
        List<Maestria> todasMaestrias = apiRiotGames.getMaestria(id);
        List<Campeao> todosCampeoes = campeaoService.todosCampeoes();

        for (Maestria maestria : todasMaestrias) {
            String idCampeao = maestria.getChampionId().toString();
            for (Campeao c : todosCampeoes) {
                if (c.getKey().equals(idCampeao)) {
                    Maestria m1 = new Maestria(c.getName(),
                            maestria.getChampionId(),
                            maestria.getChampionLevel(),
                            maestria.getChampionPoints(),
                            maestria.getChestGranted(),
                            maestria.getTokensEarned(),
                            maestria.getChampionPointsUntilNextLevel(),
                            maestria.getLastPlayTime());
                    todasMaestriasComNome.add(m1);
                }
            }

        }
        return todasMaestriasComNome;
    }

}
