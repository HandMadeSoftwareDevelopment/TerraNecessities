package com.hm.terranecessities.block;

import com.hm.terranecessities.item.block.TNIKiln;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class TNBlocks {
	public static Block kiln, woodCutter;
	
	public static void loadBlocks() {
		kiln = new TNBKiln();
		woodCutter = new TNBWoodCutter();
	}
	
	public static void registerBlocks() {
		GameRegistry.registerBlock(kiln, TNIKiln.class, "TNKiln");
		GameRegistry.registerBlock(woodCutter, "TNKiln");
	}
}