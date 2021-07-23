package api.riot.Consulta.de.invocador.services;
import api.riot.Consulta.de.invocador.domain.*;
import api.riot.Consulta.de.invocador.domain.DTO.CampeaoDTO;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import org.apache.tomcat.util.json.JSONParser;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class CampeaoService {

    @Autowired
    ApiRiotGames apiRiotGames;

    @Autowired
    ApiRiotGamesCampeoes apiRiotGamesCampeoes;



    public List<Campeao> todosCampeoes() {
        String todos = apiRiotGamesCampeoes.getTodosCampeoes();
        JSONObject campeoes = new JSONObject(todos);
        JSONObject chave = campeoes.getJSONObject("data");
        List<Campeao> listaDeCampeoes = new ArrayList<>();
        for (String cString : chave.keySet()) {
            //cString Lê cada campeão dentro da chave "data" como String
            //Para extrair esse campeão como um objeto devemos usar o JSONObject

            try {
                JSONObject campeaoObj = chave.getJSONObject(cString);

                System.out.println(campeaoObj);
                //Para cada Objeto criei uma classe e mapeei os dados

                Info info = new Info(
                        campeaoObj.getJSONObject("info").getInt("attack"),
                        campeaoObj.getJSONObject("info").getInt("defense"),
                        campeaoObj.getJSONObject("info").getInt("magic"),
                        campeaoObj.getJSONObject("info").getInt("difficulty")
                );

                Image image = new Image(campeaoObj.getJSONObject("image").getString("full"),
                        campeaoObj.getJSONObject("image").getString("sprite"),
                        campeaoObj.getJSONObject("image").getString("group"),
                        campeaoObj.getJSONObject("image").getInt("x"),
                        campeaoObj.getJSONObject("image").getInt("y"),
                        campeaoObj.getJSONObject("image").getInt("w"),
                        campeaoObj.getJSONObject("image").getInt("h")
                );

                Stats stats = new Stats(
                        campeaoObj.getJSONObject("stats").getInt("hp"),
                        campeaoObj.getJSONObject("stats").getInt("hpperlevel"),
                        campeaoObj.getJSONObject("stats").getInt("mp"),
                        campeaoObj.getJSONObject("stats").getInt("mpperlevel"),
                        campeaoObj.getJSONObject("stats").getInt("movespeed"),
                        campeaoObj.getJSONObject("stats").getInt("armor"),
                        campeaoObj.getJSONObject("stats").getDouble("armorperlevel"),
                        campeaoObj.getJSONObject("stats").getInt("spellblock"),
                        campeaoObj.getJSONObject("stats").getDouble("spellblockperlevel"),
                        campeaoObj.getJSONObject("stats").getInt("attackrange"),
                        campeaoObj.getJSONObject("stats").getInt("hpregen"),
                        campeaoObj.getJSONObject("stats").getInt("hpregenperlevel"),
                        campeaoObj.getJSONObject("stats").getInt("mpregen"),
                        campeaoObj.getJSONObject("stats").getInt("mpregenperlevel"),
                        campeaoObj.getJSONObject("stats").getInt("crit"),
                        campeaoObj.getJSONObject("stats").getInt("critperlevel"),
                        campeaoObj.getJSONObject("stats").getInt("attackdamage"),
                        campeaoObj.getJSONObject("stats").getInt("attackdamageperlevel"),
                        campeaoObj.getJSONObject("stats").getDouble("attackspeedperlevel"),
                        campeaoObj.getJSONObject("stats").getDouble("attackspeed")
                );



                List<String> campeoesList = new ArrayList<>();

                for (Object tag : campeaoObj.getJSONArray("tags")) {
                    campeoesList.add(tag.toString());
                }

                Campeao campeao = new Campeao(
                        campeaoObj.getString("version"),
                        campeaoObj.getString("id"),
                        campeaoObj.getString("key"),
                        campeaoObj.getString("name"),
                        campeaoObj.getString("title"),
                        campeaoObj.getString("blurb"),
                        info,
                        image,
                        campeoesList,
                        campeaoObj.getString("partype"),
                        stats
                );

                listaDeCampeoes.add(campeao);

            } catch (NullPointerException e){
                System.out.println("-------Erro-------\n" + e.toString());
            }
        }

        return listaDeCampeoes;
    }

    public List<CampeaoDTO> todosCampeosDTO(){
        List<Campeao> todos = todosCampeoes();
        return CampeaoDTO.converter(todos);

    }

//    public List<CampeaoDTO> retornarCampeao(){
//        String todos = apiRiotGamesCampeoes.getTodosCampeoes();
//        JSONObject campeos = new JSONObject(todos);
//        JSONObject chave = campeos.getJSONObject("data");
//        List<Campeao> listaCampeoes = new ArrayList<>();
//
//        for (String c: chave.keySet()){
//            JSONObject campeaoObj = chave.getJSONObject(c);
//            Campeao campeao;
//            campeao = new Campeao(campeaoObj.getString("name"),campeaoObj.getString("key"));
//            listaCampeoes.add(campeao);
//        }
//
//        return CampeaoDTO.converter(listaCampeoes);
//    }

    public Campeao buscarPorId(String id){
        List<Campeao> todosCampeoes = todosCampeoes();
        Campeao campeao = new Campeao();
        for (Campeao c : todosCampeoes ) {
            if(c.getId().equals(id)){
                campeao = c;
            }
        }
        return campeao;

    }

}
