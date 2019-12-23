package com.hm.terranecessities.item;

import com.bioxx.tfc.Items.Pottery.ItemPotteryBase;
import com.bioxx.tfc.api.Enums.EnumSize;
import com.bioxx.tfc.api.Enums.EnumWeight;
import com.hm.terranecessities.TNCore;
import com.hm.terranecessities.core.TNTabs;

import net.minecraft.client.renderer.texture.IIconRegister;

public class TNIPottery extends ItemPotteryBase {
	public TNIPottery() {
		super();
		
		hasSubtypes = true;
		metaNames = new String[] { "", "" };
		
		setCreativeTab(TNTabs.TN_ITEMS);
		setFolder("pottery/");
		setSize(EnumSize.SMALL);
		setWeight(EnumWeight.MEDIUM);
	}
	
	@Override
	public void registerIcons(IIconRegister registerer) {
		clayIcon = registerer.registerIcon(TNCore.MODID + ":" + textureFolder + metaNames[0]);
		ceramicIcon = registerer.registerIcon(TNCore.MODID + ":" + textureFolder + metaNames[1]);
	}
}