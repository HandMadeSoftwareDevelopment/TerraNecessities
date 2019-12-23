package com.hm.terranecessities.item;

import com.bioxx.tfc.api.Enums.EnumSize;
import com.bioxx.tfc.api.Enums.EnumWeight;

public class TNICookingPot extends TNIPottery {
	public TNICookingPot() {
		super();
		
		setMaxStackSize(1);
		setSize(EnumSize.MEDIUM);
		setWeight(EnumWeight.HEAVY);
	}
}