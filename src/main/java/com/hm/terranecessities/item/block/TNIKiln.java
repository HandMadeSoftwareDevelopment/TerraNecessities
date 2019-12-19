package com.hm.terranecessities.item.block;

import com.bioxx.tfc.Items.ItemBlocks.ItemTerraBlock;
import com.bioxx.tfc.api.Enums.EnumSize;
import com.bioxx.tfc.api.Enums.EnumWeight;

import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;

public class TNIKiln extends ItemTerraBlock {
	public TNIKiln(Block b) {
		super(b);
	}
	
	@Override
	public boolean canStack() {
		return false;
	}
	
	@Override
	public EnumSize getSize(ItemStack stack) {
		return EnumSize.HUGE;
	}
	
	@Override
	public EnumWeight getWeight(ItemStack stack) {
		return EnumWeight.HEAVY;
	}
}