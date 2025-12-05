// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.drive;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DrivetrainSubsystem;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class DriveDistanceCommand extends Command {
  private final double speed, distance;
  private final DrivetrainSubsystem drivetrain;
  private final boolean isFacingForward;

  /** Creates a new DriveDistance. */
  public DriveDistanceCommand(double speed, boolean isFacingForward, double ft, DrivetrainSubsystem drivetrain) {
    this.drivetrain = drivetrain;
    this.isFacingForward = isFacingForward;
    this.distance = ft;
    this.speed = speed;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    drivetrain.arcadeDrive(0.0,0.0);
    drivetrain.resetEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(isFacingForward) {
      drivetrain.arcadeDrive(speed,0.0); }
    else {
      drivetrain.arcadeDrive(-speed, 0);
    }
  }
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.arcadeDrive(0.0,0.0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Math.abs(drivetrain.getAverageEncoderDistance()) >= distance;
  }
} 