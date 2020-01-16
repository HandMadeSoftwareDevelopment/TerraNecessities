package com.hm.terranecessities.item;

import com.bioxx.tfc.Items.Tools.ItemWeapon;
import com.hm.terranecessities.TNCore;
import com.hm.terranecessities.core.TNTabs;

import net.minecraft.client.renderer.texture.IIconRegister;

public abstract class TNIWeapon extends ItemWeapon {
	public TNIWeapon(ToolMaterial material, float damage) {
		super(material, damage);
		
		setCreativeTab(TNTabs.TN_ITEMS);
	}
	
	@Override
	public void registerIcons(IIconRegister registerer) {
		this.itemIcon = registerer.registerIcon(TNCore.MODID + ":" + "weapons/" + this.getUnlocalizedName().replace("item.", ""));
	}
}