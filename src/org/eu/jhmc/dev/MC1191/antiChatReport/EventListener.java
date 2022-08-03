package org.eu.jhmc.dev.MC1191.antiChatReport;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class EventListener implements Listener {
    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        if(e == null)
            return;
        e.setCancelled(true);
        if(cmdMute.mutePlayers.contains(e.getPlayer().getName()))
            return;
        String Message = e.getMessage();
        String MsgSender = e.getPlayer().getDisplayName();
        plugin.server.broadcastMessage("<"+MsgSender+"> "+Message);
    }
}
