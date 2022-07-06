package dev.bence.lobbyplugin.listeners.ParticleUtils.Types;

import org.bukkit.Location;
import org.bukkit.entity.Player;

import static dev.bence.lobbyplugin.listeners.ParticleUtils.ParticleClickListener.playerParticle;

public class Types {

    public void applyType(Player player, String type) {
        Location location = player.getLocation();
        switch (type){
            case "Circle":
                float radius = 1;
                for (double t = 0; t < 50; t += 0.5) {
                    float x = radius * (float) Math.sin(t);
                    float z = radius * (float) Math.cos(t);
                    location.getWorld().spawnParticle(playerParticle.get(player.getUniqueId()), (float) location.getX() + x, (float) location.getY(), (float) location.getZ() + z, 0, 0, 0, 0, 1);
                }break;
            default:
        }

    }
}
