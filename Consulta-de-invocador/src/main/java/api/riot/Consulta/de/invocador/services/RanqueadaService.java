package api.riot.Consulta.de.invocador.services;

import api.riot.Consulta.de.invocador.domain.Invocador;
import api.riot.Consulta.de.invocador.domain.Ranqueada;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RanqueadaService {



    @Autowired
    ApiRiotGames apiRiotGames;

    public Integer calcularPorcentagem(Integer vitorias, Integer derrotas) {

        double total = 0.0;
        total = Double.parseDouble(vitorias.toString()) + Double.parseDouble(derrotas.toString());
        total = vitorias / total;
        total = total * 100;

        int totalPorcentagem = (int) total; //Cast

        return totalPorcentagem;
    }

    public Invocador getInvocador(String nome){
        Invocador invocador = apiRiotGames.getInvocador(nome);
        return invocador;
    }


    public Ranqueada getRanqueadaFlex(String id) {
        List<Ranqueada> ranqueadas = apiRiotGames.getInvocadorRanqueada(id);

        Ranqueada rF = null;
        for (Ranqueada r : ranqueadas) {
            if (!r.getTipoFila().equals("RANKED_SOLO_5x5")) {
                rF = r;
            }
        }
        rF.setPorcentagemVitoria(calcularPorcentagem(rF.getVitorias(),rF.getDerrotas()));
        System.out.println(rF.getPorcentagemVitoria());
        return rF;
    }



    public Ranqueada getRanqueadaSoloDuo(String id) {
        List<Ranqueada> ranqueadas = apiRiotGames.getInvocadorRanqueada(id);

        Ranqueada rSD = null;
        for (Ranqueada r : ranqueadas) {
            if (r.getTipoFila().equals("RANKED_SOLO_5x5")) {
                rSD = r;
            }
        }
        rSD.setPorcentagemVitoria(calcularPorcentagem(rSD.getVitorias(),rSD.getDerrotas()));
        System.out.println(rSD.getPorcentagemVitoria());
        return rSD;
    }
}
