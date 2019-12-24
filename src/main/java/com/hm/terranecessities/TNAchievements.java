package com.hm.terranecessities;

import java.util.ArrayList;
import java.util.List;

import com.bioxx.tfc.api.TFCItems;
import com.hm.terranecessities.item.TNItems;

import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraftforge.common.AchievementPage;

public class TNAchievements {
	private static List<Achievement> achievementList;
	public static Achievement[] achievements;
	
	public static Achievement atSoup, doubleEfficiency;
	
	public static AchievementPage page;
	
	private static Achievement createAchievement(String id, String name, int x, int y, ItemStack stack, Achievement required) {
		Achievement a;
		
		a = new Achievement(id, name, x, y, stack, required).registerStat();
		
		achievementList.add(a);
		
		return a;
	}
	
	public static void registerAchievements() {
		achievementList = new ArrayList<>();
		
		atSoup = createAchievement("achievement.tn_atsoup", "tn_atsoup", 0, 0, new ItemStack(TFCItems.looseRock), null);
		atSoup = createAchievement("achievement.tn_doubleefficiency", "tn_doublefficiency", 0, 0, new ItemStack(TNItems.clayMoldDoubleKnife), null);
		
		achievements = new Achievement[achievementList.size()];
		achievements = achievementList.toArray(achievements);
		
		page = new AchievementPage("TerraNecessities", achievements);
		
		AchievementPage.registerAchievementPage(page);
		
		return;
	}
	
	private TNAchievements() {
	}
}