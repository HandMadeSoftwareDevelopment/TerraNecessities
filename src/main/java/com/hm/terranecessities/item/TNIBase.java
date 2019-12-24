package com.hm.terranecessities.item;

import com.bioxx.tfc.Items.ItemTerra;
import com.hm.terranecessities.TNCore;
import com.hm.terranecessities.core.TNTabs;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class TNIBase extends ItemTerra {
	public TNIBase() {
		super();
		
		setCreativeTab(TNTabs.TN_ITEMS);
	}
	
	@Override
	public void registerIcons(IIconRegister register) {
		if (metaNames == null) {
			if (iconString != null) {
				itemIcon = register.registerIcon(TNCore.MODID + ":" + textureFolder + getIconString());
			}
			else {
				itemIcon = register.registerIcon(TNCore.MODID + ":" + textureFolder + getUnlocalizedName().replace("item.", ""));
			}
		}
		else {
			metaIcons = new IIcon[metaNames.length];
			
			for (int i = 0; i < metaNames.length; i++) {
				metaIcons[i] = register.registerIcon(TNCore.MODID + ":" + textureFolder + metaNames[i]);
			}
			
			itemIcon = metaIcons[0];
		}
	}
}