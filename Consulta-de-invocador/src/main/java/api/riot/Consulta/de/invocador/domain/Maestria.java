package api.riot.Consulta.de.invocador.domain;

public class Maestria {

    private String nomeCampeao;
    private Integer championId;
    private Integer championLevel;
    private Integer championPoints;
    private Boolean chestGranted;
    private Integer tokensEarned;
    private Integer championPointsUntilNextLevel;
    private Long lastPlayTime;

    //"championPointsSinceLastLevel": 189788,

    public Maestria(String nomeCampeao, Integer championId, Integer championLevel, Integer championPoints, Boolean chestGranted, Integer tokensEarned, Integer championPointsUntilNextLevel, Long lastPlayTime) {
        this.nomeCampeao = nomeCampeao;
        this.championId = championId;
        this.championLevel = championLevel;
        this.championPoints = championPoints;
        this.chestGranted = chestGranted;
        this.tokensEarned = tokensEarned;
        this.championPointsUntilNextLevel = championPointsUntilNextLevel;
        this.lastPlayTime = lastPlayTime;
    }

    public String getNomeCampeao() {
        return nomeCampeao;
    }

    public void setNomeCampeao(String nomeCampeao) {
        this.nomeCampeao = nomeCampeao;
    }

    public Integer getChampionId() {
        return championId;
    }

    public void setChampionId(Integer championId) {
        this.championId = championId;
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

    public Integer getTokensEarned() {
        return tokensEarned;
    }

    public void setTokensEarned(Integer tokensEarned) {
        this.tokensEarned = tokensEarned;
    }

    public Integer getChampionPointsUntilNextLevel() {
        return championPointsUntilNextLevel;
    }

    public void setChampionPointsUntilNextLevel(Integer championPointsUntilNextLevel) {
        this.championPointsUntilNextLevel = championPointsUntilNextLevel;
    }

    public Long getLastPlayTime() {
        return lastPlayTime;
    }

    public void setLastPlayTime(Long lastPlayTime) {
        this.lastPlayTime = lastPlayTime;
    }
}