package com.hm.terranecessities.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class TNBlocks {
	public static Block kiln, thatchDoor, woodCutter;
	
	public static void loadBlocks() {
		// kiln = new TNBKiln();
		thatchDoor = new TNBThatchDoor();
		woodCutter = new TNBWoodCutter();
	}
	
	public static void registerBlocks() {
		// GameRegistry.registerBlock(kiln, TNIKiln.class, "TNKiln");
		GameRegistry.registerBlock(thatchDoor, "TNThatchDoor");
		GameRegistry.registerBlock(woodCutter, "TNWoodCutter");
	}
}