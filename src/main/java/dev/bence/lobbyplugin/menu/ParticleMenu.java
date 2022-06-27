package dev.bence.lobbyplugin.menu;

import dev.bence.lobbyplugin.LobbyPlugin;
import dev.bence.lobbyplugin.enums.LobbyParticles;
import dev.bence.lobbyplugin.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;

public class ParticleMenu {

    // item naar menu
    // enum class
    // builder
    private final HashMap<ItemStack, LobbyParticles> loadedParticlesMaterial = new HashMap<>();
    private Inventory inventory;
    private LobbyParticles lobbyParticles;
    private Player player;
    private final LobbyPlugin plugin;

    public ParticleMenu(LobbyPlugin plugin) {
        this.plugin = plugin;
    }

    private void addItemsToInventory() {
        for (LobbyParticles lobbyParticles : LobbyParticles.values()) {
            inventory.setItem(lobbyParticles.getSlot(), createGuiItem(lobbyParticles.getMenuItem(), lobbyParticles.getItemName()));
            loadedParticlesMaterial.put(createGuiItem(lobbyParticles.getMenuItem(),lobbyParticles.getItemName()), lobbyParticles);
        }
        inventory.setItem(0, createGuiItem(Material.BARRIER,"&cTurn off Particle"));
    }

    /**
     * setups the inventory with desired slots and sizes.
     */
    public void setUpParticleMenu() {
        int size = plugin.getParticleManager().getParticlesMapSize()+1;

        if (size <= 9) {
            size = 9;
        } else if (size <= 18) {
            size = 18;
        } else if (size <= 27) {
            size = 27;
        } else if (size <= 36) {
            size = 36;
        } else if (size <= 45) {
            size = 45;
        } else if (size <= 54) {
            size = 54;
        }
        this.inventory = Bukkit.createInventory(null, size, ChatUtils.format("&6Particle Menu"));

        addItemsToInventory();
    }

    /**
     * ItemBuilder for custom name.
     * @param material Material
     * @param name String name
     * @return itemStack
     */
    public ItemStack createGuiItem(Material material, String name) {
        ItemStack itemStack = new ItemStack(material);
        ItemMeta itemMeta = itemStack.getItemMeta();

        itemMeta.setDisplayName(ChatUtils.format(name));
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }

    /**
     * Opens the private inventory variable for player.
     * @param player Player
     */
    public void openInventory(Player player) {
        player.openInventory(inventory);
    }

    /**
     * Checks if the itemstack is in the map.
     * @param itemStack ItemStack
     * @return true of false
     */
    public boolean doesMaterialExistInMap(ItemStack itemStack) {
        return loadedParticlesMaterial.containsKey(itemStack);
    }

    /**
     * Returns LobbyParticles that is with the itemstack key.
     * @param itemStack ItemStack
     * @return LobbyParticles
     */
    public LobbyParticles getLobbyParticlesFromMap(ItemStack itemStack) {
        return loadedParticlesMaterial.get(itemStack);
    }
}