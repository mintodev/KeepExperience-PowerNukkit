package com.mintodev.keepexperience;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerDeathEvent;

public class EventListener implements Listener {

    Main plugin;

    public EventListener(Main main) {
        plugin = main;
    }

    void EventHandler(Main main) {
        plugin = main;
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        if(plugin.isEnabled && plugin.isActive) {
            e.setKeepExperience(true);
        }
    }
}
