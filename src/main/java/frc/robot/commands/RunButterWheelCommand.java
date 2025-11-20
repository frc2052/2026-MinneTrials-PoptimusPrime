// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.ButterSubsystem;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class RunButterWheel extends Command {
  private final ButterSubsystem butter;

  /** Creates a new RunButterWheel. */
  public RunButterWheel(ButterSubsystem butter) {
    this.butter = butter;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(butter);
  } 

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    butter.setSpeed(Constants.ButterConstants.MOTOR_SPEED);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    butter.stopMotor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
