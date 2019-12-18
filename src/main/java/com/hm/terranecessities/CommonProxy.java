package com.hm.terranecessities;

import com.hm.terranecessities.entity.TNEKiln;

import cpw.mods.fml.common.registry.GameRegistry;

public class CommonProxy {
	
	public void registerTileEntities() {
		GameRegistry.registerTileEntity(TNEKiln.class, "Kiln");
	}
	
}