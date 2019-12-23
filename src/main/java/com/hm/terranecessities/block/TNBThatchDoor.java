package com.hm.terranecessities.block;

import java.util.ArrayList;

import com.bioxx.tfc.Blocks.BlockTerra;
import com.bioxx.tfc.Blocks.Vanilla.BlockCustomDoor;
import com.hm.terranecessities.item.TNItems;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class TNBThatchDoor extends BlockTerra {
	
	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metaData, int fortune) {
		ArrayList<ItemStack> stack = new ArrayList<ItemStack>();
		Block block;
		
		if ((metaData & 8) == 0) {
			block = world.getBlock(x, y + 1, z);
			
			if (block != null && (block instanceof BlockCustomDoor || block == Blocks.air)) {
				stack.add(new ItemStack(TNItems.thatchDoor, 1, 0));
			}
		}
		else {
			block = world.getBlock(x, y - 1, z);
			
			if (block instanceof BlockCustomDoor) {
				stack.add(new ItemStack(TNItems.thatchDoor, 1, 0));
			}
		}
		
		return stack;
	}
}