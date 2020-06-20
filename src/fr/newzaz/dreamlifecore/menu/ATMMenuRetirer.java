package fr.newzaz.dreamlifecore.menu;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class ATMMenuRetirer implements Listener {

    public static void openGUI(Player p) {
        Inventory inv = Bukkit.createInventory(null, 27, "§1【 §9§lDreamLife Retirer §1】");

        ItemStack itemStack1 = new ItemStack(Material.getMaterial(5848));
        ItemMeta itemMeta1 = itemStack1.getItemMeta();
        itemMeta1.setDisplayName("§4Retirer 1");
        itemMeta1.setLore(Arrays.asList("§cRetirer :","§c- Clique Gauche : 1 Piéce" ,"§c- Clique Droit : 16 Piéces" ,"§c- Clique du Milieu : 64 Piéces"));
        itemStack1.setItemMeta(itemMeta1);

        ItemStack itemStack2 = new ItemStack(Material.getMaterial(6169));
        ItemMeta itemMeta2 = itemStack2.getItemMeta();
        itemMeta2.setDisplayName("§4Retirer 5");
        itemMeta2.setLore(Arrays.asList("§cRetirer :","§c- Clique Gauche : 1 Billet" ,"§c- Clique Droit : 16 Billets" ,"§c- Clique du Milieu : 64 Billets"));
        itemStack2.setItemMeta(itemMeta2);

        ItemStack itemStack3 = new ItemStack(Material.getMaterial(160));
        ItemMeta itemMeta3 = itemStack3.getItemMeta();
        itemMeta3.setDisplayName("§6❃ §6§lDreamLife §e§lATM§6 ❃");
        itemStack3.setItemMeta(itemMeta3);

        ItemStack itemStack4 = new ItemStack(Material.getMaterial(6170));
        ItemMeta itemMeta4 = itemStack4.getItemMeta();
        itemMeta4.setDisplayName("§4Retirer 10");
        itemMeta4.setLore(Arrays.asList("§cRetirer :","§c- Clique Gauche : 1 Billet" ,"§c- Clique Droit : 16 Billets" ,"§c- Clique du Milieu : 64 Billets"));
        itemStack4.setItemMeta(itemMeta4);

        ItemStack itemStack5 = new ItemStack(Material.getMaterial(6171));
        ItemMeta itemMeta5 = itemStack5.getItemMeta();
        itemMeta5.setDisplayName("§4Retirer 20");
        itemMeta5.setLore(Arrays.asList("§cRetirer :","§c- Clique Gauche : 1 Billet" ,"§c- Clique Droit : 16 Billets" ,"§c- Clique du Milieu : 64 Billets"));
        itemStack5.setItemMeta(itemMeta5);

        ItemStack itemStack6 = new ItemStack(Material.getMaterial(6172));
        ItemMeta itemMeta6 = itemStack6.getItemMeta();
        itemMeta6.setDisplayName("§4Retirer 50");
        itemMeta6.setLore(Arrays.asList("§cRetirer :","§c- Clique Gauche : 1 Billet" ,"§c- Clique Droit : 16 Billets" ,"§c- Clique du Milieu : 64 Billets"));
        itemStack6.setItemMeta(itemMeta6);

        ItemStack itemStack7 = new ItemStack(Material.getMaterial(6173));
        ItemMeta itemMeta7 = itemStack7.getItemMeta();
        itemMeta7.setDisplayName("§4Retirer 100");
        itemMeta7.setLore(Arrays.asList("§cRetirer :","§c- Clique Gauche : 1 Billet" ,"§c- Clique Droit : 16 Billets" ,"§c- Clique du Milieu : 64 Billets"));
        itemStack7.setItemMeta(itemMeta7);

        ItemStack itemStack8 = new ItemStack(Material.getMaterial(6175));
        ItemMeta itemMeta8 = itemStack8.getItemMeta();
        itemMeta8.setDisplayName("§4Retirer 500");
        itemMeta8.setLore(Arrays.asList("§cRetirer :","§c- Clique Gauche : 1 Billet" ,"§c- Clique Droit : 16 Billets" ,"§c- Clique du Milieu : 64 Billets"));
        itemStack8.setItemMeta(itemMeta8);

        ItemStack itemStack9 = new ItemStack(Material.getMaterial(6176));
        ItemMeta itemMeta9 = itemStack9.getItemMeta();
        itemMeta9.setDisplayName("§4Retirer 1000");
        itemMeta9.setLore(Arrays.asList("§cRetirer :","§c- Clique Gauche : 1 Billet" ,"§c- Clique Droit : 16 Billets" ,"§c- Clique du Milieu : 64 Billets"));
        itemStack9.setItemMeta(itemMeta9);

        inv.setItem(12,itemStack5);
        inv.setItem(14,itemStack7);
        inv.setItem(0,itemStack3);
        inv.setItem(1,itemStack3);
        inv.setItem(2,itemStack3);
        inv.setItem(3,itemStack3);
        inv.setItem(4,itemStack1);
        inv.setItem(5,itemStack3);
        inv.setItem(6,itemStack3);
        inv.setItem(7,itemStack3);
        inv.setItem(8,itemStack3);
        inv.setItem(9,itemStack3);
        inv.setItem(10,itemStack2);
        inv.setItem(11,itemStack4);
        inv.setItem(13,itemStack6);
        inv.setItem(15,itemStack8);
        inv.setItem(16,itemStack9);
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
