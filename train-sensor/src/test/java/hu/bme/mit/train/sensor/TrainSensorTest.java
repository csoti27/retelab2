package hu.bme.mit.train.sensor;

import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.interfaces.TrainUser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;



public class TrainSensorTest {


    TrainUser user;
    TrainController controller;

    TrainSensorImpl sensor;

    @Before
    public void setup(){

        user = Mockito.mock(TrainUser.class);
        controller=Mockito.mock(TrainController.class);;
        sensor=new TrainSensorImpl(controller,user);

    }


    @Test
    public void toMinusOne(){

  
        sensor.overrideSpeedLimit(-1);
        Assert.assertEquals(true,user.getAlarmState());

    }

    @Test
    public void toFiveHundred(){

        sensor.overrideSpeedLimit(500);
        Assert.assertEquals(false,user.getAlarmState());

    }
    @Test
    public void toFiveHundredOne(){

        sensor.overrideSpeedLimit(501);
        Assert.assertEquals(501,sensor.getSpeedLimit());
        Assert.assertEquals(true,user.getAlarmState());

    }

    @Test
    public void setterTest(){


        this.user.setAlarmState(true);
        Assert.assertEquals(true,user.getAlarmState());
    }


    @Test
    public void fromHundredFiftytoFifty(){


        for(int i=0; i<150; i++){
            controller.setJoystickPosition(1);
        }
        sensor.overrideSpeedLimit(50);
        Assert.assertEquals(true,user.getAlarmState());

    }


    @Test
    public void fromHundredFiftytoSeventiyFour(){


        for(int i=0; i<150; i++){
            controller.setJoystickPosition(1);
        }
        sensor.overrideSpeedLimit(74);
        Assert.assertEquals(true,user.getAlarmState());

    }

    @Test
    public void fromHundredFiftytoSeventiyFive(){


        for(int i=0; i<150; i++){
            controller.setJoystickPosition(1);

        }
        System.out.println(controller.getStep());
        sensor.overrideSpeedLimit(75);
        Assert.assertEquals(false,user.getAlarmState());

    }



}
