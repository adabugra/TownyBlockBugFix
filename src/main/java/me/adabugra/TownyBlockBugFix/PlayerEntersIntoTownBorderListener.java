package me.adabugra.TownyBlockBugFix;

import com.palmergames.bukkit.towny.TownyAPI;
import com.palmergames.bukkit.towny.event.player.PlayerEntersIntoTownBorderEvent;
import com.palmergames.bukkit.towny.object.Resident;
import com.palmergames.bukkit.towny.object.Town;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerEntersIntoTownBorderListener implements Listener {
    @EventHandler
    public void onPlayerEntersIntoTownBorder(PlayerEntersIntoTownBorderEvent event) {
        Player player = event.getPlayer();
        Town town = event.getEnteredTown();
        Resident resident = TownyAPI.getInstance().getResident(player);
        if(resident.hasTown() && resident.getTownOrNull().equals(town)) {
            return;
        }else{
            if(player.isOp()){
                return;

            }
            player.setGameMode(GameMode.ADVENTURE);
        }
    }

}
