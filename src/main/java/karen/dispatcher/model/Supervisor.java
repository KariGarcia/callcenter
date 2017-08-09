package karen.dispatcher.model;

public class Supervisor extends Employee {
	
	@Override
	public void receiveCall() {
		super.receiveCall();
		System.out.println("A supervisor is taking the call");
	}
}
