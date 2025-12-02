// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class PopcornIndexerSubsystem extends SubsystemBase {
  private Talon indexerMotor = new Talon(4);// TODO change this.
  /** Creates a new PopcornIndexer. */
  public PopcornIndexerSubsystem() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void startIndexer() {
    indexerMotor.set(Constants.MotorSpeeds.popcornIndexerMotorSpeed);
  }
  

  public void stopIndexerMotor() {
    indexerMotor.set(0);
  }

  public void startOutdexer() { //reverse indexer (I can spell)
    indexerMotor.set(-Constants.MotorSpeeds.popcornIndexerMotorSpeed);
  }
}

