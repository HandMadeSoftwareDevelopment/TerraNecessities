package com.hm.terranecessities.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class TNItems {
	private static String[] moldMetaNames = new String[] { "fired_copper", "fired_bronze", "fired_bismuth_bronze", "fired_black_bronze" };
	// private static String[] partMetaNames = new String[] { "iron", "steel" };
	
	public static Item thatchDoor;
	
	public static Item clayMoldDoubleKnife, clayMoldDoubleHoe, cookingPot, clayMoldHammerPart, clayMoldTriggerPart,
						clayMoldHornPart, clayMoldWire, clayMoldMusketShot, clayMoldArrowhead;
	
	public static Item partBlunderbussStock, partFlintlockPistolStock, partFlintlockRifleStock, partFlintlockTrigger,
						partFlintlockHammer, partBlunderbussHorn, partTriggerHammerMechanism, partSpring;
	
	public static void loadItems() {
		// Miscellaneous
		thatchDoor = new TNIThatchDoor().setUnlocalizedName("thatch_door");
		
		// Tool Molds
		clayMoldDoubleKnife = new TNIPotteryMold("double_knife_mold", moldMetaNames);
		clayMoldDoubleHoe = new TNIPotteryMold("double_hoe_mold", moldMetaNames);
		clayMoldWire = new TNIPotteryMold("wire_mold", "fired_copper");
		
		// Ammo
		clayMoldMusketShot = new TNIPotteryMold("shot_mold", "fired_copper", "fired_lead", "fired_silver", "fired_zinc");
		clayMoldArrowhead = new TNIPotteryMold("arrowhead_mold", "fired_copper", "fired_bronze", "fired_bismuth_bronze", "fired_black_bronze");
		
		// Cooking Utensils
		cookingPot = new TNIPotteryMold("cooking_pot");
		
		// Weapon Part Molds
		clayMoldTriggerPart = new TNIPotteryMold("trigger_mechanism_mold", "fired_wrought_iron");
		clayMoldHammerPart = new TNIPotteryMold("hammer_mechanism_mold", "fired_wrought_iron");
//		clayMoldHornPart = new TNIPotteryMold("blunderbuss_horn_mold", "fired_wrought_iron");
		
		// Weapon Parts
		partBlunderbussStock = new Item().setUnlocalizedName("part_blunderbuss_stock");
		partFlintlockPistolStock = new Item().setUnlocalizedName("part_flintlock_pistol_stock");
		partFlintlockRifleStock = new Item().setUnlocalizedName("part_flintlock_rifle_stock");
		partBlunderbussHorn = new Item().setUnlocalizedName("part_blunderbuss_horn");
	}
	
	public static void registerItems() {
		GameRegistry.registerItem(thatchDoor, thatchDoor.getUnlocalizedName());
		
		registerPottery();
	}
	
	public static void registerPottery() {
		GameRegistry.registerItem(clayMoldDoubleKnife, clayMoldDoubleKnife.getUnlocalizedName());
		GameRegistry.registerItem(clayMoldDoubleHoe, clayMoldDoubleHoe.getUnlocalizedName());
		GameRegistry.registerItem(clayMoldWire, clayMoldWire.getUnlocalizedName());
		
		GameRegistry.registerItem(clayMoldMusketShot, clayMoldMusketShot.getUnlocalizedName());
		GameRegistry.registerItem(clayMoldArrowhead, clayMoldArrowhead.getUnlocalizedName());
		
		GameRegistry.registerItem(cookingPot, cookingPot.getUnlocalizedName());
		
		GameRegistry.registerItem(clayMoldTriggerPart, clayMoldTriggerPart.getUnlocalizedName());
		GameRegistry.registerItem(clayMoldHammerPart, clayMoldHammerPart.getUnlocalizedName());
//		GameRegistry.registerItem(clayMoldHornPart, clayMoldHornPart.getUnlocalizedName());
		
		GameRegistry.registerItem(partBlunderbussStock, partBlunderbussStock.getUnlocalizedName());
		GameRegistry.registerItem(partFlintlockPistolStock, partFlintlockPistolStock.getUnlocalizedName());
		GameRegistry.registerItem(partFlintlockRifleStock, partFlintlockRifleStock.getUnlocalizedName());
		GameRegistry.registerItem(partBlunderbussHorn, partBlunderbussHorn.getUnlocalizedName());
	}
}