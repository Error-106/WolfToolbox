package com.xionglongztz;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class wolftoolbox extends JavaPlugin {
    @Override
    public void onEnable() {
        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
        console.sendMessage("§f[ §b小狼工具箱 §f] §a插件已成功载入！");
    }
    @Override
    public void onDisable() {
        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
        console.sendMessage( "§f[ §b小狼工具箱 §f] §c插件已成功卸载！");
    }
    @Override
    public boolean onCommand(@NotNull CommandSender sender, Command command, @NotNull String label, String[] args) {
        if (command.getName().equalsIgnoreCase("enderchest")) { //打开末影箱
            if (sender instanceof Player player) {
                if (player.hasPermission("wolftoolbox.enderchest")) {
                    player.openInventory(player.getEnderChest());
                    player.sendMessage("§f[ §b小狼工具箱 §f] §a已打开末影箱！");
                } else {
                    player.sendMessage("§f[ §b小狼工具箱 §f] §c你没有使用该指令的权限！");
                }
            } else {
                sender.sendMessage("§f[ §b小狼工具箱 §f] §c该命令只能由玩家使用！");
            }
            return true;
        } else if (command.getName().equalsIgnoreCase("workbench")) { //打开合成台
            if (sender instanceof Player player) {
                if (player.hasPermission("wolftoolbox.workbench")) {
                    player.openWorkbench(null, true);
                    player.sendMessage("§f[ §b小狼工具箱 §f] §a已打开合成台！");
                } else {
                    player.sendMessage("§f[ §b小狼工具箱 §f] §c你没有使用该指令的权限！");
                }
            } else {
                sender.sendMessage("§f[ §b小狼工具箱 §f] §c该命令只能由玩家使用！");
            }
            return true;
        }
        return false;
    }
}