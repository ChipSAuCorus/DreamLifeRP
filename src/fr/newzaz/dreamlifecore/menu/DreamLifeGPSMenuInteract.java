package fr.newzaz.dreamlifecore.menu;

import fr.newzaz.dreamlifecore.DreamLifeMain;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.RegisteredServiceProvider;

public class DreamLifeGPSMenuInteract implements Listener {
    
    private static FileConfiguration config;
    private final DreamLifeMain pl;

    public DreamLifeGPSMenuInteract(DreamLifeMain main){
        this.pl = main;
        config = pl.getConfig();
    }
    static Permission perms = null;

    private static boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = Bukkit.getServer().getServicesManager().getRegistration(Permission.class);
        perms = rsp.getProvider();
        return perms != null;
    }

    @EventHandler
    public static void onClick0(InventoryClickEvent e) {

            if (e.getWhoClicked().getType() != EntityType.PLAYER) {
                return;
            }
            Player p = (Player) e.getWhoClicked();

            if (e.getInventory().getName().equals(config.getString("GPS.GPSMenuName").replace("&", "§"))) {
                if(e.getCurrentItem().getItemMeta() == null){
                    return;
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals(config.getString("GPS.name.name1").replace("&", "§"))) {

                    Location l1 = new Location(p.getWorld(), config.getInt("GPS.Location.l1.x"), config.getInt("GPS.Location.l1.y"), +config.getInt("GPS.Location.l1.z"));
                    p.setCompassTarget(l1);
                    p.sendMessage(config.getString("GPS.String").replace("&", "§"));
                    p.sendMessage(config.getString("GPS.String x").replace("&", "§") + config.getInt("GPS.Location.l1.x"));
                    p.sendMessage(config.getString("GPS.String y").replace("&", "§") + config.getInt("GPS.Location.l1.y"));
                    p.sendMessage(config.getString("GPS.String z").replace("&", "§") + config.getInt("GPS.Location.l1.z"));
                    e.setCancelled(true);
                    p.closeInventory();

                } else {
                    return;
                }
            }
    }

    @EventHandler
    public static void onClick1(InventoryClickEvent e) {

            if (e.getWhoClicked().getType() != EntityType.PLAYER) {
                return;
            }
            Player p = (Player) e.getWhoClicked();

            if (e.getInventory().getName().equals(config.getString("GPS.GPSMenuName").replace("&", "§"))) {
                if(e.getCurrentItem().getItemMeta() == null){
                    return;
                }

                if (e.getCurrentItem().getItemMeta().getDisplayName().equals(config.getString("GPS.name.name2").replace("&", "§"))) {

                    Location l1 = new Location(p.getWorld(), config.getInt("GPS.Location.l2.x"), config.getInt("GPS.Location.l2.y"), +config.getInt("GPS.Location.l2.z"));
                    p.setCompassTarget(l1);
                    p.sendMessage(config.getString("GPS.String").replace("&", "§"));
                    p.sendMessage(config.getString("GPS.String x").replace("&", "§") + config.getInt("GPS.Location.l2.x"));
                    p.sendMessage(config.getString("GPS.String y").replace("&", "§") + config.getInt("GPS.Location.l2.y"));
                    p.sendMessage(config.getString("GPS.String z").replace("&", "§") + config.getInt("GPS.Location.l2.z"));
                    e.setCancelled(true);
                    p.closeInventory();

                } else {
                    return;
                }

        }
    }
    @EventHandler
    public static void onClick2(InventoryClickEvent e) {

            if (e.getWhoClicked().getType() != EntityType.PLAYER) {
                return;
            }
            Player p = (Player) e.getWhoClicked();

            if (e.getInventory().getName().equals(config.getString("GPS.GPSMenuName").replace("&", "§"))) {
                if(e.getCurrentItem().getItemMeta() == null){
                    return;
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals(config.getString("GPS.name.name3").replace("&", "§"))) {

                    Location l1 = new Location(p.getWorld(), config.getInt("GPS.Location.l3.x"), config.getInt("GPS.Location.l3.y"), +config.getInt("GPS.Location.l3.z"));
                    p.setCompassTarget(l1);
                    p.sendMessage(config.getString("GPS.String").replace("&", "§"));
                    p.sendMessage(config.getString("GPS.String x").replace("&", "§") + config.getInt("GPS.Location.l3.x"));
                    p.sendMessage(config.getString("GPS.String y").replace("&", "§") + config.getInt("GPS.Location.l3.y"));
                    p.sendMessage(config.getString("GPS.String z").replace("&", "§") + config.getInt("GPS.Location.l3.z"));
                    e.setCancelled(true);
                    p.closeInventory();

                } else {
                    return;
                }

        }
    }
    @EventHandler
    public static void onClick3(InventoryClickEvent e) {
            if (e.getWhoClicked().getType() != EntityType.PLAYER) {
                return;
            }
            Player p = (Player) e.getWhoClicked();

            if (e.getInventory().getName().equals(config.getString("GPS.GPSMenuName").replace("&", "§"))) {
                if(e.getCurrentItem().getItemMeta() == null){
                    return;
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals(config.getString("GPS.name.name4").replace("&", "§"))) {

                    Location l1 = new Location(p.getWorld(), config.getInt("GPS.Location.l4.x"), config.getInt("GPS.Location.l4.y"), +config.getInt("GPS.Location.l4.z"));
                    p.setCompassTarget(l1);
                    p.sendMessage(config.getString("GPS.String").replace("&", "§"));
                    p.sendMessage(config.getString("GPS.String x").replace("&", "§") + config.getInt("GPS.Location.l4.x"));
                    p.sendMessage(config.getString("GPS.String y").replace("&", "§") + config.getInt("GPS.Location.l4.y"));
                    p.sendMessage(config.getString("GPS.String z").replace("&", "§") + config.getInt("GPS.Location.l4.z"));
                    e.setCancelled(true);
                    p.closeInventory();

                } else {
                    return;
                }

        }
    }
    @EventHandler
    public static void onClick4(InventoryClickEvent e) {

            if (e.getWhoClicked().getType() != EntityType.PLAYER) {
                return;
            }
            Player p = (Player) e.getWhoClicked();

            if (e.getInventory().getName().equals(config.getString("GPS.GPSMenuName").replace("&", "§"))) {
                if(e.getCurrentItem().getItemMeta() == null){
                    return;
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals(config.getString("GPS.name.name5").replace("&", "§"))) {

                    Location l1 = new Location(p.getWorld(), config.getInt("GPS.Location.l5.x"), config.getInt("GPS.Location.l5.y"), + config.getInt("GPS.Location.l5.z"));
                    p.setCompassTarget(l1);
                    p.sendMessage(config.getString("GPS.String").replace("&", "§"));
                    p.sendMessage(config.getString("GPS.String x").replace("&", "§") + config.getInt("GPS.Location.l5.x"));
                    p.sendMessage(config.getString("GPS.String y").replace("&", "§") + config.getInt("GPS.Location.l5.y"));
                    p.sendMessage(config.getString("GPS.String z").replace("&", "§") + config.getInt("GPS.Location.l5.z"));
                    e.setCancelled(true);
                    p.closeInventory();

                } else {
                    return;
                }
            }

    }
    @EventHandler
    public static void onClick5(InventoryClickEvent e) {

            if (e.getWhoClicked().getType() != EntityType.PLAYER) {
                return;
            }
            Player p = (Player) e.getWhoClicked();

            if (e.getInventory().getName().equals(config.getString("GPS.GPSMenuName").replace("&", "§"))) {
                if(e.getCurrentItem().getItemMeta() == null){
                    return;
                }
                if (e.getCurrentItem().getItemMeta().getDisplayName().equals(config.getString("GPS.name.name6").replace("&", "§"))) {

                    Location l1 = new Location(p.getWorld(), config.getInt("GPS.Location.l6.x"), config.getInt("GPS.Location.l6.y"), + config.getInt("GPS.Location.l6.z"));
                    p.setCompassTarget(l1);
                    p.sendMessage(config.getString("GPS.String").replace("&", "§"));
                    p.sendMessage(config.getString("GPS.String x").replace("&", "§") + config.getInt("GPS.Location.l6.x"));
                    p.sendMessage(config.getString("GPS.String y").replace("&", "§") + config.getInt("GPS.Location.l6.y"));
                    p.sendMessage(config.getString("GPS.String z").replace("&", "§") + config.getInt("GPS.Location.l6.z"));
                    e.setCancelled(true);
                    p.closeInventory();

                } else {
                    return;

            }
        }
    }
    @EventHandler
    public static void onClick6(InventoryClickEvent e) {

        if (e.getWhoClicked().getType() != EntityType.PLAYER) {
            return;
        }
        Player p = (Player) e.getWhoClicked();

        if (e.getInventory().getName().equals(config.getString("GPS.GPSMenuName").replace("&", "§"))) {
            if(e.getCurrentItem().getItemMeta() == null){
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals(config.getString("GPS.name.name7").replace("&", "§"))) {

                Location l1 = new Location(p.getWorld(), config.getInt("GPS.Location.l7.x"), config.getInt("GPS.Location.l7.y"),  + config.getInt("GPS.Location.l7.z"));
                p.setCompassTarget(l1);
                p.sendMessage(config.getString("GPS.String").replace("&", "§"));
                p.sendMessage(config.getString("GPS.String x").replace("&", "§") + config.getInt("GPS.Location.l7.x"));
                p.sendMessage(config.getString("GPS.String y").replace("&", "§") + config.getInt("GPS.Location.l7.y"));
                p.sendMessage(config.getString("GPS.String z").replace("&", "§") + config.getInt("GPS.Location.l7.z"));
                e.setCancelled(true);
                p.closeInventory();

            }
            }

    }
    @EventHandler
    public static void onClick7(InventoryClickEvent e) {

        if (e.getWhoClicked().getType() != EntityType.PLAYER) {
            return;
        }
        Player p = (Player) e.getWhoClicked();

        if (e.getInventory().getName().equals(config.getString("GPS.GPSMenuName").replace("&", "§"))) {
            if(e.getCurrentItem().getItemMeta() == null){
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals(config.getString("GPS.name.name8").replace("&", "§"))) {

                Location l1 = new Location(p.getWorld(), config.getInt("GPS.Location.l8.x"), config.getInt("GPS.Location.l8.y"),  + config.getInt("GPS.Location.l8.z"));
                p.setCompassTarget(l1);
                p.sendMessage(config.getString("GPS.String").replace("&", "§"));
                p.sendMessage(config.getString("GPS.String x").replace("&", "§") + config.getInt("GPS.Location.l8.x"));
                p.sendMessage(config.getString("GPS.String y").replace("&", "§") + config.getInt("GPS.Location.l8.y"));
                p.sendMessage(config.getString("GPS.String z").replace("&", "§") + config.getInt("GPS.Location.l8.z"));
                e.setCancelled(true);
                p.closeInventory();

            }
        }

    }
    @EventHandler
    public static void onClick8(InventoryClickEvent e) {

        if (e.getWhoClicked().getType() != EntityType.PLAYER) {
            return;
        }
        Player p = (Player) e.getWhoClicked();

        if (e.getInventory().getName().equals(config.getString("GPS.GPSMenuName").replace("&", "§"))) {
            if(e.getCurrentItem().getItemMeta() == null){
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals(config.getString("GPS.name.name9").replace("&", "§"))) {

                Location l1 = new Location(p.getWorld(), config.getInt("GPS.Location.l9.x"), config.getInt("GPS.Location.l9.y"),  + config.getInt("GPS.Location.l9.z"));
                p.setCompassTarget(l1);
                p.sendMessage(config.getString("GPS.String").replace("&", "§"));
                p.sendMessage(config.getString("GPS.String x").replace("&", "§") + config.getInt("GPS.Location.l9.x"));
                p.sendMessage(config.getString("GPS.String y").replace("&", "§") + config.getInt("GPS.Location.l9.y"));
                p.sendMessage(config.getString("GPS.String z").replace("&", "§") + config.getInt("GPS.Location.l9.z"));
                e.setCancelled(true);
                p.closeInventory();

            }
        }

    }
    @EventHandler
    public static void onClick9(InventoryClickEvent e) {

        if (e.getWhoClicked().getType() != EntityType.PLAYER) {
            return;
        }
        Player p = (Player) e.getWhoClicked();

        if (e.getInventory().getName().equals(config.getString("GPS.GPSMenuName").replace("&", "§"))) {
            if(e.getCurrentItem().getItemMeta() == null){
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals(config.getString("GPS.name.name10").replace("&", "§"))) {

                Location l1 = new Location(p.getWorld(), config.getInt("GPS.Location.l10.x"), config.getInt("GPS.Location.l10.y"),  + config.getInt("GPS.Location.l10.z"));
                p.setCompassTarget(l1);
                p.sendMessage(config.getString("GPS.String").replace("&", "§"));
                p.sendMessage(config.getString("GPS.String x").replace("&", "§") + config.getInt("GPS.Location.l10.x"));
                p.sendMessage(config.getString("GPS.String y").replace("&", "§") + config.getInt("GPS.Location.l10.y"));
                p.sendMessage(config.getString("GPS.String z").replace("&", "§") + config.getInt("GPS.Location.l10.z"));
                e.setCancelled(true);
                p.closeInventory();

            }
        }

    }
    }


