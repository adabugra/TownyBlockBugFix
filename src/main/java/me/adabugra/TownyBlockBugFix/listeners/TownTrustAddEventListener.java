package me.adabugra.TownyBlockBugFix.listeners;

import com.palmergames.bukkit.towny.TownyAPI;
import com.palmergames.bukkit.towny.event.town.TownTrustAddEvent;
import com.palmergames.bukkit.towny.object.Resident;
import com.palmergames.bukkit.towny.object.Town;
import me.adabugra.TownyBlockBugFix.TownyBlockBugFix;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class TownTrustAddEventListener implements Listener {
    @EventHandler
    public void onTownTrustAddEvent(TownTrustAddEvent event) {
        Town town = event.getTown();
        Resident resident = event.getTrustedResident();
        Player player = resident.getPlayer();

        // Check if the player is online before getting their location
        if (player != null && player.isOnline()) {
            Town currentTown = TownyAPI.getInstance().getTown(player.getLocation());



            if (currentTown != null && currentTown.getName().equals(town.getName()) && player.getGameMode() == GameMode.ADVENTURE) {
                player.setGameMode(GameMode.SURVIVAL);
            }
        }
    }
}