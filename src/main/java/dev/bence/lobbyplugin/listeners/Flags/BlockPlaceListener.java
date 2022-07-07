package dev.bence.lobbyplugin.listeners.Flags;

import dev.bence.lobbyplugin.LobbyPlugin;
import dev.bence.lobbyplugin.utils.ChatUtils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class BlockPlaceListener implements Listener {

    LobbyPlugin main = LobbyPlugin.getPlugin(LobbyPlugin.class);

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {

        if (main.getConfig().getBoolean("block-place")) {
            e.setCancelled(false);
        } else if (!main.getConfig().getBoolean("block-place")) {
            e.setCancelled(true);
            e.getPlayer().sendMessage(ChatUtils.format(main.getDataFile().getString("prefix")) + ChatUtils.format(main.getDataFile().getString("block-place-off")));
        }
    }
}


