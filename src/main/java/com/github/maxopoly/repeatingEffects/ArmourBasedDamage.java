package com.github.maxopoly.repeatingEffects;

import java.util.LinkedList;

import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import com.github.maxopoly.datarepresentations.Area;
import com.github.maxopoly.datarepresentations.ArmourState;
import com.github.maxopoly.datarepresentations.PlayerEnvironmentState;

public class ArmourBasedDamage extends RepeatingEffect {
	ArmourState as;
	String dmgMsg;
	int dmgAmount;

	public ArmourBasedDamage(JavaPlugin plugin, LinkedList<Area> areas,
			long updatetime, PlayerEnvironmentState pes, ArmourState as,
			String dmgMsg, int dmgAmount) {
		super(plugin, areas, updatetime, pes);
		this.as = as;
		this.dmgAmount = dmgAmount;
		this.dmgMsg = dmgMsg;
	}

	public void applyToPlayer(Player p) {
		if (conditionsMet(p) && as.isPlayerWearingWrongArmour(p)) {
			p.damage((float) dmgAmount);
			if (dmgMsg != null) {
				p.sendMessage(dmgMsg);
			}
		}
	}

}
