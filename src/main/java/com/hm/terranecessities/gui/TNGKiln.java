package com.hm.terranecessities.gui;

import com.bioxx.tfc.GUI.GuiContainerTFC;
import com.hm.terranecessities.TNCore;
import com.hm.terranecessities.container.TNCKiln;
import com.hm.terranecessities.entity.TNEKiln;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

@SideOnly(Side.CLIENT)
public class TNGKiln extends GuiContainerTFC {
	public static ResourceLocation texture = new ResourceLocation(TNCore.MODID, TNCore.GUIPATH + "kiln.png");
	
	private TNEKiln kiln;
	
	public TNGKiln(InventoryPlayer inventory, TNEKiln te, World world, int x, int y, int z) {
		super(new TNCKiln(inventory, te, world, x, y, z), 208, 117);
		
		kiln = te;
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		// drawGui(texture);
	}
}
