package xyz.flarereturns.nametags.stuff;

import org.bukkit.Bukkit;
import xyz.flarereturns.nametags.Main;
import xyz.flarereturns.nametags.api.Nametags;

public class AutoUpdate {

    public AutoUpdate() {
        Bukkit.getScheduler().runTaskTimer(Main.getInstance(), new Runnable() {
            @Override
            public void run() {
                Nametags.getAPI().refresh();
            }
        }, 0, 100);
    }

}
