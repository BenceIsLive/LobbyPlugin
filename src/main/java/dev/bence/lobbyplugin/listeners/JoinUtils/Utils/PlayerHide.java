package dev.bence.lobbyplugin.listeners.JoinUtils.Utils;

import dev.bence.lobbyplugin.LobbyPlugin;
import dev.bence.lobbyplugin.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerHide implements Listener {

    LobbyPlugin main = LobbyPlugin.getPlugin(LobbyPlugin.class);
    public static LobbyPlugin instance;

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {

        Player player = e.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();

        ItemStack lime = new ItemStack(Material.LIME_DYE);
        ItemMeta limeMeta = lime.getItemMeta();
        limeMeta.setDisplayName(ChatUtils.format(main.getDataFile().getString("zichtbaarheid-aan")));

        ItemStack gray = new ItemStack(Material.GRAY_DYE);
        ItemMeta grayMeta = gray.getItemMeta();
        grayMeta.setDisplayName(ChatUtils.format(main.getDataFile().getString("zichtbaarheid-uit")));



    if (e.getHand().equals(EquipmentSlot.HAND)) {
        if (item.getType().equals(Material.GRAY_DYE)) {
            e.setCancelled(true);

                for (Player players : Bukkit.getOnlinePlayers()) {
                    if (main.hidden.contains(player)) {
                        main.hidden.remove(player);
                        player.showPlayer(players);
                        player.getInventory().getItemInMainHand().setType(Material.LIME_DYE);
                        item.setItemMeta(limeMeta);
                        player.updateInventory();
                        player.sendMessage(ChatUtils.format(main.getDataFile().getString("prefix") + main.getDataFile().getString("zichtbaarheid-aan-message")));
                    }
                }
            } else if (item.getType().equals(Material.LIME_DYE)) {
                for (Player players : Bukkit.getOnlinePlayers()) {
                    if (!main.hidden.contains(player)) {
                        main.hidden.add(player);
                        player.hidePlayer(players);
                        player.getInventory().getItemInMainHand().setType(Material.GRAY_DYE);
                        item.setItemMeta(grayMeta);
                        player.updateInventory();
                        player.sendMessage(ChatUtils.format(main.getDataFile().getString("prefix") + main.getDataFile().getString("zichtbaarheid-uit-message")));
                    }
                }
            }
        }
    }
}
