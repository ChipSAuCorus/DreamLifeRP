package fr.newzaz.dreamlifecore;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class MedkitInteract implements Listener {
    public void onclick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        Action action = e.getAction();
        ItemStack item = e.getItem();

        if (item == null || item.getType() != Material.getMaterial(5716))
            return;
            if (item.getType() == Material.getMaterial(5716)) {
                if (action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK) {
                if (p.hasPermission("medkit.use")) {

                } else {
                    p.sendMessage("§cTu n'as pas la permission de faire ceci");
                    e.setCancelled(true);
                }
            }
        }
    }
}
