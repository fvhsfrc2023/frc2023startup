package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Constants;

public class Controller {
    private final Joystick m_Joystick;


    public Controller() {
        m_Joystick = new Joystick(Constants.Joystick.kJoyStickPort);
        
        m_Joystick.setXChannel(Constants.Joystick.kXChannel);
        m_Joystick.setYChannel(Constants.Joystick.kYChannel);
        m_Joystick.setZChannel(Constants.Joystick.kZChannel);
    }

    public void putDebugInfo() {
        SmartDashboard.putNumber("X", getVerticleOffset());
        SmartDashboard.putNumber("Y", getHorizontalOffset());
        SmartDashboard.putNumber("Z", getRotation());
    }

    public double getVerticleOffset() {
        return Math.abs(m_Joystick.getY()) > Constants.Joystick.fYDeadZone ? m_Joystick.getY() : 0;
    }

    public double getHorizontalOffset() {
        return Math.abs(m_Joystick.getX()) > Constants.Joystick.fYDeadZone ? m_Joystick.getX() : 0;
    }

    public double getRotation() {
        return Math.abs(m_Joystick.getZ()) > Constants.Joystick.fYDeadZone ? m_Joystick.getZ() : 0;
    }
}
