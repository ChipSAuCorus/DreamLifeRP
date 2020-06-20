package fr.newzaz.dreamlifecore.menu;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class ATMInteract implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        Action a = e.getAction();
        Block b = e.getClickedBlock();

        if(e.getItem() == null){
            return;
        }
        if(e.isBlockInHand()){
            return;
        }
        if(e.getClickedBlock().getType().equals(Material.getMaterial(165))) {
            if (a == Action.RIGHT_CLICK_BLOCK) {
                ATMMenu.openGUI(p);

            }
        }

        }

    }




