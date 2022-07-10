package com.mintodev.keepexperience;

import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerDeathEvent;

public class EventListener implements Listener {

    Main plugin;

    void EventHandler(Main main) {
        plugin = main;
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        e.setKeepExperience(true);

        if(plugin.isEnabled && plugin.isActive) {
            e.setKeepExperience(true);
        }
    }
}
