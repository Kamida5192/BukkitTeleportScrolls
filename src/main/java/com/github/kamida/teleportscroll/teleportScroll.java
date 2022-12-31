package com.github.kamida.teleportscroll;

import com.github.kamida.teleportscroll.commands.commands;
import com.github.kamida.teleportscroll.events.craftEvent;
import com.github.kamida.teleportscroll.events.teleportEvent;
import com.github.kamida.teleportscroll.items.itemManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class teleportScroll extends JavaPlugin {

    public static teleportScroll instance;

    public static teleportScroll getInstance() {
        return instance;
    }

    public static void logConsole(String message) {
        Bukkit.getConsoleSender().sendMessage("[Teleport Scrolls] " +  message);
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        itemManager.init();
        getCommand("telescroll").setExecutor(new commands());
        getServer().getPluginManager().registerEvents(new teleportEvent(), this);
        getServer().getPluginManager().registerEvents(new craftEvent(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
