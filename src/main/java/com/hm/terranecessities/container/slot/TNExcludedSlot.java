package com.hm.terranecessities.container.slot;

import java.util.ArrayList;
import java.util.List;

import com.bioxx.tfc.Containers.Slots.SlotSize;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class TNExcludedSlot extends SlotSize {
	private List<Item> allowed = new ArrayList<>();
	
	public TNExcludedSlot(IInventory inventory, int i, int j, int k) {
		super(inventory, i, j, k);
	}
	
	@Override
	public boolean isItemValid(ItemStack itemStack){
		Item item = itemStack.getItem();
		
		for (int i = 0; i < allowed.size(); i++) {
			if (item.getClass().isInstance(allowed.get(i))) {
				return super.isItemValid(itemStack);
			}
		}
		
		return false;
	}
	
	public TNExcludedSlot allow(Item... items) {
		for(int i = 0; i < items.length; i++) {
			allowed.add(items[i]);
		}
		
		return this;
	}
}