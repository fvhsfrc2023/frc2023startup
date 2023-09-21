package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

public class TankDriveSystem extends SubsystemBase {
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


    public TankDriveSystem() {
        this(
            new PWMSparkMax(Constants.Motors.kFrontLeftChannel), Constants.Motors.bFrontLeftInverted,
            new PWMSparkMax(Constants.Motors.kFrontRightChannel), Constants.Motors.bFrontRightInverted,
            new PWMSparkMax(Constants.Motors.kRearLeftChannel), Constants.Motors.bRearLeftInverted,
            new PWMSparkMax(Constants.Motors.kRearRightChannel), Constants.Motors.bRearRightInverted
        );
    }
    
    public TankDriveSystem(PWMSparkMax frontLeft, boolean flinvert,
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
        double left_speed_coef = offset < 0 ? 1 - offset * -1 : 1;
        double right_speed_coef = offset > 0 ? 1 - offset * 1 : 1;

        m_FrontLeftMotor.set(speed * left_speed_coef);
        m_RearLeftMotor.set(speed * left_speed_coef);
        m_FrontRightMotor.set(speed * right_speed_coef);
        m_RearRightMotor.set(speed * right_speed_coef);
    }
}