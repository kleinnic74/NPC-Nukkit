package com.GhostKilllaX.NPC;

import cn.nukkit.entity.Rotatable;
import cn.nukkit.math.Vector3;

public class Behaviours {

	public static void lookAt(Rotatable e, Vector3 to) {
		Vector3 direction = to.subtract(e.getPositionVector());
		double r = direction.length();
		double yaw = -Math.atan2(direction.x, direction.z)/Math.PI*180.;
		double pitch = -Math.asin(direction.y/r)/Math.PI*180.;
		e.setRotation(yaw, pitch);
	}
}
