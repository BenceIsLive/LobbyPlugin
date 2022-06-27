package dev.bence.lobbyplugin.managers;

import dev.bence.lobbyplugin.enums.LobbyParticles;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class ParticleManager {

    private final HashMap<UUID, LobbyParticles> playerLobbyParticles = new HashMap<>();

    private final ArrayList<String> customParticles = new ArrayList<>();

    /**
     * Method to add Player to Particle Map.
     * @param player Player
     * @param lobbyParticles LobbyParticles
     */
    public void addPlayerToParticleMap(Player player, LobbyParticles lobbyParticles) {
        playerLobbyParticles.put(player.getUniqueId(), lobbyParticles);
    }

    /**
     * Adding Particle names to Array
     */
    public void addParticleNamesToArray() {
        for (LobbyParticles lobbyParticles : LobbyParticles.values()) {
            customParticles.add(lobbyParticles.name());
        }
    }
    /**
     * Method to remove the Player from Particle Map.
     * @param player Player
     */
    public void removePlayerFromParticleMap(Player player) {
        playerLobbyParticles.remove(player.getUniqueId());
    }

    /**
     * Returns the Player loaded Particle.
     * @param player Player
     * @return LobbyParticles
     */
    public LobbyParticles getPlayerParticle(Player player) {
        return playerLobbyParticles.get(player.getUniqueId());
    }

    /**
     * Checks if the Player has a particle.
     * @param player Player
     * @return true or false
     */
    public boolean doesPlayerParticleExist(Player player) {
        return playerLobbyParticles.containsKey(player.getUniqueId());
    }

    /**
     * Returns the size of LoadedParticles
     * @return int size
     */
    public int getParticlesMapSize() {
        return customParticles.size();
    }
}
