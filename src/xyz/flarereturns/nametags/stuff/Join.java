package xyz.flarereturns.nametags.stuff;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import xyz.flarereturns.nametags.Main;
import xyz.flarereturns.nametags.api.Nametags;
import xyz.flarereturns.nametags.utils.VaultChecker;

public class Join implements Listener {

    @SuppressWarnings("EmptyCatchBlock")
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        if(Main.getConfigManager().prefix_users.contains(p.getName())) {
            try {
                Nametags.getAPI().setTag(p, Main.getConfigManager().prefix_users.getString(p.getName()));
            } catch (Exception ex) {}
        }

        if(Main.getConfigManager().prefix_groups.contains(VaultChecker.getVaultPermission().getPlayerGroups(p)[0])) {
            try {
                Nametags.getAPI().setTag(p, Main.getConfigManager().prefix_groups.getString(VaultChecker.getVaultPermission().getPlayerGroups(p)[0]));
            } catch (Exception ex) {}
        }

        if(Main.getConfigManager().suffix_users.contains(p.getName())) {
            try {
                Nametags.getAPI().setTag(p, Main.getConfigManager().suffix_users.getString(p.getName()), true);
            } catch (Exception ex) {}
        }

        if(Main.getConfigManager().suffix_groups.contains(VaultChecker.getVaultPermission().getPlayerGroups(p)[0])) {
            try {
                Nametags.getAPI().setTag(p, Main.getConfigManager().suffix_groups.getString(VaultChecker.getVaultPermission().getPlayerGroups(p)[0]), true);
            } catch (Exception ex) {}
        }

        if(Main.getConfigManager().permissions) {
            if(p.hasPermission("nametags.black")) {
                try {
                    Nametags.getAPI().setTag(p, "§0");
                } catch (Exception ex) {}
            }
            if(p.hasPermission("nametags.dark_blue")) {
                try {
                    Nametags.getAPI().setTag(p, "§1");
                } catch (Exception ex) {}
            }
            if(p.hasPermission("nametags.dark_green")) {
                try {
                    Nametags.getAPI().setTag(p, "§2");
                } catch (Exception ex) {}
            }
            if(p.hasPermission("nametags.dark_cyan")) {
                try {
                    Nametags.getAPI().setTag(p, "§3");
                } catch (Exception ex) {}
            }
            if(p.hasPermission("nametags.dark_red")) {
                try {
                    Nametags.getAPI().setTag(p, "§4");
                } catch (Exception ex) {}
            }
            if(p.hasPermission("nametags.dark_purple")) {
                try {
                    Nametags.getAPI().setTag(p, "§5");
                } catch (Exception ex) {}
            }

            if(p.hasPermission("nametags.gold")) {
                try {
                    Nametags.getAPI().setTag(p, "§6");
                } catch (Exception ex) {}
            }
            if(p.hasPermission("nametags.grey")) {
                try {
                    Nametags.getAPI().setTag(p, "§7");
                } catch (Exception ex) {}
            }
            if(p.hasPermission("nametags.dark_grey")) {
                try {
                    Nametags.getAPI().setTag(p, "§8");
                } catch (Exception ex) {}
            }
            if(p.hasPermission("nametags.blue")) {
                try {
                    Nametags.getAPI().setTag(p, "§9");
                } catch (Exception ex) {}
            }
            if(p.hasPermission("nametags.green")) {
                try {
                    Nametags.getAPI().setTag(p, "§a");
                } catch (Exception ex) {}
            }
            if(p.hasPermission("nametags.cyan")) {
                try {
                    Nametags.getAPI().setTag(p, "§b");
                } catch (Exception ex) {}
            }
            if(p.hasPermission("nametags.red")) {
                try {
                    Nametags.getAPI().setTag(p, "§c");
                } catch (Exception ex) {}
            }
            if(p.hasPermission("nametags.pink")) {
                try {
                    Nametags.getAPI().setTag(p, "§d");
                } catch (Exception ex) {}
            }
            if(p.hasPermission("nametags.yellow")) {
                try {
                    Nametags.getAPI().setTag(p, "§e");
                } catch (Exception ex) {}
            }
            if(p.hasPermission("nametags.white")) {
                try {
                    Nametags.getAPI().setTag(p, "§1");
                } catch (Exception ex) {}
            }

            // FORMATING
            if(p.hasPermission("nametags.obfuscated")) {
                try {
                    Nametags.getAPI().setTag(p, Nametags.getAPI().getPrefix(p) + "§k");
                } catch (Exception ex) {}
            }
            if(p.hasPermission("nametags.bold")) {
                try {
                    Nametags.getAPI().setTag(p, Nametags.getAPI().getPrefix(p) + "§l");
                } catch (Exception ex) {}
            }
            if(p.hasPermission("nametags.striketrough")) {
                try {
                    Nametags.getAPI().setTag(p, Nametags.getAPI().getPrefix(p) + "§m");
                } catch (Exception ex) {}
            }
            if(p.hasPermission("nametags.underline")) {
                try {
                    Nametags.getAPI().setTag(p, Nametags.getAPI().getPrefix(p) + "§n");
                } catch (Exception ex) {}
            }
            if(p.hasPermission("nametags.italic")) {
                try {
                    Nametags.getAPI().setTag(p, Nametags.getAPI().getPrefix(p) + "§o");
                } catch (Exception ex) {}
            }
            if(p.hasPermission("nametags.reset")) {
                try {
                    Nametags.getAPI().setTag(p, Nametags.getAPI().getPrefix(p) + "§r");
                } catch (Exception ex) {}
            }
        }

    }

}
