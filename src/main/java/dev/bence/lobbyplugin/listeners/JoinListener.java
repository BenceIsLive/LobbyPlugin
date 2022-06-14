package dev.bence.lobbyplugin.listeners;

import dev.bence.lobbyplugin.LobbyPlugin;
import dev.bence.lobbyplugin.utils.ChatUtils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class JoinListener implements Listener {

    LobbyPlugin main = LobbyPlugin.getPlugin(LobbyPlugin.class);
    public static LobbyPlugin instance;

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        Player player = e.getPlayer();

        player.getInventory().clear();

        String joinMessageOld = ChatUtils.format(main.getConfig().getString("join-message"));
        String joinMessage = joinMessageOld.replaceAll("%player%", player.getDisplayName());

        e.setJoinMessage(joinMessage);

        ItemStack joinItem = new ItemStack(Material.getMaterial(main.getConfig().getString("join-item.material")), 1);
        ItemStack lime = new ItemStack(Material.LIME_DYE, 1);

        player.getInventory().setItem(4, joinItem);

        ItemStack hideItem = new ItemStack(Material.LIME_DYE);

        player.getInventory().setItem(8, hideItem);


    }
}

