package com.hm.terranecessities.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class TNItems {
	private static String[] moldMetaNames = new String[] { "clay", "ceramic", "fired_copper", "fired_bronze", "fired_bismuth_bronze", "fired_black_bronze" };
	
	public static Item thatchDoor;
	
	public static Item clayMoldDoubleKnife, clayMoldDoubleHoe, cookingPot;
	
	public static void loadItems() {
		
//		thatchDoor = new TNIThatchDoor().setUnlocalizedName("thatch_door");
		
		clayMoldDoubleKnife = new TNIPotteryMold().setMetaNames(moldMetaNames).setUnlocalizedName("double_knife_mold");
		clayMoldDoubleHoe = new TNIPotteryMold().setMetaNames(moldMetaNames).setUnlocalizedName("double_hoe_mold");
		
		cookingPot = new TNIPotteryMold().setUnlocalizedName("cooking_pot");
	}
	
	public static void registerPottery() {
		GameRegistry.registerItem(clayMoldDoubleKnife, clayMoldDoubleKnife.getUnlocalizedName());
		GameRegistry.registerItem(clayMoldDoubleHoe, clayMoldDoubleHoe.getUnlocalizedName());
		
		GameRegistry.registerItem(cookingPot, cookingPot.getUnlocalizedName());
	}
	
	public static void registerItems() {
//		GameRegistry.registerItem(thatchDoor, thatchDoor.getUnlocalizedName());
		
		registerPottery();
	}
}