package dev.bence.lobbyplugin.listeners.JoinUtils.Utils;

import dev.bence.lobbyplugin.LobbyPlugin;
import dev.bence.lobbyplugin.utils.ChatUtils;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class JoinMessage implements Listener {

    LobbyPlugin main = LobbyPlugin.getPlugin(LobbyPlugin.class);

    public void onMessage(PlayerJoinEvent e) {

        Player player = e.getPlayer();

        String joinMessageOld = PlaceholderAPI.setPlaceholders(player, ChatUtils.format(main.getConfig().getString("join-message")));
        String joinMessage = joinMessageOld.replaceAll("%player%", player.getDisplayName());

        e.setJoinMessage(joinMessage);

    }
}
