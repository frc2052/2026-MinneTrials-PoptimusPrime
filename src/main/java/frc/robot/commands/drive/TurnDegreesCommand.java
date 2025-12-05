// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.drive;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.DrivetrainSubsystem;

public class TurnDegreesCommand extends Command {
  private double degChangeReq;
  private double initialDegreeVal;
  private DrivetrainSubsystem drivetrain;
  private boolean clockwise;

  /** Creates a new RotateSetDegrees. */
  public TurnDegreesCommand(DrivetrainSubsystem drivetrain, double degreesRequested, boolean clockwise) {
    this.drivetrain = drivetrain;
    degChangeReq = degreesRequested;
    initialDegreeVal = 0.0;
    this.clockwise = clockwise;
  }

  @Override
  public void initialize() {
      initialDegreeVal = drivetrain.getGyroAngleDegrees();
  }

  @Override
  public void execute() { // add math for direction
    
    if(clockwise == true){
      drivetrain.arcadeDrive(0, -0.7);
    } else {
      drivetrain.arcadeDrive(0, 0.7);
    }
  }

  @Override
  public void end(boolean interrupted) {
    drivetrain.arcadeDrive(0, 0);
    new InstantCommand(() -> drivetrain.zeroAll());
  }

  @Override
  public boolean isFinished() {
    System.out.println("GYRO DEGREES: " + drivetrain.getGyroAngleDegrees());
    System.out.println("REQUEST DEGREE: " + initialDegreeVal + degChangeReq);
    if(drivetrain.getGyroAngleDegrees() < (initialDegreeVal + degChangeReq)){
      return false;
    } else {
      System.out.println("===== STOP ROTATING");
      return true;
    }
  }
}

