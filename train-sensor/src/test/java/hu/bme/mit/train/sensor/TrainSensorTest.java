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


    TrainUser user = Mockito.mock(TrainUser.class);

    TrainController controller=Mockito.mock(TrainController.class);;

    TrainSensorImpl sensor;

    @Before
    public void setup(){

        sensor=new TrainSensorImpl(controller,user);

    }


    @Test
    public void toZero(){

        //when(controller.setSpeedLimit(0)).thenReturn();
        sensor.overrideSpeedLimit(0);
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
        sensor.overrideSpeedLimit(74);
        Assert.assertEquals(true,user.getAlarmState());

    }



}
