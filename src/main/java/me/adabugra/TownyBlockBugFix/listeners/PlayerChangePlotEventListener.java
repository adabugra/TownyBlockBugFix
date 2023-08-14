package me.adabugra.TownyBlockBugFix.listeners;

import com.palmergames.bukkit.towny.TownyAPI;
import com.palmergames.bukkit.towny.event.PlayerChangePlotEvent;
import com.palmergames.bukkit.towny.exceptions.NotRegisteredException;
import com.palmergames.bukkit.towny.object.Resident;
import com.palmergames.bukkit.towny.object.TownBlock;
import com.palmergames.bukkit.towny.object.WorldCoord;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class PlayerChangePlotEventListener implements Listener {
    @EventHandler
    public void onPlayerChangePlotEvent(PlayerChangePlotEvent event) {
        Player player = event.getPlayer();
        Resident resident = TownyAPI.getInstance().getResident(player);
        WorldCoord toPlot = event.getTo();

        if (resident != null && toPlot != null) {
            try {
                TownBlock townBlock = toPlot.getTownBlock();
                Set<Resident> trustedResidentsSet = townBlock.getTrustedResidents();
                List<Resident> trustedResidents = new ArrayList<>(trustedResidentsSet);
                boolean hasPlotTrust = trustedResidents.contains(resident);

                if (hasPlotTrust && player.getGameMode() == GameMode.ADVENTURE) {
                    // Player has plot trust in the plot they are moving to
                    player.setGameMode(GameMode.SURVIVAL);
                }
            } catch (NotRegisteredException e) {
                // Handle the exception, such as logging an error or performing a fallback action
            }
        }
    }
}
