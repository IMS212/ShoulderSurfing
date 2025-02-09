package com.teamderpy.shouldersurfing.config;

import net.minecraft.client.Minecraft;
import net.minecraft.world.phys.HitResult;

public enum CrosshairVisibility
{
	ALWAYS,
	NEVER,
	WHEN_AIMING,
	WHEN_IN_RANGE,
	WHEN_AIMING_OR_IN_RANGE;
	
	public boolean doRender(boolean isAiming)
	{
		if(this == CrosshairVisibility.NEVER)
		{
			return false;
		}
		else if(this == CrosshairVisibility.WHEN_AIMING)
		{
			return isAiming;
		}
		else if(this == CrosshairVisibility.WHEN_IN_RANGE)
		{
			return Minecraft.getInstance().hitResult != null && !HitResult.Type.MISS.equals(Minecraft.getInstance().hitResult.getType());
		}
		else if(this == CrosshairVisibility.WHEN_AIMING_OR_IN_RANGE)
		{
			return CrosshairVisibility.WHEN_IN_RANGE.doRender(isAiming) || CrosshairVisibility.WHEN_AIMING.doRender(isAiming);
		}
		
		return true;
	}
}