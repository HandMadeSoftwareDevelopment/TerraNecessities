package com.hm.terranecessities.item;

import com.bioxx.tfc.api.Enums.EnumSize;
import com.bioxx.tfc.api.Enums.EnumWeight;
import com.hm.terranecessities.block.TNBlocks;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class TNIThatchDoor extends TNIBase {
	public static void placeDoorBlock(World par0World, int par1, int par2, int par3, int par4, Block par5Block) {
		byte var6 = 0;
		byte var7 = 0;
		
		if (par4 == 0) {
			var7 = 1;
		}
		
		if (par4 == 1) {
			var6 = -1;
		}
		
		if (par4 == 2) {
			var7 = -1;
		}
		
		if (par4 == 3) {
			var6 = 1;
		}
		
		int var8 = (par0World.getBlock(par1 - var6, par2, par3 - var7).isNormalCube() ? 1 : 0) + (par0World.getBlock(par1 - var6, par2 + 1, par3 - var7).isNormalCube() ? 1 : 0);
		int var9 = (par0World.getBlock(par1 + var6, par2, par3 + var7).isNormalCube() ? 1 : 0) + (par0World.getBlock(par1 + var6, par2 + 1, par3 + var7).isNormalCube() ? 1 : 0);
		boolean var10 = par0World.getBlock(par1 - var6, par2, par3 - var7) == par5Block || par0World.getBlock(par1 - var6, par2 + 1, par3 - var7) == par5Block;
		boolean var11 = par0World.getBlock(par1 + var6, par2, par3 + var7) == par5Block || par0World.getBlock(par1 + var6, par2 + 1, par3 + var7) == par5Block;
		boolean var12 = false;
		
		if (var10 && !var11) {
			var12 = true;
		}
		else if (var9 > var8) {
			var12 = true;
		}
		
		par0World.setBlock(par1, par2, par3, par5Block, par4, 0x2);
		par0World.setBlock(par1, par2 + 1, par3, par5Block, 8 | (var12 ? 1 : 0), 0x2);
		par0World.notifyBlocksOfNeighborChange(par1, par2, par3, par5Block);
		par0World.notifyBlocksOfNeighborChange(par1, par2 + 1, par3, par5Block);
	}
	
	public TNIThatchDoor() {
		super();
		
		maxStackSize = 1;
		
		setTextureName("misc/thatch_door");
	}
	
	@Override
	public EnumSize getSize(ItemStack is) {
		return EnumSize.HUGE;
	}
	
	@Override
	public EnumWeight getWeight(ItemStack is) {
		return EnumWeight.HEAVY;
	}
	
	@Override
	public boolean onItemUse(ItemStack is, EntityPlayer player, World world, int i, int j, int k, int side, float hitX, float hitY, float hitZ) {
		Block block;
		
		if (side != 1) {
			return false;
		}
		else {
			++j;
			block = TNBlocks.thatchDoor;
			
			if (player.canPlayerEdit(i, j, k, side, is) && player.canPlayerEdit(i, j + 1, k, side, is)) {
				if (!block.canPlaceBlockAt(world, i, j, k)) {
					return false;
				}
				else {
					int var12 = MathHelper.floor_double((player.rotationYaw + 180.0F) * 4.0F / 360.0F - 0.5D) & 3;
					
					placeDoorBlock(world, i, j, k, var12, block);
					
					--is.stackSize;
					
					return true;
				}
			}
			else {
				return false;
			}
		}
	}
}