package dragon.craft.me.totemcraftbase.items;

import dragon.craft.me.totemcraftbase.TotemCraft_base;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.PrepareItemCraftEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemTracker implements Listener {

    private boolean someoneHasTotem(ItemStack item) {

        List<Boolean> boolList  = new ArrayList<>();
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.getInventory().containsAtLeast(item, 1)) {
                boolList.add(true);
            }
        }
        return boolList.contains(true);
    }
    public boolean someoneHasDiamondTotem() {
        return someoneHasTotem(CustomItems.diamond_totem());
    }

    public boolean someoneHasHeartTotem() {
        return someoneHasTotem(CustomItems.Heart_totem());
    }

    public boolean someoneHasIronTotem() {
        return someoneHasTotem(CustomItems.Iron_totem());
    }




    @EventHandler
    public void onPrepareItemCraft(CraftItemEvent e) {
        Player p = (Player) e.getWhoClicked();
        //p.sendMessage("[DEBUG] Listening CIE(" + someoneHasDiamondTotem() + " * " + someoneHasIronTotem() + " * " + someoneHasHeartTotem());
        if (e.getRecipe().getResult().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Szív totem") && someoneHasHeartTotem()) {
            p.playSound(p, Sound.BLOCK_ANVIL_LAND,10,10);
            p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&cA Totem már le van craftolva! Nem lehet le craftolni újra!"));
            e.setCancelled(true);
        }
        if (e.getRecipe().getResult().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY + "Vas totem") && someoneHasIronTotem()) {
            p.playSound(p, Sound.BLOCK_ANVIL_LAND,10,10);
           p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&cA Totem már le van craftolva! Nem lehet le craftolni újra!"));
            e.setCancelled(true);

        }

        if (e.getRecipe().getResult().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Gyémánt totem") && someoneHasDiamondTotem()) {
            p.playSound(p, Sound.BLOCK_ANVIL_LAND,10,10);
            p.sendMessage(ChatColor.translateAlternateColorCodes('&',"&cA Totem már le van craftolva! Nem lehet le craftolni újra!"));
            e.setCancelled(true);
        }


    }
}
