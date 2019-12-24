package com.hm.terranecessities.block;

import java.util.ArrayList;

import com.bioxx.tfc.Blocks.BlockTerra;
import com.hm.terranecessities.TNCore;
import com.hm.terranecessities.item.TNItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.client.renderer.IconFlipped;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class TNBThatchDoor extends BlockTerra {
	private IIcon[] icons = new IIcon[4];
	
	public TNBThatchDoor() {
		super(Material.wood);
		
		float var3 = 0.5F;
		float var4 = 1.0F;
		
		setBlockBounds(0.5F - var3, 0.0F, 0.5F - var3, 0.5F + var3, var4, 0.5F + var3);
		setBlockName("TNThatchDoor");
		setHardness(2.f);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int par1, int par2) {
		return this.icons[0];
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public IIcon getIcon(IBlockAccess par1IBlockAccess, int par2, int par3, int par4, int par5) {
		if (par5 != 1 && par5 != 0) {
			int meta = this.getFullMetadata(par1IBlockAccess, par2, par3, par4);
			int rotation = meta & 3;
			boolean flag = (meta & 4) != 0;
			boolean flag1 = false;
			boolean flag2 = (meta & 8) != 0;
			
			if (flag) {
				if (rotation == 0 && par5 == 2) {
					flag1 = !flag1;
				}
				else if (rotation == 1 && par5 == 5) {
					flag1 = !flag1;
				}
				else if (rotation == 2 && par5 == 3) {
					flag1 = !flag1;
				}
				else if (rotation == 3 && par5 == 4) {
					flag1 = !flag1;
				}
			}
			else {
				if (rotation == 0 && par5 == 5) {
					flag1 = !flag1;
				}
				else if (rotation == 1 && par5 == 3) {
					flag1 = !flag1;
				}
				else if (rotation == 2 && par5 == 4) {
					flag1 = !flag1;
				}
				else if (rotation == 3 && par5 == 2) {
					flag1 = !flag1;
				}
				
				if ((meta & 16) != 0) {
					flag1 = !flag1;
				}
			}
			
			return icons[(flag1 ? 2 : 0) + (flag2 ? 1 : 0)];
		}
		else {
			return icons[0];
		}
	}
	
	@Override
	public void registerBlockIcons(IIconRegister register) {
		icons[0] = register.registerIcon(TNCore.MODID + ":door/thatch_lower");
		icons[1] = register.registerIcon(TNCore.MODID + ":door/thatch_upper");
		icons[2] = new IconFlipped(icons[0], true, false);
		icons[3] = new IconFlipped(icons[1], true, false);
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public boolean getBlocksMovement(IBlockAccess blockAccess, int par2, int par3, int par4) {
		int var5 = this.getFullMetadata(blockAccess, par2, par3, par4);
		return (var5 & 4) != 0;
	}
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	public int getRenderType() {
		return 7;
	}
	
	@SideOnly(Side.CLIENT)
	@Override
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
		this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
		return super.getSelectedBoundingBoxFromPool(par1World, par2, par3, par4);
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
		this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
		return super.getCollisionBoundingBoxFromPool(par1World, par2, par3, par4);
	}
	
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
		this.setDoorRotation(this.getFullMetadata(par1IBlockAccess, par2, par3, par4));
	}
	
	public int getDoorOrientation(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
		return this.getFullMetadata(par1IBlockAccess, par2, par3, par4) & 3;
	}
	
	public boolean isDoorOpen(IBlockAccess par1IBlockAccess, int par2, int par3, int par4) {
		return (this.getFullMetadata(par1IBlockAccess, par2, par3, par4) & 4) != 0;
	}
	
	private void setDoorRotation(int par1) {
		float var2 = 0.1875F;
		this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 2.0F, 1.0F);
		int var3 = par1 & 3;
		boolean var4 = (par1 & 4) != 0;
		boolean var5 = (par1 & 16) != 0;
		
		if (var3 == 0) {
			if (var4) {
				if (!var5) {
					this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var2);
				}
				else {
					this.setBlockBounds(0.0F, 0.0F, 1.0F - var2, 1.0F, 1.0F, 1.0F);
				}
			}
			else {
				this.setBlockBounds(0.0F, 0.0F, 0.0F, var2, 1.0F, 1.0F);
			}
		}
		else if (var3 == 1) {
			if (var4) {
				if (!var5) {
					this.setBlockBounds(1.0F - var2, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
				}
				else {
					this.setBlockBounds(0.0F, 0.0F, 0.0F, var2, 1.0F, 1.0F);
				}
			}
			else {
				this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var2);
			}
		}
		else if (var3 == 2) {
			if (var4) {
				if (!var5) {
					this.setBlockBounds(0.0F, 0.0F, 1.0F - var2, 1.0F, 1.0F, 1.0F);
				}
				else {
					this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, var2);
				}
			}
			else {
				this.setBlockBounds(1.0F - var2, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
			}
		}
		else if (var3 == 3) {
			if (var4) {
				if (!var5) {
					this.setBlockBounds(0.0F, 0.0F, 0.0F, var2, 1.0F, 1.0F);
				}
				else {
					this.setBlockBounds(1.0F - var2, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
				}
			}
			else {
				this.setBlockBounds(0.0F, 0.0F, 1.0F - var2, 1.0F, 1.0F, 1.0F);
			}
		}
	}
	
	@Override
	public void onBlockClicked(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer) {
	}
	
	@Override
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
		if (this.blockMaterial == Material.iron) {
			return false;
		} else {
			int var10 = this.getFullMetadata(par1World, par2, par3, par4);
			int var11 = var10 & 7;
			var11 ^= 4;
			
			if ((var10 & 8) == 0) {
				par1World.setBlockMetadataWithNotify(par2, par3, par4, var11, 3);
				par1World.markBlockRangeForRenderUpdate(par2, par3, par4, par2, par3, par4);
			} else {
				par1World.setBlockMetadataWithNotify(par2, par3 - 1, par4, var11, 3);
				par1World.markBlockRangeForRenderUpdate(par2, par3 - 1, par4, par2, par3, par4);
			}
			
			par1World.playAuxSFXAtEntity(par5EntityPlayer, 1003, par2, par3, par4, 0);
			return true;
		}
	}
	
	public void onPoweredBlockChange(World par1World, int par2, int par3, int par4, boolean par5) {
		int var6 = this.getFullMetadata(par1World, par2, par3, par4);
		boolean var7 = (var6 & 4) != 0;
		
		if (var7 != par5) {
			int var8 = var6 & 7;
			var8 ^= 4;
			
			if ((var6 & 8) == 0) {
				par1World.setBlockMetadataWithNotify(par2, par3, par4, var8, 3);
				par1World.markBlockRangeForRenderUpdate(par2, par3, par4, par2, par3, par4);
			} else {
				par1World.setBlockMetadataWithNotify(par2, par3 - 1, par4, var8, 3);
				par1World.markBlockRangeForRenderUpdate(par2, par3 - 1, par4, par2, par3, par4);
			}
			
			par1World.playAuxSFXAtEntity((EntityPlayer) null, 1003, par2, par3, par4, 0);
		}
	}
	
	@Override
	public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, Block par5) {
		int var6 = par1World.getBlockMetadata(par2, par3, par4);
		
		if ((var6 & 8) == 0) {
			boolean var7 = false;
			
			if (par1World.getBlock(par2, par3 + 1, par4) != this) {
				par1World.setBlockToAir(par2, par3, par4);
				var7 = true;
			}
			
			if (!World.doesBlockHaveSolidTopSurface(par1World, par2, par3 - 1, par4)) {
				par1World.setBlockToAir(par2, par3, par4);
				var7 = true;
				
				if (par1World.getBlock(par2, par3 + 1, par4) == this) {
					par1World.setBlockToAir(par2, par3 + 1, par4);
				}
			}
			
			if (var7) {
				if (!par1World.isRemote) {
					this.dropBlockAsItem(par1World, par2, par3, par4, var6, 0);
				}
			} else {
				boolean var8 = par1World.isBlockIndirectlyGettingPowered(par2, par3, par4) || par1World.isBlockIndirectlyGettingPowered(par2, par3 + 1, par4);
				if ((var8 || par5.canProvidePower()) && par5 != this) {
					this.onPoweredBlockChange(par1World, par2, par3, par4, var8);
				}
			}
		} else {
			if (par1World.getBlock(par2, par3 - 1, par4) != this) {
				par1World.setBlockToAir(par2, par3, par4);
			}
			
			if (par5 != this) {
				this.onNeighborBlockChange(par1World, par2, par3 - 1, par4, par5);
			}
		}
	}
	
	@Override
	public MovingObjectPosition collisionRayTrace(World par1World, int par2, int par3, int par4, Vec3 par5Vec3, Vec3 par6Vec3) {
		this.setBlockBoundsBasedOnState(par1World, par2, par3, par4);
		return super.collisionRayTrace(par1World, par2, par3, par4, par5Vec3, par6Vec3);
	}
	
	@Override
	public boolean canPlaceBlockAt(World par1World, int par2, int par3, int par4) {
		return par3 >= 255 ? false : World.doesBlockHaveSolidTopSurface(par1World, par2, par3 - 1, par4) && super.canPlaceBlockAt(par1World, par2, par3, par4) && super.canPlaceBlockAt(par1World, par2, par3 + 1, par4);
	}
	
	@Override
	public int getMobilityFlag() {
		return 1;
	}
	
	public int getFullMetadata(IBlockAccess blockAccess, int par2, int par3, int par4) {
		int var5 = blockAccess.getBlockMetadata(par2, par3, par4);
		boolean var6 = (var5 & 8) != 0;
		int var7;
		int var8;
		
		if (var6) {
			var7 = blockAccess.getBlockMetadata(par2, par3 - 1, par4);
			var8 = var5;
		} else {
			var7 = var5;
			var8 = blockAccess.getBlockMetadata(par2, par3 + 1, par4);
		}
		
		boolean var9 = (var8 & 1) != 0;
		return var7 & 7 | (var6 ? 8 : 0) | (var9 ? 16 : 0);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public Item getItem(World par1World, int par2, int par3, int par4) {
		return this.blockMaterial == Material.iron ? Items.iron_door : Items.wooden_door;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean addDestroyEffects(World world, int x, int y, int z, int meta, EffectRenderer effectRenderer) {
		return true;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean addHitEffects(World worldObj, MovingObjectPosition target, EffectRenderer effectRenderer) {
		return true;
	}
	
	@Override
	public int getDamageValue(World world, int x, int y, int z) {
		return 1;
	}
	
	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metaData, int fortune) {
		ArrayList<ItemStack> stack = new ArrayList<ItemStack>();
		Block block;
		
		if ((metaData & 8) == 0) {
			block = world.getBlock(x, y + 1, z);
			
			if (block != null && (block instanceof TNBThatchDoor || block == Blocks.air)) {
				stack.add(new ItemStack(TNItems.thatchDoor, 1, 0));
			}
		}
		else {
			block = world.getBlock(x, y - 1, z);
			
			if (block instanceof TNBThatchDoor) {
				stack.add(new ItemStack(TNItems.thatchDoor, 1, 0));
			}
		}
		
		return stack;
	}
	
	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
		return new ItemStack(TNItems.thatchDoor, 1, 0);
	}
}