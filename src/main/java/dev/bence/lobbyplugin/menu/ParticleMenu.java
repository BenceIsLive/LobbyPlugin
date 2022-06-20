package dev.bence.lobbyplugin.menu;

import dev.bence.lobbyplugin.LobbyPlugin;
import dev.bence.lobbyplugin.libaries.ItemBuilder;
import dev.bence.lobbyplugin.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class ParticleMenu {

    LobbyPlugin main = LobbyPlugin.getPlugin(LobbyPlugin.class);

    public ParticleMenu(Player player) {

        Inventory inv = Bukkit.createInventory(player, 54, ChatUtils.format(main.getConfig().getString("particle-menu-title")));

        ItemStack dripLava = new ItemBuilder(Material.LAVA_BUCKET)
                .setName("Krijg lava om je heen")
                .build();
       inv.setItem(10, dripLava);

        player.openInventory(inv);
    }
}
