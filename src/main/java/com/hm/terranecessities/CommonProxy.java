package com.hm.terranecessities;

import com.hm.terranecessities.entity.TNEKiln;
import com.hm.terranecessities.gui.TNGUIHandler;

import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy {
	
	public void registerGUIHandler() {
		NetworkRegistry.INSTANCE.registerGuiHandler(TerraNecessities.instance, new TNGUIHandler());
	}
	
	public void registerTileEntities() {
		GameRegistry.registerTileEntity(TNEKiln.class, "Kiln");
	}
}