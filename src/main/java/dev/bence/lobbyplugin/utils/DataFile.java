package dev.bence.lobbyplugin.utils;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class DataFile extends YamlConfiguration {

    private final File config;

    public DataFile(String fileName, File dataFolder) {
        this.config = new File(dataFolder, fileName);
        load();
    }

    public void save() {
        try {
            save(config);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load() {
        try {
            if (!config.exists()) {
                config.getParentFile().mkdirs();
                config.createNewFile();
            }

            load(config);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String saveToString() {
        return super.saveToString();
    }

    @Override
    public void loadFromString(String contents) throws InvalidConfigurationException {
        super.loadFromString(contents);
    }

    @Override
    protected String buildHeader() {
        return super.buildHeader();
    }
}
