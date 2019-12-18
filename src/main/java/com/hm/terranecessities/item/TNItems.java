package com.hm.terranecessities.item;

import com.bioxx.tfc.Items.Pottery.ItemPotteryMold;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class TNItems {
	public static Item clayMoldDoubleKnife;
	
	public static void loadItems() {
		clayMoldDoubleKnife = new ItemPotteryMold().setMetaNames(new String[] { "tn_claymolddknife", "tn_ceramicmolddknife", "tn_ceramicmolddknife_copper", "tn_ceramicmolddknife_bronze", "tn_ceramicmolddknife_bismuthbronze", "tn_ceramicmolddknife_blackbronze" }).setUnlocalizedName("tn_dknifemold");
	}
	
	public static void registerItems() {
		GameRegistry.registerItem(clayMoldDoubleKnife, clayMoldDoubleKnife.getUnlocalizedName());
	}
}