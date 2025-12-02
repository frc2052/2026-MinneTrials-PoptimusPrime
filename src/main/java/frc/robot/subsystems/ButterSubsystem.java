// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ButterSubsystem extends SubsystemBase {
  /** Creates a new ButterSubsystem. */
  public ButterSubsystem() {

  }

  public final WPI_TalonSRX butterMotor = new WPI_TalonSRX(2);

  public void butterIntake(){
      butterMotor.set(-0.1);

  }

  public void butterOutput(){
      butterMotor.set(0.1);

  }

  public void stop(){
    butterMotor.set(0);

  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
