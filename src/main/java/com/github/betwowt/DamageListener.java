package com.github.betwowt;

import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.Plugin;

public class DamageListener implements Listener{

    private  Plugin plugin = FallProtection.getFallProtection();
    private String height = plugin.getConfig().getString("config.height");
    @EventHandler
    private void Fall(EntityDamageEvent event){
        if (event.getEntityType().equals(EntityType.PLAYER)) {
            if (event.getCause().equals(EntityDamageEvent.DamageCause.FALL)){
                Bukkit.getLogger().info(height);
                try {
                    if (event.getDamage()>Integer.parseInt(height)){
                        event.setCancelled(true);
                        event.getEntity().sendMessage("收到天神的祝福");
                    }
                }catch (NumberFormatException e){
                    Bukkit.getLogger().info(e.getMessage());
                }

            }
        }

    }
}
