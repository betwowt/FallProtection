package com.github.betwowt;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public final class FallProtection extends JavaPlugin {
    private static FallProtection fallProtection;
    public static FallProtection getFallProtection(){
        return fallProtection;
    }
    private Logger logger = getLogger();

    @Override
    public void onEnable() {
        fallProtection=this;
        // Plugin startup logic
        this.saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new DamageListener(),this);
        Bukkit.getLogger().info("FallProtection 已启用");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Bukkit.getLogger().info("FallProtection 已卸载");
    }
}
