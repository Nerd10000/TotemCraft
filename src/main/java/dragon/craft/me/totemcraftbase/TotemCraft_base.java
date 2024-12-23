package dragon.craft.me.totemcraftbase;

import dragon.craft.me.totemcraftbase.items.CustomRecipes;
import dragon.craft.me.totemcraftbase.items.ItemTimer;
import dragon.craft.me.totemcraftbase.items.ItemTracker;
import dragon.craft.me.totemcraftbase.listener.DIedTheFirstTime;
import dragon.craft.me.totemcraftbase.listener.DiamondTotemListener;
import dragon.craft.me.totemcraftbase.listener.HeartTotemListener;
import dragon.craft.me.totemcraftbase.listener.IronTotemListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public final class TotemCraft_base extends JavaPlugin {

    private static Plugin plugin;
    public static HashMap<UUID,Long> ITEM_CREATION_TIME = new HashMap<>();
    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;

        CustomRecipes.registerIronTotem();
        CustomRecipes.registerDiamondTotem();
        CustomRecipes.registerHeartTotem();

        Bukkit.getPluginManager().registerEvents(new DIedTheFirstTime(), this);
        Bukkit.getPluginManager().registerEvents(new IronTotemListener(), this);
        Bukkit.getPluginManager().registerEvents(new DiamondTotemListener(), this);
        Bukkit.getPluginManager().registerEvents(new HeartTotemListener(), this);
       Bukkit.getPluginManager().registerEvents(new ItemTracker(),this);
        Bukkit.getPluginManager().registerEvents(new ItemTimer(),this);
        // Register the command
        Bukkit.getPluginManager().registerEvents(new ChatEvent(),this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Plugin getPlugin() {
        return plugin;
    }
}