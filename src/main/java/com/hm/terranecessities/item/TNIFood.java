package com.hm.terranecessities.item;

import com.bioxx.tfc.Food.ItemFoodTFC;
import com.bioxx.tfc.Render.Item.FoodItemRenderer;
import com.bioxx.tfc.api.Enums.EnumFoodGroup;
import com.hm.terranecessities.TNCore;
import com.hm.terranecessities.core.TNTabs;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraftforge.client.MinecraftForgeClient;

public class TNIFood extends ItemFoodTFC {
	public TNIFood(EnumFoodGroup group, int sweet, int sour, int salty, int bitter, int umami, boolean edible, boolean usable) {
		super(group, sweet, sour, salty, bitter, umami, edible, usable);
		
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
		
		if (hasCookedIcon) {
			cookedIcon = register.registerIcon(TNCore.MODID + ":" + textureFolder + getUnlocalizedName().replace("item.", "") + " Cooked");
		}
		
		MinecraftForgeClient.registerItemRenderer(this, new FoodItemRenderer());
	}
}