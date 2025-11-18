// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class PopcornShooterSubsystem extends SubsystemBase {
  private Talon ShooterMotor = new Talon(67);// TODO change this.
  /** Creates a new PopcornShooterSubsystem. */
  public PopcornShooterSubsystem() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void startShooter() {
    ShooterMotor.set(Constants.MotorSpeeds.popcornShooterMotorSpeed);
  }

  public void stopShooterMotor() {
    ShooterMotor.set(0);
  }

  public void reverseShooter() {
    ShooterMotor.set(-Constants.MotorSpeeds.popcornShooterMotorSpeed);
  }
}
