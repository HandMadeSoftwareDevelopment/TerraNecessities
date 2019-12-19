package com.hm.terranecessities.container;

import com.bioxx.tfc.Containers.ContainerTFC;
import com.bioxx.tfc.Core.Player.PlayerInventory;
import com.hm.terranecessities.entity.TNEKiln;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.world.World;

public class TNCKiln extends ContainerTFC {
	private TNEKiln te;
	
	public TNCKiln(InventoryPlayer inventory, TNEKiln te, World world, int x, int y, int z) {
		this.te = te;
		
		PlayerInventory.buildInventoryLayout(this, inventory, 8, 118, false, true);
	}
	
	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return te.isUseableByPlayer(player);
	}
}