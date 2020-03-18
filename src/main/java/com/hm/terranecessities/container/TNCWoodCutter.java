package com.hm.terranecessities.container;

import com.bioxx.tfc.Containers.ContainerTFC;
import com.bioxx.tfc.Core.Player.PlayerInventory;
import com.bioxx.tfc.api.TFCItems;
import com.bioxx.tfc.api.Enums.EnumSize;
import com.hm.terranecessities.container.slot.TNBlockedSlot;
import com.hm.terranecessities.container.slot.TNExcludedSlot;
import com.hm.terranecessities.entity.TNEWoodCutter;
import com.hm.terranecessities.handler.TNWoodCutterRecipes;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class TNCWoodCutter extends ContainerTFC {
	private InventoryCrafting craft = new InventoryCrafting(this, 2, 1);
	private TNEWoodCutter woodCutter;
	private int state = 1;
	
	public TNCWoodCutter(InventoryPlayer player, TNEWoodCutter woodCutter, World world, int x, int y, int z) {
		this.woodCutter = woodCutter;
		
		woodCutter.openInventory();
		
		addSlotToContainer(new TNExcludedSlot(craft, 0, 41, 9).allow(TFCItems.copperAxe).setSize(EnumSize.HUGE));
		addSlotToContainer(new TNExcludedSlot(craft, 1, 41, 34).allow(TFCItems.logs).setSize(EnumSize.HUGE));
		addSlotToContainer(new TNBlockedSlot(woodCutter, 2, 94, 34));
		addSlotToContainer(new TNBlockedSlot(woodCutter, 3, 116, 34));
		
		PlayerInventory.buildInventoryLayout(this, player, 8, 90, false, true);
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return woodCutter.isUseableByPlayer(player);
	}
	
	@Override
	public void onContainerClosed(EntityPlayer player) {
		super.onContainerClosed(player);
		
		woodCutter.closeInventory();
	}
	
	@Override
	public void onCraftMatrixChanged(IInventory inventory) {
		ItemStack[] output;
		ItemStack axe, wood;
		
		if (inventory == craft) {
			axe = craft.getStackInSlot(0);
			wood = craft.getStackInSlot(1);
			
			if (axe == null || wood == null) {
				state = 1;
				return;
			}
			
			if (!axe.getClass().isInstance(TFCItems.copperAxe) || !wood.getClass().isInstance(TFCItems.logs)) {
				state = 1;
				return;
			}
			
//			output = TNWoodCutterRecipes.getCraftResults(axe, wood);
//			
//			if (output == null) {
//				state = 0;
//			}
		}
	}
	
	@Override
	public ItemStack slotClick(int slot, int mouse, int click, EntityPlayer player) {
		ItemStack stack;
		
		stack = super.slotClick(slot, mouse, click, player);
		
		if (slot < inventorySlots.size()) {
			if (inventorySlots.get(slot) != null) {
				if (((Slot) inventorySlots.get(slot)).inventory == craft) {
					onCraftMatrixChanged(craft);
				}
			}
		}
		
		return stack;
	}
	
	@Override
	public ItemStack transferStackInSlotTFC(EntityPlayer player, int index) {
		ItemStack stack = null;
		Slot slot = (Slot) inventorySlots.get(index);
		
		if (slot != null && slot.getHasStack()) {
			ItemStack slotStack = slot.getStack();
			stack = slotStack.copy();
			
			if (index < 4) {
				if (!this.mergeItemStack(slotStack, 4, inventorySlots.size(), true)) {
					return null;
				}
			}
			else if (!this.mergeItemStack(slotStack, 0, 4, false)) {
				return null;
			}
			
			if (slotStack.stackSize <= 0) {
				slot.putStack(null);
			}
			else {
				slot.onSlotChanged();
			}
			
			if (slotStack.stackSize == stack.stackSize) {
				return null;
			}
			
			slot.onPickupFromSlot(player, slotStack);
		}
		
		return stack;
	}
}