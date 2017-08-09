package karen.dispatcher.model;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class DispatcherTest {

	@Test
	public void testDispatchCall() {
		List<Operator> operators = new ArrayList<Operator>();
        operators.add(new Operator());
        operators.add(new Operator());
        operators.add(new Operator());
        operators.add(new Operator());
        operators.add(new Operator());
        
        Supervisor supervisor = new Supervisor();
        Director director = new Director();
        
        Dispatcher disp = new Dispatcher(operators);
        disp.setDirector(director);
        disp.setSupervisor(supervisor);
        
        boolean succeded = true;
        for(int i=1; i<=10 ; i++){
        	boolean res = disp.dispatchCall();
        	if(!res){
        		succeded = false;
        	}
        }
		assertTrue(succeded);
	}

}
