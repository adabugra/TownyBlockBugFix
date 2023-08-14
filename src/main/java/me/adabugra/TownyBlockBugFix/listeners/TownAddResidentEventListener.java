package me.adabugra.TownyBlockBugFix.listeners;

import com.palmergames.bukkit.towny.TownyAPI;
import com.palmergames.bukkit.towny.event.TownAddResidentEvent;
import com.palmergames.bukkit.towny.object.Resident;
import com.palmergames.bukkit.towny.object.Town;
import me.adabugra.TownyBlockBugFix.TownyBlockBugFix;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class TownAddResidentEventListener implements Listener {

    @EventHandler
    public void onTownAddResidentEvent(TownAddResidentEvent event) {
        Resident resident = event.getResident();

        if (resident == null || !resident.hasTown()) {
            return; // Prevent NullPointerException
        }

        Player player = Bukkit.getServer().getPlayer(resident.getName());

        if (player != null) {
            Bukkit.getScheduler().runTaskLater(TownyBlockBugFix.getInstance(), () -> {
                Town town = TownyAPI.getInstance().getTown(player.getLocation());
                if (town != null && resident.getTownOrNull() != null && resident.getTownOrNull().equals(town)) {
                    player.setGameMode(GameMode.SURVIVAL);
                }
            }, 20);
        }
    }
}
