package com.hm.terranecessities.init;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TNItems {
	public static Item testItem;
	
	public static void init() {
		testItem = new Item().setUnlocalizedName("tn_testitem").setCreativeTab(CreativeTabs.tabMaterials);
		
		GameRegistry.registerItem(testItem, testItem.getUnlocalizedName());
	}
}
