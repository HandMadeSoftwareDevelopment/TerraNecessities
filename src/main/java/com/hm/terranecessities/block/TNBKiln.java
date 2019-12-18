package com.hm.terranecessities.block;

import com.dunk.tfc.Blocks.BlockTerraContainer;
import com.hm.terranecessities.core.TNTabs;

public class TNBKiln extends BlockTerraContainer {
	
	public TNBKiln(){
		setBlockName("TNKiln");
		setBlockTextureName("minecraft:workbench");
		setCreativeTab(TNTabs.TN_ITEMS);
	}
}