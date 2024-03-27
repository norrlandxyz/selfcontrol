package xyz.norrland.selfcontrol;

import org.bukkit.plugin.java.JavaPlugin;

public final class Selfcontrol extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Hello World!");
        this.getCommand("suicide").setExecutor(new CommandSuicide());
        this.getCommand("selfban").setExecutor(new CommandSelfban());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
