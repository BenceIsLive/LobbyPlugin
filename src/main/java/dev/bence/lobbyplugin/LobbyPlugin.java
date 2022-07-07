package dev.bence.lobbyplugin;

import dev.bence.lobbyplugin.commands.CosmeticCommand;
import dev.bence.lobbyplugin.commands.ParticleMenuCommand;
import dev.bence.lobbyplugin.commands.ReloadCommand;
import dev.bence.lobbyplugin.listeners.*;
import dev.bence.lobbyplugin.listeners.Flags.BlockBreakListener;
import dev.bence.lobbyplugin.listeners.Flags.BlockPlaceListener;
import dev.bence.lobbyplugin.listeners.JoinUtils.JoinListener;
import dev.bence.lobbyplugin.listeners.JoinUtils.Utils.*;
import dev.bence.lobbyplugin.listeners.ParticleUtils.ParticleClickListener;
import dev.bence.lobbyplugin.listeners.ParticleUtils.ParticleMoveListener;
import dev.bence.lobbyplugin.utils.DataFile;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class LobbyPlugin extends JavaPlugin {

    private DataFile particleFile;
    private DataFile dataFile;
    private DataFile selectorFile;
    public static LobbyPlugin instance;
    public static ArrayList<Player> hidden = new ArrayList<Player>();

    @Override
    public void onEnable() {
        instance = this;
        registerCommands();
        registerEvents();

        saveDefaultConfig();
        saveResource("particle-menu.yml", false);
        saveResource("messages.yml", true);
        saveResource("server-selector.yml", false);

        dataFile = new DataFile("messages.yml", getDataFolder());
        selectorFile = new DataFile("server-selector.yml", getDataFolder());
        particleFile = new DataFile("particle-menu.yml", getDataFolder());

    }
    public DataFile getDataFile() {
        return dataFile;
    }
    public DataFile getSelectorFile() { return selectorFile; }
    public DataFile getParticleFile() { return particleFile; }


    public static LobbyPlugin getInstance() {
        return instance;
    }
    public void registerEvents() {
        PluginManager pluginManager = Bukkit.getServer().getPluginManager();
        pluginManager.registerEvents(new ParticleMoveListener(this), this);
        pluginManager.registerEvents(new JoinListener(), this);
        pluginManager.registerEvents(new QuitListener(), this);
        pluginManager.registerEvents(new PlayerHide(), this);
        pluginManager.registerEvents(new ItemDropListener(), this);
        pluginManager.registerEvents(new SelectorClickListener(), this);
        pluginManager.registerEvents(new SelectorMaterial(), this);
        pluginManager.registerEvents(new DoubleJumpListener(), this);
        pluginManager.registerEvents(new Scoreboard(), this);
        pluginManager.registerEvents(new ParticleChest(this), this);
        pluginManager.registerEvents(new Firework(), this);
        pluginManager.registerEvents(new StopRainListener(), this);
        pluginManager.registerEvents(new Tab(), this);
        pluginManager.registerEvents(new ParticleClickListener(), this);
        pluginManager.registerEvents(new BlockBreakListener(), this);
        pluginManager.registerEvents(new BlockPlaceListener(), this);

    }
    private void registerCommands() {
        getCommand("reload").setExecutor(new ReloadCommand());
        getCommand("particle").setExecutor(new ParticleMenuCommand(this));
        getCommand("cosmetic").setExecutor(new CosmeticCommand());
    }

}


