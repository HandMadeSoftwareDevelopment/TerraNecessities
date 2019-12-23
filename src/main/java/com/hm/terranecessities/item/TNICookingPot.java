package com.hm.terranecessities.item;

import com.bioxx.tfc.Items.Pottery.ItemPotteryBase;
import com.bioxx.tfc.api.Enums.EnumSize;
import com.bioxx.tfc.api.Enums.EnumWeight;
import com.bioxx.tfc.api.Interfaces.IBag;
import com.hm.terranecessities.TNCore;
import com.hm.terranecessities.core.TNTabs;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class TNICookingPot extends ItemPotteryBase implements IBag{

	@SideOnly(Side.CLIENT)
	private IIcon overlayIcon;
	
	@Override
	public ItemStack[] loadBagInventory(ItemStack arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public TNICookingPot() {
		super();
		
		metaNames = new String[] { "clay_pot"};
		setMaxStackSize(1);
		setWeight(EnumWeight.HEAVY);
		setSize(EnumSize.MEDIUM);
		setCreativeTab(TNTabs.TN_ITEMS);
		setFolder("pottery/");
	}
	
	@Override
	public void registerIcons(IIconRegister register) {
		
		super.registerIcons(register);
		
		overlayIcon = register.registerIcon(TNCore.MODID + ":" + textureFolder + "clay_pot");
	}
	
	@Override
	public IIcon getIcon(ItemStack stack, int pass) {
		if (pass == 1 && stack.getTagCompound() != null && stack.getTagCompound().hasKey("color"))
			return overlayIcon;
		
		return super.getIcon(stack, pass);
	}

}