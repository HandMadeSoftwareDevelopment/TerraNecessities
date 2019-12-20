package com.hm.terranecessities.gui;

import com.bioxx.tfc.Handlers.Client.GuiHandler;
import com.hm.terranecessities.container.TNCKiln;
import com.hm.terranecessities.container.TNCWoodCutter;
import com.hm.terranecessities.entity.TNEKiln;
import com.hm.terranecessities.entity.TNEWoodCutter;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TNGUIHandler extends GuiHandler {
	public static final int TNG_KILN = 0,
			TNG_WOODCUTTER = 1;
	
	public static TNGUIHandler instance = new TNGUIHandler();
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		
		switch (ID) {
		case TNG_KILN:
			return new TNCKiln(player.inventory, (TNEKiln) te, world, x, y, z);
		
		case TNG_WOODCUTTER:
			return new TNCWoodCutter(player.inventory, (TNEWoodCutter) te, world, x, y, z);
			
		default:
			return null;
		}
	}
	
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		
		switch (ID) {
		case TNG_KILN:
			return new TNGKiln(player.inventory, (TNEKiln) te, world, x, y, z);
		
		case TNG_WOODCUTTER:
			return new TNGWoodCutter(player.inventory, (TNEWoodCutter) te, world, x, y, z);
			
		default:
			return null;
		}
	}
}