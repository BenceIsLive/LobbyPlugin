package dev.bence.lobbyplugin.listeners;

import dev.bence.lobbyplugin.LobbyPlugin;
import dev.bence.lobbyplugin.utils.ChatUtils;
import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.libs.kyori.adventure.platform.facet.Facet;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.*;

import java.awt.*;
import java.util.List;

public class ScoreboardListener implements Listener {

    LobbyPlugin main = LobbyPlugin.getPlugin(LobbyPlugin.class);

    @EventHandler
    public void Scoreboard(PlayerJoinEvent e) {

        Player player = e.getPlayer();

        String title = (PlaceholderAPI.setPlaceholders(player, ChatUtils.format(main.getConfig().getString("scoreboard.title"))));
        Scoreboard board =  Bukkit.getScoreboardManager().getNewScoreboard();

        Objective obj = board.registerNewObjective("dummy", "title");
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.setDisplayName(title);

        List<String> lines = (PlaceholderAPI.setPlaceholders(player, ChatUtils.format(main.getConfig().getStringList("scoreboard.lines"))));
        int size = lines.size()+1;
        for (String linestring : lines) {
            size--;
            Team line = board.registerNewTeam("line"+size);
            line.addEntry(ChatColor.translateAlternateColorCodes('&', linestring));
            obj.getScore(ChatColor.translateAlternateColorCodes('&', linestring)).setScore(size);
        }

        player.setScoreboard(board);


    }
}
