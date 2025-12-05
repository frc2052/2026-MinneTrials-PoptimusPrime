// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.util.Units;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class DrivetrainConstants {
    public static final int LEFT_MOTOR_ID = 0;
    public static final int RIGHT_MOTOR_ID = 1;

    public static final int VELOCITY_CONTROL_SLOT = 0;
    public static final int CAN_TIMEOUT = 20;
    public static final int TICKS_PER_ROTATION = 1024;
    public static final double WHEEL_DIAMETER = Units.inchesToMeters(5.9);
    public static final double WHEEL_CIRCUMFERENCE = Math.PI * WHEEL_DIAMETER;
  }

  public static class ButterConstants {
    public static final int BUTTER_MOTOR_ID = 2;
    public static final double MOTOR_SPEED = 1;
  }

  public static class IntakeConstants {
    public static final int INTAKE_MOTOR_ID = 4;
    public static final double INTAKE_SPEED = 1.0;
    public static final double OUTTAKE_SPEED = -1.0;
  }

  public static class ShooterConstants {
    public static final int SHOOTER_MOTOR_ID = 5;
    public static final double SHOT_SPEED = 1;
  }
}