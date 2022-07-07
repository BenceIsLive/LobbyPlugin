package dev.bence.lobbyplugin.listeners.ParticleUtils;

import dev.bence.lobbyplugin.LobbyPlugin;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

import static dev.bence.lobbyplugin.listeners.ParticleUtils.ParticleClickListener.playerParticle;


public class ParticleMoveListener implements Listener {

    private final LobbyPlugin plugin;

    public ParticleMoveListener(LobbyPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player player = e.getPlayer();
        if (playerParticle.containsKey(player.getUniqueId())) {
            player.spawnParticle(playerParticle.get(player.getUniqueId()), player.getLocation(), 10);
        }
    }
}

