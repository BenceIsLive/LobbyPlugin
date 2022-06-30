package dev.bence.lobbyplugin.listeners;

import dev.bence.lobbyplugin.LobbyPlugin;
import dev.bence.lobbyplugin.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.persistence.PersistentDataType;

public class SelectorClickListener implements Listener {

    LobbyPlugin main = LobbyPlugin.getInstance();

    @EventHandler
    public void onClick(InventoryClickEvent e) {

        Player player = (Player) e.getWhoClicked();

                e.setCancelled(true);

            if (e.getView().getTitle().equalsIgnoreCase(ChatUtils.format(main.getSelectorFile().getString("server-selector-title")))) {
                e.setCancelled(true);


                String persistentData = e.getCurrentItem().getItemMeta().getPersistentDataContainer().get(new NamespacedKey(main, "action"), PersistentDataType.STRING);
                switch (persistentData) {
                    case "[SURVIVAL]":
                        player.performCommand("server survival");
                        player.sendMessage(ChatUtils.format("&aU wordt verzonden naar de Survival"));
                    case "[LOBBY]":
                        player.performCommand("server lobby");
                }
            }
        }
    }

