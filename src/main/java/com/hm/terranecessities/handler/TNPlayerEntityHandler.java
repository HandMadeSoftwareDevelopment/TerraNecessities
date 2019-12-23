package com.hm.terranecessities.handler;

import com.hm.terranecessities.TNAchievements;
import com.hm.terranecessities.item.TNItems;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;

public class TNPlayerEntityHandler {
	@SubscribeEvent
	public void handleItemPickup(EntityItemPickupEvent event) {
		EntityPlayer player = event.entityPlayer;
		ItemStack item = event.item.getEntityItem();
		
		if (item.getItem() == TNItems.clayMoldDoubleHoe || item.getItem() == TNItems.clayMoldDoubleKnife) {
			player.triggerAchievement(TNAchievements.doubleEfficiency);
		}
	}
}