package org.eu.jhmc.dev.MC1191.antiChatReport;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class cmdToggle implements CommandExecutor, TabCompleter {
    static final List<String> tabCompleter = new ArrayList<>();
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            sender.sendMessage(ChatColor.RED+"[错误] 此命令仅可后台执行");
            return true;
        }
        if(args.length == 0) {
            if(plugin.enable)
                plugin.logger.info("AntiChatReport is Enabled");
            else
                plugin.logger.info("AntiChatReport is Disabled");
            return true;
        }
        if(args.length != 1)
            return false;
        if(!Objects.equals(args[0], "true") && !Objects.equals(args[0], "false"))
            return false;
        else
            plugin.enable = Objects.equals(args[0], "true");
        return true; // 正常退出
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        if(args.length >= 2)
            return null;
        else
            return tabCompleter;
    }

    static {
        tabCompleter.add("true");
        tabCompleter.add("false");
    }
}
