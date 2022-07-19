package dev.bence.lobbyplugin.listeners.JoinUtils.Utils;

import dev.bence.lobbyplugin.LobbyPlugin;
import dev.bence.lobbyplugin.menu.CosmeticMenu;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class ParticleChest implements Listener {

    private final LobbyPlugin plugin;

    public ParticleChest(LobbyPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onParticleClick(PlayerInteractEvent e) {

        Player player = e.getPlayer();

        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK && e.getItem() != null) {
            if (player.getInventory().getItemInMainHand().getType().equals(Material.CHEST) && e.getItem() != null) {

                new CosmeticMenu(player);


            }
        }
    }
}

