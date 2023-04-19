package hu.bme.mit.train.interfaces;

public interface TrainController {

	void followSpeed();
	int getStep();
	int getReferenceSpeed();

	void setSpeedLimit(int speedLimit);

	void setJoystickPosition(int joystickPosition);

}
