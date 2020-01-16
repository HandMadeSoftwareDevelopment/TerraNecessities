package com.hm.terranecessities.item;

import com.bioxx.tfc.Items.Tools.ItemCustomSword;
import com.bioxx.tfc.api.Enums.EnumDamageType;
import com.hm.terranecessities.TNCore;
import com.hm.terranecessities.core.TNTabs;

import net.minecraft.client.renderer.texture.IIconRegister;

public class TNISword extends ItemCustomSword {
	public TNISword(ToolMaterial material, float damage, EnumDamageType damageType) {
		super(material, damage);
		
		this.damageType = damageType;
		
		setCreativeTab(TNTabs.TN_ITEMS);
	}
	
	@Override
	public void registerIcons(IIconRegister registerer) {
		this.itemIcon = registerer.registerIcon(TNCore.MODID + ":" + "weapons/" + this.getUnlocalizedName().replace("item.", ""));
	}
}