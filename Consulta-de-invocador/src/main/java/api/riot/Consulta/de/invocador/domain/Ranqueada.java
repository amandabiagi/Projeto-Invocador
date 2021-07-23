package api.riot.Consulta.de.invocador.domain;

public class Ranqueada {

        private String leagueId;
        private String queueType;
        private String tier;
        private String rank;
        private String summonerId;
        private String summonerName;
        private Integer leaguePoints;
        private Integer wins;
        private Integer losses;
        private Integer porcentagemVitoria;


    public Ranqueada(
                     String queueType,
                     String tier,
                     String rank,
                     String summonerName,
                     Integer leaguePoints,
                     Integer wins,
                     Integer losses,
                     Integer porcentagemVitoria
                     ) {
        this.queueType = queueType;
        this.tier = tier;
        this.rank = rank;
        this.summonerName = summonerName;
        this.leaguePoints = leaguePoints;
        this.wins = wins;
        this.losses = losses;
        this.porcentagemVitoria = porcentagemVitoria;
    }


        public String getTipoFila() {
            return queueType;
        }

        public void setQueueType(String queueType) {
            this.queueType = queueType;
        }

        public String getElo() {
            return tier;
        }

        public void setTier(String tier) {
            this.tier = tier;
        }

        public String getClassificacao() {
            return rank;
        }

        public void setRank(String rank) {
            this.rank = rank;
        }


        public String getNomeInvocador() {
            return summonerName;
        }

        public void setSummonerName(String summonerName) {
            this.summonerName = summonerName;
        }

        public Integer getPontosDaLiga() {
            return leaguePoints;
        }

        public void setLeaguePoints(Integer leaguePoints) {
            this.leaguePoints = leaguePoints;
        }

        public Integer getVitorias() {
            return wins;
        }

        public void setWins(Integer wins) {
            this.wins = wins;
        }

        public Integer getDerrotas() {
            return losses;
        }

        public void setLosses(Integer losses) {
            this.losses = losses;
        }

        public Integer getPorcentagemVitoria() {
            return porcentagemVitoria;
        }

        public void setPorcentagemVitoria(Integer porcentagemVitoria) {
            this.porcentagemVitoria = porcentagemVitoria;
        }
}
