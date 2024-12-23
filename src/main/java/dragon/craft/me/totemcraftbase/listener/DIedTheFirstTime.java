package dragon.craft.me.totemcraftbase.listener;

import dragon.craft.me.totemcraftbase.items.CustomItems;
import org.bukkit.Statistic;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DIedTheFirstTime implements Listener {

    @EventHandler
    public void onPlayerDieFirstTime(PlayerDeathEvent event) {
        // Handle player death for the first time
        Player p = event.getPlayer();
        if (p.getStatistic(Statistic.DEATHS) < 2){
       // p.sendMessage("[DEBUG] Listened to PDE!");
            Player killer = p.getKiller();
            killer.sendMessage("Gratulálunk, elindultsz a gyémánttotemmel! Kaptál egy Shard-ot!");
            killer.getInventory().addItem(CustomItems.shard());
        }
    }

}
