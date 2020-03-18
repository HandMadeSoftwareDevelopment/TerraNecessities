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
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.common.util.Constants;

public class TNEWoodCutter extends NetworkTileEntity implements IInventory {
	public ItemStack[] storage = new ItemStack[4];
	
	private void chopLumber() {
		
	}
	
	@Override
	public void closeInventory() {
		if (worldObj.isRemote) {
			worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
		}
	}
	
	@Override
	public void createInitNBT(NBTTagCompound nbt) {
		NBTTagList tags = new NBTTagList();
		
		for (int i = 0; i < storage.length; i++) {
			if (storage[i] != null) {
				NBTTagCompound tag = new NBTTagCompound();
				
				tag.setByte("Slot", (byte) i);
				
				storage[i].writeToNBT(tag);
				
				tags.appendTag(tag);
			}
		}
		
		nbt.setTag("Items", tags);
	}
	
	@Override
	public ItemStack decrStackSize(int i, int count) {
		ItemStack stack;
		
		if (storage[i] != null) {
			if (storage[i].stackSize <= count) {
				stack = storage[i];
				storage[i] = null;
				
				return stack;
			}
			
			stack = storage[i].splitStack(count);
			
			if (storage[i].stackSize == 0) {
				storage[i] = null;
			}
			
			return stack;
		}
		else {
			return null;
		}
	}
	
	public void ejectContents() {
		EntityItem item;
		Random rand = new Random();
		float f = rand.nextFloat() * 0.3F + 0.1F;
		float f1 = rand.nextFloat() * 2.0F + 0.4F;
		float f2 = rand.nextFloat() * 0.3F + 0.1F;
		float f3 = 0.05F;
		
		for (int i = 0; i < getSizeInventory(); i++) {
			if (storage[i] != null) {
				item = new EntityItem(worldObj, xCoord + f, yCoord + f1, zCoord + f2, storage[i]);
				item.motionX = (float) rand.nextGaussian() * f3;
				item.motionY = (float) rand.nextGaussian() * f3 + 0.2F;
				item.motionZ = (float) rand.nextGaussian() * f3;
				
				worldObj.spawnEntityInWorld(item);
				
				storage[i] = null;
			}
		}
	}
	
	public void ejectItem(int index) {
		EntityItem item;
		Random rand = new Random();
		float f = rand.nextFloat() * 0.8F + 0.1F;
		float f1 = rand.nextFloat() * 2.0F + 0.4F;
		float f2 = rand.nextFloat() * 0.8F + 0.1F;
		float f3 = 0.05F;
		
		if (storage[index] != null) {
			item = new EntityItem(worldObj, xCoord + f, yCoord + f1, zCoord + f2, storage[index]);
			item.motionX = (float) rand.nextGaussian() * f3;
			item.motionY = (float) rand.nextGaussian() * f3 + 0.05F;
			item.motionZ = (float) rand.nextGaussian() * f3;
			worldObj.spawnEntityInWorld(item);
		}
	}
	
	@Override
	public String getInventoryName() {
		return "TNWoodCutter";
	}
	
	@Override
	public int getInventoryStackLimit() {
		return 64;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getRenderBoundingBox() {
		return AxisAlignedBB.getBoundingBox(xCoord, yCoord, zCoord, xCoord + 1, yCoord + 1, zCoord + 1);
	}
	
	@Override
	public int getSizeInventory() {
		return storage.length;
	}
	
	@Override
	public ItemStack getStackInSlot(int i) {
		return storage[i];
	}
	
	@Override
	public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
		return null;
	}
	
	@Override
	public void handleInitPacket(NBTTagCompound nbt) {
		NBTTagList tags = nbt.getTagList("Items", 10);
		
		storage = new ItemStack[getSizeInventory()];
		
		for (int i = 0; i < tags.tagCount(); i++) {
			NBTTagCompound tag = tags.getCompoundTagAt(i);
			
			byte byte0 = tag.getByte("Slot");
			
			if (byte0 >= 0 && byte0 < storage.length) {
				storage[byte0] = ItemStack.loadItemStackFromNBT(tag);
			}
		}
	}
	
	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}
	
	@Override
	public boolean isItemValidForSlot(int i, ItemStack stack) {
		return false;
	}
	
	@Override
	public boolean isUseableByPlayer(EntityPlayer player) {
		return worldObj.getTileEntity(xCoord, yCoord, zCoord) != this ? false : player.getDistanceSq((double)xCoord + 0.5D, (double)yCoord + 0.5D, (double)zCoord + 0.5D) <= 64.0D;
	}
	
	public void openGUI(EntityPlayer player) {
		player.openGui(TerraNecessities.instance, TNCommonGUIHandler.TNG_WOODCUTTER, worldObj, xCoord, yCoord, zCoord);
	}
	
	@Override
	public void openInventory() {
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		
		NBTTagList tags = nbt.getTagList("Items", Constants.NBT.TAG_COMPOUND);
		
		storage = new ItemStack[getSizeInventory()];
		
		for (int i = 0; i < tags.tagCount(); i++) {
			NBTTagCompound data = tags.getCompoundTagAt(i);
			
			int j = data.getByte("Slot") & 255;
			
			if (j >= 0 && j < storage.length) {
				storage[j] = ItemStack.loadItemStackFromNBT(data);
			}
		}
	}
	
	@Override
	public void setInventorySlotContents(int i, ItemStack stack) {
		storage[i] = stack;
		
		if (stack != null &&stack.stackSize > getInventoryStackLimit()) {
			stack.stackSize = getInventoryStackLimit();
		}
		
		markDirty();
		
//		if (!TFC_Core.areItemsEqual(storage[i], stack)) {
//			worldObj.markBlockForUpdate(xCoord, yCoord, zCoord);
//		}
		
//		storage[i] = stack;
	}
	
	@Override
	public void updateEntity() {
		TFC_Core.handleItemTicking(this, worldObj, xCoord, yCoord, zCoord);
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		
		NBTTagCompound tag;
		NBTTagList tags = new NBTTagList();
		
		for (int i = 0; i < storage.length; ++i) {
			if (storage[i] != null) {
				tag = new NBTTagCompound();
				
				tag.setByte("Slot", (byte) i);
				
				storage[i].writeToNBT(tag);
				
				tags.appendTag(tag);
			}
		}
		
		nbt.setTag("Items", tags);
	}
}