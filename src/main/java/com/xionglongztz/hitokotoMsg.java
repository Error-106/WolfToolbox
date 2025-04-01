package com.xionglongztz;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static org.bukkit.Bukkit.getLogger;

public class hitokotoMsg {
    public static String getHito(){
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://v1.hitokoto.cn/?encode=text"))//从 Web 服务器获取纯文本数据
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            getLogger().severe("无法获取一言:" + e.getMessage());
            return null;
        }
    }
}
