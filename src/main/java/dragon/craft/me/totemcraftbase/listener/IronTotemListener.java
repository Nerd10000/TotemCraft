package dragon.craft.me.totemcraftbase.listener;

import dragon.craft.me.totemcraftbase.items.CustomItems;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemDamageEvent;

public class IronTotemListener implements Listener {

    @EventHandler
    public void onUse(PlayerItemDamageEvent e){
        Player p = e.getPlayer();
       // p.sendMessage("[DEBUG] Listened to PIDE!");
        if (p.getInventory().getItemInOffHand().getItemMeta() != null){
            if (p.getInventory().getItemInOffHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY + "Vas totem"))
            e.setDamage(0);
            CustomItems.IronTotemIsUsable = false;
        }
    }
}
