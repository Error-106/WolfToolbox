package com.xionglongztz;

import org.bukkit.Bukkit;// Bukkit API
import org.bukkit.GameMode;// 获取玩家游戏模式
import org.bukkit.command.CommandSender;// 发送命令的实体
import org.bukkit.entity.Player;// 访问玩家信息和操作玩家的方法
import static com.xionglongztz.wolfConsts.*;// 常量表
public class commandHandler {
    public static void handleEnderchestCommand(CommandSender sender, String[] args) {
        if (args.length == 0) {// 判断参数是否为0
            if (sender instanceof Player player) {// 是否为玩家执行
                if (player.hasPermission(Permission.ENDERCHEST_PERMISSION)) {// 是否具有权限
                    player.openInventory(player.getEnderChest());
                    player.sendRichMessage(Message.PREFIX + "<green>已打开末影箱!</green>");
                } else {
                    sender.sendRichMessage(Message.NO_PERMISSION);// 提示无权限
                }
            } else {
                sender.sendRichMessage(Message.ONLY_PLAYER);// 提示只能由玩家执行
            }
        } else if (sender.hasPermission(Permission.ADMIN_PERMISSION)) {// 参数不为0时，是否具有管理员权限
            Player target = Bukkit.getPlayer(args[0]);
            if (target != null) {//参数不为空
                sender.sendRichMessage(Message.PREFIX + "<green>已为玩家 <yellow>" + target.getName() + "</yellow> 打开末影箱!</green>");// 告诉管理员已执行
                target.openInventory(target.getEnderChest());
                target.sendRichMessage(Message.PREFIX + "<green>管理员 <yellow>" + sender.getName() + "</yellow> 已为你打开末影箱!</green>");// 告诉玩家已被开启
            } else {
                sender.sendRichMessage(Message.NOT_ONLINE);// 玩家离线
            }
        } else {
            if (sender instanceof Player player) {
                player.sendRichMessage(Message.NO_PERMISSION);// 提示玩家没有管理员权限
            }
        }
    }// 随身末影箱
    public static void handleWorkbenchCommand(CommandSender sender, String[] args) {
        if (args.length == 0) {// 判断参数是否为0
            if (sender instanceof Player player) {// 是否为玩家执行
                if (player.hasPermission(Permission.WORKBENCH_PERMISSION)) {// 是否具有权限
                    player.openWorkbench(null, true);
                    player.sendRichMessage(Message.PREFIX + "<green>已打开合成台!</green>");
                } else {
                    sender.sendRichMessage(Message.NO_PERMISSION);// 提示无权限
                }
            } else {
                sender.sendRichMessage(Message.ONLY_PLAYER);// 提示只能由玩家执行
            }
        } else if (sender.hasPermission(Permission.ADMIN_PERMISSION)) {// 参数不为0时，是否具有管理员权限
            Player target = Bukkit.getPlayer(args[0]);
            if (target != null) {//参数不为空
                sender.sendRichMessage(Message.PREFIX + "<green>已为玩家 <yellow>" + target.getName() + "</yellow> 打开合成台!</green>");// 告诉管理员已执行
                target.openWorkbench(null, true);
                target.sendRichMessage(Message.PREFIX + "<green>管理员 <yellow>" + sender.getName() + "</yellow> 已为你打开合成台!</green>");// 告诉玩家已被开启
            } else {
                sender.sendRichMessage(Message.NOT_ONLINE);//玩家离线
            }
        } else {
            if (sender instanceof Player player) {
                player.sendRichMessage(Message.NO_PERMISSION);// 提示玩家没有管理员权限
            }
        }
    }// 随身合成台
    public static void handleAnvilCommand(CommandSender sender, String[] args) {
        if (args.length == 0) {// 判断参数是否为0
            if (sender instanceof Player player) {// 是否为玩家执行
                if (player.hasPermission(Permission.ANVIL_PERMISSION)) {// 是否具有权限
                    player.openAnvil(null, true);
                    player.sendRichMessage(Message.PREFIX + "<green>已打开铁砧!</green>");
                } else {
                    sender.sendRichMessage(Message.NO_PERMISSION);// 提示无权限
                }
            } else {
                sender.sendRichMessage(Message.ONLY_PLAYER);// 提示只能由玩家执行
            }
        } else if (sender.hasPermission(Permission.ADMIN_PERMISSION)) {// 参数不为0时，是否具有管理员权限
            Player target = Bukkit.getPlayer(args[0]);
            if (target != null) {//参数不为空
                sender.sendRichMessage(Message.PREFIX + "<green>已为玩家 <yellow>" + target.getName() + "</yellow> 打开铁砧!</green>");// 告诉管理员已执行
                target.openAnvil(null, true);
                target.sendRichMessage(Message.PREFIX + "<green>管理员 <yellow>" + sender.getName() + "</yellow> 已为你打开铁砧!</green>");// 告诉玩家已被开启
            } else {
                sender.sendRichMessage(Message.NOT_ONLINE);//玩家离线
            }
        } else {
            if (sender instanceof Player player) {
                player.sendRichMessage(Message.NO_PERMISSION);// 提示玩家没有管理员权限
            }
        }
    }// 随身铁砧
    public static void handleCartographyTableCommand(CommandSender sender, String[] args) {
        if (args.length == 0) {// 判断参数是否为0
            if (sender instanceof Player player) {// 是否为玩家执行
                if (player.hasPermission(Permission.CARTOGRAPHYTABLE_PERMISSION)) {// 是否具有权限
                    player.openCartographyTable(null, true);
                    player.sendRichMessage(Message.PREFIX + "<green>已打开制图台!</green>");
                } else {
                    sender.sendRichMessage(Message.NO_PERMISSION);// 提示无权限
                }
            } else {
                sender.sendRichMessage(Message.ONLY_PLAYER);// 提示只能由玩家执行
            }
        } else if (sender.hasPermission(Permission.ADMIN_PERMISSION)) {// 参数不为0时，是否具有管理员权限
            Player target = Bukkit.getPlayer(args[0]);
            if (target != null) {//参数不为空
                sender.sendRichMessage(Message.PREFIX + "<green>已为玩家 <yellow>" + target.getName() + "</yellow> 打开制图台!</green>");// 告诉管理员已执行
                target.openCartographyTable(null, true);
                target.sendRichMessage(Message.PREFIX + "<green>管理员 <yellow>" + sender.getName() + "</yellow> 已为你打开制图台!</green>");// 告诉玩家已被开启
            } else {
                sender.sendRichMessage(Message.NOT_ONLINE);//玩家离线
            }
        } else {
            if (sender instanceof Player player) {
                player.sendRichMessage(Message.NO_PERMISSION);// 提示玩家没有管理员权限
            }
        }
    }// 随身制图台
    public static void handleLoomCommand(CommandSender sender, String[] args) {
        if (args.length == 0) {// 判断参数是否为0
            if (sender instanceof Player player) {// 是否为玩家执行
                if (player.hasPermission(Permission.LOOM_PERMISSION)) {// 是否具有权限
                    player.openLoom(null, true);
                    player.sendRichMessage(Message.PREFIX + "<green>已打开织布机!</green>");
                } else {
                    sender.sendRichMessage(Message.NO_PERMISSION);// 提示无权限
                }
            } else {
                sender.sendRichMessage(Message.ONLY_PLAYER);// 提示只能由玩家执行
            }
        } else if (sender.hasPermission(Permission.ADMIN_PERMISSION)) {// 参数不为0时，是否具有管理员权限
            Player target = Bukkit.getPlayer(args[0]);
            if (target != null) {//参数不为空
                sender.sendRichMessage(Message.PREFIX + "<green>已为玩家 <yellow>" + target.getName() + "</yellow> 打开织布机!</green>");// 告诉管理员已执行
                target.openLoom(null, true);
                target.sendRichMessage(Message.PREFIX + "<green>管理员 <yellow>" + sender.getName() + "</yellow> 已为你打开织布机!</green>");// 告诉玩家已被开启
            } else {
                sender.sendRichMessage(Message.NOT_ONLINE);//玩家离线
            }
        } else {
            if (sender instanceof Player player) {
                player.sendRichMessage(Message.NO_PERMISSION);// 提示玩家没有管理员权限
            }
        }
    }// 随身织布机
    public static void handleStonecutterCommand(CommandSender sender, String[] args) {
        if (args.length == 0) {// 判断参数是否为0
            if (sender instanceof Player player) {// 是否为玩家执行
                if (player.hasPermission(Permission.STONECUTTER_PERMISSION)) {// 是否具有权限
                    player.openStonecutter(null, true);
                    player.sendRichMessage(Message.PREFIX + "<green>已打开切石机!</green>");
                } else {
                    sender.sendRichMessage(Message.NO_PERMISSION);// 提示无权限
                }
            } else {
                sender.sendRichMessage(Message.ONLY_PLAYER);// 提示只能由玩家执行
            }
        } else if (sender.hasPermission(Permission.ADMIN_PERMISSION)) {// 参数不为0时，是否具有管理员权限
            Player target = Bukkit.getPlayer(args[0]);
            if (target != null) {//参数不为空
                sender.sendRichMessage(Message.PREFIX + "<green>已为玩家 <yellow>" + target.getName() + "</yellow> 打开切石机!</green>");// 告诉管理员已执行
                target.openStonecutter(null, true);
                target.sendRichMessage(Message.PREFIX + "<green>管理员 <yellow>" + sender.getName() + "</yellow> 已为你打开切石机!</green>");// 告诉玩家已被开启
            } else {
                sender.sendRichMessage(Message.NOT_ONLINE);//玩家离线
            }
        } else {
            if (sender instanceof Player player) {
                player.sendRichMessage(Message.NO_PERMISSION);// 提示玩家没有管理员权限
            }
        }
    }// 随身切石机
    public static void handleSmithingTableCommand(CommandSender sender, String[] args) {
        if (args.length == 0) {// 判断参数是否为0
            if (sender instanceof Player player) {// 是否为玩家执行
                if (player.hasPermission(Permission.SMITHINGTABLE_PERMISSION)) {// 是否具有权限
                    player.openSmithingTable(null, true);
                    player.sendRichMessage(Message.PREFIX + "<green>已打开锻造台!</green>");
                } else {
                    sender.sendRichMessage(Message.NO_PERMISSION);// 提示无权限
                }
            } else {
                sender.sendRichMessage(Message.ONLY_PLAYER);// 提示只能由玩家执行
            }
        } else if (sender.hasPermission(Permission.ADMIN_PERMISSION)) {// 参数不为0时，是否具有管理员权限
            Player target = Bukkit.getPlayer(args[0]);
            if (target != null) {//参数不为空
                sender.sendRichMessage(Message.PREFIX + "<green>已为玩家 <yellow>" + target.getName() + "</yellow> 打开锻造台!</green>");// 告诉管理员已执行
                target.openSmithingTable(null, true);
                target.sendRichMessage(Message.PREFIX + "<green>管理员 <yellow>" + sender.getName() + "</yellow> 已为你打开锻造台!</green>");// 告诉玩家已被开启
            } else {
                sender.sendRichMessage(Message.NOT_ONLINE);//玩家离线
            }
        } else {
            if (sender instanceof Player player) {
                player.sendRichMessage(Message.NO_PERMISSION);// 提示玩家没有管理员权限
            }
        }
    }// 随身锻造台
    public static void handleGrindstoneCommand(CommandSender sender, String[] args) {
        if (args.length == 0) {// 判断参数是否为0
            if (sender instanceof Player player) {// 是否为玩家执行
                if (player.hasPermission(Permission.GRINDSTONE_PERMISSION)) {// 是否具有权限
                    player.openGrindstone(null, true);
                    player.sendRichMessage(Message.PREFIX + "<green>已打开砂轮!</green>");
                } else {
                    sender.sendRichMessage(Message.NO_PERMISSION);// 提示无权限
                }
            } else {
                sender.sendRichMessage(Message.ONLY_PLAYER);// 提示只能由玩家执行
            }
        } else if (sender.hasPermission(Permission.ADMIN_PERMISSION)) {// 参数不为0时，是否具有管理员权限
            Player target = Bukkit.getPlayer(args[0]);
            if (target != null) {//参数不为空
                sender.sendRichMessage(Message.PREFIX + "<green>已为玩家 <yellow>" + target.getName() + "</yellow> 打开砂轮!</green>");// 告诉管理员已执行
                target.openGrindstone(null, true);
                target.sendRichMessage(Message.PREFIX + "<green>管理员 <yellow>" + sender.getName() + "</yellow> 已为你打开砂轮!</green>");// 告诉玩家已被开启
            } else {
                sender.sendRichMessage(Message.NOT_ONLINE);//玩家离线
            }
        } else {
            if (sender instanceof Player player) {
                player.sendRichMessage(Message.NO_PERMISSION);// 提示玩家没有管理员权限
            }
        }
    }// 随身砂轮
    public static void handleFlyCommand(CommandSender sender, String[] args) {
        if (args.length == 0) {// 判断参数是否为0
            if (sender instanceof Player player) {// 是否为玩家执行
                if (player.hasPermission(Permission.FLY_PERMISSION)) {// 是否具有权限
                    if (player.getGameMode() == GameMode.CREATIVE || player.getGameMode() == GameMode.SPECTATOR) {//是否旁观创造
                        player.sendRichMessage(Message.PREFIX + "<red>无法在创造/旁观模式切换飞行状态!</red>");// 报错
                        return;
                    }
                    if (player.getAllowFlight()) {// 获得飞行状态
                        player.setAllowFlight(false);
                        player.setFlying(false);
                        player.sendRichMessage(Message.PREFIX + "<red>已关闭飞行功能!</red>");// 告诉玩家已被开启
                    } else {
                        player.setAllowFlight(true);
                        player.setFlying(true);
                        player.sendRichMessage(Message.PREFIX + "<green>已开启飞行功能!</green>");// 告诉玩家已被开启
                    }
                } else {
                    sender.sendRichMessage(Message.NO_PERMISSION);// 提示无权限
                }
            } else {
                sender.sendRichMessage(Message.ONLY_PLAYER);// 提示只能由玩家执行
            }
        } else if (sender.hasPermission(Permission.ADMIN_PERMISSION)) {// 参数不为0时，判断是否具有管理员权限
            Player target = Bukkit.getPlayer(args[0]);
            if (target != null) {//参数不为空
                if (target.getGameMode() == GameMode.CREATIVE || target.getGameMode() == GameMode.SPECTATOR) {// 目标是否旁观创造
                    sender.sendRichMessage(Message.PREFIX + "<red>无法在创造/旁观模式切换 <yellow>" + target.getName() + "</yellow> 的飞行状态!</red>");// 向发送者报错
                    return;
                }
                if (target.getAllowFlight()) {
                    target.setAllowFlight(false);
                    target.setFlying(false);
                    target.sendRichMessage(Message.PREFIX + "<red>管理员 <yellow>" + sender.getName() + "</yellow> 已关闭你的飞行权限!</red>");// 告诉玩家已被关闭
                    sender.sendRichMessage(Message.PREFIX + "<red>已为玩家 <yellow>" + target.getName() + "</yellow> 关闭飞行!</red>");// 告诉管理员已执行
                } else {
                    target.setAllowFlight(true);
                    target.setFlying(true);
                    target.sendRichMessage(Message.PREFIX + "<green>管理员 <yellow>" + sender.getName() + "</yellow> 已开启你的飞行权限!</green>");// 告诉玩家已被开启
                    sender.sendRichMessage(Message.PREFIX + "<green>已为玩家 <yellow>" + target.getName() + "</yellow> 开启飞行!</green>");// 告诉管理员已执行
                }
            } else {
                sender.sendRichMessage(Message.NOT_ONLINE);// 玩家离线
            }
        } else {
            if (sender instanceof Player player) {
                player.sendRichMessage(Message.NO_PERMISSION);// 提示玩家没有管理员权限
            }
        }
    }// 飞行功能
    public static void handleSuicideCommand(CommandSender sender) {
        if (sender instanceof Player player) {// 是否为玩家执行
            if (player.hasPermission(Permission.SUICIDE_PERMISSION)) {// 是否具有权限
                player.setHealth(0.0);
            } else {
                sender.sendRichMessage(Message.NO_PERMISSION);// 提示无权限
            }
        } else {
            sender.sendRichMessage(Message.ONLY_PLAYER);// 提示只能由玩家执行
        }
    }// 自杀功能
    public static void handleHelpCommand(CommandSender sender) {
        if (sender.hasPermission(wolfConsts.Permission.ADMIN_PERMISSION)) {
            String Help = (
                    """
                            <aqua>==========<green>小狼工具箱(管理员)</green>==========</aqua>
                            <aqua>/workbench <green>[Player] <yellow>打开合成台</aqua>
                            <aqua></enderchest | /ender> <green>[Player] <yellow>打开末影箱</aqua>
                            <aqua>/anvil <green>[Player] <yellow>打开铁砧</aqua>
                            <aqua>/cartographytable <green>[Player] <yellow>打开制图台</aqua>
                            <aqua>/loom <green>[Player] <yellow>打开织布机</aqua>
                            <aqua>/stonecutter <green>[Player] <yellow>打开切石机</aqua>
                            <aqua>/smithingtable <green>[Player] <yellow>打开锻造台</aqua>
                            <aqua>/grindstone <green>[Player] <yellow>打开砂轮</aqua>
                            <aqua>/suicide <yellow>自杀</aqua>
                            <aqua>/fly <green>[Player] <yellow>开启或关闭飞行</aqua>
                            <aqua>/wthelp <yellow>显示本帮助</aqua>
                            <aqua>/sudo <yellow><Player> <yellow><Command> </aqua>
                                  <yellow>强制指定玩家发送指令(不需要/)
                            <aqua>/sm <yellow><Player> <yellow><Text> </aqua>
                                <yellow>强制指定玩家发送消息
                            <aqua>/cm <yellow><Text> <yellow>向控制台发送消息</aqua>
                            <aqua>/hito <yellow><Player> <yellow>测试一言功能</aqua>
                            <aqua>======================================
                            """
            );
            sender.sendRichMessage(Help);
            } else {
            String Help = (
                    """
                            <aqua>==========<green>小狼工具箱</green>==========</aqua>
                            <aqua>/workbench <yellow>打开合成台</aqua>
                            <aqua>/enderchest <yellow>打开末影箱</aqua>
                            <aqua>/anvil <yellow>打开铁砧</aqua>
                            <aqua>/cartographytable <yellow>打开制图台</aqua>
                            <aqua>/loom <yellow>打开织布机</aqua>
                            <aqua>/stonecutter <yellow>打开切石机</aqua>
                            <aqua>/smithingtable <yellow>打开锻造台</aqua>
                            <aqua>/grindstone <yellow>打开砂轮</aqua>
                            <aqua>/suicide <yellow>自杀</aqua>
                            <aqua>/fly <yellow>开启或关闭飞行</aqua>
                            <aqua>/wthelp <yellow>显示本帮助</aqua>
                            <aqua>/cm <yellow><Text> <yellow>向控制台发送消息</aqua>
                            <aqua>=============================</aqua>
                            """
            );
            sender.sendRichMessage(Help);
        }
    }// 显示帮助信息
    public static void handleSudoCommand(CommandSender sender, String[] args) {
        if (sender.hasPermission(Permission.ADMIN_PERMISSION)) {// 是否具有权限
            if (args.length == 0) {// 判断是否存在参数
                sender.sendRichMessage(Message.NO_PARAMETERS);
            } else if (args.length == 1) {// 判断参数为1时的情况，只为当前输入玩家修改模式
                Player target = Bukkit.getPlayer(args[ 0 ]);// 获取被操作的玩家id
                if (target != null) {
                    sender.sendRichMessage(Message.PREFIX + "<red>语法错误:请指定玩家 <yellow>" + target.getName() + "</yellow> 要输入的指令!</red>");
                } else {
                    sender.sendRichMessage(Message.NOT_ONLINE);
                }
            } else {
                Player target = Bukkit.getPlayer(args[ 0 ]);// 获取被操作的玩家id
                StringBuilder commandToExecute = new StringBuilder();
                for (int i = 1; i < args.length; i++) {
                    commandToExecute.append(args[ i ]).append(" ");
                }// 获得想要输入的命令
                if (target != null) { // 当玩家id不为空时
                    target.performCommand(commandToExecute.toString());
                    sender.sendRichMessage(Message.PREFIX + "<green>已让玩家 <yellow>" + target.getName() + "<yellow> 执行: </green><aqua>" + commandToExecute + "</aqua>");
                } else {
                    sender.sendRichMessage(Message.NOT_ONLINE);// 玩家离线
                }
            }
        } else {
            sender.sendRichMessage(Message.NO_PERMISSION);// 提示无权限
        }
    }// 让指定玩家执行指令
    public static void handlesendMessageCommand(CommandSender sender, String[] args) {
        if (sender.hasPermission(Permission.ADMIN_PERMISSION)) {// 是否具有权限
            if (args.length == 0) {// 判断是否存在参数
                sender.sendRichMessage(Message.NO_PARAMETERS);
            } else if (args.length == 1) {// 判断参数为1时的情况，只为当前输入玩家修改模式
                Player target = Bukkit.getPlayer(args[ 0 ]);// 获取被操作的玩家id
                if (target != null) {
                    sender.sendRichMessage(Message.PREFIX + "<red>语法错误:请指定玩家 <yellow>" + target.getName() + " </yellow>要发送的消息!</red>");
                } else {
                    sender.sendRichMessage(Message.NOT_ONLINE);
                }
            } else {
                Player target = Bukkit.getPlayer(args[ 0 ]);// 获取被操作的玩家id
                StringBuilder Playermessage = new StringBuilder();
                for (int i = 1; i < args.length; i++) {
                    Playermessage.append(args[ i ]).append(" ");
                }// 获得想要发送的消息
                if (target != null) { // 当玩家id不为空时
                    target.chat(String.valueOf(Playermessage));
                    sender.sendRichMessage(Message.PREFIX + "<green>已让玩家 <yellow>" + target.getName() + "</yellow> 发送消息: </green><aqua>" + Playermessage + "</aqua>");
                } else {
                    sender.sendRichMessage(Message.NOT_ONLINE);// 玩家离线
                }
            }
        } else {
            sender.sendRichMessage(Message.NO_PERMISSION);// 提示无权限
        }
    }// 让指定玩家说话
    public static void handleHitoMessageCommand(CommandSender sender, String[] args) {
        if (sender.hasPermission(Permission.ADMIN_PERMISSION)) {// 是否具有权限
            String msg = hitokotoMsg.getHito();
            if (args.length == 0) {// 判断是否存在参数
                if (msg != null) {
                    sender.sendRichMessage("<yellow>一言:</yellow><aqua>" + msg + "</aqua>");//发送消息
                }
            } else {
                Player target = Bukkit.getPlayer(args[ 0 ]);
                if (target != null) {//参数不为空
                    target.sendRichMessage("<yellow>一言:</yellow><aqua>" + msg + "</aqua>");
                    sender.sendRichMessage(Message.PREFIX + "<green>已向玩家 <yellow>" + target.getName() + "</yellow> 发送一言:</green><aqua>" + msg + "</aqua>");//发送消息
                } else {
                    sender.sendRichMessage(Message.NOT_ONLINE);//玩家离线
                }
            }
        } else {
            sender.sendRichMessage(Message.NO_PERMISSION);// 提示无权限
        }
    }// 测试一言功能
//    public static void handleWTCommand(CommandSender sender, String[] args) {
//         switch (args[0]) {// 判断玩家输入的指令
//            case "ender", "enderchest" -> {
//                commandHandler.handleEnderchestCommand (sender, args);
//            }
//            case "workbench" -> {
//                commandHandler.handleWorkbenchCommand (sender, args);
//            }
//            case "anvil" -> {
//                commandHandler.handleAnvilCommand (sender, args);
//            }
//            case "cartographytable" -> {
//                commandHandler.handleCartographyTableCommand (sender, args);
//            }
//            case "loom" -> {
//                commandHandler.handleLoomCommand (sender, args);
//            }
//            case "stonecutter" -> {
//                commandHandler.handleStonecutterCommand (sender, args);
//            }
//            case "smithingtable" -> {
//                commandHandler.handleSmithingTableCommand (sender, args);
//            }
//            case "grindstone" -> {
//                commandHandler.handleGrindstoneCommand (sender, args);
//            }
//            case "help" -> {
//                commandHandler.handleHelpCommand (sender);
//            }
//            case "suicide" -> {
//                commandHandler.handleSuicideCommand (sender);
//            }
//            case "fly" -> {
//                commandHandler.handleFlyCommand (sender, args);
//            }
//            case "sudo" -> {
//                commandHandler.handleSudoCommand (sender, args);
//            }
//            case "sm" -> {
//                commandHandler.handlesendMessageCommand (sender, args);
//            }
//            case "hito" -> {
//                commandHandler.handleHitoMessageCommand (sender, args);
//            }
//             default -> {
//                 sender.sendRichMessage(Message.INVALID_SYNTAX);//发送消息
//             }
//        }
//    }
}

