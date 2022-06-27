package dev.bence.lobbyplugin.commands;

import dev.bence.lobbyplugin.LobbyPlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ParticleMenuCommand implements CommandExecutor {

    private final LobbyPlugin plugin;

    public ParticleMenuCommand(LobbyPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String particle, String[] args) {
        if (!(sender instanceof Player)) return true;
        Player player = (Player) sender;

        plugin.getParticleMenu().openInventory(player);
        return true;

    }
}
