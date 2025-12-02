// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.PopcornIndexerSubsystem;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class PopcornIndexerCommand extends Command {
  private final PopcornIndexerSubsystem indexer;
  /** Creates a new PopcornIndexerCommand. */
  public PopcornIndexerCommand(PopcornIndexerSubsystem indexer) {
    this.indexer = indexer;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(indexer);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    indexer.startIndexer();
  }
    
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    indexer.stopIndexerMotor();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
