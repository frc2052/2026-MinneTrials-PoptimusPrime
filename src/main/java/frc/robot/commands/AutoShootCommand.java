// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.IndexerSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class AutoShootCommand extends Command {
  private final IndexerSubsystem indexer;
  private final ShooterSubsystem shooter;
  private final Timer timer;
  private final double time;

  /** Creates a new AutoShootCommand. */
  public AutoShootCommand(IndexerSubsystem indexer, ShooterSubsystem shooter, double time) {
    this.indexer = indexer;
    this.shooter = shooter;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(indexer, shooter);
    this.timer = new Timer();
    this.time = time;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if(timer.get() < 1.5) {
      new RunIndexerCommand(indexer);
    } else if(timer.get() < 5) {
      new FireShooterCommand(shooter);
    } else {
      timer.reset();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (timer.hasElapsed(time)) {
      return true;
    } else {
      return false;
    }
  }
}
