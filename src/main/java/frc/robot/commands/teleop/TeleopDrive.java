package frc.robot.commands.teleop;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.subsystems.DriveSystem;

public class TeleopDrive extends CommandBase {
    private final DriveSystem m_DriverSystem;
    private final Supplier<Double> getSpeed;
    private final Supplier<Double> getOffset;

    public TeleopDrive(DriveSystem driverSystem, Supplier<Double> getSpeed, Supplier<Double> getOffset) {
        this.m_DriverSystem = driverSystem;
        this.getSpeed = getSpeed;
        this.getOffset = getOffset;

        addRequirements(m_DriverSystem);
    }

    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        m_DriverSystem.drive(getSpeed.get(), getOffset.get());

        SmartDashboard.putNumber("getSpeed", getSpeed.get());
        SmartDashboard.putNumber("getOffset", getOffset.get());
    }

    @Override
    public void end(boolean interupted) {

    }

    @Override
    public boolean isFinished() {
        return false;
    }
}
