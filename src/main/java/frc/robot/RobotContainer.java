// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.FireShooterCommand;
import frc.robot.commands.FullAutosBlue;
import frc.robot.commands.FullAutosRed;
import frc.robot.commands.ReverseIntakeCommand;
import frc.robot.commands.RunButterWheelCommand;
import frc.robot.commands.RunIntakeCommand;
import frc.robot.commands.UnjamShooterCommand;
import frc.robot.commands.drive.ZeroGyroCommand;
import frc.robot.commands.drive.ArcadeDriveCommand;
import frc.robot.commands.drive.DriveDistanceCommand;
import frc.robot.commands.drive.TurnDegreesCommand;
import frc.robot.subsystems.ButterSubsystem;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.IntakeSubsystem;
import frc.robot.subsystems.ShooterSubsystem;

import static edu.wpi.first.units.Units.Meters;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final DrivetrainSubsystem drivetrain = new DrivetrainSubsystem();
  private final ButterSubsystem butter = new ButterSubsystem();
  private final IntakeSubsystem intake = new IntakeSubsystem();
  private final ShooterSubsystem shooter = new ShooterSubsystem();

  private final Joystick leftJoystick = new Joystick(0);
  private final Joystick rightJoystick = new Joystick(1);

  public RobotContainer() {
    drivetrain.setDefaultCommand(
        new ArcadeDriveCommand(drivetrain, leftJoystick::getY, rightJoystick::getX)
    );
    configureBindings();
  }

  private void configureBindings() {
    JoystickButton button1 = new JoystickButton(leftJoystick, 1);
    button1.whileTrue(new RunIntakeCommand(intake));
    
    JoystickButton button2 = new JoystickButton(rightJoystick, 1);
    button2.whileTrue(new FireShooterCommand(shooter));
    
    JoystickButton unjam = new JoystickButton(rightJoystick, 2);
    unjam.whileTrue(new UnjamShooterCommand(shooter));


    JoystickButton button3 = new JoystickButton(leftJoystick, 4);
    button3.whileTrue(new RunButterWheelCommand(butter));

    JoystickButton button4 = new JoystickButton(leftJoystick, 3);
    button4.whileTrue(new ReverseIntakeCommand(intake));

    JoystickButton zeroHeading = new JoystickButton(leftJoystick, 12);
    zeroHeading.onTrue(new ZeroGyroCommand(drivetrain));
  }
  
   /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return new FullAutosRed(drivetrain, butter, shooter);  }
}