package me.adabugra.TownyBlockBugFix.listeners;

import com.palmergames.bukkit.towny.TownyAPI;
import com.palmergames.bukkit.towny.event.plot.PlotTrustRemoveEvent;
import com.palmergames.bukkit.towny.object.Coord;
import com.palmergames.bukkit.towny.object.Resident;
import com.palmergames.bukkit.towny.object.TownBlock;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlotTrustRemoveEventListener implements Listener {
    @EventHandler
    public void onPlotTrustRemoveEvent(PlotTrustRemoveEvent event) {
        Resident trustedResident = event.getTrustedResident();
        Player player = trustedResident.getPlayer();

        if (player != null) {
            TownBlock trustedTownBlock = event.getTownBlocks().get(0); // Assuming only one block is untrusted at a time
            TownBlock playerTownBlock = TownyAPI.getInstance().getTownBlock(player.getLocation());

            if (playerTownBlock != null && playerTownBlock.equals(trustedTownBlock) && !player.isOp()) {
                player.setGameMode(GameMode.ADVENTURE);
            }
        }
    }
}
