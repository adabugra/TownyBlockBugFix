package me.adabugra.TownyBlockBugFix.listeners;

import com.palmergames.bukkit.towny.TownyAPI;
import com.palmergames.bukkit.towny.event.player.PlayerEntersIntoTownBorderEvent;
import com.palmergames.bukkit.towny.object.Resident;
import com.palmergames.bukkit.towny.object.Town;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerEntersIntoTownBorderListener implements Listener {
    @EventHandler
    public void onPlayerEntersIntoTownBorder(PlayerEntersIntoTownBorderEvent event) {
        Player player = event.getPlayer();
        Town enteredTown = event.getEnteredTown();
        Resident resident = TownyAPI.getInstance().getResident(player);

        if (resident != null && resident.hasTown()) {
            Town playerTown = resident.getTownOrNull();
            if (playerTown != null && playerTown.equals(enteredTown)) {
                return;
            }

            if (!player.isOp() && !hasTrustInTown(resident, enteredTown)) {
                player.setGameMode(GameMode.ADVENTURE);
            }
        }
    }

    private boolean hasTrustInTown(Resident resident, Town town) {
        for (Resident trustedResident : town.getTrustedResidents()) {
            if (resident.equals(trustedResident)) {
                return true;
            }
        }
        return false;
    }

}
