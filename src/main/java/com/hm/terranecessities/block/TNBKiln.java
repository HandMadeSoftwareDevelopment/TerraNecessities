package com.hm.terranecessities.block;

import com.bioxx.tfc.TerraFirmaCraft;
import com.bioxx.tfc.Blocks.BlockTerraContainer;
import com.hm.terranecessities.TNCore;
import com.hm.terranecessities.core.TNTabs;
import com.hm.terranecessities.entity.TNEKiln;
import com.hm.terranecessities.gui.TNCommonGUIHandler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class TNBKiln extends BlockTerraContainer {
	
	public TNBKiln() {
		super();
		
		setBlockName("TNBKiln");
		setBlockTextureName(TNCore.MODID + ":snow");
		setHardness(4.f);
		setCreativeTab(TNTabs.TN_ITEMS);
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TNEKiln();
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int par6, float par7, float par8, float par9) {
		if (world.isRemote) {
			return true;
		}
		
		player.openGui(TerraFirmaCraft.instance, TNCommonGUIHandler.TNG_KILN, world, x, y, z);
		
		return true;
	}
}