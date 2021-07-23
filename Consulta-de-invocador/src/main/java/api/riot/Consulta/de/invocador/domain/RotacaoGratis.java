package api.riot.Consulta.de.invocador.domain;

import java.util.List;

public class RotacaoGratis {

    private List<Integer> freeChampionIds;
    private List<Integer> freeChampionIdsForNewPlayers;
    private Integer maxNewPlayerLevel;

    public RotacaoGratis(List<Integer> freeChampionIds, List<Integer> freeChampionIdsForNewPlayers, Integer maxNewPlayerLevel) {
        this.freeChampionIds = freeChampionIds;
        this.freeChampionIdsForNewPlayers = freeChampionIdsForNewPlayers;
        this.maxNewPlayerLevel = maxNewPlayerLevel;
    }

    public List<Integer> getidCampeoesGratuitos() {
        return freeChampionIds;
    }

    public List<Integer> getidCampeoesGratuitosNovosJogadores() {
        return freeChampionIdsForNewPlayers;
    }

    public void setFreeChampionIds(List<Integer> freeChampionIds) {
        this.freeChampionIds = freeChampionIds;
    }

    public void setFreeChampionIdsForNewPlayers(List<Integer> freeChampionIdsForNewPlayers) {
        this.freeChampionIdsForNewPlayers = freeChampionIdsForNewPlayers;
    }

    public void setMaxNewPlayerLevel(Integer maxNewPlayerLevel) {
        this.maxNewPlayerLevel = maxNewPlayerLevel;
    }

    public Integer getLevelMaximo() {
        return maxNewPlayerLevel;
    }
}
