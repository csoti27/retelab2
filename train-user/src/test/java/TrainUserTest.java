import hu.bme.mit.train.interfaces.TrainController;
import hu.bme.mit.train.user.TrainUserImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class TrainUserTest {

    TrainUserImpl user;

    TrainController controller;

    @Before
    public void setup(){
        controller= Mockito.mock(TrainController.class);;
        this.user=new TrainUserImpl(controller);
        //user.setAlarmState(false);
    }

    @Test
    public void setterTest(){
        user.setAlarmState(true);
        Assert.assertEquals(true,user.getAlarmState());
    }

}
