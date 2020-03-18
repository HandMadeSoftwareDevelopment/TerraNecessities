package com.hm.terranecessities.gui;

import com.bioxx.tfc.Handlers.GuiHandler;
import com.hm.terranecessities.container.TNCKiln;
import com.hm.terranecessities.container.TNCWoodCutter;
import com.hm.terranecessities.entity.TNEKiln;
import com.hm.terranecessities.entity.TNEWoodCutter;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TNCommonGUIHandler extends GuiHandler {
	public static final int
		TNG_KILN = 0,
		TNG_WOODCUTTER = 1;
	
	public static TNCommonGUIHandler instance = new TNCommonGUIHandler();
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity te = world.getTileEntity(x, y, z);
		
		if (te == null) {
			return null;
		}
		
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
		return null;
	}
}