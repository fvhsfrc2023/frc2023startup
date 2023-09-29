package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

public class DriveSystem extends SubsystemBase {
    private final PWMSparkMax m_FrontLeftMotor;
    private final PWMSparkMax m_FrontRightMotor;
    private final PWMSparkMax m_RearLeftMotor;
    private final PWMSparkMax m_RearRightMotor;


    public static enum MotorPlace {
        FrontLeft,
        FrontRight,
        RearLeft,
        RearRight
    }

    
    public DriveSystem() {
        
        m_FrontLeftMotor = new PWMSparkMax(Constants.Motors.kFrontLeftChannel);
        m_FrontRightMotor = new PWMSparkMax(Constants.Motors.kFrontRightChannel);
        m_RearLeftMotor = new PWMSparkMax(Constants.Motors.kRearLeftChannel);
        m_RearRightMotor = new PWMSparkMax(Constants.Motors.kRearRightChannel);

        m_FrontLeftMotor.setInverted(Constants.Motors.bFrontLeftInverted);
        m_FrontRightMotor.setInverted(Constants.Motors.bFrontRightInverted);
        m_RearLeftMotor.setInverted(Constants.Motors.bRearLeftInverted);
        m_RearRightMotor.setInverted(Constants.Motors.bRearRightInverted);
    }

    @Override
    public void periodic() {
    }

    public PWMSparkMax getMotor(MotorPlace mp) {
        switch (mp) {
            case FrontLeft:
                return m_FrontLeftMotor;
            case FrontRight:
                return m_FrontRightMotor;
            case RearLeft:
                return m_RearLeftMotor;
            case RearRight:
                return m_RearRightMotor;
            default:
                return null;
        }
    }

    public void drive(double vspeed, double hspeed, double rotation) {
        double fl_speed = vspeed;
        double rl_speed = vspeed;
        double fr_speed = vspeed;
        double rr_speed = vspeed;

        fl_speed *= Math.abs(fl_speed);
        rl_speed *= Math.abs(rl_speed);
        fr_speed *= Math.abs(fr_speed);
        rr_speed *= Math.abs(rr_speed);

        fl_speed *= Math.min(1, 2 * rotation + 1);
        rl_speed *= Math.min(1, 2 * rotation + 1);
        fr_speed *= Math.min(1, -2 * rotation + 1);
        rr_speed *= Math.min(1, -2 * rotation + 1);

        fl_speed += -hspeed * Math.abs(hspeed);
        rl_speed += hspeed * Math.abs(hspeed);
        fr_speed += hspeed * Math.abs(hspeed);
        rr_speed += -hspeed * Math.abs(hspeed);

        m_FrontLeftMotor.set(fl_speed);
        m_RearLeftMotor.set(rl_speed);
        m_FrontRightMotor.set(fr_speed);
        m_RearRightMotor.set(rr_speed);
    }
}