package dev.bence.lobbyplugin.listeners.Flags;

import dev.bence.lobbyplugin.LobbyPlugin;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class VoidSpawnListener implements Listener {

    LobbyPlugin main = LobbyPlugin.getInstance();

    @EventHandler
    public void onVoid(EntityDamageEvent e) {

        Player player = (Player) e.getEntity();

        if (main.getConfig().getBoolean("void-teleport")) {
            if (e.getCause().equals(EntityDamageEvent.DamageCause.VOID)) {
                player.teleport(Bukkit.getWorld("world").getSpawnLocation());
                e.setCancelled(false);
            } else if (!main.getConfig().getBoolean("void-teleport")) {
                e.setCancelled(true);
            }

        }
    }
}
