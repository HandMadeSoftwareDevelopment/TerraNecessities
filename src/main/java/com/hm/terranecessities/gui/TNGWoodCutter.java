package com.hm.terranecessities.gui;

import com.bioxx.tfc.GUI.GuiContainerTFC;
import com.hm.terranecessities.TNCore;
import com.hm.terranecessities.container.TNCWoodCutter;
import com.hm.terranecessities.entity.TNEWoodCutter;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class TNGWoodCutter extends GuiContainerTFC {
	private static ResourceLocation texture = new ResourceLocation(TNCore.MODID, TNCore.GUIPATH + "gui_splitting.png");
	
	public TNGWoodCutter(InventoryPlayer player, TNEWoodCutter te, World world, int i, int j, int k) {
		super(new TNCWoodCutter(player, te, world, i, j, k), 176, 85);
	}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int i, int j) {
		drawGui(texture);
	}
}