package dragon.craft.me.totemcraftbase.listener;

import dragon.craft.me.totemcraftbase.items.CustomItems;
import dragon.craft.me.totemcraftbase.items.ItemTimer;
import dragon.craft.me.totemcraftbase.items.ItemTracker;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;

public class HeartTotemListener implements Listener {

    @EventHandler
    public void onUse(EntityDamageByEntityEvent e){
        if (e.getDamager() instanceof  Player p){
            //p.sendMessage("[DEBUG] Listened to EDBEE!");
            if (p.getInventory().getItemInOffHand().getItemMeta() != null)

            if (p.getInventory().getItemInOffHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Szív totem")){
                // Check if player is holding a Heart Totem{
                //p.sendMessage("[DEBUG] Listened to EDBEE! (if)");
                double getDMG = e.getDamage() - 2;
                p.heal(getDMG);
                CustomItems.HeartTotemIsUsable = false;
            }
        }
    }
}
