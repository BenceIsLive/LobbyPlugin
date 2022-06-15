package dev.bence.lobbyplugin.menu;

import dev.bence.lobbyplugin.LobbyPlugin;
import dev.bence.lobbyplugin.libaries.ItemBuilder;
import dev.bence.lobbyplugin.utils.ChatUtils;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class SelectorMenu {

    LobbyPlugin main = LobbyPlugin.getPlugin(LobbyPlugin.class);
    public SelectorMenu(Player player) {

        Inventory inv = Bukkit.createInventory(player, 27, ChatUtils.format(main.getConfig().getString("server-selector.title")));

        ItemStack item = new ItemBuilder(Material.getMaterial(main.getConfig().getString("server-selector.item")))
                .setName(PlaceholderAPI.setPlaceholders(player, ChatUtils.format(main.getConfig().getString("server-selector.name"))))
                .setGlow(main.getConfig().getBoolean("server-selector.glow"))
                .setLore(PlaceholderAPI.setPlaceholders(player,ChatUtils.format(main.getConfig().getStringList("server-selector.lore"))))
                .build();
        inv.setItem(13, item);

        player.openInventory(inv);

    }
}

