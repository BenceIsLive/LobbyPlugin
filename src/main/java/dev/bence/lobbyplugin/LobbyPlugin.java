package dev.bence.lobbyplugin;

import dev.bence.lobbyplugin.commands.ReloadCommand;
import dev.bence.lobbyplugin.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class LobbyPlugin extends JavaPlugin {

    public static LobbyPlugin instance;
    public static ArrayList<Player> hidden = new ArrayList<Player>();

    @Override
    public void onEnable() {
        System.out.println(ChatColor.GREEN + "Plugin enabled");
        instance = this;


//        COMMANDS
        getCommand("reload").setExecutor(new ReloadCommand());


//        LISTENERS
        this.getServer().getPluginManager().registerEvents(new JoinListener(), this);
        this.getServer().getPluginManager().registerEvents(new QuitListener(), this);
        this.getServer().getPluginManager().registerEvents(new HideListener(), this);
        this.getServer().getPluginManager().registerEvents(new ItemDropListener(), this);
        this.getServer().getPluginManager().registerEvents(new InventoryClickListener(), this);
        this.getServer().getPluginManager().registerEvents(new SelectorListener(), this);
        this.getServer().getPluginManager().registerEvents(new DoubleJumpListener(), this);
        this.getServer().getPluginManager().registerEvents(new ScoreboardListener(), this);
        this.getServer().getPluginManager().registerEvents(new ParticleListener(), this);
        this.getServer().getPluginManager().registerEvents(new ParticleClickListener(), this);


//        CONFIG
        saveDefaultConfig();

    }

    @Override
    public void onDisable() {

    }


    public static LobbyPlugin getInstance() {
        return instance;
    }



}
