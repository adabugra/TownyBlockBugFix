package me.adabugra.TownyBlockBugFix.listeners;

import com.palmergames.bukkit.towny.TownyAPI;
import com.palmergames.bukkit.towny.event.plot.PlotTrustAddEvent;
import com.palmergames.bukkit.towny.object.Coord;
import com.palmergames.bukkit.towny.object.Resident;
import com.palmergames.bukkit.towny.object.TownBlock;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlotTrustAddEventListener implements Listener {
    @EventHandler
    public void onPlotTrustAddEvent(PlotTrustAddEvent event) {
        Resident trustedResident = event.getTrustedResident();
        Player player = trustedResident.getPlayer();

        if (player != null) {
            TownBlock trustedTownBlock = event.getTownBlocks().get(0); // Assuming only one block is trusted at a time
            TownBlock playerTownBlock = TownyAPI.getInstance().getTownBlock(player.getLocation());

            if (playerTownBlock != null && playerTownBlock.equals(trustedTownBlock)) {
                player.setGameMode(GameMode.SURVIVAL);
            }
        }
    }
}
