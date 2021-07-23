package api.riot.Consulta.de.invocador.domain.DTO;

import api.riot.Consulta.de.invocador.domain.Maestria;

import java.util.List;
import java.util.stream.Collectors;

public class MaestriaDTO {
    private String nomeCampeao;
    private Integer championLevel;
    private Integer championPoints;
    private Boolean chestGranted;

    public MaestriaDTO(Maestria maestria) {
        this.nomeCampeao = maestria.getNomeCampeao();
        this.championLevel = maestria.getChampionLevel();
        this.championPoints = maestria.getChampionPoints();
        this.chestGranted = maestria.getChestGranted();
    }

    public static List<MaestriaDTO> converter(List<Maestria> maestrias) {
        return maestrias.stream()
                .map(MaestriaDTO::new)
                .collect(Collectors
                        .toList());
    }

    public String getNomeCampeao() {
        return nomeCampeao;
    }

    public void setNomeCampeao(String nomeCampeao) {
        this.nomeCampeao = nomeCampeao;
    }

    public Integer getChampionLevel() {
        return championLevel;
    }

    public void setChampionLevel(Integer championLevel) {
        this.championLevel = championLevel;
    }

    public Integer getChampionPoints() {
        return championPoints;
    }

    public void setChampionPoints(Integer championPoints) {
        this.championPoints = championPoints;
    }

    public Boolean getChestGranted() {
        return chestGranted;
    }

    public void setChestGranted(Boolean chestGranted) {
        this.chestGranted = chestGranted;
    }
}
