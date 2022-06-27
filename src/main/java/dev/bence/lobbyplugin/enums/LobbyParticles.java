package dev.bence.lobbyplugin.enums;

import org.bukkit.Material;
import org.bukkit.Particle;

public enum LobbyParticles {

    PARTICLE_LAVADRIP(Particle.DRIP_LAVA, 1, Material.LAVA_BUCKET, 1, "&6&lDrip-Lava Particle", "lobbyplugin.lavadrip", "CIRCLE"),
    PARTICLE_HEART(Particle.HEART,1, Material.RED_DYE, 2,"&c&lHeart Particle", "lobbyplugin.heart", "CIRCLE"),
    PARTICLE_ANGRY(Particle.VILLAGER_ANGRY,1,Material.DIAMOND_SWORD,3,"&4&lAngry Particle", "lobbyplugin.angry", "CIRCLE");

    private final Particle particle;
    private final int count;
    private final Material menuItem;
    private final int slot;
    private final String itemName;
    private final String permission;
    private final String type;


    LobbyParticles(Particle particle, int count, Material menuItem, int slot, String itemName, String permission, String type) {
        this.particle = particle;
        this.count = count;
        this.menuItem = menuItem;
        this.slot = slot;
        this.itemName = itemName;
        this.permission = permission;
        this.type = type;
    }
    public Particle getParticle() {
        return particle;
    }
    public int getCount() {
        return count;
    }
    public Material getMenuItem() {
        return menuItem;
    }
    public int getSlot() {
        return slot;
    }
    public String getItemName() {
        return itemName;
    }
    public String getPermission() {
        return permission;
    }
    public String getType() { return type; }
}
