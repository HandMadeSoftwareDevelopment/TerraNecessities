package com.hm.terranecessities.item;

import com.bioxx.tfc.api.Enums.EnumDamageType;
import com.bioxx.tfc.api.Enums.EnumItemReach;
import com.bioxx.tfc.api.Enums.EnumSize;

import net.minecraft.item.ItemStack;

public class TNISpear extends TNISword {
	public TNISpear(ToolMaterial material, float damage) {
		super(material, damage, EnumDamageType.PIERCING);
		
		setMaxDamage(material.getMaxUses());
	}
	
	@Override
	public EnumSize getSize(ItemStack stack) {
		return EnumSize.LARGE;
	}
	
	@Override
	public EnumItemReach getReach(ItemStack stack) {
		return EnumItemReach.FAR;
	}
}
