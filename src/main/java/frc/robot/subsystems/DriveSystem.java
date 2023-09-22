package frc.robot.subsystems;

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
        double left_coef = rotation < 0 ? 1 + rotation : 1;
        double right_coef = rotation > 0 ? 1 - rotation : 1;

        double fl_speed = vspeed * left_coef - hspeed;
        double rl_speed = vspeed * left_coef + hspeed;
        double fr_speed = vspeed * right_coef + hspeed;
        double rr_speed = vspeed * right_coef - hspeed;

        m_FrontLeftMotor.set(Math.abs(fl_speed) > 1 ? Math.abs(fl_speed) / fl_speed : fl_speed);
        m_FrontRightMotor.set(Math.abs(fr_speed) > 1 ? Math.abs(fr_speed) / fr_speed : fr_speed);
        m_RearLeftMotor.set(Math.abs(rl_speed) > 1 ? Math.abs(rl_speed) / rl_speed : rl_speed);
        m_RearRightMotor.set(Math.abs(rr_speed) > 1 ? Math.abs(rr_speed) / rr_speed : rr_speed);
    }
}