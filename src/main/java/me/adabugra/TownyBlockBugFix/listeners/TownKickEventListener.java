package me.adabugra.TownyBlockBugFix.listeners;

import com.palmergames.bukkit.towny.TownyAPI;
import com.palmergames.bukkit.towny.event.town.TownKickEvent;
import com.palmergames.bukkit.towny.object.Resident;
import com.palmergames.bukkit.towny.object.Town;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class TownKickEventListener implements Listener {
    @EventHandler
    public void onTownyKickEvent(TownKickEvent event) {
        Resident resident = event.getKickedResident();
        Player player = resident.getPlayer();

        if (player == null) {
            return; // Player is offline or not available
        }

        Town town = TownyAPI.getInstance().getTown(player.getLocation());

        if (town != null && town.equals(resident.getTownOrNull()) && !player.isOp()) {
            player.setGameMode(GameMode.ADVENTURE);
        }
    }
}
