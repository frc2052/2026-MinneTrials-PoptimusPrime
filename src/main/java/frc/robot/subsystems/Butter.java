// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Butter extends SubsystemBase {
  /** Creates a new Butter. */
  public Butter() {}

  private WPI_TalonSRX butter_motor = new WPI_TalonSRX(2);



  public void butterOutake() {

     butter_motor.set(0.1);
    
    }


  public void butterIntake() {

    butter_motor.set(-0.1);

  }

  public void stop() {
    butter_motor.set(0);
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}



/** I currently need to make butter's motor set to 0.1 or -0.1 for intake/outake 
 * please use 
  butter_motor.set(0.1); at some point
*/