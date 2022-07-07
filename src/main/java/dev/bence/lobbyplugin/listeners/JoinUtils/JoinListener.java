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


        if (main.getConfig().getBoolean("selector-item.enabled")) {
            ItemStack joinItem = new ItemBuilder(Material.getMaterial(main.getSelectorFile().getString("selector-item")))
                    .setName(ChatUtils.format(main.getSelectorFile().getString("selector.name")))
                    .setLore(ChatUtils.format(main.getSelectorFile().getStringList("selector.lore")))
                    .setAmount(main.getSelectorFile().getInt("selector.amount"))
                    .build();
            player.getInventory().setItem(main.getConfig().getInt("selector-item.slot"), joinItem);
        }

            if (main.getConfig().getBoolean("particle-menu.enabled")) {
                ItemStack particleChest = new ItemBuilder(Material.CHEST)
                        .setName(ChatUtils.format(main.getParticleFile().getString("particle-chest.name")))
                        .setLore(ChatUtils.format(main.getParticleFile().getStringList("particle-chest.lore")))
                        .build();
                player.getInventory().setItem(main.getConfig().getInt("particle-menu.slot"), particleChest);
            }

                ItemStack hideItem = new ItemBuilder(Material.LIME_DYE)
                        .setName(ChatUtils.format(main.getDataFile().getString("zichtbaarheid-aan")))
                        .build();


                e.setJoinMessage(joinMessage);
                player.getInventory().setItem(8, hideItem);


            }
        }



