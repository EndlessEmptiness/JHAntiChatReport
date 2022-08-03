package org.eu.jhmc.dev.MC1191.antiChatReport;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class plugin extends JavaPlugin {
    public static Logger logger;
    public static FileConfiguration config;
    public static Server server;
    public static JavaPlugin instance;
    public static boolean enable;

    @Override
    public void onEnable(){
        if (Bukkit.getPluginCommand("JHAntiChatReport") != null) {
            Bukkit.getPluginCommand("JHAntiChatReport").setExecutor(new cmdToggle());
            Bukkit.getPluginCommand("JHAntiChatReport").setTabCompleter(new cmdToggle());
            logger.info("command /JHAntiChatReport registered");
        } else logger.warning("Unable to register command /JHAntiChatReport");
        if (Bukkit.getPluginCommand("acrMute") != null) {
            Bukkit.getPluginCommand("acrMute").setExecutor(new cmdMute());
            logger.info("command /acrMute registered");
        } else logger.warning("Unable to register command /acrMute");
        if (Bukkit.getPluginCommand("acrUnmute") != null) {
            Bukkit.getPluginCommand("acrUnmute").setExecutor(new cmdUnMute());
            logger.info("command /acrUnmute registered");
        } else logger.warning("Unable to register command /acrUnmute");

        Bukkit.getPluginManager().registerEvents(new EventListener(), this);
    }

    @Override
    public void onDisable(){
        config.set("antiChatReport.enable",enable);
        config.set("antiChatReport.mutePlayers",cmdMute.mutePlayers);
        saveConfig();
    }

    @Override
    public void onLoad(){
        saveDefaultConfig();
        logger = getLogger();
        config = getConfig();
        server = getServer();
        instance = this;
        enable = config.getBoolean("antiChatReport.enable",true);
        cmdMute.mutePlayers = plugin.instance.getConfig().getStringList("antiChatReport.mutePlayers");
    }
}
