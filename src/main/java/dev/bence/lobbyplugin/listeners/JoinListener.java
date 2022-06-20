package dev.bence.lobbyplugin.listeners;

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

        String joinMessageOld = PlaceholderAPI.setPlaceholders(player,ChatUtils.format(main.getConfig().getString("join-message")));
        String joinMessage = joinMessageOld.replaceAll("%player%", player.getDisplayName());

        e.setJoinMessage(joinMessage);

        Firework fireWork = (Firework) e.getPlayer().getWorld().spawnEntity(player.getLocation(), EntityType.FIREWORK);
        FireworkMeta fwMeta = fireWork.getFireworkMeta();

        fwMeta.addEffect(FireworkEffect.builder()
                .flicker(false)
                .trail(true)
                .with(FireworkEffect.Type.STAR)
                .withColor(Color.BLUE)
                .withColor(Color.WHITE)
                .withFade(Color.RED)
                .build());
        fireWork.setFireworkMeta(fwMeta);


        if (main.getConfig().getBoolean("particle-menu")) {
            ItemStack particleItem = new ItemBuilder(Material.CHEST)
                    .setName(ChatUtils.format("&aParticle Menu"))
                    .setLore(ChatUtils.format("&7Zet hier jou particles aan!"))
                    .build();
            player.getInventory().setItem(0, particleItem);
        }

        ItemStack joinItem = new ItemStack(Material.getMaterial(main.getConfig().getString("join-item.material")), 1);
        ItemStack lime = new ItemStack(Material.LIME_DYE, 1);

        player.getInventory().setItem(4, joinItem);

        ItemStack hideItem = new ItemStack(Material.LIME_DYE);

        player.getInventory().setItem(8, hideItem);


    }
}

