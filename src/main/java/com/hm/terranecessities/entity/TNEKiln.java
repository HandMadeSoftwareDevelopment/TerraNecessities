package com.hm.terranecessities.entity;

import com.bioxx.tfc.TileEntities.NetworkTileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class TNEKiln extends NetworkTileEntity implements IInventory {
	ItemStack[] storage;
	
	public TNEKiln() {
		broadcastRange = 5;
		
		storage = new ItemStack[2];
	}
	
	@Override
	public int getSizeInventory() {
		return 2;
	}
	
	@Override
	public ItemStack getStackInSlot(int i) {
		return storage[i];
	}
	
	@Override
	public ItemStack decrStackSize(int i, int j) {
		ItemStack stack, newStack;
		
		if (storage[i] != null) {
			if (storage[i].stackSize <= j) {
				stack = storage[i];
				storage[i] = null;
				return stack;
			}
			
			newStack = storage[i].splitStack(j);
			
			if (storage[i].stackSize == 0) {
				storage[i] = null;
			}
			
			return newStack;
		}
		else {
			return null;
		}
	}
	
	@Override
	public ItemStack getStackInSlotOnClosing(int i) {
		return storage[i];
	}
	
	@Override
	public void setInventorySlotContents(int i, ItemStack stack) {
		storage[i] = stack;
		
	}
	
	@Override
	public String getInventoryName() {
		return "Kiln";
	}
	
	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}
	
	@Override
	public int getInventoryStackLimit() {
		return 64;
	}
	
	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return true;
	}
	
	@Override
	public void openInventory() {
	}
	
	@Override
	public void closeInventory() {
	}
	
	@Override
	public boolean isItemValidForSlot(int i, ItemStack stack) {
		return true;
	}
	
	@Override
	public void createInitNBT(NBTTagCompound nbt) {
	}
	
	@Override
	public void handleInitPacket(NBTTagCompound nbt) {
	}
}