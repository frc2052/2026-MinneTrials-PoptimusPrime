// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.autos;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Constants;
import frc.robot.subsystems.ButterSubsystem;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class butterAutoCommand extends SequentialCommandGroup {
  /** Creates a new butterAutoCommand. */
  public butterAutoCommand(boolean isRed, ButterSubsystem butter) {
    // Use addRequirements() here to declare subsystem dependencies.

    //drive forward five feet
    if (isRed) {
      //turn right 90 degrees  
    } else {
      //turn left 90 degrees
    }
    // move forward 
    addCommands(new InstantCommand(() -> butter.setSpeed(Constants.ButterConstants.MOTOR_SPEED)).withTimeout(5)); 
    addCommands(new InstantCommand(() -> butter.stopMotor()));

  }

}
