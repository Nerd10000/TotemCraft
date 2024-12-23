package dragon.craft.me.totemcraftbase.items;

import it.unimi.dsi.fastutil.Hash;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;

import java.util.HashMap;
import java.util.UUID;

public class ItemTimer implements Listener {

    public static int PROTECT_MINS = 30;
    public static long PROTECT_MS = PROTECT_MINS * 60000; //1.8 million ms

    public static HashMap<UUID,String> TOTEMMAP = new HashMap<>(3);
   // public static HashMap<UUID,Boolean> Is_Protecting_in_Process = new HashMap<>(3);
    public static HashMap<UUID,Long> timeMap = new HashMap();
    @EventHandler
    public void onCraft(CraftItemEvent e){

        if (e.getRecipe().getResult().getItemMeta().
                getDisplayName().equalsIgnoreCase(ChatColor.RED + "Szív totem"
                ) || e.getRecipe().getResult().getItemMeta().
                getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Gyémánt totem") ||
                e.getRecipe().getResult().getItemMeta().
                        getDisplayName().equalsIgnoreCase(ChatColor.GRAY + "Vas totem")){
            if (e.isCancelled() == false){

                Player player = (Player) e.getWhoClicked();
                UUID playerUUID = e.getWhoClicked().getUniqueId();
                TOTEMMAP.put(playerUUID, e.getRecipe().getResult().getItemMeta().getDisplayName());
                timeMap.put(playerUUID,System.currentTimeMillis());

                player.sendMessage(ChatColor.translateAlternateColorCodes('&', """
                        &7--------------------------------------------------
                        &aElindult az időzítő! védd meg a totetmet 30p-ig!
                        &cHa kilépsz ilyenkor elveszik a totemed!
                        &7--------------------------------------------------
                        """));
                player.playSound(player, Sound.ITEM_GOAT_HORN_SOUND_2,10,10);
                //Is_Protecting_in_Process.put(playerUUID, true);

            }

        }

    }
    @EventHandler
    public void onItemSwap(PlayerSwapHandItemsEvent e){
        if (e.getOffHandItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Szív totem") ||
        e.getOffHandItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Gyémánt totem") ||
        e.getOffHandItem().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY + "Vas totem")){
            Player player = e.getPlayer();
            long timeout = (timeMap.get(player.getUniqueId()) + PROTECT_MS) - System.currentTimeMillis();
            if (timeout <= 0){
                player.sendMessage(ChatColor.RED + "Az idő nem járt még le! (" + timeout / 60000 + "| 30)");
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e){
        Player p = e.getPlayer();

        if (TOTEMMAP.containsKey(p)){
            //Handle death logic here
            TOTEMMAP.remove(p);
            timeMap.remove(p);
            for (Player player : Bukkit.getOnlinePlayers()){
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', p.getDisplayName() +
                        " &ameghalt a totemmel! &7(" + p.getLocation().getX() +" | " + p.getLocation().getY() + " | " + p.getLocation().getZ()));

                player.playSound(player,Sound.BLOCK_AMETHYST_BLOCK_PLACE,10,10);
            }

        }

    }
    @EventHandler
    public void onPickup(PlayerPickupItemEvent e){
        if (e.getItem().getItemStack().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.RED + "Szív totem") ||
                e.getItem().getItemStack().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.AQUA + "Gyémánt totem") ||
                e.getItem().getItemStack().getItemMeta().getDisplayName().equalsIgnoreCase(ChatColor.GRAY + "Vas totem")){
            Player player = e.getPlayer();
            TOTEMMAP.put(player.getUniqueId(),e.getItem().getItemStack().getItemMeta().getDisplayName());
            timeMap.put(player.getUniqueId(),System.currentTimeMillis());

            for (Player p : Bukkit.getOnlinePlayers()){
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', p.getDisplayName() +
                        "&aFelvette a totemet!"));
                p.playSound(p,Sound.BLOCK_AMETHYST_BLOCK_PLACE,10,10);
            }
        }

    }



}
