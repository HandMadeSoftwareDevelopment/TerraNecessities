package com.hm.terranecessities.item;

import com.bioxx.tfc.Items.ItemArrow;
import com.hm.terranecessities.TNCore;
import com.hm.terranecessities.core.TNTabs;

import net.minecraft.client.renderer.texture.IIconRegister;

public class TNIArrow extends ItemArrow {
	private float damage;
	
	public TNIArrow(ToolMaterial material, float damage) {
		this.damage = damage;
		
		setCreativeTab(TNTabs.TN_ITEMS);
		setMaxDamage(material.getMaxUses() / 2);
	}
	
	public void registerIcons(IIconRegister register) {
		itemIcon = register.registerIcon(TNCore.MODID + ":");
	}
	
}