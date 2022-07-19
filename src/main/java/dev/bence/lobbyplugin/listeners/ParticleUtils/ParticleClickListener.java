package dev.bence.lobbyplugin.listeners.ParticleUtils;

import dev.bence.lobbyplugin.LobbyPlugin;
import dev.bence.lobbyplugin.listeners.ParticleUtils.Types.Types;
import dev.bence.lobbyplugin.utils.BungeeUtils;
import dev.bence.lobbyplugin.utils.ChatUtils;
import org.bukkit.Particle;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.HashMap;
import java.util.UUID;

public class ParticleClickListener implements Listener {

    LobbyPlugin main = LobbyPlugin.getInstance();
    public static HashMap<UUID, Particle> playerParticle = new HashMap<>();
    public Types types;

    @EventHandler
    public void onParticleClick(InventoryClickEvent e) {
        Player player = (Player) e.getWhoClicked();
        // ckeck name title
        if (e.getView().getTitle().equalsIgnoreCase(ChatUtils.format(main.getParticleFile().getString("particle-menu-title"))) && e.getCurrentItem() != null) {
            e.setCancelled(true);
            // remove/replace/add player to hashmap
            for (String key : main.getParticleFile().getConfigurationSection("particle-menu.").getKeys(false)) {
                ConfigurationSection keySection = main.getParticleFile().getConfigurationSection("particle-menu.").getConfigurationSection(key);
                int slot = keySection.getInt("slot");
                checkSlotStatus(e.getRawSlot(), slot, keySection, player);
//                if( keySection.getString("type") != null){
//                    types.applyType(player, keySection.getString("type"));
//                }

            }
            player.closeInventory();
        }
    }

    public void checkSlotStatus(int slotNumber1, int slotNumber2, ConfigurationSection keySection, Player player) {
        if (slotNumber1 == slotNumber2) {
            String particle_name = keySection.getString("particle");
            Particle particle = Particle.valueOf(particle_name);
            if (player.hasPermission(keySection.getString("permission"))) {
                if (!(playerParticle.containsKey(player.getUniqueId()))) {
                    playerParticle.put(player.getUniqueId(), particle);
                    player.sendMessage(ChatUtils.format(main.getDataFile().getString("prefix")) + ChatUtils.format(main.getDataFile().getString("particle-aan").replace("%particle_name%", particle_name)));
                } else if (playerParticle.get(player.getUniqueId()) == particle) {
                    playerParticle.remove(player.getUniqueId());
                    player.sendMessage(ChatUtils.format(main.getDataFile().getString("prefix")) + ChatUtils.format(main.getDataFile().getString("particle-uit").replace("%particle_name%", particle_name)));
                } else {
                    playerParticle.replace(player.getUniqueId(), particle);
                    player.sendMessage(ChatUtils.format(main.getDataFile().getString("prefix")) + ChatUtils.format(main.getDataFile().getString("particle-uit").replace("%particle_name%", particle_name)));
                    player.sendMessage(ChatUtils.format(main.getDataFile().getString("prefix")) + ChatUtils.format(main.getDataFile().getString("particle-aan").replace("%particle_name%", particle_name)));
                }


            } else {
                player.sendMessage(ChatUtils.format(main.getDataFile().getString("prefix")) + ChatUtils.format(main.getDataFile().getString("no-permission-particle")));
            }
        }
    }
}