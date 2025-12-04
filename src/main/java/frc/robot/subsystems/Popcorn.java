// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Popcorn extends SubsystemBase {
  
  private final WPI_TalonSRX m_intakeMotor = new WPI_TalonSRX(3);
  
  public void intakeforward() {
    m_intakeMotor.set(0.1);
  }
  public void intakebackward() {
    m_intakeMotor.set(0.1);
   }
   private final WPI_TalonSRX m_shooterMotor = new WPI_TalonSRX(4);

   public void shooterforward() {
    m_shooterMotor.set(0.1);
  }
  public void shooterbackward() {
    m_shooterMotor.set(0.1);
   }
   private final WPI_TalonSRX m_indexerMotor = new WPI_TalonSRX(5);
   public void indexerforward() {
    m_indexerMotor.set(0.1);
  }
  public void indexerbackward() {
    m_indexerMotor.set(0.1);
   }
  /** Creates a new Popcorn. */
  public Popcorn() {
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  
  }
public Object popcornMethodCommand() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'popcornMethodCommand'");
}
public Object stop() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'stop'");
}
}
