package Emag;

public interface SpeedRole {

  boolean isFasterThan(SpeedRole speed);

	boolean isSlowerThan(SpeedRole speed);

	boolean isFaster(int speedValue);

	boolean isTheSame(int speedValue);

	boolean isSlower(int speedValue);

}