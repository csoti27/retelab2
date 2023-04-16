package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainSensor;
import hu.bme.mit.train.interfaces.TrainUser;

public class TrainSensorImpl implements TrainSensor {

	private TrainController controller;
	private TrainUser user;
	private int speedLimit = 5;

	public TrainSensorImpl(TrainController controller, TrainUser user) {
		this.controller = controller;
		this.user = user;
	}

	@Override
	public int getSpeedLimit() {
		return speedLimit;
	}

	@Override
	public void overrideSpeedLimit(int speedLimit) {
		this.speedLimit = speedLimit;
		controller.setSpeedLimit(speedLimit);
		if(this.speedLimit<0||this.speedLimit>500){
			this.user.setAlarmState(true);
			System.out.println("atbillentem");
		}
		else if((float)this.speedLimit<(float)this.controller.getReferenceSpeed()/2){
			this.user.setAlarmState(true);
		}

		else {
			this.user.setAlarmState(false);
		}
	}

}

