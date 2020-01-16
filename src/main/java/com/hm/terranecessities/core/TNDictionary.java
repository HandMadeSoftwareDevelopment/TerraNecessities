package com.hm.terranecessities.core;

import com.hm.terranecessities.item.TNItems;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class TNDictionary {
	private static void register(String string, ItemStack source) {
		OreDictionary.registerOre(string, source);
	}
	
	public static void registerOreDictionary() {
		final int WILD = OreDictionary.WILDCARD_VALUE;
		
		for (Item spear : TNRecipes.spears) {
			register("itemSpear", new ItemStack(spear, 1, WILD));
		}
		
		register("itemBismuthBronzeSpear", new ItemStack(TNItems.bismuthBronzeSpear, 1, WILD));
		register("itemBlackBronzeSpear", new ItemStack(TNItems.blackBronzeSpear, 1, WILD));
		register("itemBronzeSpear", new ItemStack(TNItems.bronzeSpear, 1, WILD));
		register("itemCopperSpear", new ItemStack(TNItems.copperSpear, 1, WILD));
	}
}