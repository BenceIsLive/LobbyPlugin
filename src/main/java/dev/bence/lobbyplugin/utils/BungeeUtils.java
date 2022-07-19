package dev.bence.lobbyplugin.utils;

import dev.bence.lobbyplugin.LobbyPlugin;
import dev.bence.lobbyplugin.listeners.PlayerChangeServerEvent;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;


public class BungeeUtils {

    LobbyPlugin main = LobbyPlugin.getPlugin(LobbyPlugin.class);

    public static void connect(Player player, String serverName) {
        PlayerChangeServerEvent event = new PlayerChangeServerEvent(player, serverName);
        Bukkit.getPluginManager().callEvent(event);

        if(!event.isCancelled()) {
            ByteArrayOutputStream b = new ByteArrayOutputStream();
            DataOutputStream out = new DataOutputStream(b);

            if(event.getMessage() != null) {
                player.sendMessage(event.getMessage());
            }

            try {
                out.writeUTF("Connect");
                out.writeUTF(serverName);
            } catch(IOException ex) {}
            Bukkit.getLogger().info("Connecting " + player.getName() + " to " + serverName + "...");
            player.sendPluginMessage(LobbyPlugin.getInstance(), "BungeeCord", b.toByteArray());
        }
    }
}
