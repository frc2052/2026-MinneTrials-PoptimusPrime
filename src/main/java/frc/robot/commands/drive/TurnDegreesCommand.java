// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.drive;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DrivetrainSubsystem;

public class TurnDegreesCommand extends Command {
  private double heading;
  private final DrivetrainSubsystem drivetrain;
  private boolean clockwise;

  public TurnDegreesCommand(DrivetrainSubsystem drivetrain, double heading, boolean clockwise) {
    this.drivetrain = drivetrain;
    this.heading = heading;
    this.clockwise = clockwise;
    addRequirements(drivetrain);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    if(clockwise == true){
      drivetrain.arcadeDrive(0, -0.75);
    } else {
      drivetrain.arcadeDrive(0, 0.75);
    }
  }

  @Override
  public void end(boolean interrupted) {
    drivetrain.tankDrive(0, 0);
  }

  @Override
  public boolean isFinished() {
    if (MathUtil.isNear(heading, drivetrain.getGyroAngleDegrees(), 7)) {
      return true;
    } else {
      return false;
    }
  }
}

