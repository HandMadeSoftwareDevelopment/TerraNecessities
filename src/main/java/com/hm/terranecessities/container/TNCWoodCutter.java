package com.hm.terranecessities.container;

import com.bioxx.tfc.Containers.ContainerTFC;
import com.bioxx.tfc.Core.Player.PlayerInventory;
import com.bioxx.tfc.api.TFCItems;
import com.bioxx.tfc.api.Enums.EnumSize;
import com.hm.terranecessities.container.slot.TNExcludedSlot;
import com.hm.terranecessities.entity.TNEWoodCutter;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class TNCWoodCutter extends ContainerTFC {
	private TNEWoodCutter woodCutter;
	
	public TNCWoodCutter(InventoryPlayer player, TNEWoodCutter woodCutter, World world, int x, int y, int z) {
		this.woodCutter = woodCutter;
		
		woodCutter.openInventory();
		layoutContainer(player, woodCutter, 0, 0);
		
		PlayerInventory.buildInventoryLayout(this, player, 8, 90, false, true);
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return true;
	}
	
	protected void layoutContainer(IInventory playerInventory, IInventory chestInventory, int width, int height) {
		addSlotToContainer(new TNExcludedSlot(chestInventory, 0, 41, 9).allow(TFCItems.copperAxe).setSize(EnumSize.HUGE));
		addSlotToContainer(new TNExcludedSlot(chestInventory, 0, 41, 34).allow(TFCItems.logs).setSize(EnumSize.HUGE));
		addSlotToContainer(new TNExcludedSlot(chestInventory, 0, 94, 34).allow(TFCItems.singlePlank).setSize(EnumSize.HUGE));
		addSlotToContainer(new TNExcludedSlot(chestInventory, 0, 116, 34).allow(TFCItems.stick).setSize(EnumSize.HUGE));
	}
	
	@Override
	public ItemStack transferStackInSlotTFC(EntityPlayer player, int slotNum) {
		ItemStack origStack = null;
		Slot slot = (Slot) this.inventorySlots.get(slotNum);
		
		if (slot != null && slot.getHasStack()) {
			ItemStack slotStack = slot.getStack();
			origStack = slotStack.copy();
			
			if (slotNum < 10) {
				if (!this.mergeItemStack(slotStack, 10, inventorySlots.size(), true)) {
					return null;
				}
			} else {
				if (!this.mergeItemStack(slotStack, 0, 10, false)) {
					return null;
				}
			}
			
			if (slotStack.stackSize <= 0) {
				slot.putStack(null);
			}
			else {
				slot.onSlotChanged();
			}
			
			if (slotStack.stackSize == origStack.stackSize) {
				return null;
			}
			
			slot.onPickupFromSlot(player, slotStack);
		}
		
		return origStack;
	}
	
	@Override
	public void onContainerClosed(EntityPlayer player) {
		super.onContainerClosed(player);
		
		woodCutter.closeInventory();
	}
}