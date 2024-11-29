package me.adabugra.TownyBlockBugFix.listeners;

import com.palmergames.bukkit.towny.TownyAPI;
import com.palmergames.bukkit.towny.object.Resident;
import com.palmergames.bukkit.towny.object.Town;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;

public class PlayerTeleportEventListener implements Listener {
    @EventHandler
    public void onPlayerTeleportEvent(PlayerTeleportEvent event) {
        Player player = event.getPlayer();
        Resident resident = TownyAPI.getInstance().getResident(player);
        if (resident == null) {
            return;
        }

        Location destination = event.getTo();
        Town town = TownyAPI.getInstance().getTown(destination);

        if (town != null) {
            Town playerTown = resident.getTownOrNull();
            if (playerTown != null && playerTown.equals(town)) {
                // Teleported within their own town
                player.setGameMode(GameMode.SURVIVAL);
            } else if(!player.isOp()) {
                // Teleported to a different town
                player.setGameMode(GameMode.ADVENTURE);
            }
        } else {
            // Teleported to wilderness
            player.setGameMode(GameMode.SURVIVAL);
        }
    }
}
