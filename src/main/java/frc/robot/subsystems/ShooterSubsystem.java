// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.VictorSPXControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ShooterSubsystem extends SubsystemBase {
  private final VictorSPX shootMotorSRX;

  /** Creates a new ShooterSubsystem. */
  public ShooterSubsystem() {
    shootMotorSRX = new VictorSPX(Constants.ShooterConstants.SHOOTER_MOTOR_ID);
    shootMotorSRX.setNeutralMode(NeutralMode.Coast);
    shootMotorSRX.setInverted(InvertType.InvertMotorOutput);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setSpeed(double speed) {
    shootMotorSRX.set(VictorSPXControlMode.PercentOutput, speed);
  }

  public void stopMotor() {
    shootMotorSRX.set(ControlMode.PercentOutput, 0);
  }
}
