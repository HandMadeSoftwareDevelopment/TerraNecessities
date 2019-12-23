package com.hm.terranecessities.gui;

import com.hm.terranecessities.entity.TNEKiln;
import com.hm.terranecessities.entity.TNEWoodCutter;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TNClientGUIHandler extends TNCommonGUIHandler {
	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		TileEntity te;
		
		try {
			te = world.getTileEntity(x, y, z);
		}
		catch (Exception e) {
			te = null;
		}
		
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