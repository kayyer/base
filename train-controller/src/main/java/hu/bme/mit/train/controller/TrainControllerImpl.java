package hu.bme.mit.train.controller;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;
import hu.bme.mit.train.interfaces.TrainController;

import java.time.LocalDate;
import java.util.Date;

public class TrainControllerImpl implements TrainController {

	private int step = 0;
	private int referenceSpeed = 0;
	private int speedLimit = 0;
	private Table<LocalDate,Integer,Integer> tachograpf = HashBasedTable.create();

	@Override
	public void followSpeed() {
		if (referenceSpeed < 0) {
			referenceSpeed = 0;
		} else {
		    if(referenceSpeed+step > 0) {
                referenceSpeed += step;
            } else {
		        referenceSpeed = 0;
            }
		}

		enforceSpeedLimit();
	}

	@Override
	public int getReferenceSpeed() {
		return referenceSpeed;
	}

	@Override
	public void setSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
		enforceSpeedLimit();
		
	}

	private void enforceSpeedLimit() {
		if (referenceSpeed > speedLimit) {
			referenceSpeed = speedLimit;
		}
	}

	@Override
	public void setJoystickPosition(int joystickPosition) {
		this.step = joystickPosition;		
	}

	public void writeSpeed(){
		System.out.println("The reference speed is: " +  referenceSpeed);
		System.out.println("The speed limit is: " + speedLimit);
	}

	public int getStep() {
		return step;
	}

	public void addTachograph(Integer j,Integer r) {
		LocalDate myObj = LocalDate.now();
		tachograpf.put(myObj,j,r);
	}


	public Table<LocalDate,Integer,Integer> getTachograph() {
		return tachograpf;
	}
}
