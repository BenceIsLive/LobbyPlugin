package dev.bence.lobbyplugin.listeners.JoinUtils.Utils;

import dev.bence.lobbyplugin.LobbyPlugin;
import dev.bence.lobbyplugin.utils.ChatUtils;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.List;

public class Tab implements Listener {

    private Tab tab;

    LobbyPlugin main = LobbyPlugin.getPlugin(LobbyPlugin.class);

    @EventHandler
    public void onTabListener(PlayerJoinEvent e) {

        if (main.getConfig().getBoolean("tab-visible")) {

            List<String> list = main.getConfig().getStringList("tab.header");
            String header = "";
            for (String item : list) {
                header += item + "\n";
            }


            List<String> list1 = main.getConfig().getStringList("tab.footer");
            String footer = "";
            for (String item : list1) {
                footer += item + "\n";
            }
            e.getPlayer().setPlayerListHeaderFooter(PlaceholderAPI.setPlaceholders(e.getPlayer(), ChatUtils.format(header)), PlaceholderAPI.setPlaceholders(e.getPlayer(), ChatUtils.format(footer)));
        }


    }
}

