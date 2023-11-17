// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

import frc.robot.subsystems.DriveSystem;
import frc.robot.commands.teleop.TeleopDrive;

/** This is a demo program showing how to use Mecanum control with the MecanumDrive class. */
public class Robot extends TimedRobot {
  private final DriveSystem m_DriverSystem = new DriveSystem();
  private final Controller m_Controller = new Controller();

  @Override
  public void robotInit() {
    m_DriverSystem.register();

    SmartDashboard.putString("hi", "world");
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();

    m_Controller.putDebugInfo();
  }

  @Override
  public void teleopPeriodic() {
    
  }


  @Override
  public void teleopInit() {
    CommandScheduler.getInstance().cancelAll();

    CommandScheduler.getInstance().schedule(
      new TeleopDrive(
        m_DriverSystem,
              m_Controller::getVerticleOffset,
              m_Controller::getHorizontalOffset,
              m_Controller::getRotation)
    );
  }

  @Override
  public void autonomousInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void autonomousPeriodic() {
    m_DriverSystem.getMotor(DriveSystem.MotorPlace.RearLeft).set(0.2);
    m_DriverSystem.getMotor(DriveSystem.MotorPlace.RearRight).set(0.2);
    m_DriverSystem.getMotor(DriveSystem.MotorPlace.FrontLeft).set(0.2);
    m_DriverSystem.getMotor(DriveSystem.MotorPlace.FrontRight).set(0.2);
  }
}
