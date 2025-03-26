package com.xionglongztz;// 当前Java类包名
import org.bukkit.Bukkit;// Bukkit API
import org.bukkit.GameMode;// 获取玩家游戏模式
import org.bukkit.command.ConsoleCommandSender;// 表示服务器控制台
import org.bukkit.plugin.java.JavaPlugin;// Bukkit插件的主类
import org.bukkit.command.Command;// 表示服务器命令
import org.bukkit.command.CommandSender;// 发送命令的实体
import org.bukkit.entity.Player;// 访问玩家信息和操作玩家的方法
import org.jetbrains.annotations.NotNull;// 标记参数或返回值不能为空
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public final class wolftoolbox extends JavaPlugin{
    private static final String PREFIX = "§f[ §b小狼工具箱 §f] ";// 插件前缀
    private static final String NO_PERMISSION = PREFIX + "§c你没有使用该命令的权限！";// 无执行权限
    private static final String ONLY_PLAYER = PREFIX + "§c该命令只能由玩家使用！";// 在控制台执行时触发
    private static final String ENDERCHEST_PERMISSION = "wolftoolbox.enderchest";// 随身末影箱权限
    private static final String WORKBENCH_PERMISSION = "wolftoolbox.workbench";// 随身合成台权限
    private static final String ANVIL_PERMISSION = "wolftoolbox.anvil";// 随身铁砧权限
    private static final String CARTOGRAPHYTABLE_PERMISSION = "wolftoolbox.cartographytable";// 随身制图台权限
    private static final String LOOM_PERMISSION = "wolftoolbox.loom";// 随身织布机权限
    private static final String STONECUTTER_PERMISSION = "wolftoolbox.stonecutter";// 随身切石机权限
    private static final String SMITHINGTABLE_PERMISSION = "wolftoolbox.smithingtable";// 随身锻造台权限
    private static final String GRINDSTONE_PERMISSION = "wolftoolbox.grindstone";// 随身砂轮权限
    private static final String SUICIDE_PERMISSION = "wolftoolbox.suicide";// 自杀权限
    private static final String FLY_PERMISSION = "wolftoolbox.fly";// 飞行权限
    private static final String ADMIN_PERMISSION = "wolftoolbox.admin";// 管理员权限

    @Override
    public void onEnable() {
        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();// 获得控制台消息sender
        saveDefaultConfig();
        reloadConfig();
        getServer().getPluginManager().registerEvents(new wolfevents(), this);// 注册事件监听器
        console.sendMessage(PREFIX + "§a插件已启用！");
    }
    @Override
    public void onDisable() {
        ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
        console.sendMessage(PREFIX + "§c插件已禁用！");
    }
    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, Command command, @NotNull String alias, String[] args) {
        if (command.getName().equalsIgnoreCase("gm")) {
            if (args.length == 1) {// 返回预设的候选词列表
                List<String> suggestions = new ArrayList<>();
                suggestions.add("c");
                suggestions.add("s");
                suggestions.add("a");
                suggestions.add("p");
                return suggestions;
            }
        } else if (command.getName().equalsIgnoreCase("sudo")) {
            if (args.length == 2) {// 返回预设的候选词列表
                List<String> suggestions = new ArrayList<>();
                suggestions.add("");
                return suggestions;// 这里是遍历服务器可用指令的，但是我不会写
            }
        }
        return null; // 返回 null 表示使用默认的 Tab 补全
    }// 修改候选词
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {
        switch (command.getName().toLowerCase()) {// 判断玩家输入的指令
            case "enderchest" -> {
                handleEnderchestCommand(sender, args);
                return true;
            }
            case "workbench" -> {
                handleWorkbenchCommand(sender, args);
                return true;
            }
            case "anvil" -> {
                handleAnvilCommand(sender, args);
                return true;
            }
            case "cartographytable" -> {
                handleCartographyTableCommand(sender, args);
                return true;
            }
            case "loom" -> {
                handleLoomCommand(sender, args);
                return true;
            }
            case "stonecutter" -> {
                handleStonecutterCommand(sender, args);
                return true;
            }
            case "smithingtable" -> {
                handleSmithingTableCommand(sender, args);
                return true;
            }
            case "grindstone" -> {
                handleGrindstoneCommand(sender, args);
                return true;
            }
            case "wthelp" -> {
                handleHelpCommand(sender);
                return true;
            }
            case "suicide" -> {
                handleSuicideCommand(sender);
                return true;
            }
            case "fly" -> {
                handleFlyCommand(sender, args);
                return true;
            }
            case "gm" -> {
                handleGamemodeCommand(sender, args);
                return true;
            }
                case "sudo" -> {
                handleSudoCommand(sender, args);
                return true;
            }
            default -> {
                return false;
            }
        }
    }// 处理输入命令

    private void handleEnderchestCommand(CommandSender sender, String[] args) {
        if (args.length == 0) {// 判断参数是否为0
            if (sender instanceof Player player) {// 是否为玩家执行
                if (player.hasPermission(ENDERCHEST_PERMISSION)) {// 是否具有权限
                    player.openInventory(player.getEnderChest());
                    player.sendMessage(PREFIX + "§a已打开末影箱！");
                } else {
                    sender.sendMessage(NO_PERMISSION);// 提示无权限
                }
            } else {
                sender.sendMessage(ONLY_PLAYER);// 提示只能由玩家执行
            }
        } else if (sender.hasPermission(ADMIN_PERMISSION)) {// 参数不为0时，是否具有管理员权限
            Player target = Bukkit.getPlayer(args[0]);
            if (target != null) {//参数不为空
                sender.sendMessage(PREFIX + "§a已为玩家 §e" + target.getName() + " §a打开末影箱！");// 告诉管理员已执行
                target.openInventory(target.getEnderChest());
                target.sendMessage(PREFIX + "§a管理员 §e" + sender.getName() + " §a已为你打开末影箱！");// 告诉玩家已被开启
            } else {
                sender.sendMessage(PREFIX + "§c玩家 §e" + args[0] + " §c不在线！");//玩家离线
            }
        } else {
            if (sender instanceof Player player) {
                player.sendMessage(NO_PERMISSION);// 提示玩家没有管理员权限
            }
        }
    }// 随身末影箱
    private void handleWorkbenchCommand(CommandSender sender, String[] args) {
        if (args.length == 0) {// 判断参数是否为0
            if (sender instanceof Player player) {// 是否为玩家执行
                if (player.hasPermission(WORKBENCH_PERMISSION)) {// 是否具有权限
                    player.openWorkbench(null, true);
                    player.sendMessage(PREFIX + "§a已打开合成台！");
                } else {
                    sender.sendMessage(NO_PERMISSION);// 提示无权限
                }
            } else {
                sender.sendMessage(ONLY_PLAYER);// 提示只能由玩家执行
            }
        } else if (sender.hasPermission(ADMIN_PERMISSION)) {// 参数不为0时，是否具有管理员权限
            Player target = Bukkit.getPlayer(args[0]);
            if (target != null) {//参数不为空
                sender.sendMessage(PREFIX + "§a已为玩家 §e" + target.getName() + " §a打开合成台！");// 告诉管理员已执行
                target.openWorkbench(null, true);
                target.sendMessage(PREFIX + "§a管理员 §e" + sender.getName() + " §a已为你打开合成台！");// 告诉玩家已被开启
            } else {
                sender.sendMessage(PREFIX + "§c玩家 §e" + args[0] + " §c不在线！");//玩家离线
            }
        } else {
            if (sender instanceof Player player) {
                player.sendMessage(NO_PERMISSION);// 提示玩家没有管理员权限
            }
        }
    }// 随身合成台
    private void handleAnvilCommand(CommandSender sender, String[] args) {
        if (args.length == 0) {// 判断参数是否为0
            if (sender instanceof Player player) {// 是否为玩家执行
                if (player.hasPermission(ANVIL_PERMISSION)) {// 是否具有权限
                    player.openAnvil(null,true);
                    player.sendMessage(PREFIX + "§a已打开铁砧！");
                } else {
                    sender.sendMessage(NO_PERMISSION);// 提示无权限
                }
            } else {
                sender.sendMessage(ONLY_PLAYER);// 提示只能由玩家执行
            }
        } else if (sender.hasPermission(ADMIN_PERMISSION)) {// 参数不为0时，是否具有管理员权限
            Player target = Bukkit.getPlayer(args[0]);
            if (target != null) {//参数不为空
                sender.sendMessage(PREFIX + "§a已为玩家 §e" + target.getName() + " §a打开铁砧！");// 告诉管理员已执行
                target.openAnvil(null, true);
                target.sendMessage(PREFIX + "§a管理员 §e" + sender.getName() + " §a已为你打开铁砧！");// 告诉玩家已被开启
            } else {
                sender.sendMessage(PREFIX + "§c玩家 §e" + args[0] + " §c不在线！");//玩家离线
            }
        } else {
            if (sender instanceof Player player) {
                player.sendMessage(NO_PERMISSION);// 提示玩家没有管理员权限
            }
        }
    }// 随身铁砧
    private void handleCartographyTableCommand(CommandSender sender, String[] args) {
        if (args.length == 0) {// 判断参数是否为0
            if (sender instanceof Player player) {// 是否为玩家执行
                if (player.hasPermission(CARTOGRAPHYTABLE_PERMISSION)) {// 是否具有权限
                    player.openCartographyTable(null,true);
                    player.sendMessage(PREFIX + "§a已打开制图台！");
                } else {
                    sender.sendMessage(NO_PERMISSION);// 提示无权限
                }
            } else {
                sender.sendMessage(ONLY_PLAYER);// 提示只能由玩家执行
            }
        } else if (sender.hasPermission(ADMIN_PERMISSION)) {// 参数不为0时，是否具有管理员权限
            Player target = Bukkit.getPlayer(args[0]);
            if (target != null) {//参数不为空
                sender.sendMessage(PREFIX + "§a已为玩家 §e" + target.getName() + " §a打开制图台！");// 告诉管理员已执行
                target.openCartographyTable(null, true);
                target.sendMessage(PREFIX + "§a管理员 §e" + sender.getName() + " §a已为你打开制图台！");// 告诉玩家已被开启
            } else {
                sender.sendMessage(PREFIX + "§c玩家 §e" + args[0] + " §c不在线！");//玩家离线
            }
        } else {
            if (sender instanceof Player player) {
                player.sendMessage(NO_PERMISSION);// 提示玩家没有管理员权限
            }
        }
    }// 随身制图台
    private void handleLoomCommand(CommandSender sender, String[] args) {
        if (args.length == 0) {// 判断参数是否为0
            if (sender instanceof Player player) {// 是否为玩家执行
                if (player.hasPermission(LOOM_PERMISSION)) {// 是否具有权限
                    player.openLoom(null,true);
                    player.sendMessage(PREFIX + "§a已打开织布机！");
                } else {
                    sender.sendMessage(NO_PERMISSION);// 提示无权限
                }
            } else {
                sender.sendMessage(ONLY_PLAYER);// 提示只能由玩家执行
            }
        } else if (sender.hasPermission(ADMIN_PERMISSION)) {// 参数不为0时，是否具有管理员权限
            Player target = Bukkit.getPlayer(args[0]);
            if (target != null) {//参数不为空
                sender.sendMessage(PREFIX + "§a已为玩家 §e" + target.getName() + " §a打开织布机！");// 告诉管理员已执行
                target.openLoom(null, true);
                target.sendMessage(PREFIX + "§a管理员 §e" + sender.getName() + " §a已为你打开织布机！");// 告诉玩家已被开启
            } else {
                sender.sendMessage(PREFIX + "§c玩家 §e" + args[0] + " §c不在线！");//玩家离线
            }
        } else {
            if (sender instanceof Player player) {
                player.sendMessage(NO_PERMISSION);// 提示玩家没有管理员权限
            }
        }
    }// 随身织布机
    private void handleStonecutterCommand(CommandSender sender, String[] args) {
        if (args.length == 0) {// 判断参数是否为0
            if (sender instanceof Player player) {// 是否为玩家执行
                if (player.hasPermission(STONECUTTER_PERMISSION)) {// 是否具有权限
                    player.openStonecutter(null,true);
                    player.sendMessage(PREFIX + "§a已打开切石机！");
                } else {
                    sender.sendMessage(NO_PERMISSION);// 提示无权限
                }
            } else {
                sender.sendMessage(ONLY_PLAYER);// 提示只能由玩家执行
            }
        } else if (sender.hasPermission(ADMIN_PERMISSION)) {// 参数不为0时，是否具有管理员权限
            Player target = Bukkit.getPlayer(args[0]);
            if (target != null) {//参数不为空
                sender.sendMessage(PREFIX + "§a已为玩家 §e" + target.getName() + " §a打开切石机！");// 告诉管理员已执行
                target.openStonecutter(null, true);
                target.sendMessage(PREFIX + "§a管理员 §e" + sender.getName() + " §a已为你打开切石机！");// 告诉玩家已被开启
            } else {
                sender.sendMessage(PREFIX + "§c玩家 §e" + args[0] + " §c不在线！");//玩家离线
            }
        } else {
            if (sender instanceof Player player) {
                player.sendMessage(NO_PERMISSION);// 提示玩家没有管理员权限
            }
        }
    }// 随身切石机
    private void handleSmithingTableCommand(CommandSender sender, String[] args) {
        if (args.length == 0) {// 判断参数是否为0
            if (sender instanceof Player player) {// 是否为玩家执行
                if (player.hasPermission(SMITHINGTABLE_PERMISSION)) {// 是否具有权限
                    player.openSmithingTable(null,true);
                    player.sendMessage(PREFIX + "§a已打开锻造台！");
                } else {
                    sender.sendMessage(NO_PERMISSION);// 提示无权限
                }
            } else {
                sender.sendMessage(ONLY_PLAYER);// 提示只能由玩家执行
            }
        } else if (sender.hasPermission(ADMIN_PERMISSION)) {// 参数不为0时，是否具有管理员权限
            Player target = Bukkit.getPlayer(args[0]);
            if (target != null) {//参数不为空
                sender.sendMessage(PREFIX + "§a已为玩家 §e" + target.getName() + " §a打开锻造台！");// 告诉管理员已执行
                target.openSmithingTable(null, true);
                target.sendMessage(PREFIX + "§a管理员 §e" + sender.getName() + " §a已为你打开锻造台！");// 告诉玩家已被开启
            } else {
                sender.sendMessage(PREFIX + "§c玩家 §e" + args[0] + " §c不在线！");//玩家离线
            }
        } else {
            if (sender instanceof Player player) {
                player.sendMessage(NO_PERMISSION);// 提示玩家没有管理员权限
            }
        }
    }// 随身锻造台
    private void handleGrindstoneCommand(CommandSender sender, String[] args) {
        if (args.length == 0) {// 判断参数是否为0
            if (sender instanceof Player player) {// 是否为玩家执行
                if (player.hasPermission(GRINDSTONE_PERMISSION)) {// 是否具有权限
                    player.openGrindstone(null,true);
                    player.sendMessage(PREFIX + "§a已打开砂轮！");
                } else {
                    sender.sendMessage(NO_PERMISSION);// 提示无权限
                }
            } else {
                sender.sendMessage(ONLY_PLAYER);// 提示只能由玩家执行
            }
        } else if (sender.hasPermission(ADMIN_PERMISSION)) {// 参数不为0时，是否具有管理员权限
            Player target = Bukkit.getPlayer(args[0]);
            if (target != null) {//参数不为空
                sender.sendMessage(PREFIX + "§a已为玩家 §e" + target.getName() + " §a打开砂轮！");// 告诉管理员已执行
                target.openGrindstone(null, true);
                target.sendMessage(PREFIX + "§a管理员 §e" + sender.getName() + " §a已为你打开砂轮！");// 告诉玩家已被开启
            } else {
                sender.sendMessage(PREFIX + "§c玩家 §e" + args[0] + " §c不在线！");//玩家离线
            }
        } else {
            if (sender instanceof Player player) {
                player.sendMessage(NO_PERMISSION);// 提示玩家没有管理员权限
            }
        }
    }// 随身砂轮
    private void handleFlyCommand(CommandSender sender, String[] args) {
        if (args.length == 0) {// 判断参数是否为0
            if (sender instanceof Player player) {// 是否为玩家执行
                if (player.hasPermission(FLY_PERMISSION)) {// 是否具有权限
                    if (player.getGameMode() == GameMode.CREATIVE || player.getGameMode() == GameMode.SPECTATOR){//是否旁观创造
                        player.sendMessage(PREFIX + "§c无法在创造/旁观模式切换飞行状态！");// 报错
                        return;
                    }
                    if (player.isFlying()){
                        player.setAllowFlight(false);
                        player.setFlying(false);
                        player.sendMessage(PREFIX + "§c已关闭飞行功能！");// 告诉玩家已被开启
                    } else {
                        player.setAllowFlight(true);
                        player.setFlying(true);
                        player.sendMessage(PREFIX + "§a已开启飞行功能！");// 告诉玩家已被开启
                    }
                } else {
                    sender.sendMessage(NO_PERMISSION);// 提示无权限
                }
            } else {
                sender.sendMessage(ONLY_PLAYER);// 提示只能由玩家执行
            }
        } else if (sender.hasPermission(ADMIN_PERMISSION)) {// 参数不为0时，判断是否具有管理员权限
            Player target = Bukkit.getPlayer(args[0]);
            if (target != null) {//参数不为空
                if (target.getGameMode() == GameMode.CREATIVE || target.getGameMode() == GameMode.SPECTATOR){//目标是否旁观创造
                    sender.sendMessage(PREFIX + "§c无法在创造/旁观模式切换§e " + target.getName() + " §c的飞行状态！");// 向发送者报错
                    return;
                }
                if (target.isFlying()){
                    target.setAllowFlight(false);
                    target.setFlying(false);
                    target.sendMessage(PREFIX + "§c管理员 §e" + sender.getName() + " §c已关闭你的飞行权限！");// 告诉玩家已被关闭
                    sender.sendMessage(PREFIX + "§c已为玩家 §e" + target.getName() + " §c关闭飞行！");// 告诉管理员已执行
                } else {
                    target.setAllowFlight(true);
                    target.setFlying(true);
                    target.sendMessage(PREFIX + "§a管理员 §e" + sender.getName() + " §a已开启你的飞行权限！");// 告诉玩家已被开启
                    sender.sendMessage(PREFIX + "§a已为玩家 §e" + target.getName() + " §a开启飞行！");// 告诉管理员已执行
                }
            } else {
                sender.sendMessage(PREFIX + "§c玩家 §e" + args[0] + " §c不在线！");//玩家离线
            }
        } else {
            if (sender instanceof Player player) {
                player.sendMessage(NO_PERMISSION);// 提示玩家没有管理员权限
            }
        }
    }// 飞行功能
    private void handleSuicideCommand(CommandSender sender) {
        if (sender instanceof Player player) {// 是否为玩家执行
            if (player.hasPermission(SUICIDE_PERMISSION)) {// 是否具有权限
                player.setHealth(0.0);
            } else {
                sender.sendMessage(NO_PERMISSION);// 提示无权限
            }
        } else {
            sender.sendMessage(ONLY_PLAYER);// 提示只能由玩家执行
        }
    }// 自杀功能
    private void handleHelpCommand(CommandSender sender) {
        if (sender.hasPermission(ADMIN_PERMISSION)) {
            sender.sendMessage("§b==========§a小狼工具箱(管理员)§b==========");
            sender.sendMessage("§b/workbench §a[Player] §e打开合成台");
            sender.sendMessage("§b/enderchest §a[Player] §e打开末影箱");
            sender.sendMessage("§b/anvil §a[Player] §e打开铁砧");
            sender.sendMessage("§b/cartographytable §a[Player] §e打开制图台");
            sender.sendMessage("§b/loom §a[Player] §e打开织布机");
            sender.sendMessage("§b/stonecutter §a[Player] §e打开切石机");
            sender.sendMessage("§b/smithingtable §a[Player] §e打开锻造台");
            sender.sendMessage("§b/grindstone §a[Player] §e打开砂轮");
            sender.sendMessage("§b/suicide §e自杀");
            sender.sendMessage("§b/fly §a[Player] §e开启或关闭飞行");
            sender.sendMessage("§b/wthelp §e显示本帮助");
            sender.sendMessage("§b/gm §e<c(1)/s(2)/a(3)/p(4)> §a[Player] ");
            sender.sendMessage("    §e切换游戏模式为§ac/1(创造)§es/2(生存)§ca/3(冒险)§7p/4(旁观)");
            sender.sendMessage("§b/sudo §e<Player> §e[<Command>|<Text>] §e强制指定玩家发送指令/消息");
            sender.sendMessage("§b======================================");
        } else {
            sender.sendMessage("§b==========§a小狼工具箱§b==========");
            sender.sendMessage("§b/workbench §e打开合成台");
            sender.sendMessage("§b/enderchest §e打开末影箱");
            sender.sendMessage("§b/anvil §e打开铁砧");
            sender.sendMessage("§b/cartographytable §e打开制图台");
            sender.sendMessage("§b/loom §e打开织布机");
            sender.sendMessage("§b/stonecutter §e打开切石机");
            sender.sendMessage("§b/smithingtable §e打开锻造台");
            sender.sendMessage("§b/grindstone §e打开砂轮");
            sender.sendMessage("§b/suicide §e自杀");
            sender.sendMessage("§b/fly §e开启或关闭飞行");
            sender.sendMessage("§b/wthelp §e显示本帮助");
            sender.sendMessage("§b=============================");
        }
    }// 显示帮助信息
    private void handleSudoCommand(CommandSender sender, String[] args) {
        if (sender.hasPermission(ADMIN_PERMISSION)) {// 是否具有权限
            if (args.length == 0) {// 判断是否存在参数
                sender.sendMessage(PREFIX + "§c语法错误，该指令不能单独执行！");
            } else if (args.length == 1) {// 判断参数为1时的情况，只为当前输入玩家修改模式
                Player target = Bukkit.getPlayer(args[0]);// 获取被操作的玩家id
                if (target != null) {
                    sender.sendMessage(PREFIX + "§c语法错误：请指定玩家 §e" + target.getName() + " §c要输入的指令/消息！");
                } else {
                    sender.sendMessage(PREFIX + "§c玩家 §e" + args[0] + " §c不在线！");
                }
            } else {
                Player target = Bukkit.getPlayer(args[0]);// 获取被操作的玩家id
                StringBuilder commandToExecute = new StringBuilder();
                for (int i = 1; i < args.length; i++) {
                    commandToExecute.append(args[i]).append(" ");
                }// 获得想要输入的命令
                if (target != null) { // 当玩家id不为空时
                    if (target.hasPermission(commandToExecute.substring(1))) {
                        target.performCommand(commandToExecute.toString());
                        sender.sendMessage(PREFIX + "§a已让玩家 §e" + target.getName() + " §a执行指令 §b" + commandToExecute);
                    } else {
                        sender.sendMessage(PREFIX + "§c玩家 §e" + target.getName() + " §c没有权限执行 §b" + commandToExecute);
                    }
                } else {
                    sender.sendMessage(PREFIX + "§c玩家 §e" + args[0] + " §c不在线！");// 玩家离线
                }
            }
        } else {
        sender.sendMessage(NO_PERMISSION);// 提示无权限
        }
    }// 让指定玩家说话/执行指令
    private void handleGamemodeCommand(CommandSender sender, String[] args) {
        if (sender.hasPermission(ADMIN_PERMISSION)) {// 是否具有权限
            if (args.length == 0) {// 判断是否存在参数
                sender.sendMessage(PREFIX + "§c请输入确切的游戏模式！参数只能为§ac/1(创造)§es/2(生存)§ca/3(冒险)§7p/4(旁观)");
            } else if (args.length == 1) {// 判断参数为1时的情况，只为当前输入玩家修改模式
                if (sender instanceof Player player) {// 是否为玩家执行
                    switch (args[0]) {
                        case "c":
                        case "1":
                            player.sendMessage(PREFIX + "§a已切换为§a§o创造模式");
                            player.setGameMode(GameMode.CREATIVE);
                            break;
                        case "s":
                        case "2":
                            player.sendMessage(PREFIX + "§a已切换为§e§o生存模式");
                            player.setGameMode(GameMode.SURVIVAL);
                            break;
                        case "a":
                        case "3":
                            player.sendMessage(PREFIX + "§a已切换为§c§o冒险模式");
                            player.setGameMode(GameMode.ADVENTURE);
                            break;
                        case "p":
                        case "4":
                            player.sendMessage(PREFIX + "§a已切换为§7§o旁观模式");
                            player.setGameMode(GameMode.SPECTATOR);
                            break;
                        default:
                            player.sendMessage(PREFIX + "§c游戏模式无效！参数只能为§ac/1(创造)§es/2(生存)§ca/3(冒险)§7p/4(旁观)");
                    }
                } else {
                    sender.sendMessage(ONLY_PLAYER);// 提示只能由玩家执行
                }
            } else if (args.length == 2) {
                Player target = Bukkit.getPlayer(args[1]);// 获取被操作的玩家id
                if (target != null) { // 当玩家id不为空时
                    switch (args[0]) {
                        case "c":
                        case "1":
                            sender.sendMessage(PREFIX + "§a已切换玩家 §e" + target.getName() + " §a的游戏模式为§a§o创造模式");
                            target.sendMessage(PREFIX + "§a管理员 §e" + sender.getName() + " §a已切换你的游戏模式为§a§o创造模式");
                            target.setGameMode(GameMode.CREATIVE);
                            break;
                        case "s":
                        case "2":
                            sender.sendMessage(PREFIX + "§a已切换玩家 §e" + target.getName() + " §a的游戏模式为§e§o生存模式");
                            target.sendMessage(PREFIX + "§a管理员 §e" + sender.getName() + " §a已切换你的游戏模式为§e§o生存模式");
                            target.setGameMode(GameMode.SURVIVAL);
                            break;
                        case "a":
                        case "3":
                            sender.sendMessage(PREFIX + "§a已切换玩家 §e" + target.getName() + " §a的游戏模式为§c§o冒险模式");
                            target.sendMessage(PREFIX + "§a管理员 §e" + sender.getName() + " §a已切换你的游戏模式为§c§o冒险模式");
                            target.setGameMode(GameMode.ADVENTURE);
                            break;
                        case "p":
                        case "4":
                            sender.sendMessage(PREFIX + "§a已切换玩家 §e" + target.getName() + " §a的游戏模式为§7§o旁观模式");
                            target.sendMessage(PREFIX + "§a管理员 §e" + sender.getName() + " §a已切换你的游戏模式为§7§o旁观模式");
                            target.setGameMode(GameMode.SPECTATOR);
                            break;
                        default:
                            sender.sendMessage(PREFIX + "§c游戏模式无效！参数只能为§ac/1(创造)§es/2(生存)§ca/3(冒险)§7p/4(旁观)");
                    }
                } else {
                    sender.sendMessage(PREFIX + "§c玩家 §e" + args[1] + " §c不在线！");// 玩家离线
                }
            } else {
                sender.sendMessage(PREFIX + "§c未知参数！请使用 /wthelp 查看帮助");// 参数错误
            }
        } else {
            sender.sendMessage(NO_PERMISSION);// 提示无权限
        }
    }// 切换游戏模式
}
