package dragon.craft.me.totemcraftbase.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.ItemRarity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CustomItems {
    /// Data Set
    public static boolean DiamondTotemIsUsable;
    public static boolean HeartTotemIsUsable;
    public static boolean IronTotemIsUsable;

    public static ItemStack diamond_totem(){
        ItemStack i = new ItemStack(Material.TOTEM_OF_UNDYING);
        ItemMeta i2 = i.getItemMeta();
        i2.setDisplayName(ChatColor.AQUA + "Gyémánt totem");
        i2.setRarity(ItemRarity.RARE);
        i2.setMaxStackSize(1);

        i.setAmount(1);
        i.setItemMeta(i2);
        i2.setFireResistant(true);
        return i;
    }
    public static ItemStack Heart_totem(){
        ItemStack i = new ItemStack(Material.TOTEM_OF_UNDYING);
        ItemMeta i2 = i.getItemMeta();
        i2.setDisplayName(ChatColor.RED + "Szív totem");
        i2.setRarity(ItemRarity.RARE);
        i2.setMaxStackSize(1);

        i.setAmount(1);
        i2.setFireResistant(true);
        i.setItemMeta(i2);

        return i;
    }
    public static ItemStack Iron_totem(){
        ItemStack i = new ItemStack(Material.TOTEM_OF_UNDYING);
        ItemMeta i2 = i.getItemMeta();
        i2.setDisplayName(ChatColor.GRAY + "Vas totem");
        i2.setRarity(ItemRarity.RARE);
        i2.setMaxStackSize(1);

        i.setAmount(1);
        i2.setFireResistant(true);
        i.setItemMeta(i2);
        return i;
    }
    public static ItemStack shard(){
        ItemStack i = new ItemStack(Material.NETHER_STAR);
        ItemMeta i2 = i.getItemMeta();
        i2.setMaxStackSize(16);
        i2.setRarity(ItemRarity.RARE);
        i2.setDisplayName("Totem töredék");
        i2.setFireResistant(true);
        i.setItemMeta(i2);
        return i;
    }
}
