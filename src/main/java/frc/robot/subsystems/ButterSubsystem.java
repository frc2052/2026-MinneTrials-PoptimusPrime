// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ButterSubsystem extends SubsystemBase {
  private final WPI_TalonSRX butterMotorSRX;

  /** Creates a new ButterSubsystem. */
  public ButterSubsystem() {
    butterMotorSRX = new WPI_TalonSRX(Constants.ButterConstants.BUTTER_MOTOR_ID);
    butterMotorSRX.setNeutralMode(NeutralMode.Brake);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setSpeed(double speed) {
    butterMotorSRX.set(speed);
  }

  public void stopMotor() {
    butterMotorSRX.set(ControlMode.PercentOutput, 0);
  }
}
