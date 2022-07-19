package dev.bence.lobbyplugin.listeners;

import dev.bence.lobbyplugin.LobbyPlugin;
import dev.bence.lobbyplugin.utils.BungeeUtils;
import dev.bence.lobbyplugin.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.Server;
import org.bukkit.configuration.ConfigurationSection;
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

            for (String key : main.getSelectorFile().getConfigurationSection("server-selector").getKeys(false)) {
                ConfigurationSection keySection = main.getSelectorFile().getConfigurationSection("server-selector").getConfigurationSection(key);
                int slot = keySection.getInt("slot");
                checkSlotStatus(e.getRawSlot(), slot, keySection, player);

            }

        }

    }

    public void checkSlotStatus(int slotNumber1, int slotNumber2, ConfigurationSection keySection, Player player) {
        if (slotNumber1 == slotNumber2) {
            BungeeUtils.connect(player, keySection.getString("server"));
        }
    }
}

