package dev.bence.lobbyplugin.menu;

import dev.bence.lobbyplugin.LobbyPlugin;
import dev.bence.lobbyplugin.libaries.ItemBuilder;
import dev.bence.lobbyplugin.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;


public class CosmeticMenu {

    LobbyPlugin main = LobbyPlugin.getPlugin(LobbyPlugin.class);

    public CosmeticMenu(Player player) {

        Inventory inv = Bukkit.createInventory(player, 27, main.getParticleFile().getString("particle-menu-title"));

        for (String key : main.getParticleFile().getConfigurationSection("particle-menu.").getKeys(false)) {
            ConfigurationSection keySection = main.getParticleFile().getConfigurationSection("particle-menu.").getConfigurationSection(key);
            int slot = keySection.getInt("slot");
            ItemStack item = new ItemBuilder(Material.getMaterial(keySection.getString("item")))
                    .setName(ChatUtils.format(keySection.getString("name")))
                    .setLore(ChatUtils.format(keySection.getStringList("lore")))
                    .build();
            inv.setItem(slot, item);

            player.openInventory(inv);
        }
    }
}


