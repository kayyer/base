package hu.bme.mit.train.interfaces;

import com.google.common.collect.Table;

import java.time.LocalDate;
import java.util.Date;

public interface TrainController {

	void followSpeed();

	int getReferenceSpeed();

	void setSpeedLimit(int speedLimit);

	void setJoystickPosition(int joystickPosition);

	int getStep();

	Table<LocalDate,Integer,Integer> getTachograph();

	void addTachograph(Integer j,Integer r);

}
