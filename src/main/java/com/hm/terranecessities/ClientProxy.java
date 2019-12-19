package com.hm.terranecessities;

import com.hm.terranecessities.gui.TNGUIHandler;

import cpw.mods.fml.common.network.NetworkRegistry;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy {
	
	public void registerGUIHandler() {
		NetworkRegistry.INSTANCE.registerGuiHandler(TerraNecessities.instance, new TNGUIHandler());
		
		MinecraftForge.EVENT_BUS.register(new TNGUIHandler());
	}
}