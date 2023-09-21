// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandScheduler;

import frc.robot.subsystems.TankDriveSystem;
import frc.robot.commands.teleop.TeleopDrive;

/** This is a demo program showing how to use Mecanum control with the MecanumDrive class. */
public class Robot extends TimedRobot {
  private final TankDriveSystem m_DriverSystem = new TankDriveSystem();
  private final Controller m_Controller = new Controller();

  @Override
  public void robotInit() {
    m_DriverSystem.register();

    SmartDashboard.putString("hi", "world");
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
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
        () -> m_Controller.getVerticleOffset(), 
        () -> m_Controller.getRotation())
    );
  }

  @Override
  public void autonomousInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void autonomousPeriodic() {
    m_DriverSystem.getMotor(TankDriveSystem.MotorPlace.RearLeft).set(0.2);
    m_DriverSystem.getMotor(TankDriveSystem.MotorPlace.RearRight).set(0.2);
    m_DriverSystem.getMotor(TankDriveSystem.MotorPlace.FrontLeft).set(0.2);
    m_DriverSystem.getMotor(TankDriveSystem.MotorPlace.FrontRight).set(0.2);
  }
}
