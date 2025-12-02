// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.subsystems.Butter;
import frc.robot.subsystems.DriveTrain;
import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.ArcadeDrive;
import frc.robot.commands.Autos;
import frc.robot.commands.ExampleCommand;
import frc.robot.subsystems.ExampleSubsystem;
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
  private final ExampleSubsystem m_exampleSubsystem = new ExampleSubsystem();

  private final Joystick m_controller = new Joystick(0);

  private final DriveTrain m_drivetrain = new DriveTrain();

  private final Butter m_butter = new Butter();

  private final Popcorn m_popcorn = new Popcorn();
  
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
    // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
    new Trigger(m_exampleSubsystem::exampleCondition)
        .onTrue(new ExampleCommand(m_exampleSubsystem));
        m_drivetrain.setDefaultCommand(getArcadeDriveCommand());

    JoystickButton butterIntakeButton = new JoystickButton(m_controller, 3);
    butterIntakeButton.whileTrue(new InstantCommand(() -> m_butter.butterIntake()))
      .onFalse(new InstantCommand(() -> m_butter.stop()));

    JoystickButton butterOutakeButton = new JoystickButton(m_controller, 5);
    butterOutakeButton.whileTrue(new InstantCommand(() -> m_butter.butterOutake()))
      .onFalse(new InstantCommand(() -> m_butter.stop()));

    JoystickButton popcornIntakeButton = new JoystickButton(m_controller, 6);
    popcornIntakeButton.whileTrue(new InstantCommand(() -> m_popcorn.popcornIntake()))
      .onFalse(new InstantCommand(() -> m_popcorn.stopIntake()));

    JoystickButton popcornOutakeButton = new JoystickButton(m_controller, 4);
    popcornOutakeButton.whileTrue(new InstantCommand(() -> m_popcorn.popcornOutake()))
      .onFalse(new InstantCommand(() -> m_popcorn.stopIntake()));

    JoystickButton popcornShooterButton = new JoystickButton(m_controller, 1);
    popcornShooterButton.whileTrue(new InstantCommand(() -> m_popcorn.shooter()))
      .onFalse(new InstantCommand(() -> m_popcorn.stopShooter()));

    JoystickButton popcornIndexerButton = new JoystickButton(m_controller, 2);
    popcornIndexerButton.whileTrue(new InstantCommand(() -> m_popcorn.indexer()))
      .onFalse(new InstantCommand(() -> m_popcorn.stopIndexer()));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return Autos.exampleAuto(m_exampleSubsystem);
  }

   public Command getArcadeDriveCommand() {
    return new ArcadeDrive(
        m_drivetrain, () -> -m_controller.getRawAxis(1), () -> -m_controller.getRawAxis(2));
  }

}
