package me.adabugra.TownyBlockBugFix.listeners;

import com.palmergames.bukkit.towny.event.town.TownLeaveEvent;
import com.palmergames.bukkit.towny.object.Resident;
import com.palmergames.bukkit.towny.object.Town;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class TownLeaveEventListener implements Listener {
    @EventHandler
    public void onTownLeaveEvent(TownLeaveEvent event) {
        Resident resident = event.getResident();
        Town town = event.getTown();

        if (resident == null || town == null) {
            return; // Prevent NullPointerExceptionb
        }

        Player player = resident.getPlayer();

        if (player != null && resident.getTownOrNull() != null && resident.getTownOrNull().equals(town) && !player.isOp()) {
            player.setGameMode(GameMode.ADVENTURE);
        }
    }
}
