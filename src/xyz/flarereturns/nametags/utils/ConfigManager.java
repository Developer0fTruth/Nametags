package xyz.flarereturns.nametags.utils;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import xyz.flarereturns.nametags.Main;

public class ConfigManager {

    FileConfiguration cfg = Main.getInstance().getConfig();

    public boolean permissions;

    public ConfigurationSection prefix_users;
    public ConfigurationSection prefix_groups;

    public ConfigurationSection suffix_users;
    public ConfigurationSection suffix_groups;

    public void makeSure() {
        cfg.options().copyDefaults(true);
        Main.getInstance().saveConfig();

        permissions = cfg.getBoolean("Permissions");

        prefix_users = cfg.getConfigurationSection("Prefix.Users");
        prefix_groups = cfg.getConfigurationSection("Prefix.Groups");
        suffix_users = cfg.getConfigurationSection("Suffix.Users");
        suffix_groups = cfg.getConfigurationSection("Suffix.Groups");

    }

}
