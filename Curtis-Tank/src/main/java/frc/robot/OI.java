package frc.robot;
import edu.wpi.first.wpilibj.Joystick;

public class OI {
    static Joystick controller = new Joystick(0);

    public static void OIPeriodic(){
        // Drive.move(controller.getRawAxis(1), controller.getRawAxis(4));
        Drive.move(controller.getRawAxis(1), controller.getRawAxis(0), 0.2);
    }
}
