package com.troytan.ymcake.manager;

import java.io.IOException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.troytan.ymcake.dto.TulingIn;
import com.troytan.ymcake.dto.TulingOut;

@Component
public class TulingManager {

    private static final String API_URL = "http://www.tuling123.com/";
    private static final String KEY     = "71f28bf79c820df10d39b4074345ef8c";

    /**
     * 机器人对话三方接口
     *
     * @author troytan
     * @date 2018年5月2日
     * @param msg
     * @return
     * @throws JsonParseException
     * @throws JsonMappingException
     * @throws IOException
     */
    public String chatWithText(String msg) throws JsonParseException, JsonMappingException, IOException {
        TulingIn in = new TulingIn(KEY, msg, "troytan");
        Client client = ClientBuilder.newClient().register(JacksonJsonProvider.class);
        WebTarget target = client.target(API_URL).path("openapi/api");
        Response response = target.request("applicayion/json;utf-8").post(Entity.entity(in,
                                                                                        MediaType.APPLICATION_JSON));
        // 手动jsonString转object，直接readEntity会报错
        TulingOut out = new ObjectMapper().readValue(response.readEntity(String.class), TulingOut.class);
        return out.getText();
    }

}
