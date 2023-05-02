package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

public class Drive {
    public static VictorSPX leftFront = new VictorSPX(0);
    public static VictorSPX leftBack = new VictorSPX(0);
    public static VictorSPX rightFront = new VictorSPX(0);
    public static VictorSPX rightBack = new VictorSPX(0);

    public static void move(double forwardness, double steeringness, double deadbandness){
        // leftFront.set(ControlMode.PercentOutput, forwardness);
        // leftBack.set(ControlMode.PercentOutput, forwardness);
        // rightFront.set(ControlMode.PercentOutput, forwardness);
        // rightBack.set(ControlMode.PercentOutput, forwardness);

        // if(Math.abs(steer) > deadband){
        //     leftFront.set(ControlMode.PercentOutput, steer);
        //     leftBack.set(ControlMode.PercentOutput, steer);
        //     rightFront.set(ControlMode.PercentOutput, -steer);
        //     rightBack.set(ControlMode.PercentOutput, -steer);   
        // }

        if(Math.abs(steeringness) < deadbandness) steeringness = 0.0;
        if(Math.abs(forwardness) < deadbandness) forwardness = 0.0;

        double leftSpeed = Math.pow(forwardness,2) * Double.min((1.0 + steeringness),1.0); // + forwad
        double rightSpeed = Math.pow(forwardness,2) * Double.max((-1.0 + steeringness),-1.0); // - forward

        leftFront.set(ControlMode.PercentOutput, leftSpeed);
        leftBack.set(ControlMode.PercentOutput, leftSpeed);
        rightFront.set(ControlMode.PercentOutput, rightSpeed);
        rightBack.set(ControlMode.PercentOutput, rightSpeed);
    }
}
