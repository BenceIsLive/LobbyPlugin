package dev.bence.lobbyplugin.listeners;

import dev.bence.lobbyplugin.LobbyPlugin;
import dev.bence.lobbyplugin.utils.ChatUtils;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class QuitListener implements Listener {

    LobbyPlugin main = LobbyPlugin.getPlugin(LobbyPlugin.class);

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {

        Player player = e.getPlayer();

        String leaveMessageOld = PlaceholderAPI.setPlaceholders(player,ChatUtils.format(main.getConfig().getString("leave-message")));
        String leaveMessage = leaveMessageOld.replaceAll("%player%", player.getDisplayName());

        e.setQuitMessage(leaveMessage);
    }
}
