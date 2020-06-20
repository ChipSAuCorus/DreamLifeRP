package fr.newzaz.dreamlifecore.menu;


import fr.newzaz.dreamlifecore.DreamLifeMain;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class DreamLifeGPSMenu implements Listener {
    private static FileConfiguration config;
    private final DreamLifeMain pl;

    public DreamLifeGPSMenu(DreamLifeMain main){
        this.pl = main;
        config = pl.getConfig();
    }
    public static void openGUI(Player p) {
        Inventory inv = Bukkit.createInventory(null, config.getInt("GPS.Size"), config.getString("GPS.GPSMenuName").replace("&","§"));

            ItemStack itemStack1 = new ItemStack(Material.getMaterial(config.getInt("GPS.ItemStack.id1")));
            ItemMeta itemMeta1 = itemStack1.getItemMeta();
            itemMeta1.setDisplayName(config.getString("GPS.name.name1").replace("&", "§"));
            itemStack1.setItemMeta(itemMeta1);



        ItemStack itemStack2 = new ItemStack(Material.getMaterial(config.getInt("GPS.ItemStack.id2")));
        ItemMeta itemMeta2 = itemStack2.getItemMeta();
        itemMeta2.setDisplayName(config.getString("GPS.name.name2").replace("&","§"));
        itemStack2.setItemMeta(itemMeta2);



            ItemStack itemStack3 = new ItemStack(Material.getMaterial(config.getInt("GPS.ItemStack.id3")));
            ItemMeta itemMeta3 = itemStack3.getItemMeta();
            itemMeta3.setDisplayName(config.getString("GPS.name.name3").replace("&", "§"));
            itemStack3.setItemMeta(itemMeta3);



        ItemStack itemStack4 = new ItemStack(Material.getMaterial(config.getInt("GPS.ItemStack.id4")));
        ItemMeta itemMeta4 = itemStack4.getItemMeta();
        itemMeta4.setDisplayName(config.getString("GPS.name.name4").replace("&","§"));
        itemStack4.setItemMeta(itemMeta4);

        ItemStack itemStack5 = new ItemStack(Material.getMaterial(config.getInt("GPS.ItemStack.id5")));
        ItemMeta itemMeta5 = itemStack5.getItemMeta();
        itemMeta5.setDisplayName(config.getString("GPS.name.name5").replace("&","§"));
        itemStack5.setItemMeta(itemMeta5);

        ItemStack itemStack6 = new ItemStack(Material.getMaterial(config.getInt("GPS.ItemStack.id6")));
        ItemMeta itemMeta6 = itemStack6.getItemMeta();
        itemMeta6.setDisplayName(config.getString("GPS.name.name6").replace("&","§"));
        itemStack6.setItemMeta(itemMeta6);

        ItemStack itemStack7 = new ItemStack(Material.getMaterial(config.getInt("GPS.ItemStack.id7")));
        ItemMeta itemMeta7 = itemStack7.getItemMeta();
        itemMeta7.setDisplayName(config.getString("GPS.name.name7").replace("&","§"));
        itemStack7.setItemMeta(itemMeta7);

        ItemStack itemStack8 = new ItemStack(Material.getMaterial(config.getInt("GPS.ItemStack.id8")));
        ItemMeta itemMeta8 = itemStack8.getItemMeta();
        itemMeta8.setDisplayName(config.getString("GPS.name.name8").replace("&","§"));
        itemStack8.setItemMeta(itemMeta8);

        ItemStack itemStack9 = new ItemStack(Material.getMaterial(config.getInt("GPS.ItemStack.id9")));
        ItemMeta itemMeta9 = itemStack9.getItemMeta();
        itemMeta9.setDisplayName(config.getString("GPS.name.name9").replace("&","§"));
        itemStack9.setItemMeta(itemMeta9);

        ItemStack itemStack10 = new ItemStack(Material.getMaterial(config.getInt("GPS.ItemStack.id10")));
        ItemMeta itemMeta10 = itemStack10.getItemMeta();
        itemMeta10.setDisplayName(config.getString("GPS.name.name10").replace("&","§"));
        itemStack10.setItemMeta(itemMeta10);
        if(config.getBoolean("Action.a1") == true) {
            inv.setItem(config.getInt("GPS.Slot.slot1"), itemStack1);
        }
        if(config.getBoolean("Action.a2") ==true) {
            inv.setItem(config.getInt("GPS.Slot.slot2"), itemStack2);
        }
        if(config.getBoolean("Action.a3")==true) {
            inv.setItem(config.getInt("GPS.Slot.slot3"), itemStack3);
        }
        if(config.getBoolean("Action.a4")==true) {
            inv.setItem(config.getInt("GPS.Slot.slot4"), itemStack4);
        }
        if(config.getBoolean("Action.a5") == true) {
            inv.setItem(config.getInt("GPS.Slot.slot5"), itemStack5);
        }
        if(config.getBoolean("Action.a6") == true) {
            inv.setItem(config.getInt("GPS.Slot.slot6"), itemStack6);
        }
        if(config.getBoolean("Action.a7") == true) {
            inv.setItem(config.getInt("GPS.Slot.slot7"), itemStack7);
        }
        if(config.getBoolean("Action.a8") == true) {
            inv.setItem(config.getInt("GPS.Slot.slot8"), itemStack8);
        }
        if(config.getBoolean("Action.a9") == true) {
            inv.setItem(config.getInt("GPS.Slot.slot9"), itemStack9);
        }
        if(config.getBoolean("Action.a10") == true) {
            inv.setItem(config.getInt("GPS.Slot.slot10"), itemStack10);
        }

        p.openInventory(inv);
    }

}
