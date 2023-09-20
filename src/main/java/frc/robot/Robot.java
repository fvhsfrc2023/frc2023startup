// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;

import frc.robot.subsystems.DriverSystem;

/** This is a demo program showing how to use Mecanum control with the MecanumDrive class. */
public class Robot extends TimedRobot {
  private final DriverSystem m_DriverSystem = new DriverSystem();

  @Override
  public void robotInit() {

  }

  @Override
  public void teleopPeriodic() {
    
  }


  @Override
  public void autonomousPeriodic() {
    m_DriverSystem.getMotor(DriverSystem.MotorPlace.RearLeft).set(0.2);
    m_DriverSystem.getMotor(DriverSystem.MotorPlace.RearRight).set(0.2);
    m_DriverSystem.getMotor(DriverSystem.MotorPlace.FrontLeft).set(0.2);
    m_DriverSystem.getMotor(DriverSystem.MotorPlace.FrontRight).set(0.2);
  }
}
