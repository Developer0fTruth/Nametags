package xyz.flarereturns.nametags.utils;

import net.milkbowl.vault.permission.Permission;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import xyz.flarereturns.nametags.Main;

public class VaultChecker {

    private static Permission permission;

    public static void checkVault() {
        if(Bukkit.getPluginManager().getPlugin("Vault").isEnabled()) {
            setupVault();
        } else {
            Bukkit.getConsoleSender().sendMessage("[Nametags] §cVault is not enabled or installed. Aborting...");
            Bukkit.getPluginManager().disablePlugin(Main.getInstance());
        }
    }

    public static void setupVault() {
        RegisteredServiceProvider<Permission> rsp = Bukkit.getServicesManager().getRegistration(Permission.class);
        if(rsp != null) {
            permission = rsp.getProvider();
        } else {
            Bukkit.getConsoleSender().sendMessage("[Nametags] §cAn error occured whilst registering Permissions with Vault...");
            checkVault();
            return;
        }
        Bukkit.getConsoleSender().sendMessage("[Nametags] Successfully hooked into Vault.");
    }

    public static void unregisterVault() {
        if(permission != null) {
            permission = null;
        }
    }

    public static Permission getVaultPermission() {
        if(permission != null) {
            return permission;
        } else {
            checkVault();
        }
        return permission;
    }

}
