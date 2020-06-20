package fr.newzaz.dreamlifecore.runnable;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.Arrays;

public class Salaire extends BukkitRunnable {

    Economy econ = null;
    Permission perms = null;

    int tax = 2;

    private boolean setupEconomy() {
        RegisteredServiceProvider<Economy> economyProvider = Bukkit.getServer().getServicesManager()
                .getRegistration(net.milkbowl.vault.economy.Economy.class);
        if (economyProvider != null) {
            econ = economyProvider.getProvider();
        }

        return (econ != null);
    }

    private boolean setupPermissions() {
        RegisteredServiceProvider<Permission> rsp = Bukkit.getServer().getServicesManager()
                .getRegistration(Permission.class);
        perms = rsp.getProvider();
        return perms != null;
    }


    @Override
    public void run() {
        if (setupEconomy()) {
            if (setupPermissions()) {
               for (Player p : Bukkit.getServer().getOnlinePlayers()){
                    if(perms.playerInGroup(p,"Soldat")){
                        int salaire = 1500;
                        int taxe = tax*salaire /100;
                        p.sendMessage("§a§m§l--------------§a§l[DreamLife §e§lSalaire]§e§m§l--------------");
                        p.sendMessage("§aRank : §e" + Arrays.toString(perms.getPlayerGroups(p))+ "§a.");
                        p.sendMessage("§e§m-----------------------");
                        p.sendMessage("§aTu as reçu un salaire de §e"+ salaire + "$§a.");
                        p.sendMessage("§e§m-----------------------");
                        p.sendMessage("§aTaxe : §e" + tax + "%§a.");
                        p.sendMessage("§e§m-----------------------");
                        p.sendMessage("§aSalaire totale : §e" + (salaire-taxe) + "$§a.");
                        p.sendMessage("§a§m§l--------------§a§l[DreamLife §e§lSalaire]§e§m§l--------------");
                        econ.depositPlayer(p,salaire-taxe);
                    }
                }
            }
                }
    }
}
