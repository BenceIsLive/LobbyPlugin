package dev.bence.lobbyplugin.listeners;

import dev.bence.lobbyplugin.LobbyPlugin;
import dev.bence.lobbyplugin.utils.ChatUtils;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ParticleClickListener implements Listener {

    LobbyPlugin main = LobbyPlugin.getInstance();

    @EventHandler
    public void onParticleClick(InventoryClickEvent e) {

        Player player = (Player) e.getWhoClicked();

        if(e.getView().getTitle().equalsIgnoreCase(ChatUtils.format(main.getConfig().getString("particle-menu-title"))) && e.getCurrentItem() != null) {
            e.setCancelled(true);
            switch (e.getRawSlot()) {
                case 10: // kit
                    player.spawnParticle(Particle.BUBBLE_POP, player.getLocation(), 10);
                    player.sendMessage("Je hebt nu een drip lava particle");
                    break;
                default:
                    return;
            }
            player.closeInventory();

        }


        }
}