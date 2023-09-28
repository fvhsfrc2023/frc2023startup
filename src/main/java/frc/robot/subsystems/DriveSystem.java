package frc.robot.subsystems;

import java.sql.Blob;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
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
        this(
            new PWMSparkMax(Constants.Motors.kFrontLeftChannel), Constants.Motors.bFrontLeftInverted,
            new PWMSparkMax(Constants.Motors.kFrontRightChannel), Constants.Motors.bFrontRightInverted,
            new PWMSparkMax(Constants.Motors.kRearLeftChannel), Constants.Motors.bRearLeftInverted,
            new PWMSparkMax(Constants.Motors.kRearRightChannel), Constants.Motors.bRearRightInverted
        );
    }
    
    public DriveSystem(PWMSparkMax frontLeft, boolean flinvert,
                        PWMSparkMax frontRight, boolean frinvert,
                        PWMSparkMax rearLeft, boolean rlinvert,
                        PWMSparkMax rearRight, boolean rrinvert) {
        
        m_FrontLeftMotor = frontLeft;
        m_FrontRightMotor = frontRight;
        m_RearLeftMotor = rearLeft;
        m_RearRightMotor = rearRight;

        m_FrontLeftMotor.setInverted(flinvert);
        m_FrontRightMotor.setInverted(frinvert);
        m_RearLeftMotor.setInverted(rlinvert);
        m_RearRightMotor.setInverted(rrinvert);
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
        
        double fLPower = vspeed + rotation + hspeed;
        double fRPower = vspeed - rotation - hspeed;
        double bLPower = vspeed + rotation - hspeed;
        double bRPower = vspeed - rotation + hspeed;

        double denominator = Math.max(Math.abs(vspeed) + Math.abs(rotation) + Math.abs(hspeed), 1);
        fLPower /= denominator;
        fRPower /= denominator;
        bLPower /= denominator;
        bRPower /= denominator;
        m_FrontLeftMotor.set(fLPower);
        m_FrontRightMotor.set(fRPower);
        m_RearLeftMotor.set(bLPower);
        m_RearRightMotor.set(bRPower);

    }
}