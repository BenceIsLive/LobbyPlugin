package dev.bence.lobbyplugin.listeners.Flags;

import dev.bence.lobbyplugin.LobbyPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class FallDamageListener implements Listener {

    LobbyPlugin main = LobbyPlugin.getPlugin(LobbyPlugin.class);

    @EventHandler
    public void onFallDamage(EntityDamageEvent e) {


        if (main.getConfig().getBoolean("fall-damage")) {
            e.setCancelled(false);
        } else if (!main.getConfig().getBoolean("fall-damage")) {
            e.setCancelled(true);
        }


    }

}