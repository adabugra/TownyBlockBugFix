package me.adabugra.TownyBlockBugFix;

import com.palmergames.bukkit.towny.event.player.PlayerExitsFromTownBorderEvent;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerExitsFromTownBorderListener implements Listener {
    @EventHandler
    public void onPlayerExitsFromTownBorderEvent(PlayerExitsFromTownBorderEvent event) {
        Player player = event.getPlayer();
        player.setGameMode(GameMode.SURVIVAL);
    }

}