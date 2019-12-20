package com.hm.terranecessities.block;

import com.bioxx.tfc.Blocks.BlockTerraContainer;
import com.bioxx.tfc.TileEntities.TEFoodPrep;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class TNBWoodCutter extends BlockTerraContainer {
	public TNBWoodCutter() {
		super();
		
		setBlockBounds(0, 0, 0, 1, 0.15f, 1);
		setBlockName("TNWoodCutter");
		setHardness(1.f);
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityplayer, int side, float hitX, float hitY, float hitZ) {
		if(!world.isRemote)
		{
			TEFoodPrep te = (TEFoodPrep) world.getTileEntity(x, y, z);
			te.openGui(entityplayer);
		}
		return true;
	}
}
