package fr.newzaz.dreamlifecore;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class BackPackFix implements Listener {

   @EventHandler
    public static void onClick1(InventoryClickEvent e) {

       if (e.getWhoClicked().getType() != EntityType.PLAYER) {
           return;
       }
       Player p = (Player) e.getWhoClicked();
       Inventory inv = p.getInventory();
       if (e.getCurrentItem() == null) return;

       if (e.getInventory().getName().equalsIgnoreCase("Chest")) {
           if (e.getCurrentItem().getTypeId() == 10703) {
                   if (e.getClick().isShiftClick() || e.getClick().isLeftClick() || e.getClick().isRightClick() || e.getClick().isCreativeAction() || e.getClick().isKeyboardClick()) {
                       e.setCancelled(true);
                       p.sendMessage("§3§l[DreamLife§f§lProtect] §cIl est impossible de mettre un sac à l'intérieur d'un sac  !!");
                   }
               }

           }
       }
    @EventHandler
    public static void onclick4(PlayerPickupItemEvent e) {
        Player p = e.getPlayer();
        ItemStack item = e.getItem().getItemStack();
        if(e.getItem().getItemStack().getTypeId() == 10703) {
            if (item.getTypeId() == 10703 && item.getDurability() == 16 || item.getDurability() == 17|| item.getDurability() == 18|| item.getDurability() == 19|| item.getDurability() == 20|| item.getDurability() == 21|| item.getDurability() == 22|| item.getDurability() == 23|| item.getDurability() == 24|| item.getDurability() == 25|| item.getDurability() == 26|| item.getDurability() == 27|| item.getDurability() == 28|| item.getDurability() == 29|| item.getDurability() == 30|| item.getDurability() == 31) {

                if (p.hasPermission("backpack.get")) {
                } else {
                    p.sendMessage("§3§l[DreamLife§f§lProtect] §cNous avons détecté une activité suspecte lors du lancement de votre sac ! Merci d'aller voir un Modérateur pour le récupérer !");
                    e.setCancelled(true);
                }
            }
        }





    }
}
