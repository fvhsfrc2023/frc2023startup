package frc.robot.commands.teleop;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.DriveSystem;

public class TeleopDrive extends CommandBase {
    private final DriveSystem m_DriverSystem;
    private final Supplier<Double> getSpeed;
    private final Supplier<Double> getHSpeed;
    private final Supplier<Double> getRotation;

    public TeleopDrive(DriveSystem driverSystem, Supplier<Double> getSpeed, Supplier<Double> getHspeed, Supplier<Double> getRotation) {
        this.m_DriverSystem = driverSystem;
        this.getSpeed = getSpeed;
        this.getHSpeed = getHspeed;
        this.getRotation = getRotation;

        addRequirements(m_DriverSystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        m_DriverSystem.drive(getSpeed.get(), getHSpeed.get(), getRotation.get());

        SmartDashboard.putNumber("getSpeed", getSpeed.get());
        SmartDashboard.putNumber("getOffset", getRotation.get());
    }

    @Override
    public void end(boolean interupted) {

    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
