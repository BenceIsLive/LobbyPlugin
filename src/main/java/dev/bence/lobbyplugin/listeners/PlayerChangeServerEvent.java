package dev.bence.lobbyplugin.listeners;

import dev.bence.lobbyplugin.LobbyPlugin;
import dev.bence.lobbyplugin.utils.ChatUtils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerChangeServerEvent extends Event implements Cancellable {

    private static final HandlerList handlers = new HandlerList();
    private boolean cancelled;
    private Player playerPla;
    private String serverStr;
    private String serverAddressStr;
    private String messageStr = ChatColor.GRAY + "Connecting to server " + ChatColor.GOLD + null + ChatColor.GRAY + "...";

    LobbyPlugin main = LobbyPlugin.getInstance();

    public PlayerChangeServerEvent(Player player, String server) {
        playerPla = player;
        serverStr = server;
        messageStr = ChatUtils.format(main.getDataFile().getString("server-switch") + "&6" + server);
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        cancelled = cancel;
    }

    public String getMessage() {
        return messageStr;
    }

    public Player getPlayer() {
        return playerPla;
    }

    public String getServer() {
        return serverStr;
    }

    public String getServerAddress() {
        return serverAddressStr;
    }

    public void setMessage(String message) {
        messageStr = message;
    }

    public void setServer(String server) {
        serverStr = server;
    }

    public void setServerAddress(String serverAddress) {
        serverAddressStr = serverAddress;
    }
}