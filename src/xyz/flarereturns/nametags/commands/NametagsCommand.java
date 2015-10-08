package xyz.flarereturns.nametags.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import xyz.flarereturns.nametags.Main;

public class NametagsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(args.length == 1) {
            if(args[0].equalsIgnoreCase("refresh")) {
                xyz.flarereturns.nametags.api.Nametags.getAPI().refresh();
                sender.sendMessage(Main.pr + "§7Successfully refreshed all Nametags.");
                return true;
            }
            if(args[0].equalsIgnoreCase("reload")) {
                Main.getConfigManager().makeSure();
                sender.sendMessage(Main.pr + "§7The Config has been reloaded.");
                return true;
            }
            if(args[0].equalsIgnoreCase("resetall")) {
                try {
                    xyz.flarereturns.nametags.api.Nametags.getAPI().unregisterAll();
                    sender.sendMessage(Main.pr + "§7All Players has been unregistered.");
                    return true;
                } catch (Exception ex) {
                    ex.printStackTrace();
                    sender.sendMessage(Main.pr + "§cAn error occured.");
                    return true;
                }
            }
        }
        if(args.length == 2) {
            if(args[0].equalsIgnoreCase("reset")) {
                try {
                    xyz.flarereturns.nametags.api.Nametags.getAPI().unregisterTag(Bukkit.getPlayer(args[1]));
                    sender.sendMessage(Main.pr + "§7" + args[1] + "'s Tag has been unregistered.");
                    return true;
                } catch (Exception ex) {
                    ex.printStackTrace();
                    sender.sendMessage(Main.pr + "§7The Player doesn't exists.");
                    return true;
                }
            }
            if(args[0].equalsIgnoreCase("getprefix")) {
                Player t = Bukkit.getPlayer(args[1]);
                if(t.isOnline()) {
                    try {
                        sender.sendMessage(Main.pr + "§7" + t.getName() + "'s Prefix is: §r" + xyz.flarereturns.nametags.api.Nametags.getAPI().getPrefix(t));
                        return true;
                    } catch (Exception ex) {
                        sender.sendMessage(Main.pr + "§7The Player has no Nametag");
                        return true;
                    }
                } else {
                    sender.sendMessage(Main.pr + "§7The user is not online");
                    return true;
                }
            }
            if(args[0].equalsIgnoreCase("getsuffix")) {
                Player t = Bukkit.getPlayer(args[1]);
                if(t.isOnline()) {
                    try {
                        sender.sendMessage(Main.pr + "§7" + t.getName() + "'s Suffix is: §r" + xyz.flarereturns.nametags.api.Nametags.getAPI().getSuffix(t));
                        return true;
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        sender.sendMessage(Main.pr + "§7The Player has no Nametag");
                        return true;
                    }
                } else {
                    sender.sendMessage(Main.pr + "§7The user is not online");
                    return true;
                }
            }
        }
        if(args.length >= 3) {
            if(args[0].equalsIgnoreCase("setprefix")) {
                Player t = Bukkit.getPlayer(args[1]);
                if(t.isOnline()) {
                    String prfx = args[2];
                    for(int i = 3; i < args.length; i++) {
                        prfx = prfx + " " + args[i];
                    }
                    try {
                        xyz.flarereturns.nametags.api.Nametags.getAPI().setTag(t, prfx);
                        sender.sendMessage(Main.pr + "§7Successfully set the Prefix for " + t.getName() + " to §r" + prfx.replaceAll("&", "§"));
                        return true;
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        sender.sendMessage(Main.pr + "§cAn error occured.");
                        return true;
                    }
                } else {
                    sender.sendMessage(Main.pr + "§7The user is not online.");
                    return true;
                }
            }
            if(args[0].equalsIgnoreCase("setsuffix")) {
                Player t = Bukkit.getPlayer(args[1]);
                if(t.isOnline()) {
                    String prfx = args[2];
                    for(int i = 3; i < args.length; i++) {
                        prfx = prfx + " " + args[i];
                    }
                    try {
                        xyz.flarereturns.nametags.api.Nametags.getAPI().setTag(t, prfx, false);
                        sender.sendMessage(Main.pr + "§7Successfully set the Suffix for " + t.getName() + " to §r" + prfx.replaceAll("&", "§"));
                        return true;
                    } catch (Exception ex) {
                        ex.printStackTrace();
                        sender.sendMessage(Main.pr + "§cAn error occured.");
                        return true;
                    }
                } else {
                    sender.sendMessage(Main.pr + "§7The user is not online.");
                    return true;
                }
            }
        }
        sender.sendMessage("§8§m------------------------------------------------");
        sender.sendMessage("§8§l> §e§lNametags §7made by FlareReturns (§ebit.ly/FlareNametags§7)");
        sender.sendMessage(" §7Use §a/" + label + " <Refresh §a§l❘ §aReload §a§l❘ §aResetall>");
        sender.sendMessage(" §7or §a/" + label + " <GetPrefix §a§l❘ §aGetSuffix §a§l❘ §aReset> <Playername>");
        sender.sendMessage(" §7or §a/" + label + " <SetPrefix §a§l❘ §aSetSuffix> <Playername> <Prefix §a§l❘ §aSuffix>");
        sender.sendMessage("§8§m------------------------------------------------");
        return true;
    }

}
