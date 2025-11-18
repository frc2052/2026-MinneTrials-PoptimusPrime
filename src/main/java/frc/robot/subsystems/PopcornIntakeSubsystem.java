// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class PopcornIntakeSubsystem extends SubsystemBase {
  private Talon intakeMotor = new Talon(3);// TODO change this.
  /** Creates a new PopcornIntake. */
  public PopcornIntakeSubsystem() {
    
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void startIntake() {
    intakeMotor.set(Constants.MotorSpeeds.popcornIntakeMotorSpeed);
  }

  public void stopIntakeMotor() {
    intakeMotor.set(0);
  }

  public void startOuttake() {
    intakeMotor.set(-Constants.MotorSpeeds.popcornIntakeMotorSpeed);
  }
}
