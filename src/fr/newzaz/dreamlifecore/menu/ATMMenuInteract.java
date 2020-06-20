package fr.newzaz.dreamlifecore.menu;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.RegisteredServiceProvider;

public class ATMMenuInteract implements Listener {

    static Economy econ = null;

    private static boolean setupEconomy() {
        RegisteredServiceProvider<Economy> economyProvider = Bukkit.getServer().getServicesManager()
                .getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            econ = economyProvider.getProvider();
        }

        return (econ != null);
    }

    @EventHandler
    public static void onClick0(InventoryClickEvent e) {

        if (e.getWhoClicked().getType() != EntityType.PLAYER) {
            return;
        }
        Player p = (Player) e.getWhoClicked();

        if (e.getInventory().getName().equals("§1【 §9§lDreamLife ATM §1】") || e.getInventory().getName().equals("§1【 §9§lDreamLife Retirer §1】") || e.getInventory().getName().equals("§1【 §9§lDreamLife Déposer §1】")) {
            if (e.getCurrentItem().getItemMeta() == null) {
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§6❃ §6§lDreamLife §e§lATM§6 ❃")) {
                e.setCancelled(true);

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

        if (e.getInventory().getName().equals("§1【 §9§lDreamLife ATM §1】")) {
            if(!e.getInventory().getName().equals("§1【 §9§lDreamLife ATM §1】")){ return;}
            if (e.getCurrentItem().getItemMeta() == null) {
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§cRetirer de l'argent")) {
                e.setCancelled(true);
                ATMMenuRetirer.openGUI(p);

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

        if (e.getInventory().getName().equals("§1【 §9§lDreamLife ATM §1】")) {
            if(!e.getInventory().getName().equals("§1【 §9§lDreamLife ATM §1】")){ return;}
            if (e.getCurrentItem().getItemMeta() == null) {
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§cDéposer de l'argent")) {
                e.setCancelled(true);
                ATMMenuDéposer.openGUI(p);

            } else {
                return;
            }
        }
    }

    @EventHandler
    public static void onClick3(InventoryClickEvent e) {
        ItemStack itemStack1 = new ItemStack(Material.getMaterial(5848));
        ItemMeta itemMeta1 = itemStack1.getItemMeta();
        itemMeta1.setDisplayName("§ePiéce de §b1 $");
        itemStack1.setAmount(1);
        itemStack1.setItemMeta(itemMeta1);

        ItemStack itemStack2 = itemStack1.clone();
        itemStack2.setAmount(16);
        if (e.getWhoClicked().getType() != EntityType.PLAYER) {
            return;
        }
        Player p = (Player) e.getWhoClicked();

        if (e.getInventory().getName().equals("§1【 §9§lDreamLife Retirer §1】")) {
            if(!e.getInventory().getName().equals("§1【 §9§lDreamLife Retirer §1】")){ return;}
            if (e.getCurrentItem().getItemMeta() == null) {
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4Retirer 1")) {
                if (setupEconomy()) {
                        if (e.getClick().isLeftClick()) {
                            if (econ.getBalance(p) >= 1) {
                                econ.withdrawPlayer(p, 1);
                                p.sendMessage("§4[§c❃ DreamLife ATM ❃§4] §cTu as retiré 1$");
                                p.getInventory().addItem(itemStack1);
                                e.setCancelled(true);
                            } else {
                                e.setCancelled(true);
                                p.sendMessage("§4[§c❃ DreamLife ATM ❃§4] §cTu n'as pas assez d'argent !");
                            }
                        }
                        if (e.getClick().isCreativeAction()) {
                            if (econ.getBalance(p) >= 64) {
                                econ.withdrawPlayer(p, 64);
                                p.sendMessage("§4[§c❃ DreamLife ATM ❃§4] §cTu as retiré 64$");
                                p.getInventory().addItem(itemStack2);
                                p.getInventory().addItem(itemStack2);
                                p.getInventory().addItem(itemStack2);
                                p.getInventory().addItem(itemStack2);
                                e.setCancelled(true);
                            } else {
                                e.setCancelled(true);
                                p.sendMessage("§4[§c❃ DreamLife ATM ❃§4] §cTu n'as pas assez d'argent !");
                            }
                        }
                        if (e.getClick().isRightClick()) {
                            if (econ.getBalance(p) >= 16) {
                                econ.withdrawPlayer(p, 16);
                                p.sendMessage("§4[§c❃ DreamLife ATM ❃§4] §cTu as retiré 16$");
                                p.getInventory().addItem(itemStack2);
                                e.setCancelled(true);
                            } else {
                                e.setCancelled(true);
                                p.sendMessage("§4[§c❃ DreamLife ATM ❃§4] §cTu n'as pas assez d'argent !");
                            }
                        }
                        if (e.getClick().isKeyboardClick()) {
                            e.setCancelled(true);
                        }

                    }
                }
            }
        }



    @EventHandler
    public static void onClick4(InventoryClickEvent e) {
        ItemStack itemStack1 = new ItemStack(Material.getMaterial(6169));
        ItemMeta itemMeta1 = itemStack1.getItemMeta();
        itemMeta1.setDisplayName("§eBillet de §b5 $");
        itemStack1.setAmount(1);
        itemStack1.setItemMeta(itemMeta1);

        ItemStack itemStack2 = itemStack1.clone();
        itemStack2.setAmount(16);
        if (e.getWhoClicked().getType() != EntityType.PLAYER) {
            return;
        }
        Player p = (Player) e.getWhoClicked();

        if (e.getInventory().getName().equals("§1【 §9§lDreamLife Retirer §1】")) {
            if(!e.getInventory().getName().equals("§1【 §9§lDreamLife Retirer §1】")){ return;}
            if (e.getCurrentItem().getItemMeta() == null) {
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4Retirer 5")) {
                if (setupEconomy()) {
                    if (e.getClick().isLeftClick()) {
                        if (econ.getBalance(p) >= 5) {
                            econ.withdrawPlayer(p, 5);
                            p.sendMessage("§4[§c❃ DreamLife ATM ❃§4] §cTu as retiré 5$");
                            p.getInventory().addItem(itemStack1);
                            e.setCancelled(true);
                        } else {
                            e.setCancelled(true);
                            p.sendMessage("§4[§c❃ DreamLife ATM ❃§4] §cTu n'as pas assez d'argent !");
                        }
                    }
                    if (e.getClick().isCreativeAction()) {
                        if (econ.getBalance(p) >= 320) {
                            econ.withdrawPlayer(p, 320);
                            p.sendMessage("§4[§c❃ DreamLife ATM ❃§4] §cTu as retiré 320$");
                            p.getInventory().addItem(itemStack2);
                            p.getInventory().addItem(itemStack2);
                            p.getInventory().addItem(itemStack2);
                            p.getInventory().addItem(itemStack2);
                            e.setCancelled(true);
                        } else {
                            e.setCancelled(true);
                            p.sendMessage("§4[§c❃ DreamLife ATM ❃§4] §cTu n'as pas assez d'argent !");
                        }
                    }
                    if (e.getClick().isRightClick()) {
                        if (econ.getBalance(p) >= 80) {
                            econ.withdrawPlayer(p, 80);
                            p.sendMessage("§4[§c❃ DreamLife ATM ❃§4] §cTu as retiré 80$");
                            p.getInventory().addItem(itemStack2);
                            e.setCancelled(true);
                        } else {
                            e.setCancelled(true);
                            p.sendMessage("§4[§c❃ DreamLife ATM ❃§4] §cTu n'as pas assez d'argent !");
                        }
                    }
                    if (e.getClick().isKeyboardClick()) {
                        e.setCancelled(true);
                    }

                }
            }
        }
    }

    @EventHandler
    public static void onClick5(InventoryClickEvent e) {
        ItemStack itemStack1 = new ItemStack(Material.getMaterial(6170));
        ItemMeta itemMeta1 = itemStack1.getItemMeta();
        itemMeta1.setDisplayName("§eBillet de §b10 $");
        itemStack1.setAmount(1);
        itemStack1.setItemMeta(itemMeta1);

        ItemStack itemStack2 = itemStack1.clone();
        itemStack2.setAmount(16);
        if (e.getWhoClicked().getType() != EntityType.PLAYER) {
            return;
        }
        Player p = (Player) e.getWhoClicked();

        if (e.getInventory().getName().equals("§1【 §9§lDreamLife Retirer §1】")) {
            if(!e.getInventory().getName().equals("§1【 §9§lDreamLife Retirer §1】")){ return;}
            if (e.getCurrentItem().getItemMeta() == null) {
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4Retirer 10")) {
                if (setupEconomy()) {
                    if (e.getClick().isLeftClick()) {
                        if (econ.getBalance(p) >= 10) {
                            econ.withdrawPlayer(p, 10);
                            p.sendMessage("§4[§c❃ DreamLife ATM ❃§4] §cTu as retiré 10$");
                            p.getInventory().addItem(itemStack1);
                            e.setCancelled(true);
                        } else {
                            e.setCancelled(true);
                            p.sendMessage("§4[§c❃ DreamLife ATM ❃§4] §cTu n'as pas assez d'argent !");
                        }
                    }
                    if (e.getClick().isCreativeAction()) {
                        if (econ.getBalance(p) >= 640) {
                            econ.withdrawPlayer(p, 640);
                            p.sendMessage("§4[§c❃ DreamLife ATM ❃§4] §cTu as retiré 640$");
                            p.getInventory().addItem(itemStack2);
                            p.getInventory().addItem(itemStack2);
                            p.getInventory().addItem(itemStack2);
                            p.getInventory().addItem(itemStack2);
                            e.setCancelled(true);
                        } else {
                            e.setCancelled(true);
                            p.sendMessage("§4[§c❃ DreamLife ATM ❃§4] §cTu n'as pas assez d'argent !");
                        }
                    }
                    if (e.getClick().isRightClick()) {
                        if (econ.getBalance(p) >= 160) {
                            econ.withdrawPlayer(p, 160);
                            p.sendMessage("§4[§c❃ DreamLife ATM ❃§4] §cTu as retiré 160$");
                            p.getInventory().addItem(itemStack2);
                            e.setCancelled(true);
                        } else {
                            e.setCancelled(true);
                            p.sendMessage("§4[§c❃ DreamLife ATM ❃§4] §cTu n'as pas assez d'argent !");
                        }
                    }
                    if (e.getClick().isKeyboardClick()) {
                        e.setCancelled(true);
                    }

                }
            }
        }
    }

    @EventHandler
    public static void onClick6(InventoryClickEvent e) {
        ItemStack itemStack1 = new ItemStack(Material.getMaterial(6171));
        ItemMeta itemMeta1 = itemStack1.getItemMeta();
        itemMeta1.setDisplayName("§eBillet de §b20 $");
        itemStack1.setAmount(1);
        itemStack1.setItemMeta(itemMeta1);

        ItemStack itemStack2 = itemStack1.clone();
        itemStack2.setAmount(16);
        if (e.getWhoClicked().getType() != EntityType.PLAYER) {
            return;
        }
        Player p = (Player) e.getWhoClicked();

        if (e.getInventory().getName().equals("§1【 §9§lDreamLife Retirer §1】")) {
            if(!e.getInventory().getName().equals("§1【 §9§lDreamLife Retirer §1】")){ return;}
            if (e.getCurrentItem().getItemMeta() == null) {
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4Retirer 20")) {
                if (setupEconomy()) {
                    if (e.getClick().isLeftClick()) {
                        if (econ.getBalance(p) >= 20) {
                            econ.withdrawPlayer(p, 20);
                            p.sendMessage("§4[§c❃ DreamLife ATM ❃§4] §cTu as retiré 20$");
                            p.getInventory().addItem(itemStack1);
                            e.setCancelled(true);
                        } else {
                            e.setCancelled(true);
                            p.sendMessage("§4[§c❃ DreamLife ATM ❃§4] §cTu n'as pas assez d'argent !");
                        }
                    }
                    if (e.getClick().isCreativeAction()) {
                        if (econ.getBalance(p) >= 1280) {
                            econ.withdrawPlayer(p, 1280);
                            p.sendMessage("§4[§c❃ DreamLife ATM ❃§4] §cTu as retiré 1280");
                            p.getInventory().addItem(itemStack2);
                            p.getInventory().addItem(itemStack2);
                            p.getInventory().addItem(itemStack2);
                            p.getInventory().addItem(itemStack2);
                            e.setCancelled(true);
                        } else {
                            e.setCancelled(true);
                            p.sendMessage("§4[§c❃ DreamLife ATM ❃§4] §cTu n'as pas assez d'argent !");
                        }
                    }
                    if (e.getClick().isRightClick()) {
                        if (econ.getBalance(p) >= 320) {
                            econ.withdrawPlayer(p, 320);
                            p.sendMessage("§4[§c❃ DreamLife ATM ❃§4] §cTu as retiré 320$");
                            p.getInventory().addItem(itemStack2);
                            e.setCancelled(true);
                        } else {
                            e.setCancelled(true);
                            p.sendMessage("§4[§c❃ DreamLife ATM ❃§4] §cTu n'as pas assez d'argent !");
                        }
                    }
                    if (e.getClick().isKeyboardClick()) {
                        e.setCancelled(true);
                    }

                }
            }
        }
    }

    @EventHandler
    public static void onClick7(InventoryClickEvent e) {
        ItemStack itemStack1 = new ItemStack(Material.getMaterial(6172));
        ItemMeta itemMeta1 = itemStack1.getItemMeta();
        itemMeta1.setDisplayName("§eBillet de §b50 $");
        itemStack1.setAmount(1);
        itemStack1.setItemMeta(itemMeta1);

        ItemStack itemStack2 = itemStack1.clone();
        itemStack2.setAmount(16);
        if (e.getWhoClicked().getType() != EntityType.PLAYER) {
            return;
        }
        Player p = (Player) e.getWhoClicked();

        if (e.getInventory().getName().equals("§1【 §9§lDreamLife Retirer §1】")) {
            if(!e.getInventory().getName().equals("§1【 §9§lDreamLife Retirer §1】")){ return;}
            if (e.getCurrentItem().getItemMeta() == null) {
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4Retirer 50")) {
                if (setupEconomy()) {
                    if (e.getClick().isLeftClick()) {
                        if (econ.getBalance(p) >= 50) {
                            econ.withdrawPlayer(p, 50);
                            p.sendMessage("§4[§c❃ DreamLife ATM ❃§4] §cTu as retiré 50$");
                            p.getInventory().addItem(itemStack1);
                            e.setCancelled(true);
                        } else {
                            e.setCancelled(true);
                            p.sendMessage("§4[§c❃ DreamLife ATM ❃§4] §cTu n'as pas assez d'argent !");
                        }
                    }
                    if (e.getClick().isCreativeAction()) {
                        if (econ.getBalance(p) >= 3200) {
                            econ.withdrawPlayer(p, 3200);
                            p.sendMessage("§4[§c❃ DreamLife ATM ❃§4] §cTu as retiré 3200$");
                            p.getInventory().addItem(itemStack2);
                            p.getInventory().addItem(itemStack2);
                            p.getInventory().addItem(itemStack2);
                            p.getInventory().addItem(itemStack2);
                            e.setCancelled(true);
                        } else {
                            e.setCancelled(true);
                            p.sendMessage("§4[§c❃ DreamLife ATM ❃§4] §cTu n'as pas assez d'argent !");
                        }
                    }
                    if (e.getClick().isRightClick()) {
                        if (econ.getBalance(p) >= 800) {
                            econ.withdrawPlayer(p, 800);
                            p.sendMessage("§4[§c❃ DreamLife ATM ❃§4] §cTu as retiré 800$");
                            p.getInventory().addItem(itemStack2);
                            e.setCancelled(true);
                        } else {
                            e.setCancelled(true);
                            p.sendMessage("§4[§c❃ DreamLife ATM ❃§4] §cTu n'as pas assez d'argent !");
                        }
                    }
                    if (e.getClick().isKeyboardClick()) {
                        e.setCancelled(true);
                    }

                }
            }
        }
    }

    @EventHandler
    public static void onClick8(InventoryClickEvent e) {
        ItemStack itemStack1 = new ItemStack(Material.getMaterial(6173));
        ItemMeta itemMeta1 = itemStack1.getItemMeta();
        itemMeta1.setDisplayName("§eBillet de §b100 $");
        itemStack1.setAmount(1);
        itemStack1.setItemMeta(itemMeta1);

        ItemStack itemStack2 = itemStack1.clone();
        itemStack2.setAmount(16);
        if (e.getWhoClicked().getType() != EntityType.PLAYER) {
            return;
        }
        Player p = (Player) e.getWhoClicked();

        if (e.getInventory().getName().equals("§1【 §9§lDreamLife Retirer §1】")) {
            if(!e.getInventory().getName().equals("§1【 §9§lDreamLife Retirer §1】")){ return;}
            if (e.getCurrentItem().getItemMeta() == null) {
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4Retirer 100")) {
                if (setupEconomy()) {
                    if (e.getClick().isLeftClick()) {
                        if (econ.getBalance(p) >= 100) {
                            econ.withdrawPlayer(p, 100);
                            p.sendMessage("§4[§c❃ DreamLife ATM ❃§4] §cTu as retiré 100$");
                            p.getInventory().addItem(itemStack1);
                            e.setCancelled(true);
                        } else {
                            e.setCancelled(true);
                            p.sendMessage("§4[§c❃ DreamLife ATM ❃§4] §cTu n'as pas assez d'argent !");
                        }
                    }
                    if (e.getClick().isCreativeAction()) {
                        if (econ.getBalance(p) >= 6400) {
                            econ.withdrawPlayer(p, 6400);
                            p.sendMessage("§4[§c❃ DreamLife ATM ❃§4] §cTu as retiré 6400$");
                            p.getInventory().addItem(itemStack2);
                            p.getInventory().addItem(itemStack2);
                            p.getInventory().addItem(itemStack2);
                            p.getInventory().addItem(itemStack2);
                            e.setCancelled(true);
                        } else {
                            e.setCancelled(true);
                            p.sendMessage("§4[§c❃ DreamLife ATM ❃§4] §cTu n'as pas assez d'argent !");
                        }
                    }
                    if (e.getClick().isRightClick()) {
                        if (econ.getBalance(p) >= 1600) {
                            econ.withdrawPlayer(p, 1600);
                            p.sendMessage("§4[§c❃ DreamLife ATM ❃§4] §cTu as retiré 1600$");
                            p.getInventory().addItem(itemStack2);
                            e.setCancelled(true);
                        } else {
                            e.setCancelled(true);
                            p.sendMessage("§4[§c❃ DreamLife ATM ❃§4] §cTu n'as pas assez d'argent !");
                        }
                    }
                    if (e.getClick().isKeyboardClick()) {
                        e.setCancelled(true);
                    }

                }
            }
        }
    }

    @EventHandler
    public static void onClick9(InventoryClickEvent e) {
        ItemStack itemStack1 = new ItemStack(Material.getMaterial(6175));
        ItemMeta itemMeta1 = itemStack1.getItemMeta();
        itemMeta1.setDisplayName("§eBillet de §b500 $");
        itemStack1.setAmount(1);
        itemStack1.setItemMeta(itemMeta1);

        ItemStack itemStack2 = itemStack1.clone();
        itemStack2.setAmount(16);
        if (e.getWhoClicked().getType() != EntityType.PLAYER) {
            return;
        }
        Player p = (Player) e.getWhoClicked();

        if (e.getInventory().getName().equals("§1【 §9§lDreamLife Retirer §1】")) {
            if(!e.getInventory().getName().equals("§1【 §9§lDreamLife Retirer §1】")){ return;}
            if (e.getCurrentItem().getItemMeta() == null) {
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4Retirer 500")) {
                if (setupEconomy()) {
                    if (e.getClick().isLeftClick()) {
                        if (econ.getBalance(p) >= 500) {
                            econ.withdrawPlayer(p, 500);
                            p.sendMessage("§4[§c❃ DreamLife ATM ❃§4] §cTu as retiré 500$");
                            p.getInventory().addItem(itemStack1);
                            e.setCancelled(true);
                        } else {
                            e.setCancelled(true);
                            p.sendMessage("§4[§c❃ DreamLife ATM ❃§4] §cTu n'as pas assez d'argent !");
                        }
                    }
                    if (e.getClick().isCreativeAction()) {
                        if (econ.getBalance(p) >= 32000) {
                            econ.withdrawPlayer(p, 32000);
                            p.sendMessage("§4[§c❃ DreamLife ATM ❃§4] §cTu as retiré 32000$");
                            p.getInventory().addItem(itemStack2);
                            p.getInventory().addItem(itemStack2);
                            p.getInventory().addItem(itemStack2);
                            p.getInventory().addItem(itemStack2);
                            e.setCancelled(true);
                        } else {
                            e.setCancelled(true);
                            p.sendMessage("§4[§c❃ DreamLife ATM ❃§4] §cTu n'as pas assez d'argent !");
                        }
                    }
                    if (e.getClick().isRightClick()) {
                        if (econ.getBalance(p) >= 8000) {
                            econ.withdrawPlayer(p, 8000);
                            p.sendMessage("§4[§c❃ DreamLife ATM ❃§4] §cTu as retiré 8000$");
                            p.getInventory().addItem(itemStack2);
                            e.setCancelled(true);
                        } else {
                            e.setCancelled(true);
                            p.sendMessage("§4[§c❃ DreamLife ATM ❃§4] §cTu n'as pas assez d'argent !");
                        }
                    }
                    if (e.getClick().isKeyboardClick()) {
                        e.setCancelled(true);
                    }

                }
            }
        }
    }

    @EventHandler
    public static void onClick10(InventoryClickEvent e) {
        ItemStack itemStack1 = new ItemStack(Material.getMaterial(6176));
        ItemMeta itemMeta1 = itemStack1.getItemMeta();
        itemMeta1.setDisplayName("§eBillet de §b1000 $");
        itemStack1.setAmount(1);
        itemStack1.setItemMeta(itemMeta1);

        ItemStack itemStack2 = itemStack1.clone();
        itemStack2.setAmount(16);
        if (e.getWhoClicked().getType() != EntityType.PLAYER) {
            return;
        }
        Player p = (Player) e.getWhoClicked();

        if (e.getInventory().getName().equals("§1【 §9§lDreamLife Retirer §1】")) {
            if(!e.getInventory().getName().equals("§1【 §9§lDreamLife Retirer §1】")){ return;}
            if (e.getCurrentItem().getItemMeta() == null) {
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§4Retirer 1000")) {
                if (setupEconomy()) {
                    if (e.getClick().isLeftClick()) {
                        if (econ.getBalance(p) >= 1000) {
                            econ.withdrawPlayer(p, 1000);
                            p.sendMessage("§4[§c❃ DreamLife ATM ❃§4] §cTu as retiré 1000$");
                            p.getInventory().addItem(itemStack1);
                            e.setCancelled(true);
                        } else {
                            e.setCancelled(true);
                            p.sendMessage("§4[§c❃ DreamLife ATM ❃§4] §cTu n'as pas assez d'argent !");
                        }
                    }
                    if (e.getClick().isCreativeAction()) {
                        if (econ.getBalance(p) >= 64000) {
                            econ.withdrawPlayer(p, 64000);
                            p.sendMessage("§4[§c❃ DreamLife ATM ❃§4] §cTu as retiré 64000$");
                            p.getInventory().addItem(itemStack2);
                            p.getInventory().addItem(itemStack2);
                            p.getInventory().addItem(itemStack2);
                            p.getInventory().addItem(itemStack2);
                            e.setCancelled(true);
                        } else {
                            e.setCancelled(true);
                            p.sendMessage("§4[§c❃ DreamLife ATM ❃§4] §cTu n'as pas assez d'argent !");
                        }
                    }
                    if (e.getClick().isRightClick()) {
                        if (econ.getBalance(p) >= 16000) {
                            econ.withdrawPlayer(p, 16000);
                            p.sendMessage("§4[§c❃ DreamLife ATM ❃§4] §cTu as retiré 16000$");
                            p.getInventory().addItem(itemStack2);
                            e.setCancelled(true);
                        } else {
                            e.setCancelled(true);
                            p.sendMessage("§4[§c❃ DreamLife ATM ❃§4] §cTu n'as pas assez d'argent !");
                        }
                    }
                    if (e.getClick().isKeyboardClick()) {
                        e.setCancelled(true);
                    }

                }
            }
        }
    }

    @EventHandler
    public static void onClick11(InventoryClickEvent e) {

        if (e.getWhoClicked().getType() != EntityType.PLAYER) {
            return;
        }
        Player p = (Player) e.getWhoClicked();
        Inventory inv = p.getInventory();

        if (e.getInventory().getName().equals("§1【 §9§lDreamLife Déposer §1】")) {
            if(!e.getInventory().getName().equals("§1【 §9§lDreamLife Déposer §1】")){ return;}
            if (e.getCurrentItem().getItemMeta() == null) {
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§2Déposer 1")) {
                if (setupEconomy()) {
                    if (e.getClick().isLeftClick()) {
                        for (ItemStack item : p.getInventory().getContents()) {
                            if (item == null || item.getType() != Material.getMaterial(5848) || !item.hasItemMeta())
                                continue;
                            if (item.getItemMeta().getDisplayName().equals("§ePiéce de §b1 $")) {
                                if(item.getAmount() > 1){
                                    item.setAmount(item.getAmount() -1);
                                    econ.depositPlayer(p, 1);
                                    p.updateInventory();
                                    p.sendMessage("§9[§b❃ DreamLife ATM ❃§9] §bVous avez déposé une Piéce");
                                    e.setCancelled(true);
                                    return;
                                }else if (item.getAmount() == 1) {
                                        p.getInventory().removeItem(item);
                                        econ.depositPlayer(p, 1);
                                        e.setCancelled(true);
                                        p.updateInventory();
                                        p.sendMessage("§9[§b❃ DreamLife ATM ❃§9] §bVous avez déposé une Piéce");
                                        return;
                                    }
                                }


                            }
                        }


                    if (e.getClick().isCreativeAction()) {
                        for (ItemStack item : p.getInventory().getContents()) {
                            if (item == null || item.getType() != Material.getMaterial(5848) || !item.hasItemMeta())
                                continue;
                            if (item.getItemMeta().getDisplayName().equals("§ePiéce de §b1 $")) {
                                if(item.getAmount() > 64){
                                    item.setAmount(item.getAmount() -64);
                                    econ.depositPlayer(p, 64);
                                    p.updateInventory();
                                    p.sendMessage("§9[§b❃ DreamLife ATM ❃§9] §bVous avez déposé 64 Piéces");
                                    e.setCancelled(true);
                                    return;
                                }else
                                if (item.getAmount() == 64) {
                                    p.getInventory().removeItem(item);
                                    econ.depositPlayer(p, 64);
                                    p.updateInventory();
                                    p.sendMessage("§9[§b❃ DreamLife ATM ❃§9] §bVous avez déposé 64 Piéces");
                                    e.setCancelled(true);
                                    return;
                                }
                        }
                        }
                    }

                    if (e.getClick().isRightClick()) {
                        for (ItemStack item : p.getInventory().getContents()) {
                            if (item == null || item.getType() != Material.getMaterial(5848) || !item.hasItemMeta())
                                continue;
                            if (item.getItemMeta().getDisplayName().equals("§ePiéce de §b1 $")) {
                                if(item.getAmount() > 16){
                                    item.setAmount(item.getAmount() -16);
                                    econ.depositPlayer(p, 16);
                                    p.updateInventory();
                                    p.sendMessage("§9[§b❃ DreamLife ATM ❃§9] §bVous avez déposé 16 Piéces");
                                    e.setCancelled(true);
                                    return;
                                }else
                                if (item.getAmount() == 16) {
                                    p.getInventory().removeItem(item);
                                    econ.depositPlayer(p, 16);
                                    p.updateInventory();

                                    e.setCancelled(true);
                                    p.sendMessage("§9[§b❃ DreamLife ATM ❃§9] §bVous avez déposé 16 Piéces");
                                    return;
                                }
                            }
                        }

                    }

                    if (e.getClick().isKeyboardClick()) {
                        e.setCancelled(true);
                    }


                }

            }
        }
        }


    @EventHandler
    public static void onClick12(InventoryClickEvent e) {

        if (e.getWhoClicked().getType() != EntityType.PLAYER) {
            return;
        }
        Player p = (Player) e.getWhoClicked();
        Inventory inv = p.getInventory();
        if (e.getInventory().getName().equals("§1【 §9§lDreamLife Déposer §1】")) {
            if(!e.getInventory().getName().equals("§1【 §9§lDreamLife Déposer §1】")){ return;}
            if (e.getCurrentItem().getItemMeta() == null) {
                return;
            }
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§2Déposer 5")) {
                if (setupEconomy()) {
                    if (e.getClick().isLeftClick()) {
                        for (ItemStack item : p.getInventory().getContents()) {
                            if (item == null || item.getType() != Material.getMaterial(6169) || !item.hasItemMeta())
                                continue;
                            if (item.getItemMeta().getDisplayName().equals("§eBillet de §b5 $")) {
                                if (item.getAmount() > 1) {
                                    item.setAmount(item.getAmount() - 1);
                                    econ.depositPlayer(p, 5);
                                    p.updateInventory();
                                    p.sendMessage("§9[§b❃ DreamLife ATM ❃§9] §bVous avez déposé un billet de 5$");
                                    e.setCancelled(true);
                                    return;
                                }else
                                if (item.getAmount() == 1) {
                                    p.getInventory().removeItem(item);
                                    econ.depositPlayer(p, 5);
                                    p.updateInventory();
                                    p.sendMessage("§9[§b❃ DreamLife ATM ❃§9] §bVous avez déposé un billet de 5$");
                                    e.setCancelled(true);
                                    return;
                                }
                            }
                        }
                    }

                    if (e.getClick().isCreativeAction()) {
                        for (ItemStack item : p.getInventory().getContents()) {
                            if (item == null || item.getType() != Material.getMaterial(6169) || !item.hasItemMeta())
                                continue;
                            if (item.getItemMeta().getDisplayName().equals("§eBillet de §b5 $")) {
                                if(item.getAmount() > 64){
                                    item.setAmount(item.getAmount() -64);
                                    econ.depositPlayer(p, 320);
                                    p.updateInventory();
                                    p.sendMessage("§9[§b❃ DreamLife ATM ❃§9] §bVous avez déposé 64 billets de 5$");
                                    e.setCancelled(true);
                                    return;
                                }else
                                if (item.getAmount() == 64) {
                                    p.getInventory().removeItem(item);
                                    econ.depositPlayer(p, 320);
                                    p.updateInventory();
                                    p.sendMessage("§9[§b❃ DreamLife ATM ❃§9] §bVous avez déposé 64 billets de 5$");
                                    e.setCancelled(true);
                                    return;
                                }
                            }
                        }
                    }

                    if (e.getClick().isRightClick()) {
                        for (ItemStack item : p.getInventory().getContents()) {
                            if (item == null || item.getType() != Material.getMaterial(6169) || !item.hasItemMeta())
                                continue;
                            if (item.getItemMeta().getDisplayName().equals("§eBillet de §b5 $")) {
                                if(item.getAmount() > 16){
                                    item.setAmount(item.getAmount() -16);
                                    econ.depositPlayer(p, 80);
                                    p.updateInventory();
                                    p.sendMessage("§9[§b❃ DreamLife ATM ❃§9] §bVous avez déposé 16 billets de 5$");
                                    e.setCancelled(true);
                                    return;
                                }else
                                if (item.getAmount() == 16) {
                                    p.getInventory().removeItem(item);
                                    econ.depositPlayer(p, 80);
                                    p.updateInventory();


                                    p.sendMessage("§9[§b❃ DreamLife ATM ❃§9] §bVous avez déposé 16 billets de 5$");
                                    e.setCancelled(true);
                                    return;
                                }
                            }
                        }
                    }

                    if (e.getClick().isKeyboardClick()) {
                        e.setCancelled(true);
                    }


                }

            }
        }
    }

    @EventHandler
    public static void onClick13(InventoryClickEvent e) {

        if (e.getWhoClicked().getType() != EntityType.PLAYER) {
            return;
        }
        Player p = (Player) e.getWhoClicked();
        Inventory inv = p.getInventory();
        if(e.getCurrentItem() == null) return;
        if (e.getInventory().getName().equals("§1【 §9§lDreamLife Déposer §1】")) {
            if(!e.getInventory().getName().equals("§1【 §9§lDreamLife Déposer §1】")){ return;}
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§2Déposer 10")) {
                if (setupEconomy()) {
                    if (e.getClick().isLeftClick()) {
                        for (ItemStack item : p.getInventory().getContents()) {
                            if (item == null || item.getType() != Material.getMaterial(6170) || !item.hasItemMeta())
                                continue;
                            if (item.getItemMeta().getDisplayName().equals("§eBillet de §b10 $")) {
                                if (item.getAmount() > 1) {
                                    item.setAmount(item.getAmount() - 1);
                                    econ.depositPlayer(p, 10);
                                    p.updateInventory();
                                    p.sendMessage("§9[§b❃ DreamLife ATM ❃§9] §bVous avez déposer un billets de 10$");
                                    e.setCancelled(true);
                                    return;
                                }else
                                if (item.getAmount() == 1) {
                                    p.getInventory().removeItem(item);
                                    econ.depositPlayer(p, 10);
                                    p.updateInventory();
                                    p.sendMessage("§9[§b❃ DreamLife ATM ❃§9] §bVous avez déposé un billets de 10$");
                                    e.setCancelled(true);
                                    return;
                                }
                            }
                        }
                    }

                    if (e.getClick().isCreativeAction()) {
                        for (ItemStack item : p.getInventory().getContents()) {
                            if (item == null || item.getType() != Material.getMaterial(6170) || !item.hasItemMeta())
                                continue;
                            if (item.getItemMeta().getDisplayName().equals("§eBillet de §b10 $")) {
                                if(item.getAmount() > 64){
                                    item.setAmount(item.getAmount() -64);
                                    econ.depositPlayer(p, 640);
                                    p.updateInventory();
                                    p.sendMessage("§9[§b❃ DreamLife ATM ❃§9] §bVous avez déposé 64 billets de 10$");
                                    e.setCancelled(true);
                                    return;
                                }else
                                if (item.getAmount() == 64) {
                                    p.getInventory().removeItem(item);
                                    econ.depositPlayer(p, 640);
                                    p.updateInventory();
                                    p.sendMessage("§9[§b❃ DreamLife ATM ❃§9] §bVous avez déposé 64 billets de 10$");
                                    e.setCancelled(true);
                                    return;
                                }
                            }
                        }
                    }

                    if (e.getClick().isRightClick()) {
                        for (ItemStack item : p.getInventory().getContents()) {
                            if (item == null || item.getType() != Material.getMaterial(6170) || !item.hasItemMeta())
                                continue;
                            if (item.getItemMeta().getDisplayName().equals("§eBillet de §b10 $")) {
                                if(item.getAmount() > 16){
                                    item.setAmount(item.getAmount() -16);
                                    econ.depositPlayer(p, 160);
                                    p.updateInventory();
                                    p.sendMessage("§9[§b❃ DreamLife ATM ❃§9] §bVous avez déposé 16 billets de 10$");
                                    e.setCancelled(true);
                                    return;
                                }else
                                if (item.getAmount() == 16) {
                                    p.getInventory().removeItem(item);
                                    econ.depositPlayer(p, 160);
                                    p.updateInventory();
                                    e.setCancelled(true);

                                    p.sendMessage("§9[§b❃ DreamLife ATM ❃§9] §bVous avez déposé 16 billets de 10$");
                                    return;
                                }
                            }
                        }
                    }

                    if (e.getClick().isKeyboardClick()) {
                        e.setCancelled(true);
                    }


                }
                }
        }
    }

    @EventHandler
    public static void onClick14(InventoryClickEvent e) {

        if (e.getWhoClicked().getType() != EntityType.PLAYER) {
            return;
        }
        Player p = (Player) e.getWhoClicked();
        Inventory inv = p.getInventory();
        if(e.getCurrentItem() == null) return;
        if (e.getInventory().getName().equals("§1【 §9§lDreamLife Déposer §1】")) {
            if(!e.getInventory().getName().equals("§1【 §9§lDreamLife Déposer §1】")){ return;}
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§2Déposer 20")) {
                if (setupEconomy()) {
                    if (e.getClick().isLeftClick()) {
                        for (ItemStack item : p.getInventory().getContents()) {
                            if (item == null || item.getType() != Material.getMaterial(6171) || !item.hasItemMeta())
                                continue;
                            if (item.getItemMeta().getDisplayName().equals("§eBillet de §b20 $")) {
                                if (item.getAmount() > 1) {
                                    item.setAmount(item.getAmount() - 1);
                                    econ.depositPlayer(p, 20);
                                    p.updateInventory();
                                    p.sendMessage("§9[§b❃ DreamLife ATM ❃§9] §bVous avez déposé un billet de 20$");
                                    e.setCancelled(true);
                                    return;
                                }else
                                if (item.getAmount() == 1) {
                                    p.getInventory().removeItem(item);
                                    econ.depositPlayer(p, 20);
                                    p.updateInventory();
                                    p.sendMessage("§9[§b❃ DreamLife ATM ❃§9] §bVous avez déposé un billet de 20$");
                                    e.setCancelled(true);
                                    return;
                                }
                            }
                        }
                    }

                    if (e.getClick().isCreativeAction()) {
                        for (ItemStack item : p.getInventory().getContents()) {
                            if (item == null || item.getType() != Material.getMaterial(6171) || !item.hasItemMeta())
                                continue;
                            if (item.getItemMeta().getDisplayName().equals("§eBillet de §b20 $")) {
                                if(item.getAmount() > 64){
                                    item.setAmount(item.getAmount() -64);
                                    econ.depositPlayer(p, 1280);
                                    p.updateInventory();
                                    p.sendMessage("§9[§b❃ DreamLife ATM ❃§9] §bVous avez déposé 64 billets de 20$");
                                    e.setCancelled(true);
                                    return;
                                }else
                                if (item.getAmount() == 64) {
                                    p.getInventory().removeItem(item);
                                    econ.depositPlayer(p, 1280);
                                    p.updateInventory();
                                    p.sendMessage("§9[§b❃ DreamLife ATM ❃§9] §bVous avez déposé 64 billets de 20$");
                                    e.setCancelled(true);
                                    return;
                                }
                            }
                        }
                    }

                    if (e.getClick().isRightClick()) {
                        for (ItemStack item : p.getInventory().getContents()) {
                            if (item == null || item.getType() != Material.getMaterial(6171) || !item.hasItemMeta())
                                continue;
                            if (item.getItemMeta().getDisplayName().equals("§eBillet de §b20 $")) {
                                if(item.getAmount() > 16){
                                    item.setAmount(item.getAmount() -16);
                                    econ.depositPlayer(p, 320);
                                    p.updateInventory();
                                    p.sendMessage("§9[§b❃ DreamLife ATM ❃§9] §bVous avez déposé 16 billets de 20$");
                                    e.setCancelled(true);
                                    return;
                                }else
                                if (item.getAmount() == 16) {
                                    p.getInventory().removeItem(item);
                                    econ.depositPlayer(p, 320);
                                    p.updateInventory();


                                    p.sendMessage("§9[§b❃ DreamLife ATM ❃§9] §bVous avez déposé 16 billets de 20$");
                                    e.setCancelled(true);
                                    return;
                                }
                            }
                        }

                    }

                    if (e.getClick().isKeyboardClick()) {
                        e.setCancelled(true);
                    }


                }

            }
        }
    }

    @EventHandler
    public static void onClick15(InventoryClickEvent e) {

        if (e.getWhoClicked().getType() != EntityType.PLAYER) {
            return;
        }
        Player p = (Player) e.getWhoClicked();
        Inventory inv = p.getInventory();
        if(e.getCurrentItem() == null) return;
        if (e.getInventory().getName().equals("§1【 §9§lDreamLife Déposer §1】")) {
            if(!e.getInventory().getName().equals("§1【 §9§lDreamLife Déposer §1】")){ return;}
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§2Déposer 50")) {
                if (setupEconomy()) {
                    if (e.getClick().isLeftClick()) {
                        for (ItemStack item : p.getInventory().getContents()) {
                            if (item == null || item.getType() != Material.getMaterial(6172) || !item.hasItemMeta())
                                continue;
                            if (item.getItemMeta().getDisplayName().equals("§eBillet de §b50 $")) {
                                if (item.getAmount() > 1) {
                                    item.setAmount(item.getAmount() - 1);
                                    econ.depositPlayer(p, 50);
                                    p.updateInventory();
                                    p.sendMessage("§9[§b❃ DreamLife ATM ❃§9] §bVous avez déposé un billet de 50$");
                                    e.setCancelled(true);
                                    return;
                                } else if (item.getAmount() == 1) {
                                    p.getInventory().removeItem(item);
                                    econ.depositPlayer(p, 50);
                                    p.updateInventory();
                                    p.sendMessage("§9[§b❃ DreamLife ATM ❃§9] §bVous avez déposé un billet de 50$");
                                    e.setCancelled(true);
                                    return;
                                }
                            }
                        }
                    }

                    if (e.getClick().isCreativeAction()) {
                        for (ItemStack item : p.getInventory().getContents()) {
                            if (item == null || item.getType() != Material.getMaterial(6172) || !item.hasItemMeta())
                                continue;
                            if (item.getItemMeta().getDisplayName().equals("§eBillet de §b50 $")) {
                                if(item.getAmount() > 64){
                                    item.setAmount(item.getAmount() -64);
                                    econ.depositPlayer(p, 3200);
                                    p.updateInventory();
                                    p.sendMessage("§9[§b❃ DreamLife ATM ❃§9] §bVous avez déposé 64 billets de 50$");
                                    e.setCancelled(true);
                                    return;
                                }else
                                if (item.getAmount() == 64) {
                                    p.getInventory().removeItem(item);
                                    econ.depositPlayer(p, 3200);
                                    p.updateInventory();
                                    p.sendMessage("§9[§b❃ DreamLife ATM ❃§9] §bVous avez déposé 64 billets de 50$");
                                    e.setCancelled(true);
                                    return;
                                }
                            }
                        }
                    }

                    if (e.getClick().isRightClick()) {
                        for (ItemStack item : p.getInventory().getContents()) {
                            if (item == null || item.getType() != Material.getMaterial(6172) || !item.hasItemMeta())
                                continue;
                            if (item.getItemMeta().getDisplayName().equals("§eBillet de §b50 $")) {
                                if(item.getAmount() > 16){
                                    item.setAmount(item.getAmount() -16);
                                    econ.depositPlayer(p, 800);
                                    p.updateInventory();
                                    p.sendMessage("§9[§b❃ DreamLife ATM ❃§9] §bVous avez déposé 16 billets de 50$");
                                    e.setCancelled(true);
                                    return;
                                }else
                                if (item.getAmount() == 16) {
                                    p.getInventory().removeItem(item);
                                    econ.depositPlayer(p, 800);
                                    p.updateInventory();


                                    p.sendMessage("§9[§b❃ DreamLife ATM ❃§9] §bVous avez déposé 16 billets de 50$");
                                    e.setCancelled(true);
                                    return;
                                }
                            }

                        }
                    }

                    if (e.getClick().isKeyboardClick()) {
                        e.setCancelled(true);
                    }


                }
            }
        }
    }

    @EventHandler
    public static void onClick16(InventoryClickEvent e) {

        if (e.getWhoClicked().getType() != EntityType.PLAYER) {
            return;
        }
        Player p = (Player) e.getWhoClicked();
        Inventory inv = p.getInventory();
        if(e.getCurrentItem() == null) return;
        if (e.getInventory().getName().equals("§1【 §9§lDreamLife Déposer §1】")) {
            if(!e.getInventory().getName().equals("§1【 §9§lDreamLife Déposer §1】")){ return;}
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§2Déposer 100")) {
                if (setupEconomy()) {
                    if (e.getClick().isLeftClick()) {
                        for (ItemStack item : p.getInventory().getContents()) {
                            if (item == null || item.getType() != Material.getMaterial(6173) || !item.hasItemMeta())
                                continue;
                            if (item.getItemMeta().getDisplayName().equals("§eBillet de §b100 $")) {
                                if(item.getAmount() > 1){
                                    item.setAmount(item.getAmount() -1);
                                    econ.depositPlayer(p, 100);
                                    p.updateInventory();
                                    p.sendMessage("§9[§b❃ DreamLife ATM ❃§9] §bVous avez déposé un billet de 100$");
                                    e.setCancelled(true);
                                    return;
                                }else
                                if (item.getAmount() == 1) {
                                    p.getInventory().removeItem(item);
                                    econ.depositPlayer(p, 100);
                                    p.updateInventory();
                                    p.sendMessage("§9[§b❃ DreamLife ATM ❃§9] §bVous avez déposé un billet de 100$");
                                    e.setCancelled(true);
                                    return;
                                }
                            }
                        }
                    }

                    if (e.getClick().isCreativeAction()) {
                        for (ItemStack item : p.getInventory().getContents()) {
                            if (item == null || item.getType() != Material.getMaterial(6173) || !item.hasItemMeta())
                                continue;
                            if (item.getItemMeta().getDisplayName().equals("§eBillet de §b100 $")) {
                                if(item.getAmount() > 64){
                                    item.setAmount(item.getAmount() -64);
                                    econ.depositPlayer(p, 6400);
                                    p.updateInventory();
                                    p.sendMessage("§9[§b❃ DreamLife ATM ❃§9] §bVous avez déposé 64 billets de 100$");
                                    e.setCancelled(true);
                                    return;
                                }else
                                if (item.getAmount() == 64) {
                                    p.getInventory().removeItem(item);
                                    econ.depositPlayer(p, 6400);
                                    p.updateInventory();
                                    p.sendMessage("§9[§b❃ DreamLife ATM ❃§9] §bVous avez déposé 64 billets de 100$");
                                    e.setCancelled(true);
                                    return;
                                }
                            }
                        }
                    }

                    if (e.getClick().isRightClick()) {
                        for (ItemStack item : p.getInventory().getContents()) {
                            if (item == null || item.getType() != Material.getMaterial(6173) || !item.hasItemMeta())
                                continue;
                            if (item.getItemMeta().getDisplayName().equals("§eBillet de §b100 $")) {
                                if(item.getAmount() > 16){
                                    item.setAmount(item.getAmount() -16);
                                    econ.depositPlayer(p, 1600);
                                    p.updateInventory();
                                    p.sendMessage("§9[§b❃ DreamLife ATM ❃§9] §bVous avez déposé 16 billets de 100$");
                                    e.setCancelled(true);
                                    return;
                                }else
                                if (item.getAmount() == 16) {
                                    p.getInventory().removeItem(item);
                                    econ.depositPlayer(p, 1600);
                                    p.updateInventory();


                                    p.sendMessage("§9[§b❃ DreamLife ATM ❃§9] §bVous avez déposé 16 billets de 100$");
                                    e.setCancelled(true);
                                    return;
                                }
                            }

                        }
                    }

                    if (e.getClick().isKeyboardClick()) {
                        e.setCancelled(true);
                    }


                }
            }else {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public static void onClick17(InventoryClickEvent e) {

        if (e.getWhoClicked().getType() != EntityType.PLAYER) {
            return;
        }
        Player p = (Player) e.getWhoClicked();
        Inventory inv = p.getInventory();
        if(e.getCurrentItem() == null) return;
        if (e.getInventory().getName().equals("§1【 §9§lDreamLife Déposer §1】")) {
            if(!e.getInventory().getName().equals("§1【 §9§lDreamLife Déposer §1】")){ return;}
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§2Déposer 500")) {
                if (setupEconomy()) {
                    if (e.getClick().isLeftClick()) {
                        for (ItemStack item : p.getInventory().getContents()) {
                            if (item == null || item.getType() != Material.getMaterial(6175) || !item.hasItemMeta())
                                continue;
                            if (item.getItemMeta().getDisplayName().equals("§eBillet de §b500 $")) {
                                if(item.getAmount() > 1){
                                    item.setAmount(item.getAmount() -1);
                                    econ.depositPlayer(p, 500);
                                    p.updateInventory();
                                    p.sendMessage("§9[§b❃ DreamLife ATM ❃§9] §bVous avez déposé un billet de 500$");
                                    e.setCancelled(true);
                                    return;
                                }else
                                if (item.getAmount() == 1) {
                                    p.getInventory().removeItem(item);
                                    econ.depositPlayer(p, 500);
                                    p.updateInventory();
                                    p.sendMessage("§9[§b❃ DreamLife ATM ❃§9] §bVous avez déposé un billet de 500$");
                                    e.setCancelled(true);
                                    return;
                                }

                            }
                        }
                    }

                    if (e.getClick().isCreativeAction()) {
                        for (ItemStack item : p.getInventory().getContents()) {
                            if (item == null || item.getType() != Material.getMaterial(6175) || !item.hasItemMeta())
                                continue;
                            if (item.getItemMeta().getDisplayName().equals("§eBillet de §b500 $")) {
                                if(item.getAmount() > 64){
                                    item.setAmount(item.getAmount() -64);
                                    econ.depositPlayer(p, 32000);
                                    p.updateInventory();
                                    p.sendMessage("§9[§b❃ DreamLife ATM ❃§9] §bVous avez déposé 64 billets de 500$");
                                    e.setCancelled(true);
                                    return;
                                }else if (item.getAmount() == 64) {
                                    p.getInventory().removeItem(item);
                                    econ.depositPlayer(p, 32000);
                                    p.updateInventory();
                                    p.sendMessage("§9[§b❃ DreamLife ATM ❃§9] §bVous avez déposé 64 billets de 500$");
                                    e.setCancelled(true);
                                    return;
                                } else {
                                    p.sendMessage("§9[§b❃ DreamLife ATM ❃§9] §bTu n'as pas assez de billet");
                                    e.setCancelled(true);
                                    return;
                                }
                            }
                        }
                    }

                    if (e.getClick().isRightClick()) {
                        for (ItemStack item : p.getInventory().getContents()) {
                            if (item == null || item.getType() != Material.getMaterial(6175) || !item.hasItemMeta())
                                continue;
                            if (item.getItemMeta().getDisplayName().equals("§eBillet de §b500 $")) {
                                if(item.getAmount() > 16){
                                    item.setAmount(item.getAmount() -16);
                                    econ.depositPlayer(p, 8000);
                                    p.updateInventory();
                                    p.sendMessage("§9[§b❃ DreamLife ATM ❃§9] §bVous avez déposé 16 billets de 500$");
                                    e.setCancelled(true);
                                    return;
                                }else
                                if (item.getAmount() == 16) {
                                    p.getInventory().removeItem(item);
                                    econ.depositPlayer(p, 8000);
                                    p.updateInventory();


                                    p.sendMessage("§9[§b❃ DreamLife ATM ❃§9] §bVous avez déposé 16 billets de 500$");
                                    e.setCancelled(true);
                                    return;
                                } else {
                                    p.sendMessage("§9[§b❃ DreamLife ATM ❃§9] §bTu n'as pas assez de billet");
                                    e.setCancelled(true);
                                    return;
                                }
                            }

                        }
                    }

                    if (e.getClick().isKeyboardClick()) {
                        e.setCancelled(true);
                    }


                }
            }
        }
    }

    @EventHandler
    public static void onClick18(InventoryClickEvent e) {

        if (e.getWhoClicked().getType() != EntityType.PLAYER) {
            return;
        }
        Player p = (Player) e.getWhoClicked();
        Inventory inv = p.getInventory();
        if(e.getCurrentItem() == null) return;
        if (e.getInventory().getName().equals("§1【 §9§lDreamLife Déposer §1】")) {
            if(!e.getInventory().getName().equals("§1【 §9§lDreamLife Déposer §1】")){ return;}
            if (e.getCurrentItem().getItemMeta().getDisplayName().equals("§2Déposer 1000")) {
                if (setupEconomy()) {
                    if (e.getClick().isLeftClick()) {
                        for (ItemStack item : p.getInventory().getContents()) {
                            if (item == null || item.getType() != Material.getMaterial(6176) || !item.hasItemMeta())
                                continue;
                            if (item.getItemMeta().getDisplayName().equals("§eBillet de §b1000 $")) {
                                if (item.getAmount() > 1) {
                                    item.setAmount(item.getAmount() - 1);
                                    econ.depositPlayer(p, 1000);
                                    p.updateInventory();
                                    p.sendMessage("§9[§b❃ DreamLife ATM ❃§9] §bVous avez déposé un billet de 1000$");
                                    e.setCancelled(true);
                                    return;
                                } else if (item.getAmount() == 1) {
                                    p.getInventory().removeItem(item);
                                    econ.depositPlayer(p, 1000);
                                    p.updateInventory();
                                    p.sendMessage("§9[§b❃ DreamLife ATM ❃§9] §bVous avez déposé un billet de 1000$");
                                    e.setCancelled(true);
                                    return;
                                }
                            }
                        }
                    }

                    if (e.getClick().isCreativeAction()) {
                        for (ItemStack item : p.getInventory().getContents()) {
                            if (item == null || item.getType() != Material.getMaterial(6176) || !item.hasItemMeta())
                                continue;
                            if (item.getItemMeta().getDisplayName().equals("§eBillet de §b1000 $")) {
                                if(item.getAmount() > 64){
                                    item.setAmount(item.getAmount() -64);
                                    econ.depositPlayer(p, 64000);
                                    p.updateInventory();
                                    p.sendMessage("§9[§b❃ DreamLife ATM ❃§9] §bVous avez déposé 64 billets de 1000$");
                                    e.setCancelled(true);
                                    return;
                                }else if (item.getAmount() == 64) {
                                    p.getInventory().removeItem(item);
                                    econ.depositPlayer(p, 64000);
                                    p.updateInventory();
                                    p.sendMessage("§9[§b❃ DreamLife ATM ❃§9] §bVous avez déposé 64 billets de 1000$");
                                    e.setCancelled(true);
                                    return;
                                }
                            }
                        }
                    }

                    if (e.getClick().isRightClick()) {
                        for (ItemStack item : p.getInventory().getContents()) {
                            if (item == null || item.getType() != Material.getMaterial(6176) || !item.hasItemMeta())
                                continue;
                            if (item.getItemMeta().getDisplayName().equals("§eBillet de §b1000 $")) {
                                if(item.getAmount() > 16){
                                    item.setAmount(item.getAmount() -16);
                                    econ.depositPlayer(p, 16000);
                                    p.updateInventory();
                                    p.sendMessage("§9[§b❃ DreamLife ATM ❃§9] §bVous avez déposé 16 billets de 1000$");
                                    e.setCancelled(true);
                                    return;
                                }else
                                if (item.getAmount() == 16) {
                                    p.getInventory().removeItem(item);
                                    econ.depositPlayer(p, 16000);
                                    p.updateInventory();


                                    p.sendMessage("§9[§b❃ DreamLife ATM ❃§9] §bVous avez déposé 16 billets de 1000$");
                                    e.setCancelled(true);
                                    return;
                                }
                            }
                            }
                        }
                    if (e.getClick().isKeyboardClick()) {
                        e.setCancelled(true);
                    }
                    }





                }else {
                e.setCancelled(true);
            }
            }
        }
    }




