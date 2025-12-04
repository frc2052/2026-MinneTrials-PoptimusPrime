// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Butter extends SubsystemBase {
  
  private final WPI_TalonSRX m_oneMotor = new WPI_TalonSRX(2);
  /** Creates a new Butter. */
  public Butter() {
      
  }


  public void forward() {
    m_oneMotor.set(0.1);
  }
 public void backward() {
  m_oneMotor.set(0.1);
 }
 public void stop() {
  m_oneMotor.set(0.1);
 }
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }


  public Object butterMethodCommand() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'butterMethodCommand'");
  }
}
