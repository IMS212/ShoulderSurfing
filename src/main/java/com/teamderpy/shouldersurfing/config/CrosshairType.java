package com.teamderpy.shouldersurfing.config;

import com.teamderpy.shouldersurfing.util.ShoulderSurfingHelper;

public enum CrosshairType
{
	ADAPTIVE,
	DYNAMIC,
	STATIC,
	STATIC_WITH_1PP;
	
	public boolean isDynamic()
	{
		if(this == CrosshairType.ADAPTIVE)
		{
			return ShoulderSurfingHelper.isHoldingSpecialItem();
		}
		else if(this == CrosshairType.DYNAMIC)
		{
			return true;
		}
		
		return false;
	}
	
	public boolean doSwitchPerspective()
	{
		if(this == CrosshairType.STATIC_WITH_1PP)
		{
			return ShoulderSurfingHelper.isHoldingSpecialItem();
		}
		
		return false;
	}
}