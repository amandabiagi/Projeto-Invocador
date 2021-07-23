package api.riot.Consulta.de.invocador.services;
import com.google.gson.Gson;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;


@FeignClient(name = "riotgamesapicampeoes", url = "http://ddragon.leagueoflegends.com")
public interface ApiRiotGamesCampeoes {

    @RequestMapping(value = "/cdn/11.9.1/data/en_US/champion.json")
    String getTodosCampeoes();



}
