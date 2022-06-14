package dev.bence.lobbyplugin.commands;

import dev.bence.lobbyplugin.LobbyPlugin;
import dev.bence.lobbyplugin.utils.ChatUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCommand implements CommandExecutor {

    LobbyPlugin  main = LobbyPlugin.getPlugin(LobbyPlugin.class);

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;
            main.reloadConfig();
            player.sendMessage(ChatUtils.format("&aConfig herladen!"));

        }
        return false;
    }
}