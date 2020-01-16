package com.hm.terranecessities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bioxx.tfc.Handlers.Network.PacketPipeline;
import com.hm.terranecessities.block.TNBlocks;
import com.hm.terranecessities.core.TNDictionary;
import com.hm.terranecessities.core.TNRecipes;
import com.hm.terranecessities.handler.TNPlayerEntityHandler;
import com.hm.terranecessities.item.TNItems;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

@Mod(dependencies = "required-after:tfc_coremod;"/*required-after:tfccrops;required-after:tfcmetals;"*/, modid = TNCore.MODID, name = TNCore.NAME, version = TNCore.VERSION)
public class TerraNecessities {
	public static final String CLIENT_PROXY_CLASS = "com.hm.terranecessities.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "com.hm.terranecessities.CommonProxy";
	
	public static final Logger LOG = LogManager.getLogger(TNCore.MODID);
	
	@Mod.Instance("terranecessities")
	public static TerraNecessities instance;
	
	@SidedProxy(clientSide = CLIENT_PROXY_CLASS, serverSide = SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	public static final PacketPipeline PACKET_PIPELINE = new PacketPipeline();
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		instance = this;
		
		TNBlocks.loadBlocks();
		TNBlocks.registerBlocks();
		
		proxy.registerTileEntities(true);
		
		TNItems.loadItems();
		TNItems.registerItems();
		
		proxy.registerGUIHandler();
		
		return;
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		PACKET_PIPELINE.initalise();
		
		TNAchievements.registerAchievements();
		
		MinecraftForge.EVENT_BUS.register(new TNPlayerEntityHandler());
		
		TNItems.loadDelayedItems();
		TNItems.registerDelayedItems();
		
		TNDictionary.registerOreDictionary();
		TNRecipes.registerRecipes();
		
		return;
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		PACKET_PIPELINE.postInitialise();
		
		return;
	}
}