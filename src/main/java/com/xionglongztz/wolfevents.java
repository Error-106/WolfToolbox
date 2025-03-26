package com.xionglongztz;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;//玩家
import org.bukkit.event.EventHandler;//用于注册事件监视器
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;

import java.net.http.HttpRequest;//HTTP请求
import java.net.http.HttpClient;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpResponse;

import static org.bukkit.Bukkit.getLogger;

public class wolfevents implements Listener {
    private static final String PREFIX = "§f[ §b小狼工具箱 §f] ";// 插件前缀
    private static final String FLY_PERMISSION = "wolftoolbox.fly";// 飞行权限
    private static final String MSG_PERMISSION = "wolftoolbox.msg";// 一言权限

    @EventHandler
    public void onWorldChange(PlayerChangedWorldEvent e) {// 玩家所在世界变化
        Player player = e.getPlayer();
        if (player.hasPermission(FLY_PERMISSION)) {
            player.setAllowFlight(true);// 允许玩家飞行
        } else {
            player.setFlying(false);// 关闭飞行
            player.setAllowFlight(false);// 不允许玩家开启飞行
            player.sendMessage(PREFIX + "§c当前世界无飞行权限，已关闭飞行功能！");// 告诉玩家已被关闭
        }
    }// 当改变玩家所在世界时，若没有权限，则关闭
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {//玩家进入游戏
        Player player = event.getPlayer();
        if (player.hasPermission(MSG_PERMISSION)) {//检查玩家是否拥有权限
            try {
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create("https://v1.hitokoto.cn/?encode=text"))//从 Web 服务器获取纯文本数据
                        .build();
                HttpResponse<String> response = HttpClient.newHttpClient()
                        .send(request, HttpResponse.BodyHandlers.ofString());
                String message = response.body();
                player.sendMessage("§e一言:§b" + message);//发送消息
            } catch (IOException | InterruptedException e) {
                getLogger().severe("无法获取一言:" + e.getMessage());
            }
        }
    }
    @EventHandler(priority = EventPriority.MONITOR)// 最高优先级
    public void onPlayerCommand(PlayerCommandPreprocessEvent e) {// 监视指令发送，输出到控制台
        Player player = e.getPlayer(); // 获得玩家信息
        String command = e.getMessage(); // 获得指令内容
        String customCmdMsg = "§9§o*" + player.getName() + "§r§f: §7" + command;// 构建消息
        Bukkit.getConsoleSender().sendMessage(customCmdMsg);// 向控制台发送构建后的消息
        // WT无法干预控制台记录命令到日志，所以需要将Spigot的commands/log设为False才可以避免重复记录！
    }
}
