package karen.dispatcher.model;

import java.util.ArrayList;
import java.util.List;

public class Operator extends Employee {
	
	public Operator(){
	}
	
	@Override
	public void receiveCall() {
		super.receiveCall();
		System.out.println("An operator is taking the call");
	}
	
	public static Operator getAnyFreeOperator(List<Operator> operators){
		Operator freeOperator = null;
		for(Operator operator : operators){
			if(operator.isAvailable()){
				freeOperator = operator;
			}
		}
		return freeOperator;
	}
	
	
}
