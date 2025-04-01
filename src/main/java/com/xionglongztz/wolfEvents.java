package com.xionglongztz;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;// 玩家
import org.bukkit.event.EventHandler;// 用于注册事件监视器
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;
import java.util.concurrent.CompletableFuture;
import static com.xionglongztz.wolfConsts.*;// 常量表
public class wolfEvents implements Listener {// 注册监听器

    @EventHandler
    public void onWorldChange(PlayerChangedWorldEvent e) {// 玩家所在世界变化
        Player player = e.getPlayer();
        if (player.hasPermission(Permission.FLY_PERMISSION)) {
            player.setAllowFlight(true);// 允许玩家飞行
        } else {
            player.setFlying(false);// 关闭飞行
            player.setAllowFlight(false);// 不允许玩家开启飞行
            player.sendRichMessage(Message.PREFIX + "<red>当前世界无飞行权限，已关闭飞行功能！</red>");// 告诉玩家已被关闭
        }
    }// 当改变玩家所在世界时，若没有权限，则关闭
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {// 玩家进入游戏
        Player player = event.getPlayer();
        if (player.hasPermission(Permission.MSG_PERMISSION)) {// 检查玩家是否拥有权限
            CompletableFuture.supplyAsync(hitokotoMsg::getHito).thenAcceptAsync(msg->{
                if (msg != null && player.isOnline()){// 判断消息是否有效，以及玩家是否在线
                    player.sendRichMessage("<yellow>一言:</yellow><aqua>" + msg + "</aqua>");//发送消息
                }
            });// 将阻塞操作交给异步线程，防止HTTP请求阻塞主线程
        }
        if (player.hasPermission(Permission.FLY_PERMISSION)) {// 玩家进入服务器时，给有权限的玩家飞行
            player.setAllowFlight (true);// 允许玩家飞行
        } else {
            player.setFlying (false);// 关闭飞行
            player.setAllowFlight (false);// 不允许玩家开启飞行
        }
    }
    @EventHandler(priority = EventPriority.MONITOR)// 最高优先级
    public void onPlayerCommand(PlayerCommandPreprocessEvent e) {// 监视指令发送，输出到控制台
        Player player = e.getPlayer(); // 获得玩家信息
        String command = e.getMessage(); // 获得指令内容
        String customCmdMsg = "<blue>*<italic>" + player.getName() + "</italic></blue><white>:</white> <gray>" + command + "</gray>";// 构建消息
        Bukkit.getConsoleSender().sendRichMessage(customCmdMsg);// 向控制台发送构建后的消息
        // WT无法干预控制台记录命令到日志，所以需要将Spigot的commands/log设为False才可以避免重复记录！
    }
}

