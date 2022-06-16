package dev.bence.lobbyplugin.menu;

import dev.bence.lobbyplugin.LobbyPlugin;
import dev.bence.lobbyplugin.libaries.ItemBuilder;
import dev.bence.lobbyplugin.utils.ChatUtils;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SelectorMenu {

    LobbyPlugin main = LobbyPlugin.getPlugin(LobbyPlugin.class);

    public SelectorMenu(Player player) {

        Inventory inv = Bukkit.createInventory(player, 27, ChatUtils.format(main.getConfig().getString("server-selector-title")));

        for (String key : main.getConfig().getConfigurationSection("server-selector.").getKeys(false)) {
            ConfigurationSection keySection = main.getConfig().getConfigurationSection("server-selector.").getConfigurationSection(key);
            int slot = keySection.getInt("slot");
            ItemStack item = new ItemBuilder(Material.getMaterial(keySection.getString("item")))
                    .setName(ChatUtils.format(keySection.getString("name")))
                    .setLore(ChatUtils.format(keySection.getStringList("lore")))
                    .setGlow(keySection.getBoolean("glow"))
                    .setPersistentData("action", keySection.getString("action"))
                    .build();
            inv.setItem(slot, item);

            player.openInventory(inv);
        }
    }
}


