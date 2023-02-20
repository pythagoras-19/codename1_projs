/**
 * Interface for steering Movable objects.
 */
package com.mycompany.a1;

/**
 * @author mchristiansen
 * This interface allows Movable objects to change their heading to maneuver around the GameWorld.
 */
public interface ISteerable {

	public void steer(int heading);
}
