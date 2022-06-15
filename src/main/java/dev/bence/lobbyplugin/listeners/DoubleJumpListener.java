package dev.bence.lobbyplugin.listeners;

import dev.bence.lobbyplugin.LobbyPlugin;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;

public class DoubleJumpListener implements Listener {

    LobbyPlugin main = LobbyPlugin.getPlugin(LobbyPlugin.class);


    @EventHandler
    public void onPlayerFly(PlayerToggleFlightEvent e) {
        Player p = e.getPlayer();


        if (main.getConfig().getBoolean("double-jump")) {
            if (p.getGameMode() != GameMode.CREATIVE) {
                e.setCancelled(true);
                p.setAllowFlight(false);
                p.setFlying(false);
                p.setVelocity(p.getLocation().getDirection().multiply(2.0D).setY(0.9D));
                p.playEffect(p.getLocation(), Effect.BLAZE_SHOOT, 15);
            }
        }
    }


    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();

        if (main.getConfig().getBoolean("double-jump")) {
            if ((e.getPlayer().getGameMode() != GameMode.CREATIVE)
                    && (p.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() != Material.AIR)) {
                p.setAllowFlight(true);
            }

        } else {
            p.setAllowFlight(false);
        }
    }
}