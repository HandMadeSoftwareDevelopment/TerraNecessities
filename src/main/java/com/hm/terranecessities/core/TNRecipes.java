package com.hm.terranecessities.core;

import com.bioxx.tfc.Core.Recipes;
import com.bioxx.tfc.api.TFCItems;
import com.bioxx.tfc.api.Crafting.CraftingManagerTFC;
import com.bioxx.tfc.api.Crafting.KilnCraftingManager;
import com.bioxx.tfc.api.Crafting.KilnRecipe;
import com.hm.terranecessities.item.TNItems;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;

public class TNRecipes {
	
	public static void registerRecipes() {
		registerKnapping();
		registerKilning();
		registerMolding();
		registerTooling();
	}
	
	private static void registerKilning() {
		KilnCraftingManager manager;
		
		manager = KilnCraftingManager.getInstance();
		
		manager.addRecipe(
			new KilnRecipe(
				new ItemStack(TNItems.clayMoldDoubleHoe, 1, 0),
				0, 
				new ItemStack(TNItems.clayMoldDoubleHoe, 1, 1)));
		
		manager.addRecipe(
			new KilnRecipe(
				new ItemStack(TNItems.clayMoldDoubleKnife, 1, 0),
				0, 
				new ItemStack(TNItems.clayMoldDoubleKnife, 1, 1)));
		manager.addRecipe(
			new KilnRecipe(
				new ItemStack(TNItems.clayPot, 1, 0),
				0,
				new ItemStack(TNItems.ceramicPot,1,0)));
	}
	
	private static void registerKnapping() {
		CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TNItems.clayMoldDoubleKnife, 1), new Object[] {
			" #  #",
			"## ##",
			"## ##",
			"## ##",
			"## ##",
			'#',
			new ItemStack(TFCItems.flatClay, 1, 1)});
		CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TNItems.clayMoldDoubleHoe, 1), new Object[]{
			"#####",
			"   ##",
			"     ",
			"#####",
			"   ##",
			'#',
			new ItemStack(TFCItems.flatClay, 1, 1)});
		CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TNItems.clayPot, 1), new Object[]{
			"     ",
			"#   #",
			"#####",
			"#####",
			"#####",
			'#',
			new ItemStack(TFCItems.flatClay, 1, 1)});
	}
	
	private static void registerMolding() {
		CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TNItems.clayMoldDoubleKnife, 1, 2), new Object[] { "12", '1', Recipes.getStackTemp(new ItemStack(TFCItems.copperUnshaped, 1, 1)), '2', new ItemStack(TNItems.clayMoldDoubleHoe, 1, 1) });
		CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TNItems.clayMoldDoubleKnife, 1, 3), new Object[] { "12", '1', Recipes.getStackTemp(new ItemStack(TFCItems.bronzeUnshaped, 1, 1)), '2', new ItemStack(TNItems.clayMoldDoubleHoe, 1, 1) });
		CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TNItems.clayMoldDoubleKnife, 1, 4), new Object[] { "12", '1', Recipes.getStackTemp(new ItemStack(TFCItems.bismuthBronzeUnshaped, 1, 1)), '2', new ItemStack(TNItems.clayMoldDoubleHoe, 1, 1) });
		CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TNItems.clayMoldDoubleKnife, 1, 5), new Object[] { "12", '1', Recipes.getStackTemp(new ItemStack(TFCItems.blackBronzeUnshaped, 1, 1)), '2', new ItemStack(TNItems.clayMoldDoubleHoe, 1, 1) });
		
		CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TNItems.clayMoldDoubleKnife, 1, 2), new Object[] { "12", '1', Recipes.getStackTemp(new ItemStack(TFCItems.copperUnshaped, 1, 1)), '2', new ItemStack(TNItems.clayMoldDoubleKnife, 1, 1) });
		CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TNItems.clayMoldDoubleKnife, 1, 3), new Object[] { "12", '1', Recipes.getStackTemp(new ItemStack(TFCItems.bronzeUnshaped, 1, 1)), '2', new ItemStack(TNItems.clayMoldDoubleKnife, 1, 1) });
		CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TNItems.clayMoldDoubleKnife, 1, 4), new Object[] { "12", '1', Recipes.getStackTemp(new ItemStack(TFCItems.bismuthBronzeUnshaped, 1, 1)), '2', new ItemStack(TNItems.clayMoldDoubleKnife, 1, 1) });
		CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TNItems.clayMoldDoubleKnife, 1, 5), new Object[] { "12", '1', Recipes.getStackTemp(new ItemStack(TFCItems.blackBronzeUnshaped, 1, 1)), '2', new ItemStack(TNItems.clayMoldDoubleKnife, 1, 1) });
	}
	
	private static void registerTooling() {
		GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.copperHoeHead, 2),
				Recipes.getStackNoTemp(new ItemStack(TNItems.clayMoldDoubleHoe, 1, 2)));
		GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bronzeHoeHead, 2),
				Recipes.getStackNoTemp(new ItemStack(TNItems.clayMoldDoubleHoe, 1, 3)));
		GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bismuthBronzeHoeHead, 2),
				Recipes.getStackNoTemp(new ItemStack(TNItems.clayMoldDoubleHoe, 1, 4)));
		GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.blackBronzeHoeHead, 2),
				Recipes.getStackNoTemp(new ItemStack(TNItems.clayMoldDoubleHoe, 1, 5)));
		
		GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.copperKnifeHead, 2),
				Recipes.getStackNoTemp(new ItemStack(TNItems.clayMoldDoubleKnife, 1, 2)));
		GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bronzeKnifeHead, 2),
				Recipes.getStackNoTemp(new ItemStack(TNItems.clayMoldDoubleKnife, 1, 3)));
		GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.bismuthBronzeKnifeHead, 2),
				Recipes.getStackNoTemp(new ItemStack(TNItems.clayMoldDoubleKnife, 1, 4)));
		GameRegistry.addShapelessRecipe(new ItemStack(TFCItems.blackBronzeKnifeHead, 2),
				Recipes.getStackNoTemp(new ItemStack(TNItems.clayMoldDoubleKnife, 1, 5)));
	}
}