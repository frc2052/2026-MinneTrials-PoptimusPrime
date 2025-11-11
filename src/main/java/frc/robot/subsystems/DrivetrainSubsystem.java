// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix6.hardware.Pigeon2;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.DrivetrainConstants;

public class DrivetrainSubsystem extends SubsystemBase {
  /** Creates a new DrivetrainSubsystem. */
  private final Pigeon2 pigeonGyro;

  private final WPI_TalonSRX leftMotorSRX;
  private final WPI_TalonSRX rightMotorSRX;
  
  private final DifferentialDriveOdometry odometry;
  private final DifferentialDrive diffDrive;

  public DrivetrainSubsystem() {
    leftMotorSRX = new WPI_TalonSRX(DrivetrainConstants.LEFT_MOTOR_ID);
    rightMotorSRX = new WPI_TalonSRX(DrivetrainConstants.RIGHT_MOTOR_ID);
    pigeonGyro = new Pigeon2(DrivetrainConstants.PIGEON_ID);

    leftMotorSRX.configFactoryDefault();
    rightMotorSRX.configFactoryDefault();

    leftMotorSRX.setSafetyEnabled(true);
    rightMotorSRX.setSafetyEnabled(true);

    leftMotorSRX.setExpiration(0.1);
    rightMotorSRX.setExpiration(0.1);

    leftMotorSRX.configSelectedFeedbackSensor(
      FeedbackDevice.QuadEncoder,
      DrivetrainConstants.VELOCITY_CONTROL_SLOT,
      DrivetrainConstants.CAN_TIMEOUT);

    rightMotorSRX.configSelectedFeedbackSensor(
      FeedbackDevice.QuadEncoder,
      DrivetrainConstants.VELOCITY_CONTROL_SLOT,
      DrivetrainConstants.CAN_TIMEOUT);

    leftMotorSRX.setNeutralMode(NeutralMode.Brake);
    rightMotorSRX.setNeutralMode(NeutralMode.Brake);

    leftMotorSRX.setSensorPhase(true);
    rightMotorSRX.setSensorPhase(true);

    leftMotorSRX.setInverted(true);
    rightMotorSRX.setInverted(false);



    diffDrive = new DifferentialDrive(leftMotorSRX, rightMotorSRX);

    odometry = new DifferentialDriveOdometry(
      Rotation2d.fromDegrees(getGyroAngleDegrees()),
      null,
      null);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    System.out.println(getGyroAngleDegrees());
  }

  // ------ ENCODER METHODS ------ //
  public double getLeftEncoderPos() {
    return leftMotorSRX.getSelectedSensorPosition();
  }

  public double getRightEncoderPos() {
    return rightMotorSRX.getSelectedSensorPosition();
  }

  // ------ GYRO METHODS ------ //
  public void zeroHeading() {
    System.out.println("GYRO ZEROED");
    pigeonGyro.reset();
  }

  public double getGyroAngleDegrees() {
    return pigeonGyro.getYaw().getValueAsDouble();
  }

  public double getGyroAngleRadians() {
    return Math.toRadians(getGyroAngleDegrees());
  }

  // ------ DRIVE METHODS ------ //
  public void arcadeDrive(double fwd, double rot) {
    diffDrive.arcadeDrive(fwd, rot);
    diffDrive.feed();
  }

  public void tankDrive(double leftSpeed, double rightSpeed) {
    diffDrive.tankDrive(leftSpeed, rightSpeed);
    diffDrive.feed();
  }
}
