package karen.dispatcher.model;

public class Director extends Employee {

	@Override
	public void receiveCall() {
		super.receiveCall();
		System.out.println("A director is taking the call");
	}
}
