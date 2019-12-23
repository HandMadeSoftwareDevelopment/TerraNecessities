package com.hm.terranecessities.item;

import com.hm.terranecessities.TNCore;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class TNIPotteryMold extends TNIPottery {
	private IIcon bismuthBronzeIcon, blackBronzeIcon, bronzeIcon, copperIcon;
	
	@Override
	public void registerIcons(IIconRegister registerer) {
		String prepend = TNCore.MODID + ":" + textureFolder + getUnlocalizedName().replaceFirst("item.", "");
		
		clayIcon = registerer.registerIcon(prepend + "_" + metaNames[0]);
		ceramicIcon = registerer.registerIcon(prepend + "_" + metaNames[1]);
		
		if (metaNames.length > 2) {
			copperIcon = registerer.registerIcon(prepend + "_" + metaNames[2]);
			bronzeIcon = registerer.registerIcon(prepend + "_" + metaNames[3]);
			bismuthBronzeIcon = registerer.registerIcon(prepend + "_" + metaNames[4]);
			blackBronzeIcon = registerer.registerIcon(prepend + "_" + metaNames[5]);
		}
	}
	
	@Override
	public IIcon getIconFromDamage(int damage) {
		if (damage > 5) {
			damage = (damage - 2) % 4 + 2;
		}
		
		switch (damage) {
		case 0:
			return this.clayIcon;
		case 1:
			return this.ceramicIcon;
		case 2:
			return this.copperIcon;
		case 3:
			return this.bronzeIcon;
		case 4:
			return this.bismuthBronzeIcon;
		case 5:
			return this.blackBronzeIcon;
		
		default:
			return this.clayIcon;
		}
	}
}