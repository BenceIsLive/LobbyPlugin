package dev.bence.lobbyplugin.listeners;

import dev.bence.lobbyplugin.LobbyPlugin;
import dev.bence.lobbyplugin.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class HideListener implements Listener {

    LobbyPlugin main = LobbyPlugin.getPlugin(LobbyPlugin.class);
    public static LobbyPlugin instance;

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {

        Player player = e.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();

        ItemStack lime = new ItemStack(Material.LIME_DYE);
        ItemMeta limeMeta = lime.getItemMeta();
        limeMeta.setDisplayName(ChatUtils.format("&cSpelers verbergen"));
        limeMeta.setLore(Arrays.asList(ChatUtils.format("&7&oLinkermuisknop om spelers te verbergen!")));

        ItemStack gray = new ItemStack(Material.GRAY_DYE);
        ItemMeta grayMeta = gray.getItemMeta();
        grayMeta.setDisplayName(ChatUtils.format("&cSpelers zichtbaar maken"));
        grayMeta.setLore(Arrays.asList(ChatUtils.format("&7&oRechtermuisknop om spelers te laten zien!")));


        e.setCancelled(true);
        if (e.getMaterial().equals(Material.GRAY_DYE)) {
            for (Player players : Bukkit.getOnlinePlayers()) {
                if (main.hidden.contains(player)) {
                    main.hidden.remove(player);
                    player.showPlayer(players);
                    player.getInventory().getItemInMainHand().setType(Material.LIME_DYE);
                    item.setItemMeta(limeMeta);
                    player.updateInventory();
                    player.sendMessage(ChatUtils.format(main.getConfig().getString("prefix") + "&aSpelers zichtbaar"));
                }
            }
        } else if (e.getMaterial().equals(Material.LIME_DYE)) {
            for (Player players : Bukkit.getOnlinePlayers()) {
                if (!main.hidden.contains(player)) {
                    main.hidden.add(player);
                    player.hidePlayer(players);
                    player.getInventory().getItemInMainHand().setType(Material.GRAY_DYE);
                    item.setItemMeta(grayMeta);
                    player.updateInventory();
                    player.sendMessage(ChatUtils.format(main.getConfig().getString("prefix") + "&cSpelers verborgen"));
                }
            }
        }
    }
}








