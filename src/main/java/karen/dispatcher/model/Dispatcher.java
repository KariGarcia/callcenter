package karen.dispatcher.model;

import java.util.List;

public final class Dispatcher {
	
	private List<Operator> operators;
	private Supervisor supervisor;
	private Director director;
	final int maxCallsAllowed = 10;
	
	private static int currentCalls = 0;
	
	
	public Dispatcher(List<Operator> operators){
		this.operators = operators;
	}

	public boolean dispatchCall(){
		
		if(currentCalls < maxCallsAllowed){
			Operator operator = Operator.getAnyFreeOperator(operators);
			if(operator != null){
				operator.receiveCall();
			} 
			else if(this.supervisor != null && this.supervisor.isAvailable()){
				this.supervisor.receiveCall();
			} 
			else if(this.director != null && this.director.isAvailable()){
				this.director.receiveCall();
			} else {
				this.putClientOnHold();
			}
			return true;
		}
		return false;
	}
	
	public void setOperators(List<Operator> operators){
		this.operators = operators;
	}
	
	public void setSupervisor(Supervisor supervisor){
		this.supervisor = supervisor;
	}
	
	public void setDirector(Director director){
		this.director = director;
	}
	
	public void putClientOnHold(){
		System.out.println("Client on hold");
		this.callOnHold();
		this.playMusic();
	}
	
	public void playMusic(){
	}
	
	static public void callHasFinished(){
		currentCalls--;
	}
	
	static public void callHasStarted(){
		currentCalls++;
	}
	
	static public void callOnHold(){
		currentCalls++;
	}
}
