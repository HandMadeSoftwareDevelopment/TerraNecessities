package com.hm.terranecessities.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class TNItems {
	private static String[] moldMetaNames = new String[] { "clay", "ceramic", "fired_copper", "fired_bronze", "fired_bismuth_bronze", "fired_black_bronze" };
	
	public static Item clayMoldDoubleKnife, clayMoldDoubleHoe, clayPot, ceramicPot;
	
	public static void loadItems() {
		clayMoldDoubleKnife = new TNIPotteryMold().setMetaNames(moldMetaNames).setUnlocalizedName("double_knife_mold");
		clayMoldDoubleHoe = new TNIPotteryMold().setMetaNames(moldMetaNames).setUnlocalizedName("double_hoe_mold");
		
		clayPot = new TNIPotteryMold().setUnlocalizedName("cooking_pot_clay");
	}
	
	public static void registerItems() {
		GameRegistry.registerItem(clayMoldDoubleKnife, clayMoldDoubleKnife.getUnlocalizedName());
		GameRegistry.registerItem(clayMoldDoubleHoe, clayMoldDoubleHoe.getUnlocalizedName());
		
		GameRegistry.registerItem(clayPot, clayPot.getUnlocalizedName());
	}
	
	
}