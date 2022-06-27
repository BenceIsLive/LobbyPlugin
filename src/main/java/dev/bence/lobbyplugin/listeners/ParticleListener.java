package dev.bence.lobbyplugin.listeners;

import dev.bence.lobbyplugin.LobbyPlugin;
import dev.bence.lobbyplugin.enums.LobbyParticles;
import dev.bence.lobbyplugin.utils.ChatUtils;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;

public class ParticleListener implements Listener {

    private final LobbyPlugin plugin;

    public ParticleListener(LobbyPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onClickParticle(InventoryClickEvent event) {
        if (!(event.getWhoClicked() instanceof Player player)) return;

        if (!(event.getView().getTitle().equalsIgnoreCase(ChatUtils.format("&6Particle Menu")))) return;

        event.setCancelled(true);

        if (event.getCurrentItem().getType() == Material.BARRIER && event.getCurrentItem().getItemMeta().getDisplayName().equals(ChatUtils.format("&cTurn off Particle"))) {
            if (plugin.getParticleManager().doesPlayerParticleExist(player)) {
                plugin.getParticleManager().removePlayerFromParticleMap(player);
                player.sendMessage(ChatUtils.format("&cJe hebt nu je particle uitgezet."));
                player.closeInventory();
            } else {
                player.sendMessage(ChatUtils.format("&cJe hebt geen particle aanstaan."));
            }
            return;

        }

        if (!plugin.getParticleMenu().doesMaterialExistInMap(event.getCurrentItem())) return;

        if (plugin.getParticleManager().doesPlayerParticleExist(player)) {
            plugin.getParticleManager().removePlayerFromParticleMap(player);
        }

        LobbyParticles lobbyParticles = plugin.getParticleMenu().getLobbyParticlesFromMap(event.getCurrentItem());

        if (player.hasPermission(lobbyParticles.getPermission())) {
            plugin.getParticleManager().addPlayerToParticleMap(player, lobbyParticles);

            player.sendMessage(ChatUtils.format("&6Je hebt nu de &c" + lobbyParticles.getItemName() + " &6aangezet."));
        } else {
            player.sendMessage(ChatUtils.format("&cJe hebt geen permission om deze particle te gebruiken."));
        }
        player.closeInventory();
    }
}
