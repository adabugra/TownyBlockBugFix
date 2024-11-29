package me.adabugra.TownyBlockBugFix.listeners;

import com.palmergames.bukkit.towny.TownyAPI;
import com.palmergames.bukkit.towny.event.town.TownTrustRemoveEvent;
import com.palmergames.bukkit.towny.object.Resident;
import com.palmergames.bukkit.towny.object.Town;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class TownTrustRemoveEventListener implements Listener {
    @EventHandler
    public void onTownTrustRemoveEvent(TownTrustRemoveEvent event) {
        Resident trustedResident = event.getTrustedResident();
        Town town = event.getTown();
        Player player = trustedResident.getPlayer();

        if (player != null && player.isOnline()) {
            Town currentTown = TownyAPI.getInstance().getTown(player.getLocation());

            if (currentTown != null && currentTown.getName().equals(town.getName()) && player.getGameMode() == GameMode.SURVIVAL && !player.isOp()) {
                player.setGameMode(GameMode.ADVENTURE);
            }
        }
    }
}
