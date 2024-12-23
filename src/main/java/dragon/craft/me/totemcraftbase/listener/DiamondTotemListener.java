package dragon.craft.me.totemcraftbase.listener;

import dragon.craft.me.totemcraftbase.items.CustomItems;
import dragon.craft.me.totemcraftbase.items.CustomRecipes;
import dragon.craft.me.totemcraftbase.items.ItemTimer;
import io.papermc.paper.event.block.BlockBreakBlockEvent;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class DiamondTotemListener implements Listener {


    @EventHandler
    public void onPlayerMine(BlockBreakEvent e){

        Player p = e.getPlayer();
       // p.sendMessage("[DEBUG] Listened to BBE!");
        if (p.getInventory().getItemInOffHand().getItemMeta() != null){
            if (p.getInventory().getItemInOffHand().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Gyémánt totem"))
                p.addPotionEffect(new PotionEffect((PotionEffectType.SPEED),10,4));
            p.addPotionEffect(new PotionEffect((PotionEffectType.HASTE),10,4));
            CustomItems.DiamondTotemIsUsable = false;
        }
    }
}
