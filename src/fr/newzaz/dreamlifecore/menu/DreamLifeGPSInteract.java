package fr.newzaz.dreamlifecore.menu;

import fr.newzaz.dreamlifecore.DreamLifeMain;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class DreamLifeGPSInteract implements Listener {
    private static FileConfiguration config;
    private final DreamLifeMain pl;

    public DreamLifeGPSInteract(DreamLifeMain main){
        this.pl = main;
        config = pl.getConfig();
    }
    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        Action a = e.getAction();

        if(p.getInventory().getItemInHand() == null) {
            return;
        }

        if(p.getInventory().getItemInHand().getItemMeta() == null) {
            return;
        }

        if(p.getInventory().getItemInHand().getType().equals(Material.getMaterial(config.getInt("GPS.id")))) {
            if(a != Action.RIGHT_CLICK_AIR) {


                DreamLifeGPSMenu.openGUI(p);
            }else if(a != Action.RIGHT_CLICK_BLOCK) {

                DreamLifeGPSMenu.openGUI(p);
            }else {
                return;
            }
        }else {
            return;
        }
    }
}
