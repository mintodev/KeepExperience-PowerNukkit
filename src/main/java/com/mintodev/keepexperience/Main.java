package com.mintodev.keepexperience;

import cn.nukkit.Player;
import cn.nukkit.command.Command;
import cn.nukkit.command.CommandSender;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.utils.TextFormat;

import java.util.Objects;

public class Main extends PluginBase {

    public boolean isEnabled;
    public boolean isActive = true;

    @Override
    public void onEnable() {
        this.saveDefaultConfig();

        this.getServer().getPluginManager().registerEvents(new EventListener(this), this);
        this.isEnabled = this.getConfig().getBoolean("enabled");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(Objects.equals(command.getName(), "keepexperience") && sender.hasPermission("keepexperience.cmd")) {
            if(!(sender instanceof Player)) {
                sender.sendMessage(TextFormat.RED + "Please use this command in-game");
                return true;
            }

            if(this.isEnabled) {
                if(this.isActive) {
                    this.isActive = false;
                    sender.sendMessage(this.getConfig().getString("disableMessage"));
                } else {
                    this.isActive = true;
                    sender.sendMessage(this.getConfig().getString("enableMessage"));
                }
                return true;
            } else {
                sender.sendMessage(this.getConfig().getString("keepExperienceDisabled"));
            }
        }
        return true;
    }
}
