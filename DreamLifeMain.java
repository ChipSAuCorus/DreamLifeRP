package fr.newzaz.dreamlifecore;

import fr.newzaz.dreamlifecore.menu.*;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;


public class DreamLifeMain extends JavaPlugin {
    private static DreamLifeMain instance;
    File cfile;
    private static FileConfiguration config;
    @Override
    public void onEnable() {
        System.out.println("Le Plugin DreamLifeGPS s'est bien allumé !");
        instance = this;
        registerCommands();
        registerEvents();
        config = getConfig();
        config.options().copyDefaults(true);
        saveConfig();
        cfile = new File(getDataFolder(), "config.yml");
        runnable();
    }

    @Override
    public void onDisable() {
        System.out.println("Le Plugin DreamLifeGPS s'est bien éteint !");
    }


    private void registerCommands(){
        
    }

    private void registerEvents() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new DreamLifeGPSMenu(this), this);
        pm.registerEvents(new DreamLifeGPSMenuInteract(this), this);
        pm.registerEvents(new DreamLifeGPSInteract(this), this);
        pm.registerEvents(new MedkitInteract(), this);
        pm.registerEvents(new BackPackFix(),this);
        //pm.registerEvents(new ATMInteract(),this);
        pm.registerEvents(new ATMMenu(),this);
        //pm.registerEvents(new ATMMenuInteract(),this);
        pm.registerEvents(new ATMMenuRetirer(),this);
        pm.registerEvents(new ATMMenuDéposer(),this);
    }
        private void runnable(){
           //new Salaire().runTaskTimer(this, 10 * 20L, 10 * 20L);
        }

    public static DreamLifeMain getInstance() {
        return instance;
    }


}
