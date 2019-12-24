package com.hm.terranecessities.item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.hm.terranecessities.TNCore;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;

public class TNIPotteryMold extends TNIPottery {
	private IIcon[] icons;
	
	public TNIPotteryMold(String name, String... metaNames) {
		super();
		
		this.metaNames = addMetaNames(metaNames);
		
		icons = new IIcon[this.metaNames.length];
		
		setUnlocalizedName(name);
	}
	
	private String[] addMetaNames(String[] metaNames) {
		List<String> names = new ArrayList<>();
		boolean usable;
		
		names.addAll(Arrays.asList(this.metaNames));
		
		for (int i = 0; i < metaNames.length; i++) {
			usable = true;
			
			for (int j = 0; j < names.size(); j++) {
				if (metaNames[i].equals(names.get(j))) {
					usable = false;
					break;
				}
			}
			
			if (usable) {
				names.add(metaNames[i]);
			}
		}
		
		// create empty array to fill with elements and return it.
		return names.toArray(new String[0]);
	}
	
	@Override
	public IIcon getIconFromDamage(int damage) {
		if (damage > 5) {
			damage = (damage - 2) % 4 + 2;
		}
		
		switch (damage) {
		case 0:
			return getMoldMetaIcon("clay");
		case 1:
			return getMoldMetaIcon("ceramic");
		case 2:
			return getMoldMetaIcon("fired_copper");
		case 3:
			return getMoldMetaIcon("fired_bronze");
		case 4:
			return getMoldMetaIcon("fired_bismuth_bronze");
		case 5:
			return getMoldMetaIcon("fired_black_bronze");
		
		default:
			return this.clayIcon;
		}
	}
	
	private IIcon getMoldMetaIcon(String metaName) {
		for (int i = 0; i < metaNames.length; i++) {
			if (metaNames[i].equals(metaName)) {
				return icons[i];
			}
		}
		
		return this.clayIcon;
	}
	
	@Override
	public void registerIcons(IIconRegister register) {
		String prepend = TNCore.MODID + ":" + textureFolder + getUnlocalizedName().replaceFirst("item.", "");
		
		for (int i = 0; i < metaNames.length; i++) {
			icons[i] = register.registerIcon(prepend + "_" + metaNames[i]);
		}
	}
}