package frc.robot;

public class Constants {
    public static class Motors {
        public static final int kFrontLeftChannel = 1;
        public static final int kRearLeftChannel = 3;
        public static final int kFrontRightChannel = 0;
        public static final int kRearRightChannel = 2;

        public static final boolean bFrontLeftInverted = true;
        public static final boolean bRearLeftInverted = true;
        public static final boolean bFrontRightInverted = false;
        public static final boolean bRearRightInverted = false;
    }

    public static class Joystick {
        public static final int kJoyStickPort = 0;
        
        public static final int kXChannel = 0;
        public static final int kYChannel = 1;
        public static final int kZChannel = 4;

        public static final double fXDeadZone = 0.2;
        public static final double fYDeadZone = 0.2;
        public static final double fZDeadZone = 0.2;
    }
}
