package org.eu.jhmc.dev.MC1191.antiChatReport;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class cmdMute implements CommandExecutor {
    public static List<String> mutePlayers;
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            if (!sender.hasPermission("acr.mute")) {
                sender.sendMessage(ChatColor.RED+"无权限! ");
                sender.sendMessage(ChatColor.RED+"需要权限 acr.mute");
                return true;
            }
        }
        if(args.length != 1)
            return false;
        if(!mutePlayers.contains(args[0]))
            mutePlayers.add(args[0]);
        if(sender instanceof Player) sender.sendMessage(ChatColor.GREEN+"已禁言 "+args[0]);
        return true;
    }
}
