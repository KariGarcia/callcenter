package karen.dispatcher;

import java.util.ArrayList;
import java.util.List;

import karen.dispatcher.model.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        
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
        
        for(int i=0; i<10 ; i++){
        	disp.dispatchCall();
        }
        
        
    }
}
