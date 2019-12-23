package com.hm.terranecessities.block;

import java.util.ArrayList;

import com.bioxx.tfc.Blocks.BlockTerraContainer;
import com.bioxx.tfc.Core.TFC_Textures;
import com.bioxx.tfc.TileEntities.TEFoodPrep;
import com.hm.terranecessities.entity.TNEWoodCutter;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;

public class TNBWoodCutter extends BlockTerraContainer {
	public TNBWoodCutter() {
		super();
		
		setBlockBounds(0, 0, 0, 1, 0.15f, 1);
		setBlockName("TNWoodCutter");
		setHardness(1.f);
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean addDestroyEffects(World world, int x, int y, int z, int meta, EffectRenderer effectRenderer) {
		return world.getBlock(x, y, z) == this;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public boolean addHitEffects(World worldObj, MovingObjectPosition target, EffectRenderer effectRenderer) {
		return true;
	}
	
	@Override
	public void breakBlock(World world, int par2, int par3, int par4, Block par5, int par6) {
		eject(world, par2, par3, par4);
	}
	
	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TNEWoodCutter();
	}
	
	public void eject(World world, int x, int y, int z) {
		if (world.getTileEntity(x, y, z) instanceof TEFoodPrep) {
			TNEWoodCutter te = (TNEWoodCutter) world.getTileEntity(x, y, z);
			te.ejectContents();
			world.removeTileEntity(x, y, z);
		}
	}
	
	@Override
	public boolean getBlocksMovement(IBlockAccess par1IBlockAccess, int i, int j, int k) {
		return true;
	}
	
	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World par1World, int par2, int par3, int par4) {
		return null;
	}
	
	@Override
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
		return new ArrayList<ItemStack>();
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(IBlockAccess access, int i, int j, int k, int meta) {
		return TFC_Textures.invisibleTexture;
	}
	
	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
		return null;
	}
	
	@Override
	public AxisAlignedBB getSelectedBoundingBoxFromPool(World par1World, int i, int j, int k) {
		return AxisAlignedBB.getBoundingBox(i, j, k, i + 1, j + 0.15, k + 1);
	}
	
	@Override
	public void harvestBlock(World world, EntityPlayer entityplayer, int i, int j, int k, int l) {
		eject(world, i, j, k);
	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer entityplayer, int side, float hitX, float hitY, float hitZ) {
		if (!world.isRemote) {
			TNEWoodCutter te = (TNEWoodCutter) world.getTileEntity(x, y, z);
			te.openGUI(entityplayer);
		}
		
		return true;
	}
	
	@Override
	public void onBlockDestroyedByExplosion(World par1World, int par2, int par3, int par4, Explosion ex) {
		eject(par1World, par2, par3, par4);
	}
	
	@Override
	public void onBlockDestroyedByPlayer(World par1World, int par2, int par3, int par4, int par5) {
		eject(par1World, par2, par3, par4);
	}
	
	@Override
	public void onNeighborBlockChange(World world, int i, int j, int k, Block block) {
		if (!world.isRemote) {
			if (!world.isSideSolid(i, j - 1, k, ForgeDirection.UP)) {
				((TNEWoodCutter) world.getTileEntity(i, j, k)).ejectContents();
				world.setBlockToAir(i, j, k);
				return;
			}
		}
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegisterer) {
	}
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
}
