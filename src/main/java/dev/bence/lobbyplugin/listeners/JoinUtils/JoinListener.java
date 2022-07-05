package dev.bence.lobbyplugin.listeners.JoinUtils;

import dev.bence.lobbyplugin.LobbyPlugin;
import dev.bence.lobbyplugin.libaries.ItemBuilder;
import dev.bence.lobbyplugin.utils.ChatUtils;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.*;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.inventory.meta.ItemMeta;

public class JoinListener implements Listener {

    LobbyPlugin main = LobbyPlugin.getPlugin(LobbyPlugin.class);
    public static LobbyPlugin instance;

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        Player player = e.getPlayer();

        player.getInventory().clear();

        String joinMessage = PlaceholderAPI.setPlaceholders(player, ChatUtils.format(main.getDataFile().getString("join-message")));

        ItemStack joinItem = new ItemBuilder(Material.getMaterial(main.getSelectorFile().getString("selector-item")))
                .setName(ChatUtils.format(main.getSelectorFile().getString("selector.name")))
                .setLore(ChatUtils.format(main.getSelectorFile().getStringList("selector.lore")))
                .setAmount(main.getSelectorFile().getInt("selector.amount"))
                .build();
        ItemStack particleChest = new ItemBuilder(Material.CHEST)
                .setName(ChatUtils.format(main.getConfig().getString("particle-chest.name")))
                .setLore(ChatUtils.format(main.getConfig().getStringList("particle-chest.lore")))
                .build();
        ItemStack hideItem = new ItemBuilder(Material.LIME_DYE)
            .setName(ChatUtils.format(main.getDataFile().getString("zichtbaarheid-aan")))
            .build();


        e.setJoinMessage(joinMessage);
        player.getInventory().setItem(4, joinItem);
        player.getInventory().setItem(8, hideItem);
        player.getInventory().setItem(0, particleChest);


    }
}

