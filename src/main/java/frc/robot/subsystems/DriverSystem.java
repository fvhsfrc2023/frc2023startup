package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

public class DriverSystem extends SubsystemBase {
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


    public DriverSystem() {
        this(
            new PWMSparkMax(Constants.Motors.kFrontLeftChannel), Constants.Motors.bFrontLeftInverted,
            new PWMSparkMax(Constants.Motors.kFrontRightChannel), Constants.Motors.bFrontRightInverted,
            new PWMSparkMax(Constants.Motors.kRearLeftChannel), Constants.Motors.bRearLeftInverted,
            new PWMSparkMax(Constants.Motors.kRearRightChannel), Constants.Motors.bRearRightInverted
        );
    }
    
    public DriverSystem(PWMSparkMax frontLeft, boolean flinvert,
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

    public void drive(double speed, double offset) {
        double left_speed = offset + speed;
        double right_speed = -offset + speed;

        m_FrontLeftMotor.set(left_speed);
        m_RearLeftMotor.set(left_speed);
        m_FrontRightMotor.set(right_speed);
        m_RearRightMotor.set(right_speed);
    }
}