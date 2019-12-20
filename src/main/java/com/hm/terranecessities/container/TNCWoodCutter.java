package com.hm.terranecessities.container;

import com.bioxx.tfc.Containers.ContainerTFC;
import com.bioxx.tfc.api.TFCItems;
import com.bioxx.tfc.api.Enums.EnumSize;
import com.hm.terranecessities.container.slot.TNExcludedSlot;
import com.hm.terranecessities.entity.TNEWoodCutter;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.world.World;

public class TNCWoodCutter extends ContainerTFC {
	private EntityPlayer player;
	private TNEWoodCutter woodCutter;
	
	public TNCWoodCutter(InventoryPlayer player, TNEWoodCutter woodCutter, World world, int x, int y, int z) {
		this.player = player.player;
		this.woodCutter = woodCutter;
		
		woodCutter.openInventory();
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return true;
	}
	
	protected void layoutContainer(IInventory playerInventory, IInventory chestInventory, int width, int height) {
		addSlotToContainer(new TNExcludedSlot(chestInventory, 0, 41, 9).allow(TFCItems.copperAxe).setSize(EnumSize.HUGE));
		addSlotToContainer(new TNExcludedSlot(chestInventory, 0, 41, 34).allow(TFCItems.logs).setSize(EnumSize.HUGE));
		//addSlotToContainer(new TNExcludedSlot(chestInventory, 0, 94, 34).allow(TFCItems.logs).setSize(EnumSize.HUGE));
		//addSlotToContainer(new TNExcludedSlot(chestInventory, 0, 116, 34).allow(TFCItems.copperAxe).setSize(EnumSize.HUGE));
	}
}