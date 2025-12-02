// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.ArcadeDriveCommand;
import frc.robot.commands.Autos;
import frc.robot.commands.ButterIntakeCommand;
import frc.robot.commands.ButterIntakeReverseCommand;
import frc.robot.commands.ExampleCommand;
import frc.robot.commands.PopcornIndexerCommand;
import frc.robot.commands.PopcornIntakeCommand;
import frc.robot.commands.PopcornIntakeReverseCommand;
import frc.robot.commands.PopcornShooterCommand;
import frc.robot.commands.PopcornShooterReverseCommand;
import frc.robot.subsystems.ButterIntakeSubsystem;
import frc.robot.subsystems.DrivetrainSubsystem;
import frc.robot.subsystems.ExampleSubsystem;
import frc.robot.subsystems.PopcornIndexerSubsystem;
import frc.robot.subsystems.PopcornIntakeSubsystem;
import frc.robot.subsystems.PopcornShooterSubsystem;
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
  private final DrivetrainSubsystem drivetrainSubsystem;
  private final ButterIntakeSubsystem butterIntake;
  private final PopcornIndexerSubsystem popcornIndexer;
  private final PopcornShooterSubsystem popcornShooter;
  private final PopcornIntakeSubsystem popcornIntake;

  private final Joystick joystick1 = new Joystick(0);

  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController m_driverController =
      new CommandXboxController(OperatorConstants.kDriverControllerPort);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    drivetrainSubsystem = new DrivetrainSubsystem();
    butterIntake = new ButterIntakeSubsystem();
    popcornIndexer = new PopcornIndexerSubsystem();
    popcornShooter = new PopcornShooterSubsystem();
    popcornIntake = new PopcornIntakeSubsystem();
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
    drivetrainSubsystem.setDefaultCommand(
      new ArcadeDriveCommand(
        drivetrainSubsystem,
        () -> joystick1.getY(),
        () -> joystick1.getX()
      )
    );
    JoystickButton shootButton = new JoystickButton(joystick1, 1);
    shootButton.whileTrue(new PopcornShooterCommand(popcornShooter));
    JoystickButton outShootButton = new JoystickButton(joystick1, 2);
    outShootButton.whileTrue(new PopcornShooterReverseCommand(popcornShooter));
    JoystickButton pIntakeButton = new JoystickButton(joystick1, 3);
    pIntakeButton.whileTrue(new PopcornIntakeCommand(popcornIntake));
    JoystickButton pOuttakeButton = new JoystickButton(joystick1, 5);
    pOuttakeButton.whileTrue(new PopcornIntakeReverseCommand(popcornIntake));
    JoystickButton budaButton = new JoystickButton(joystick1, 4);
    budaButton.whileTrue(new ButterIntakeCommand(butterIntake));
    JoystickButton budaOuttakeButton = new JoystickButton(joystick1, 6);
    budaOuttakeButton.whileTrue(new ButterIntakeReverseCommand(butterIntake));

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return new InstantCommand();
  }
}
