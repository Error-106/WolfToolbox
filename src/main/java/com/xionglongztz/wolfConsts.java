package com.xionglongztz;

public final class wolfConsts {
    private wolfConsts(){}// 私有构造函数，防止被实例化
    public static final class Permission{ // 权限常量表
        public static final String ENDERCHEST_PERMISSION = "wolftoolbox.enderchest";// 随身末影箱权限
        public static final String WORKBENCH_PERMISSION = "wolftoolbox.workbench";// 随身合成台权限
        public static final String ANVIL_PERMISSION = "wolftoolbox.anvil";// 随身铁砧权限
        public static final String CARTOGRAPHYTABLE_PERMISSION = "wolftoolbox.cartographytable";// 随身制图台权限
        public static final String LOOM_PERMISSION = "wolftoolbox.loom";// 随身织布机权限
        public static final String STONECUTTER_PERMISSION = "wolftoolbox.stonecutter";// 随身切石机权限
        public static final String SMITHINGTABLE_PERMISSION = "wolftoolbox.smithingtable";// 随身锻造台权限
        public static final String GRINDSTONE_PERMISSION = "wolftoolbox.grindstone";// 随身砂轮权限
        public static final String SUICIDE_PERMISSION = "wolftoolbox.suicide";// 自杀权限
        public static final String FLY_PERMISSION = "wolftoolbox.fly";// 飞行权限
        public static final String ADMIN_PERMISSION = "wolftoolbox.admin";// 管理员权限
        public static final String MSG_PERMISSION = "wolftoolbox.msg";// 一言权限
    }
    public static final class Message{ // 消息文本常量表
        public static final String PREFIX = "<white>[<aqua>WolfToolbox</aqua>]</white> ";// 插件前缀
        public static final String ONENABLE = PREFIX + "<green>插件已启用!</green>";// 插件启用时显示
        public static final String ONDISABLE = PREFIX + "<red>插件已禁用!</red>";// 插件禁用时显示
        public static final String NO_PERMISSION = PREFIX + "<red>你没有权限这么做!</red>";// 无执行权限
        public static final String ONLY_PLAYER = PREFIX + "<red>该命令只能由玩家使用!</red>";// 在控制台执行时触发
        public static final String NOT_ONLINE = PREFIX + "<red>该玩家不在线!</red>";
        public static final String NO_PARAMETERS = PREFIX + "<red>语法错误:该指令不能单独执行!</red>";
        public static final String INVALID_SYNTAX = PREFIX + "<red>未知参数!请使用 /wthelp 查看帮助!</red>";
    }
}
