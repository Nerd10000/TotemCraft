package dragon.craft.me.totemcraftbase.items;

import dragon.craft.me.totemcraftbase.TotemCraft_base;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;

public class CustomRecipes {

    private static ShapedRecipe iron,diamond,heart;


    public  static void registerDiamondTotem(){
        ShapedRecipe shapedRecipe = new ShapedRecipe(new NamespacedKey(TotemCraft_base.getPlugin(),"D"),CustomItems.diamond_totem());




        shapedRecipe.shape("DDD", "SDS", "SOS");

        //Q = Quartz - S = Shard - D - Diamond block


        shapedRecipe.setIngredient('O', Material.OBSIDIAN);
        shapedRecipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.shard()));
        shapedRecipe.setIngredient('D', Material.DIAMOND_BLOCK);
        diamond = shapedRecipe;
        TotemCraft_base.getPlugin().getServer().addRecipe(shapedRecipe);
    }
    public  static void registerHeartTotem(){
        ShapedRecipe shapedRecipe = new ShapedRecipe(new NamespacedKey(TotemCraft_base.getPlugin(),"H"),CustomItems.Heart_totem());
        shapedRecipe.shape("RRR", "SRS", "SNS");

        //Q = Quartz - S = Shard - D - Diamond block


        shapedRecipe.setIngredient('R', Material.REDSTONE_BLOCK);
        shapedRecipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.shard()));
        shapedRecipe.setIngredient('N', Material.NETHERITE_INGOT);
        heart = shapedRecipe;
        TotemCraft_base.getPlugin().getServer().addRecipe(shapedRecipe);
    }
    public  static void registerIronTotem(){
        ShapedRecipe shapedRecipe = new ShapedRecipe(new NamespacedKey(TotemCraft_base.getPlugin(),"I"),CustomItems.Iron_totem());
        shapedRecipe.shape("III", "SIS", "STS");

        //Q = Quartz - S = Shard - D - Diamond block
        shapedRecipe.setIngredient('I', Material.IRON_BLOCK);
        shapedRecipe.setIngredient('S', new RecipeChoice.ExactChoice(CustomItems.shard()));
        shapedRecipe.setIngredient('T', Material.TOTEM_OF_UNDYING);
        iron = shapedRecipe;
        TotemCraft_base.getPlugin().getServer().addRecipe(shapedRecipe);
    }

    public static ShapedRecipe getDiamond() {
        return diamond;
    }

    public static ShapedRecipe getHeart() {
        return heart;
    }

    public static ShapedRecipe getIron() {
        return iron;
    }
}
