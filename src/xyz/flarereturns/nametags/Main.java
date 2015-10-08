package xyz.flarereturns.nametags;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.flarereturns.nametags.commands.NametagsCommand;
import xyz.flarereturns.nametags.stuff.AutoUpdate;
import xyz.flarereturns.nametags.stuff.Join;
import xyz.flarereturns.nametags.stuff.WorldChange;
import xyz.flarereturns.nametags.utils.ConfigManager;
import xyz.flarereturns.nametags.utils.VaultChecker;

public class Main extends JavaPlugin {

    public static String pr = " §9Nametags §8» §7";
    private static Main instance;
    private static ConfigManager cfgManager;

    @Override
    public void onEnable() {
        instance = this;
        cfgManager = new ConfigManager();
        getConfigManager().makeSure();
        VaultChecker.checkVault();
        registerListeners();
        registerCommands();
        new AutoUpdate();
        Bukkit.getConsoleSender().sendMessage("[Nametags] Nametags v" + getDescription().getVersion() + " was enabled.");
    }

    @Override
    public void onDisable() {
        VaultChecker.unregisterVault();
        cfgManager = null;
        instance = null;
        Bukkit.getConsoleSender().sendMessage("[Nametags] Nametags v" + getDescription().getVersion() + " was disabled.");
    }

    private void registerListeners() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new Join(), this);
        pm.registerEvents(new WorldChange(), this);
    }

    private void registerCommands() {
        Server s = Bukkit.getServer();
        s.getPluginCommand("nametags").setExecutor(new NametagsCommand());
    }

    public static ConfigManager getConfigManager() {
        return cfgManager;
    }

    public static Main getInstance() {
        return instance;
    }

}
