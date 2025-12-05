// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.autos.butterAutoCommand;
import frc.robot.subsystems.ButterSubsystem;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Popcorn;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ButterSubsystem m_ButterSubsystem = new ButterSubsystem();
  private final Popcorn m_PopcornSubsystem = new Popcorn();
  private final DriveTrain m_DriveTrainSubsystem = new DriveTrain();

  private final Joystick joystickOne = new Joystick(0);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  }

  /**
   * Use this method to define your trigger->command mappings. Triggers can be created via the
   * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
   * predicate, or via the named factories in {@link
   * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
   * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
   * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
   * joysticks}.
   */
  private void configureBindings() {


    // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
    // cancelling on release.

    JoystickButton ButterButton = new JoystickButton(joystickOne, 3);
    ButterButton.whileTrue(new InstantCommand(() -> m_ButterSubsystem.setSpeed(Constants.ButterConstants.MOTOR_SPEED)))
    .onFalse(new InstantCommand(() -> m_ButterSubsystem.stopMotor()));

    JoystickButton PopcornButton = new JoystickButton(joystickOne, 4);
    PopcornButton.whileTrue(new InstantCommand(() -> m_PopcornSubsystem.popcornMethodCommand()))
    .onFalse(new InstantCommand(() -> m_PopcornSubsystem.stop()));

    m_DriveTrainSubsystem.setDefaultCommand(getAutonomousCommand());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return new butterAutoCommand(true, m_ButterSubsystem);
  }
}
