package com.xionglongztz;
import org.bukkit.entity.Player;//玩家
import org.bukkit.event.EventHandler;//用于注册事件监视器
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;//玩家加入游戏事件
import org.bukkit.event.player.PlayerChangedWorldEvent;

import java.net.http.HttpRequest;//HTTP请求
import java.net.http.HttpClient;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpResponse;

import static org.bukkit.Bukkit.getLogger;

public class wolfevents implements Listener {
    private static final String PREFIX = "§f[ §b小狼工具箱 §f] ";// 插件前缀
    private static final String FLY_PERMISSION = "wolftoolbox.fly";// 飞行权限
    private static final String MSG_PERMISSION = "wolftoolbox.msg";// 管理员权限
    @EventHandler
    public void onWorldChange(PlayerChangedWorldEvent e) {
        Player player = e.getPlayer();
        if (!player.hasPermission(FLY_PERMISSION)) {
            player.setFlying(false);
            player.setAllowFlight(false);
        } else {
            player.setAllowFlight(true);
            player.setFlying(true);
        }
    }// 当改变玩家所在世界时，若没有权限，则关闭
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (player.hasPermission(MSG_PERMISSION)) {//检查玩家是否拥有权限
            try {
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create("https://v1.hitokoto.cn/?encode=text"))//从 Web 服务器获取纯文本数据
                        .build();
                HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
                String message = response.body();
                player.sendMessage(PREFIX + "§e一言：§b" + message);//发送消息
            } catch (IOException | InterruptedException e) {
                getLogger().severe("无法获取一言：" + e.getMessage());
            }
        }
    }
}
