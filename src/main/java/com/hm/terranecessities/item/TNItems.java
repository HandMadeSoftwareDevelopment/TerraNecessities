package com.hm.terranecessities.item;

import com.bioxx.tfc.Core.TFCTabs;
import com.bioxx.tfc.api.TFCItems;
import com.hm.terranecessities.core.TNRecipes;
import com.hm.terranecessities.core.TNTabs;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

@SuppressWarnings("unused")
public class TNItems {
	private static String[] moldMetaNames = new String[] { "fired_copper", "fired_bronze", "fired_bismuth_bronze", "fired_black_bronze" };
	
	public static Item thatchDoor;
	
	public static Item clayMoldDoubleKnife, clayMoldDoubleHoe, cookingPot, clayMoldHammerPart, clayMoldTriggerPart,
						clayMoldHornPart, clayMoldWire, clayMoldMusketShot, clayMoldArrowhead, clayMoldSpearhead;
	
	public static Item partBlunderbussStock, partFlintlockPistolStock, partFlintlockRifleStock, partFlintlockTrigger,
						partFlintlockHammer, partBlunderbussHorn, partTriggerHammerMechanism, partSpring, partTriggerMechanism,
						partHammerMechanism, partPistolBarrel, partRifleBarrel, partBlunderbussBarrel;
	
	public static Item metalSpearhead, stoneSpearhead, stoneSpear, metalSpear, metalArrowhead, metalArrow;
	
	public static Item copperSpear, bronzeSpear, blackBronzeSpear, bismuthBronzeSpear;
	
	public static Item stoneShot, copperShot, zincShot, bismuthShot, bronzeShot, blackBronzeShot, silverShot;
	
	public static void loadDelayedItems() {
		// Weapons
		copperSpear = new TNISpear(TFCItems.copperToolMaterial, 80).setUnlocalizedName("spear_copper");
		bronzeSpear = new TNISpear(TFCItems.bronzeToolMaterial, 100).setUnlocalizedName("spear_bronze");
		blackBronzeSpear = new TNISpear(TFCItems.blackBronzeToolMaterial, 95).setUnlocalizedName("spear_black_bronze");
		bismuthBronzeSpear = new TNISpear(TFCItems.bismuthBronzeToolMaterial, 90).setUnlocalizedName("spear_bismuth_bronze");
		
		// Recipe items
		TNRecipes.spears = new Item[] { copperSpear, bronzeSpear, blackBronzeSpear, bismuthBronzeSpear };
	}
	
	public static void loadItems() {
		// Miscellaneous
		thatchDoor = new TNIThatchDoor().setUnlocalizedName("thatch_door");
		
		// Tool Molds
		clayMoldDoubleKnife = new TNIPotteryMold("double_knife_mold", moldMetaNames);
		clayMoldDoubleHoe = new TNIPotteryMold("double_hoe_mold", moldMetaNames);
		clayMoldWire = new TNIPotteryMold("wire_mold", "fired_copper");
		
		// Ammo/Head Molds
		clayMoldMusketShot = new TNIPotteryMold("shot_mold", "fired_copper", "fired_lead", "fired_silver", "fired_zinc");
		clayMoldArrowhead = new TNIPotteryMold("arrowhead_mold", "fired_copper", "fired_bronze", "fired_bismuth_bronze", "fired_black_bronze");
		clayMoldSpearhead = new TNIPotteryMold("spearhead_mold", "fired_copper", "fired_bronze", "fired_bismuth_bronze", "fired_black_bronze");
		// Cooking Utensils
		cookingPot = new TNIPotteryMold("cooking_pot").setMaxStackSize(1);
		
		// Weapon Part Molds
		clayMoldTriggerPart = new TNIPotteryMold("trigger_mechanism_mold", "fired_wrought_iron");
		clayMoldHammerPart = new TNIPotteryMold("hammer_mechanism_mold", "fired_wrought_iron");
		clayMoldHornPart = new TNIPotteryMold("blunderbuss_horn_mold", "fired_wrought_iron");
		
		// Weapon Parts
		partBlunderbussStock = new Item().setUnlocalizedName("part_blunderbuss_stock").setTextureName("parts/part_blunderbuss_stock").setCreativeTab(TNTabs.TN_ITEMS);
		partFlintlockPistolStock = new Item().setUnlocalizedName("part_flintlock_pistol_stock").setTextureName("parts/part_flintlock_pistol_stock").setCreativeTab(TNTabs.TN_ITEMS);
		partFlintlockRifleStock = new Item().setUnlocalizedName("part_flintlock_rifle_stock").setTextureName("parts/part_flintlock_rifle_stock").setCreativeTab(TNTabs.TN_ITEMS);
		partBlunderbussHorn = new Item().setUnlocalizedName("part_blunderbuss_horn").setTextureName("parts/part_blunderbuss_horn").setCreativeTab(TNTabs.TN_ITEMS);
		partTriggerMechanism = new Item().setUnlocalizedName("part_trigger_mechanism").setCreativeTab(TNTabs.TN_ITEMS);
		partHammerMechanism =  new Item().setUnlocalizedName("part_hammer_mechanism").setCreativeTab(TNTabs.TN_ITEMS);
		partTriggerHammerMechanism = new Item().setUnlocalizedName("part_hammer_trigger").setCreativeTab(TNTabs.TN_ITEMS);
		partSpring = new Item().setUnlocalizedName("part_spring").setCreativeTab(TNTabs.TN_ITEMS);
		partPistolBarrel = new Item().setUnlocalizedName("part_pistol_barrel").setCreativeTab(TNTabs.TN_ITEMS);
		partRifleBarrel = new Item().setUnlocalizedName("part_rifle_barrel").setCreativeTab(TNTabs.TN_ITEMS);
		partBlunderbussBarrel = new Item().setUnlocalizedName("part_blunderbuss_barrel").setCreativeTab(TNTabs.TN_ITEMS);
		
		// Ammunition
		
	}
	
	public static void registerDelayedItems() {
		for (Item item : TNRecipes.spears) {
			GameRegistry.registerItem(item, item.getUnlocalizedName());
		}
		
		// Creative tabs
		((TFCTabs) TNTabs.TN_ITEMS).setTabIconItem(copperSpear);
	}
	
	public static void registerItems() {
		// Items
		GameRegistry.registerItem(thatchDoor, thatchDoor.getUnlocalizedName());
		
		GameRegistry.registerItem(partBlunderbussStock, partBlunderbussStock.getUnlocalizedName());
		GameRegistry.registerItem(partFlintlockPistolStock, partFlintlockPistolStock.getUnlocalizedName());
		GameRegistry.registerItem(partFlintlockRifleStock, partFlintlockRifleStock.getUnlocalizedName());
		GameRegistry.registerItem(partBlunderbussHorn, partBlunderbussHorn.getUnlocalizedName());
		
		GameRegistry.registerItem(partTriggerMechanism, partTriggerMechanism.getUnlocalizedName());;
		GameRegistry.registerItem(partHammerMechanism, partHammerMechanism.getUnlocalizedName());
		GameRegistry.registerItem(partTriggerHammerMechanism, partTriggerHammerMechanism.getUnlocalizedName());
		GameRegistry.registerItem(partSpring, partSpring.getUnlocalizedName());
		GameRegistry.registerItem(partPistolBarrel, partPistolBarrel.getUnlocalizedName());
		GameRegistry.registerItem(partRifleBarrel, partRifleBarrel.getUnlocalizedName());
		GameRegistry.registerItem(partBlunderbussBarrel, partBlunderbussBarrel.getUnlocalizedName());
		
		registerPottery();
	}
	
	public static void registerPottery() {
		GameRegistry.registerItem(clayMoldDoubleKnife, clayMoldDoubleKnife.getUnlocalizedName());
		GameRegistry.registerItem(clayMoldDoubleHoe, clayMoldDoubleHoe.getUnlocalizedName());
		GameRegistry.registerItem(clayMoldWire, clayMoldWire.getUnlocalizedName());
		
		GameRegistry.registerItem(clayMoldMusketShot, clayMoldMusketShot.getUnlocalizedName());
		GameRegistry.registerItem(clayMoldArrowhead, clayMoldArrowhead.getUnlocalizedName());
		GameRegistry.registerItem(clayMoldSpearhead, clayMoldSpearhead.getUnlocalizedName());
		
		GameRegistry.registerItem(cookingPot, cookingPot.getUnlocalizedName());
		
		GameRegistry.registerItem(clayMoldTriggerPart, clayMoldTriggerPart.getUnlocalizedName());
		GameRegistry.registerItem(clayMoldHammerPart, clayMoldHammerPart.getUnlocalizedName());
		GameRegistry.registerItem(clayMoldHornPart, clayMoldHornPart.getUnlocalizedName());
	
	}
}