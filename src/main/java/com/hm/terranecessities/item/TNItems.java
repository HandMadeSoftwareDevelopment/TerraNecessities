package com.hm.terranecessities.item;

import com.hm.terranecessities.TNCore;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class TNItems {
	private static String[] moldMetaNames = new String[] { "clay", "ceramic", "fired_copper", "fired_bronze", "fired_bismuth_bronze", "fired_black_bronze" };

	public static Item thatchDoor;

	//private static String[] partMetaNames = new String[] {"clay", "ceramic", "iron", "steel"};
	public static Item clayMoldDoubleKnife, clayMoldDoubleHoe, cookingPot, clayMoldHammerPart, clayMoldTriggerPart, clayMoldHornPart, clayMoldWire,
						clayMoldMusketShot, clayMoldArrowhead;
						
	public static Item partBlunderbussStock, partFlintlockPistolStock, partFlintlockRifleStock, partFlintlockTrigger, partFlintlockHammer,
						partBlunderbussHorn, partTriggerHammerMechanism, partSpring;
	
	public static void loadItems() {
		// Miscellaneous
		thatchDoor = new TNIThatchDoor().setUnlocalizedName("thatch_door");
		
		// Tool Molds
		clayMoldDoubleKnife = new TNIPotteryMold().setMetaNames(moldMetaNames).setUnlocalizedName("double_knife_mold");
		clayMoldDoubleHoe = new TNIPotteryMold().setMetaNames(moldMetaNames).setUnlocalizedName("double_hoe_mold");
		clayMoldWire = new TNIPotteryMold().setMetaNames(moldMetaNames).setUnlocalizedName("wire_mold");
		
		// Ammo
		clayMoldMusketShot = new TNIPotteryMold().setMetaNames(moldMetaNames).setUnlocalizedName("shot");
		clayMoldArrowhead = new TNIPotteryMold().setMetaNames(moldMetaNames).setUnlocalizedName("arrowhead_mold");
		
		// Cooking Utensils
		cookingPot = new TNIPotteryMold().setUnlocalizedName("cooking_pot");
		
		// Weapon Part Molds
		clayMoldTriggerPart = new TNIPotteryMold().setMetaNames(moldMetaNames).setUnlocalizedName("trigger_mechanism_mold");
		clayMoldHammerPart = new TNIPotteryMold().setMetaNames(moldMetaNames).setUnlocalizedName("hammer_mechanism_mold");
		clayMoldHornPart = new TNIPotteryMold().setMetaNames(moldMetaNames).setUnlocalizedName("blunderbuss_horn_mold");
		
		// Weapon Parts
		partBlunderbussStock = new Item().setUnlocalizedName("part_blunderbuss_stock");
		partFlintlockPistolStock = new Item().setUnlocalizedName("part_flintlock_pistol_stock");
		partFlintlockRifleStock = new Item().setUnlocalizedName("part_flintlock_rifle_stock");
		partBlunderbussHorn = new Item().setUnlocalizedName("part_blunderbuss_horn");
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
		GameRegistry.registerItem(clayMoldHornPart, clayMoldHornPart.getUnlocalizedName());
		
		GameRegistry.registerItem(partBlunderbussStock, partBlunderbussStock.getUnlocalizedName());
		GameRegistry.registerItem(partFlintlockPistolStock, partFlintlockPistolStock.getUnlocalizedName());
		GameRegistry.registerItem(partFlintlockRifleStock, partFlintlockRifleStock.getUnlocalizedName());
		GameRegistry.registerItem(partBlunderbussHorn, partBlunderbussHorn.getUnlocalizedName());
	}
	
	public static void registerItems() {
		GameRegistry.registerItem(thatchDoor, thatchDoor.getUnlocalizedName());
		
		registerPottery();
	}
}