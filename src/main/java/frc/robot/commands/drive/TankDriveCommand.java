// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.drive;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DrivetrainSubsystem;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class TankDriveCommand extends Command {
  
  private final DrivetrainSubsystem drivetrain;
  private final Supplier<Double> leftSpeedSupplier;
  private final Supplier<Double> rightSpeedSupplier; 

  /** Creates a new TankDriveCommand. */
  public TankDriveCommand(DrivetrainSubsystem drivetrain, Supplier<Double> leftSpeed, Supplier<Double> rightSpeed) {
    this.drivetrain = drivetrain;
    leftSpeedSupplier = leftSpeed;
    rightSpeedSupplier = rightSpeed;
    // Use addRequirements() here to declare subsystem dependencies.

    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drivetrain.arcadeDrive(leftSpeedSupplier.get(), rightSpeedSupplier.get());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
