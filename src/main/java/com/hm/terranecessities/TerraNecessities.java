package com.hm.terranecessities;

import com.hm.terranecessities.init.TNItems;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = TerraNecessities.MODID, name = TerraNecessities.NAME, version = TerraNecessities.VERSION)

public class TerraNecessities {
	public static final String MODID = "terranecessities";
	public static final String NAME = "TerraNecessities";
	public static final String VERSION = "1.7.10-A1";
	
	public static final String CLIENT_PROXY_CLASS = "com.hm.terranecessities.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "com.hm.terranecessities.CommonProxy";
	
	@Mod.Instance("terranecessities")
	public static TerraNecessities instance;
	
	@SidedProxy(clientSide = CLIENT_PROXY_CLASS, serverSide = SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		instance = this;
		
		TNItems.init();
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
	}
}