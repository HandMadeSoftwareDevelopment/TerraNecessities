package com.hm.terranecessities.entity;

import java.util.Random;

import com.bioxx.tfc.Core.TFC_Core;
import com.bioxx.tfc.TileEntities.NetworkTileEntity;
import com.hm.terranecessities.TerraNecessities;
import com.hm.terranecessities.gui.TNCommonGUIHandler;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;

public class TNEWoodCutter extends NetworkTileEntity implements IInventory {
	public ItemStack[] storage = new ItemStack[3];
	
	@Override
	public int getSizeInventory() {
		return storage.length;
	}
	
	@Override
	public ItemStack getStackInSlot(int i) {
		return storage[i];
	}
	
	@Override
	public ItemStack decrStackSize(int i, int j) {
		ItemStack stack;
		
		if(storage[i] != null) {
			if(storage[i].stackSize <= j) {
				stack = storage[i];
				storage[i] = null;
				
				return stack;
			}
			
			stack = storage[i].splitStack(j);
			
			if(storage[i].stackSize == 0) {
				storage[i] = null;
			}
			
			return stack;
		}
		else {
			return null;
		}
	}
	
	public void ejectContents() {
		EntityItem entityitem;
		Random rand = new Random();
		float f = rand.nextFloat() * 0.3F + 0.1F;
		float f1 = rand.nextFloat() * 2.0F + 0.4F;
		float f2 = rand.nextFloat() * 0.3F + 0.1F;
		float f3 = 0.05F;
		
		for (int i = 0; i < getSizeInventory(); i++) {
			if(storage[i] != null) {
				entityitem = new EntityItem(worldObj, xCoord + f, yCoord + f1, zCoord + f2, storage[i]);
				entityitem.motionX = (float)rand.nextGaussian() * f3;
				entityitem.motionY = (float)rand.nextGaussian() * f3 + 0.2F;
				entityitem.motionZ = (float)rand.nextGaussian() * f3;
				
				worldObj.spawnEntityInWorld(entityitem);
			}
		}
	}
	
	@Override
	public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
		return null;
	}
	
	@Override
	public void setInventorySlotContents(int i, ItemStack stack) {
		if(!TFC_Core.areItemsEqual(storage[i], stack)) {
			worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
		}
		
		storage[i] = stack;
	}
	
	@Override
	public String getInventoryName() {
		return "TNWoodCutter";
	}
	
	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getRenderBoundingBox() {
		return AxisAlignedBB.getBoundingBox(xCoord, yCoord, zCoord, xCoord + 1, yCoord + 1, zCoord + 1);
	}
	
	@Override
	public int getInventoryStackLimit() {
		return 64;
	}
	
	@Override
	public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
		return false;
	}
	
	public void openGUI(EntityPlayer player) {
		player.openGui(TerraNecessities.instance, TNCommonGUIHandler.TNG_WOODCUTTER, worldObj, xCoord, yCoord, zCoord);
	}
	
	@Override
	public void openInventory() {
	}
	
	@Override
	public void closeInventory() {
		if (worldObj.isRemote) {
			worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
		}
	}
	
	@Override
	public void updateEntity() {
		TFC_Core.handleItemTicking(this, worldObj, xCoord, yCoord, zCoord);
	}
	
	@Override
	public boolean isItemValidForSlot(int i, ItemStack stack) {
		return false;
	}
	
	@Override
	public void createInitNBT(NBTTagCompound arg0) {
	}
	
	@Override
	public void handleInitPacket(NBTTagCompound arg0) {
	}
}