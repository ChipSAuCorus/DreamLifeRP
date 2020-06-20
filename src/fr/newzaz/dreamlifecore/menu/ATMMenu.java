package fr.newzaz.dreamlifecore.menu;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ATMMenu implements Listener {
    public static void openGUI(Player p) {
        Inventory inv = Bukkit.createInventory(null, 27, "§1【 §9§lDreamLife ATM §1】");

        ItemStack itemStack1 = new ItemStack(Material.getMaterial(4133));
        ItemMeta itemMeta1 = itemStack1.getItemMeta();
        itemMeta1.setDisplayName("§cRetirer de l'argent");
        itemStack1.setItemMeta(itemMeta1);

        ItemStack itemStack2 = new ItemStack(Material.getMaterial(4132));
        ItemMeta itemMeta2 = itemStack2.getItemMeta();
        itemMeta2.setDisplayName("§cDéposer de l'argent");
        itemStack2.setItemMeta(itemMeta2);

        ItemStack itemStack3 = new ItemStack(Material.getMaterial(160));
        ItemMeta itemMeta3 = itemStack3.getItemMeta();
        itemMeta3.setDisplayName("§6❃ §6§lDreamLife §e§lATM§6 ❃");
        itemStack3.setItemMeta(itemMeta3);

        inv.setItem(12,itemStack1);
        inv.setItem(14,itemStack2);
        inv.setItem(0,itemStack3);
        inv.setItem(1,itemStack3);
        inv.setItem(2,itemStack3);
        inv.setItem(3,itemStack3);
        inv.setItem(4,itemStack3);
        inv.setItem(5,itemStack3);
        inv.setItem(6,itemStack3);
        inv.setItem(7,itemStack3);
        inv.setItem(8,itemStack3);
        inv.setItem(9,itemStack3);
        inv.setItem(10,itemStack3);
        inv.setItem(11,itemStack3);
        inv.setItem(13,itemStack3);
        inv.setItem(15,itemStack3);
        inv.setItem(16,itemStack3);
        inv.setItem(17,itemStack3);
        inv.setItem(18,itemStack3);
        inv.setItem(19,itemStack3);
        inv.setItem(20,itemStack3);
        inv.setItem(21,itemStack3);
        inv.setItem(22,itemStack3);
        inv.setItem(23,itemStack3);
        inv.setItem(24,itemStack3);
        inv.setItem(25,itemStack3);
        inv.setItem(26,itemStack3);
        p.openInventory(inv);
    }
}
