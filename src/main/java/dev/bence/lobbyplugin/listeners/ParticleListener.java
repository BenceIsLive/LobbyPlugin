package dev.bence.lobbyplugin.listeners;

import dev.bence.lobbyplugin.LobbyPlugin;
import dev.bence.lobbyplugin.menu.ParticleMenu;
import dev.bence.lobbyplugin.menu.SelectorMenu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class ParticleListener implements Listener {

    LobbyPlugin main = LobbyPlugin.getPlugin(LobbyPlugin.class);

    @EventHandler
    public void particleEvent(PlayerInteractEvent e) {
        Player player = e.getPlayer();

        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getItem() != null) {
            if (e.getItem().getType().equals(Material.CHEST)) {

                new ParticleMenu(player);
            }


        }
    }

}
