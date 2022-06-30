package dev.bence.lobbyplugin.listeners;


import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.weather.WeatherChangeEvent;

public class StopRainListener implements Listener {

    @EventHandler
    public void onStopRain(WeatherChangeEvent e) {

        if (e.toWeatherState()) {
            e.setCancelled(true);
        }
    }
}