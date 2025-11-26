// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.drive;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.Constants.DrivetrainConstants;


/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class TurnDegreesCommand extends Command {
  private final DrivetrainSubsystem drivetrain;
  private final double speed, degrees;

  /** Creates a new TurnDegrees. */
  public TurnDegreesCommand(double speed, double degrees, DrivetrainSubsystem drivetrain) {
    this.drivetrain = drivetrain;
    this.speed = speed;
    this.degrees = degrees;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    drivetrain.arcadeDrive(0,0);
    drivetrain.resetEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drivetrain.arcadeDrive(0, speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drivetrain.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    double inchPerDegree = DrivetrainConstants.WHEEL_CIRCUMFERENCE / 360;
    return getAverageTurningDistance() >= inchPerDegree * degrees;
  }

  private double getAverageTurningDistance() {
    double leftDistance = Math.abs(drivetrain.getLeftEncoderPos());
    double rightDistance = Math.abs(drivetrain.getRightEncoderPos());
    return (leftDistance + rightDistance) / 2.0;
  }
}
