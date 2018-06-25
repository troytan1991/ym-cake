package com.troytan.ymcake.manager;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;
import com.troytan.ymcake.dto.NewsRequestDto;
import com.troytan.ymcake.util.HtmlUtils;

/**
 * 连接创美之源公众号接口
 * 
 * @author troytan
 * @date 2018年6月25日
 */
@Component
public class CmzyManager {

    private final String APP_ID     = "wx2cd49ed28f6c9896";
    private final String APP_SECRET = "364a0200174d3cbcc980314bfc5e6368";

    /**
     * 更新图文
     *
     * @author troytan
     * @throws JSONException
     * @date 2018年6月25日
     */
    public void updateNews() throws JSONException {
        String token = getAccessToken();
        NewsRequestDto in = new NewsRequestDto("news", 0, -1);
        Client client = ClientBuilder.newClient().register(JacksonJsonProvider.class);
        WebTarget target = client.target("https://api.weixin.qq.com/cgi-bin/material/batchget_material").path("").queryParam("access_token",
                                                                                                                             token);
        Response response = target.request("applicayion/json;utf-8").post(Entity.entity(in,
                                                                                        MediaType.APPLICATION_JSON));
        JSONObject object = new JSONObject(response.readEntity(String.class));
        JSONArray items = object.getJSONArray("item");
        for (int i = 0; i < items.length(); i++) {
            String mediaId = items.getJSONObject(i).getString("media_id");
            JSONObject news = items.getJSONObject(i).getJSONObject("content").getJSONArray("news_item").getJSONObject(0);
            String title = news.getString("title");
            String digest = news.getString("digest");
            String url = news.getString("url");
            String content = news.getString("content");
            System.out.println(HtmlUtils.getTextFromHtml(content, 50));
        }
    }

    /**
     * 获取token
     *
     * @author troytan
     * @date 2018年6月25日
     * @return
     * @throws JSONException
     */
    private String getAccessToken() throws JSONException {
        Client client = ClientBuilder.newClient().register(JacksonJsonProvider.class);
        WebTarget target = client.target("https://api.weixin.qq.com/cgi-bin/token").path("").queryParam("appid",
                                                                                                        APP_ID).queryParam("secret",
                                                                                                                           APP_SECRET).queryParam("grant_type",
                                                                                                                                                  "client_credential");
        String response = target.request("applicayion/json;utf-8").get(String.class);
        return new JSONObject(response).getString("access_token");
    }

}
