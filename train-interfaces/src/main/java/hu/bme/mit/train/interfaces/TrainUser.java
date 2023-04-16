package hu.bme.mit.train.interfaces;

public interface TrainUser {


	void setAlarmState(boolean alarmState);
	boolean getAlarmState();
	int getJoystickPosition();

	boolean getAlarmFlag();

	
	void overrideJoystickPosition(int joystickPosition);

}
