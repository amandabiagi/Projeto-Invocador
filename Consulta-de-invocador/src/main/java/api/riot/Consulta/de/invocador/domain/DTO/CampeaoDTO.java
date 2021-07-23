package api.riot.Consulta.de.invocador.domain.DTO;

import api.riot.Consulta.de.invocador.domain.Campeao;
import api.riot.Consulta.de.invocador.domain.Image;
import api.riot.Consulta.de.invocador.domain.Info;

import java.util.List;
import java.util.stream.Collectors;

public class CampeaoDTO {

    private String key;
    private String name;
    private List<String> tags;

    public CampeaoDTO(Campeao campeao) {
        this.key = campeao.getKey();
        this.name = campeao.getName();
        this.tags = campeao.getTags();
    }

    public static List<CampeaoDTO> converter(List<Campeao> listaCampeoes) {
            return listaCampeoes.stream().map(CampeaoDTO::new).collect(Collectors.toList());
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
