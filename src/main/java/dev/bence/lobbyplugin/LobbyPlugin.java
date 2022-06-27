package dev.bence.lobbyplugin;

import dev.bence.lobbyplugin.commands.ParticleMenuCommand;
import dev.bence.lobbyplugin.commands.ReloadCommand;
import dev.bence.lobbyplugin.listeners.*;
import dev.bence.lobbyplugin.listeners.JoinUtils.JoinListener;
import dev.bence.lobbyplugin.listeners.JoinUtils.Utils.*;
import dev.bence.lobbyplugin.managers.ParticleManager;
import dev.bence.lobbyplugin.menu.ParticleMenu;
import org.bukkit.Bukkit;
import org.bukkit.block.data.type.Fire;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class LobbyPlugin extends JavaPlugin {

    private static LobbyPlugin instance;
    public static ArrayList<Player> hidden = new ArrayList<Player>();
    private final ParticleManager particleManager;
    private final ParticleMenu particleMenu;
    public LobbyPlugin() {
        this.particleManager = new ParticleManager();
        this.particleMenu = new ParticleMenu(this);
    }

    @Override
    public void onEnable() {
        instance = this;

        particleManager.addParticleNamesToArray();
        particleMenu.setUpParticleMenu();

        registerCommands();
        registerEvents();

        saveDefaultConfig();


    }

    public ParticleManager getParticleManager() {
        return this.particleManager;
    }

    public ParticleMenu getParticleMenu() {
        return this.particleMenu;
    }

    public static LobbyPlugin getInstance() {
        return instance;
    }
    public void registerEvents() {
        PluginManager pluginManager = Bukkit.getServer().getPluginManager();
        pluginManager.registerEvents(new ParticleListener(this), this);
        pluginManager.registerEvents(new ParticleMoveListener(this), this);
        pluginManager.registerEvents(new JoinListener(), this);
        pluginManager.registerEvents(new QuitListener(), this);
        pluginManager.registerEvents(new PlayerHide(), this);
        pluginManager.registerEvents(new ItemDropListener(), this);
        pluginManager.registerEvents(new InventoryClickListener(), this);
        pluginManager.registerEvents(new SelectorMaterial(), this);
        pluginManager.registerEvents(new DoubleJumpListener(), this);
        pluginManager.registerEvents(new Scoreboard(), this);
        pluginManager.registerEvents(new ParticleChest(this), this);
        pluginManager.registerEvents(new Firework(), this);
        pluginManager.registerEvents(new JoinMessage(), this);

    }
    private void registerCommands() {
        getCommand("reload").setExecutor(new ReloadCommand());
        getCommand("particle").setExecutor(new ParticleMenuCommand(this));
    }
}


