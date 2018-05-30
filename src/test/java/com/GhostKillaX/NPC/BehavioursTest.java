package com.GhostKillaX.NPC;

import org.junit.Assert;
import org.junit.Test;

import com.GhostKilllaX.NPC.Behaviours;

import cn.nukkit.entity.Rotatable;
import cn.nukkit.math.Vector3;

public class BehavioursTest {

	private static final class RotatableMock implements Rotatable {
		private Vector3 position;
		private double pitch;
		private double yaw;

		public RotatableMock(double x, double y, double z) {
			this.position = new Vector3(x, y, z);
		}

		@Override
		public Vector3 getPositionVector() {
			return position;
		}

		@Override
		public void setRotation(double yaw, double pitch) {
			this.pitch = pitch;
			this.yaw = yaw;
		}

		@Override
		public double getPitch() {
			return pitch;
		}

		@Override
		public double getYaw() {
			return yaw;
		}
	}

	@Test
	public void lookStraight() {
		Vector3 to = new Vector3(0, 0, 1);
		Rotatable e = new RotatableMock(0., 0., 0.);
		Behaviours.lookAt(e, to);
		Assert.assertEquals(0, e.getPitch(), 0.001);
		Assert.assertEquals(0, e.getYaw(), 0.001);
	}

	@Test
	public void lookRight() {
		Vector3 to = new Vector3(1, 0, 0);
		Rotatable e = new RotatableMock(0., 0., 0.);
		Behaviours.lookAt(e, to);
		Assert.assertEquals(-90, e.getYaw(), 0.001);
	}


	@Test
	public void lookLeft() {
		Vector3 to = new Vector3(-1, 0, 0);
		Rotatable e = new RotatableMock(0., 0., 0.);
		Behaviours.lookAt(e, to);
		Assert.assertEquals(90, e.getYaw(), 0.001);
	}

	@Test
	public void lookBack() {
		Vector3 to = new Vector3(0, 0, -1);
		Rotatable e = new RotatableMock(0., 0., 0.);
		Behaviours.lookAt(e, to);
		Assert.assertEquals(-180, e.getYaw(), 0.001);
	}

	@Test
	public void lookStraightUp() {
		Vector3 to = new Vector3(0, 1, 0);
		Rotatable e = new RotatableMock(0., 0., 0.);
		Behaviours.lookAt(e, to);
		Assert.assertEquals(-90, e.getPitch(), 0.001);
	}

	@Test
	public void lookUp45Degrees() {
		Vector3 to = new Vector3(0, 1, 1);
		Rotatable e = new RotatableMock(0., 0., 0.);
		Behaviours.lookAt(e, to);
		Assert.assertEquals(-45, e.getPitch(), 0.001);
	}

	@Test
	public void lookUpRight45Degrees() {
		Vector3 to = new Vector3(1, 1, 0);
		Rotatable e = new RotatableMock(0., 0., 0.);
		Behaviours.lookAt(e, to);
		Assert.assertEquals(-45, e.getPitch(), 0.001);
	}
		
	@Test
	public void lookUpRight45DegreesFurtherAway() {
		Vector3 to = new Vector3(5, 5, 0);
		Rotatable e = new RotatableMock(0., 0., 0.);
		Behaviours.lookAt(e, to);
		Assert.assertEquals(-45, e.getPitch(), 0.001);
	}
	
	@Test
	public void lookStraightDown() {
		Vector3 to = new Vector3(0, -1, 0);
		Rotatable e = new RotatableMock(0., 0., 0.);
		Behaviours.lookAt(e, to);
		Assert.assertEquals(90, e.getPitch(), 0.001);
	}
}
