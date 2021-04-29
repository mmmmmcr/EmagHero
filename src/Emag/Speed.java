package Emag;

/**
 * The speed of a player
 * @author mircea_badoi
 *
 */
public class Speed implements SpeedRole {
  
  /**
   * The value of the speed
   */
  protected int speedValue;
  
  /**
   * Public constructor
   * @param speedValue The value of the speed
   */
  public Speed(int speedValue) {
    this.speedValue = speedValue;
  }
  
  /**
   * True if the value hold by this object is greater than the value of the given {@link SpeedRole}
   * @param theOtherSpeed Object to compare to
   */
  @Override
  public boolean isFasterThan(SpeedRole theOtherSpeed) {
    if (theOtherSpeed.isTheSame(speedValue)) {
      return false;
    }
    if (theOtherSpeed.isSlower(speedValue)) {
      return true;
    }
    return false;
  }
  
  /**
   * True if the value hold by this object is less than the value of the given {@link SpeedRole}
   * @param Object to compare to
   */
  @Override
  public boolean isSlowerThan(SpeedRole theOtherSpeed) {
    if (theOtherSpeed.isTheSame(speedValue)) {
      return false;
    }
    if (theOtherSpeed.isFaster(speedValue)) {
      return true;
    }
    return false;
  }
  
  /**
   * True if the speed value is greater than the given value
   * @param The speed to compare to
   */
  @Override
  public boolean isFaster(int speedValue) {
    return this.speedValue > speedValue;
  }
  
  /**
   * True if the speed value is the same with the  given value
   * @param The speed to compare to
   */
  @Override
  public boolean isTheSame(int speedValue) {
    return this.speedValue == speedValue;
  }
  
  /**
   * True if the speed value is less than the given value
   * @param The speed to compare to
   */
  @Override
  public boolean isSlower(int speedValue) {

    return this.speedValue < speedValue;
  }

}