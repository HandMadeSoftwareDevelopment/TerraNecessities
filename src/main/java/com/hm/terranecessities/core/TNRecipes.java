package com.hm.terranecessities.core;

import com.bioxx.tfc.api.TFCItems;
import com.bioxx.tfc.api.Crafting.CraftingManagerTFC;
import com.hm.terranecessities.item.TNItems;

import net.minecraft.item.ItemStack;

public class TNRecipes {
	
	public static void registerRecipes() {
		registerKnapping();
		registerMolding();
		registerTooling();
	}
	
	private static void registerTooling() {
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
			"",
			"#####",
			"   ##",
			new ItemStack(TFCItems.flatClay, 1, 1)});
	}
	
	private static void registerKnapping() {
		
	}
	
	private static void registerMolding() {
//		CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldAxe, 1, 2), new Object[] { "12", '1', Recipes.getStackTemp(new ItemStack(TFCItems.copperUnshaped, 1, 1)), '2', new ItemStack(TFCItems.clayMoldAxe, 1, 1) });
//		CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldAxe, 1, 3), new Object[] { "12", '1', Recipes.getStackTemp(new ItemStack(TFCItems.bronzeUnshaped, 1, 1)), '2', new ItemStack(TFCItems.clayMoldAxe, 1, 1) });
//		CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldAxe, 1, 4), new Object[] { "12", '1', Recipes.getStackTemp(new ItemStack(TFCItems.bismuthBronzeUnshaped, 1, 1)), '2', new ItemStack(TFCItems.clayMoldAxe, 1, 1) });
//		CraftingManagerTFC.getInstance().addRecipe(new ItemStack(TFCItems.clayMoldAxe, 1, 5), new Object[] { "12", '1', Recipes.getStackTemp(new ItemStack(TFCItems.blackBronzeUnshaped, 1, 1)), '2', new ItemStack(TFCItems.clayMoldAxe, 1, 1) });
	}
}