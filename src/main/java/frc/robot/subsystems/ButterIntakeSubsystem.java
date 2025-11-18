// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.Talon;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ButterIntakeSubsystem extends SubsystemBase {
  private Talon butterMotor = new Talon(5);// TODO change this.
  /** Creates a new ButterIntakeOuttakeSubsystem. */
  public ButterIntakeSubsystem() {}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  public void intakeButter(double s) {
    butterMotor.set(s);
  }
  public void stopButter() {
    butterMotor.set(0);
  }




}
