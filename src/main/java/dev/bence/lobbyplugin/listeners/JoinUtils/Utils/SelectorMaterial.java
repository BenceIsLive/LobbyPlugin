package dev.bence.lobbyplugin.listeners.JoinUtils.Utils;

import dev.bence.lobbyplugin.LobbyPlugin;
import dev.bence.lobbyplugin.menu.SelectorMenu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class SelectorMaterial implements Listener {

    LobbyPlugin main = LobbyPlugin.getPlugin(LobbyPlugin.class);

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        Player player = e.getPlayer();

        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getItem() != null) {
            if (e.getItem().getType().equals(Material.getMaterial(main.getSelectorFile().getString("selector.item")))) {

                new SelectorMenu(player);
            }


        }
    }
}