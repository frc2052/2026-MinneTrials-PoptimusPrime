// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.DrivetrainSubsystem;

public class ArcadeDriveCommand extends Command {
  DrivetrainSubsystem drivetrain;
  Supplier<Double> speedSupplier;
  Supplier<Double> rotationSupplier;

  /** Creates a new ArcadeDriveCommand. */
  public ArcadeDriveCommand(DrivetrainSubsystem drivetrain, Supplier<Double> speedSupplier, Supplier<Double> rotationSupplier) {
    this.drivetrain = drivetrain;
    this.speedSupplier = speedSupplier;
    this.rotationSupplier = rotationSupplier;
    addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drivetrain.arcadeDrive(speedSupplier.get(), rotationSupplier.get());
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
