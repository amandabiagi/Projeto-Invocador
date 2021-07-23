package api.riot.Consulta.de.invocador.services;
import api.riot.Consulta.de.invocador.domain.Invocador;
import api.riot.Consulta.de.invocador.domain.Maestria;
import api.riot.Consulta.de.invocador.domain.Ranqueada;
import api.riot.Consulta.de.invocador.domain.RotacaoGratis;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.*;
import java.util.List;


@FeignClient(name = "riotgamesapi", url = "https://br1.api.riotgames.com")
public interface ApiRiotGames {

    String key = "X-Riot-Token=RGAPI-5c767b7b-9d20-4990-9a64-a8246cc1c1f7";

    @RequestMapping(value = "/lol/platform/v3/champion-rotations",
            headers = {key})
    RotacaoGratis getRotacaoGratis();


    @RequestMapping(value = "/lol/summoner/v4/summoners/by-name/{summonerName}",
            headers = {key})
    Invocador getInvocador(@PathVariable String summonerName);


    @RequestMapping(value = "/lol/league/v4/entries/by-summoner/{encryptedSummonerId}",
            headers = {key})
    List<Ranqueada> getInvocadorRanqueada(@PathVariable String encryptedSummonerId);


    @RequestMapping(value = "/lol/champion-mastery/v4/champion-masteries/by-summoner/{encryptedSummonerId}",
            headers = {key})
    List<Maestria> getMaestria(@PathVariable String encryptedSummonerId);




}

