package com.hm.terranecessities;

import com.hm.terranecessities.entity.TNEWoodCutter;
import com.hm.terranecessities.gui.TNCommonGUIHandler;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy {
	public void registerGUIHandler() {
		NetworkRegistry.INSTANCE.registerGuiHandler(TerraNecessities.instance, new TNCommonGUIHandler());
	}
	
	public void registerTileEntities(boolean b) {
		if (b) {
//			GameRegistry.registerTileEntity(TNEKiln.class, "TNKiln");
			GameRegistry.registerTileEntity(TNEWoodCutter.class, "TNWoodCutter");
		}
	}
}