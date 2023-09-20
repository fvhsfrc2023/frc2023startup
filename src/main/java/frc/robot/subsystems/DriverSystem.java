package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;

import frc.robot.Constants.Motors;;

public class DriverSystem {
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
            new PWMSparkMax(Motors.kFrontLeftChannel), Motors.kFrontLeftInverted,
            new PWMSparkMax(Motors.kFrontRightChannel), Motors.kFrontRightInverted,
            new PWMSparkMax(Motors.kRearLeftChannel), Motors.kRearLeftInverted,
            new PWMSparkMax(Motors.kRearRightChannel), Motors.kRearRightInverted
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

    public void drive(double forward, double offset) {

    }
}