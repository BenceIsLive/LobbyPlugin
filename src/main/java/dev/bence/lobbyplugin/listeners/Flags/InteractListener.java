package dev.bence.lobbyplugin.listeners.Flags;

import dev.bence.lobbyplugin.LobbyPlugin;
import dev.bence.lobbyplugin.utils.ChatUtils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

public class InteractListener implements Listener  {

    LobbyPlugin main = LobbyPlugin.getPlugin(LobbyPlugin.class);

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {

        Player player = e.getPlayer();

        if (main.getConfig().getBoolean("interact")) {
            e.setCancelled(false);
        } else if (!main.getConfig().getBoolean("interact")) {
            e.setCancelled(true);
            e.getPlayer().sendMessage(ChatUtils.format(main.getDataFile().getString("prefix")) + ChatUtils.format(main.getDataFile().getString("block-break-off")));

        }


    }

}
