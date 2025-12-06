// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import static edu.wpi.first.units.Units.Meters;

import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.drive.DriveDistanceCommand;
import frc.robot.commands.drive.TurnDegreesCommand;
import frc.robot.subsystems.ButterSubsystem;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class FullAutosBlue extends SequentialCommandGroup {
  
  /** Creates a new FullAutos. */
  public FullAutosBlue(DrivetrainSubsystem drivetrain, ButterSubsystem butter, ShooterSubsystem shooter) {

    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new InstantCommand(() -> drivetrain.zeroHeading()),
      Commands.waitSeconds(0.25),
      new DriveDistanceCommand(Meters.of(1.25), drivetrain),
      new TurnDegreesCommand(drivetrain, 90, false),
      new RunButterWheelCommand(butter).withTimeout(1.0),
      new TurnDegreesCommand(drivetrain, 0, true),
      new AutoShootCommand(shooter, 7));
  }
}
