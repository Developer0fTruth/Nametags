package xyz.flarereturns.nametags.stuff;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import xyz.flarereturns.nametags.api.Nametags;

public class WorldChange implements Listener {

    @EventHandler
    public void onChange(PlayerChangedWorldEvent e) {
        Nametags.getAPI().refresh();
    }

}
