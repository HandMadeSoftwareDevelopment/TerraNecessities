package com.hm.terranecessities;

import com.hm.terranecessities.gui.TNClientGUIHandler;

import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy {
	
	@Override
	public void registerGUIHandler() {
		NetworkRegistry.INSTANCE.registerGuiHandler(TerraNecessities.instance, new TNClientGUIHandler());
		
		MinecraftForge.EVENT_BUS.register(new TNClientGUIHandler());
	}
	
//	public void registerTileEntities(boolean b) {
//		super.registerTileEntities(false);
//		
//		if (b) {
//			ClientRegistry.registerTileEntity(TNEKiln.class, "TNEKiln");
//			ClientRegistry.registerTileEntity(TNEWoodCutter.class, "TNWoodCutter", new TNRWoodCutter());
//		}
//	}
}