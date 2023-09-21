package frc.robot;

public class Constants {
    public static class Motors {
        public static final int kFrontLeftChannel = 1;
        public static final int kRearLeftChannel = 0;
        public static final int kFrontRightChannel = 3;
        public static final int kRearRightChannel = 2;

        public static final boolean bFrontLeftInverted = false;
        public static final boolean bRearLeftInverted = false;
        public static final boolean bFrontRightInverted = true;
        public static final boolean bRearRightInverted = true;
    }

    public static class Joystick {
        public static final int kJoyStickPort = 0;
        
        public static final int kXChannel = 0;
        public static final int kYChannel = 1;
        public static final int kZChannel = 4;

        public static final double fXDeadZone = 0.1;
        public static final double fYDeadZone = 0.1;
        public static final double fZDeadZone = 0.1;
    }
}
