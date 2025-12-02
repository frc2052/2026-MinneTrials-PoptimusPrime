// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class PopcornSubsytem extends SubsystemBase {
  /** Creates a new PopcornSubsytem. */
  public PopcornSubsytem() {}

  private WPI_TalonSRX popcornIntakeMotor = new WPI_TalonSRX(3);
  private WPI_TalonSRX popcornShooterMotor = new WPI_TalonSRX(4);
  private WPI_TalonSRX popcornIndexerMotor = new WPI_TalonSRX(5);


  public void popcornIntake() {
    popcornIntakeMotor.set(0.1);

  }

  public void popcornOutake(){
    popcornIntakeMotor.set(-0.1);

  }

 public void popcornIndexer(){
  popcornIndexerMotor.set (0.1);

 }

 public void popcornShooter(){
  popcornShooterMotor.set(0.1);

 }

 public void stopIntake(){
  popcornIntakeMotor.set(0);

 }

 public void stopIndexer(){
  popcornIndexerMotor.set(0);

 }

 public void stopShooter(){
  popcornShooterMotor.set(0);

 }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
