package org.firstinspires.ftc.teamcode.Lessons;

import com.arcrobotics.ftclib.hardware.RevIMU;
import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.navigation.Acceleration;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.AngularVelocity;
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder;
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference;
import org.firstinspires.ftc.robotcore.external.navigation.Orientation;

@TeleOp
public class J_ImuLesson extends OpMode {
    RevIMU imu;

    @Override
    public void init(){
        BNO055IMU.Parameters imuParameters = new BNO055IMU.Parameters(); //Declares parameters for imu
        imuParameters.angleUnit = BNO055IMU.AngleUnit.DEGREES; //Sets angle units for imu (degrees or radians)
        imuParameters.calibrationDataFile = "BNO055IMUCalibration.json"; // Calibrates imu (the .json file should already exist in the project)
        imu = new RevIMU(hardwareMap);
        imu.init();
    }
    @Override
    public void start(){

    }
    @Override
    public void loop(){
        AngularVelocity velocity = imu.getRevIMU().getAngularVelocity(); //Gets rate of change of angles
        Acceleration acceleration = imu.getRevIMU().getAcceleration(); //Gets rate of change of velocity
        double[] angles = imu.getAngles();
        //Displays angles, velocity, and acceleration of IMU
        telemetry.addData("Z",angles[0]);
        telemetry.addData("Y",angles[1]);
        telemetry.addData("X",angles[2]);
        telemetry.addData("Z Angular Velocity",velocity.zRotationRate);
        telemetry.addData("Y Angular Velocity",velocity.yRotationRate);
        telemetry.addData("X Angular Velocity",velocity.xRotationRate);
        telemetry.addData("Z Acceleration",acceleration.zAccel);
        telemetry.addData("Y Acceleration",acceleration.yAccel);
        telemetry.addData("X Acceleration",acceleration.xAccel);
    }
}