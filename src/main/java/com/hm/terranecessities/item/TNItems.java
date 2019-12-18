package com.hm.terranecessities.item;

import com.hm.terranecessities.TerraNecessities;
import com.hm.terranecessities.core.TNTabs;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class TNItems {
	public static Item testItem;
	
	public static void init() {
		testItem = new Item().setUnlocalizedName("tn_testitem").setTextureName(TerraNecessities.MODID + ":copper_double_knife_mold").setCreativeTab(TNTabs.TN_ITEMS);
		
		GameRegistry.registerItem(testItem, testItem.getUnlocalizedName());
	}
}
