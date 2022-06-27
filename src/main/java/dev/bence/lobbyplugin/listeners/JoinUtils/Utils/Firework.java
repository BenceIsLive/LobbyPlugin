package dev.bence.lobbyplugin.listeners.JoinUtils.Utils;

import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.meta.FireworkMeta;

public class Firework implements Listener {

    @EventHandler
    public void onFirework(PlayerJoinEvent e) {

        Player player = e.getPlayer();

        org.bukkit.entity.Firework fireWork = (org.bukkit.entity.Firework) e.getPlayer().getWorld().spawnEntity(player.getLocation(), EntityType.FIREWORK);
        FireworkMeta fwMeta = fireWork.getFireworkMeta();

        fwMeta.addEffect(FireworkEffect.builder()
                .flicker(false)
                .trail(true)
                .with(FireworkEffect.Type.STAR)
                .withColor(Color.BLUE)
                .withColor(Color.WHITE)
                .withFade(Color.RED)
                .build());
        fireWork.setFireworkMeta(fwMeta);
    }
}
