package me.adabugra.TownyBlockBugFix;

import me.adabugra.TownyBlockBugFix.listeners.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
public final class TownyBlockBugFix extends JavaPlugin {
    private static TownyBlockBugFix instance;

    @Override
    public void onEnable() {
        instance = this;
        getServer().getPluginManager().registerEvents(new PlayerEntersIntoTownBorderListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerExitsFromTownBorderListener(), this);
        getServer().getPluginManager().registerEvents(new TownAddResidentEventListener(), this);
        getServer().getPluginManager().registerEvents(new TownLeaveEventListener(), this);
        getServer().getPluginManager().registerEvents(new TownTrustAddEventListener(), this);
        getServer().getPluginManager().registerEvents(new TownTrustRemoveEventListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerTeleportEventListener(), this);
        getServer().getPluginManager().registerEvents(new TownKickEventListener(), this);
        getServer().getPluginManager().registerEvents(new PlotTrustAddEventListener(), this);
        getServer().getPluginManager().registerEvents(new PlotTrustRemoveEventListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerChangePlotEventListener(), this);

        // Plugin startup logic
        Plugin townyPlugin = Bukkit.getPluginManager().getPlugin("Towny");
        if (townyPlugin == null) {
            getLogger().warning("TownyAdvanced plugin is not installed. Plugin will not be enabled.");
            return;
        } else {
            Bukkit.getLogger().info("  _______                        ____  _            _    ____              ______ _      ");
            Bukkit.getLogger().info(" |__   __|                      |  _ \\| |          | |  |  _ \\            |  ____(_)     ");
            Bukkit.getLogger().info("    | | _____      ___ __  _   _| |_) | | ___   ___| | _| |_) |_   _  __ _| |__   ___  __");
            Bukkit.getLogger().info("    | |/ _ \\ \\ /\\ / / '_ \\| | | |  _ <| |/ _ \\ / __| |/ /  _ <| | | |/ _` |  __| | \\ \\/ /");
            Bukkit.getLogger().info("    | | (_) \\ V  V /| | | | |_| | |_) | | (_) | (__|   <| |_) | |_| | (_| | |    | |>  < ");
            Bukkit.getLogger().info("    |_|\\___/ \\_/\\_/ |_| |_|\\__, |____/|_|\\___/ \\___|_|\\_\\____/ \\__,_|\\__, |_|    |_/_/\\_\\");
            Bukkit.getLogger().info("                            __/ |                                     __/ |              ");
            Bukkit.getLogger().info("                           |___/                                     |___/               ");


        }
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("Disabled");// Plugin shutdown logic
    }
    public static TownyBlockBugFix getInstance() {
        return instance;
    }
}
