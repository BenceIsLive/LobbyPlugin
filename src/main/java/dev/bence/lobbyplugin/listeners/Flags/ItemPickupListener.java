package dev.bence.lobbyplugin.listeners.Flags;

import dev.bence.lobbyplugin.LobbyPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class ItemPickupListener implements Listener {

    LobbyPlugin main = LobbyPlugin.getInstance();

    @EventHandler
    public void onItemPickup(EntityPickupItemEvent e) {

        if (main.getConfig().getBoolean("item-pickup")) {
            e.setCancelled(false);
        } else if (!main.getConfig().getBoolean("item-pickup")) {
            e.setCancelled(true);
        }
    }
}
