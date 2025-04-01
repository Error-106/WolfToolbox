package com.xionglongztz;// 当前Java类包名

import org.bukkit.Bukkit;// Bukkit API
import org.bukkit.command.Command;// 表示服务器命令
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;// 表示服务器控制台
import org.bukkit.plugin.java.JavaPlugin;// Bukkit插件的主类
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import java.util.ArrayList;
import java.util.List;

import static com.xionglongztz.wolfConsts.*;// 常量表

public final class wolfToolbox extends JavaPlugin {
    @Override
    public void onEnable() {// 插件已启用
        saveDefaultConfig ();
        reloadConfig ();
        ConsoleCommandSender console = Bukkit.getServer ().getConsoleSender ();// 获得控制台消息sender
        getServer ().getPluginManager ().registerEvents (new wolfEvents (), this);// 注册事件监听器
        console.sendRichMessage (Message.ONENABLE);
    }
    @Override
    public void onDisable() {// 插件已禁用
        ConsoleCommandSender console = Bukkit.getServer ().getConsoleSender ();
        console.sendRichMessage (Message.ONDISABLE);
    }
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, Command command, @NotNull String alias, String[] args) {
        switch (command.getName ().toLowerCase ()) {
            case "sudo":
            case "sm": {
                if (args.length >= 2) {
                    return new ArrayList<> ();
                }
            }
            case "wt":
            case "wtb": {
                if (args.length == 1) {
                    List<String> suggests = new ArrayList<> (List.of ("enderchest", "workbench",
                            "anvil", "cartographytable", "loom", "stonecutter", "smithingtable",
                            "grindstone", "help", "fly", "suicide", "cm"));// 通用指令
                    if (sender.hasPermission (Permission.ADMIN_PERMISSION)) {
                        suggests.addAll (List.of ("sudo", "sm", "hito", "reload"));
                    }// 当有管理员权限时增加管理员命令
                    return suggests;
                }
            }
        }
        return null; // 返回 null 表示使用默认的 Tab 补全
    }
    // 修改TAB自动补全的候选词
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        return switch (command.getName ().toLowerCase ()) {// 判断玩家输入的指令
            case "ender", "enderchest" -> {
                commandHandler.handleEnderchestCommand (sender, args);
                yield true;
            }
            case "workbench" -> {
                commandHandler.handleWorkbenchCommand (sender, args);
                yield true;
            }
            case "anvil" -> {
                commandHandler.handleAnvilCommand (sender, args);
                yield true;
            }
            case "cartographytable" -> {
                commandHandler.handleCartographyTableCommand (sender, args);
                yield true;
            }
            case "loom" -> {
                commandHandler.handleLoomCommand (sender, args);
                yield true;
            }
            case "stonecutter" -> {
                commandHandler.handleStonecutterCommand (sender, args);
                yield true;
            }
            case "smithingtable" -> {
                commandHandler.handleSmithingTableCommand (sender, args);
                yield true;
            }
            case "grindstone" -> {
                commandHandler.handleGrindstoneCommand (sender, args);
                yield true;
            }
            case "wthelp" -> {
                commandHandler.handleHelpCommand (sender);
                yield true;
            }
            case "suicide" -> {
                commandHandler.handleSuicideCommand (sender);
                yield true;
            }
            case "fly" -> {
                commandHandler.handleFlyCommand (sender, args);
                yield true;
            }
            case "sudo" -> {
                commandHandler.handleSudoCommand (sender, args);
                yield true;
            }
            case "sm" -> {
                commandHandler.handlesendMessageCommand (sender, args);
                yield true;
            }
            case "hito" -> {
                commandHandler.handleHitoMessageCommand (sender, args);
                yield true;
            }
//            case "wtb", "wt" -> {
//                commandHandler.handleWTCommand (sender, args);
//                yield true;
//            }
            default -> false;
        };
    }// 处理输入命令
}