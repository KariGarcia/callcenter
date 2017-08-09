package karen.dispatcher.model;

import java.util.Random;

public class Employee {
	private boolean isAvailable = true;
	
	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	public void receiveCall() {
		Employee employee = this;
		
		employee.setAvailable(false);
		Dispatcher.callHasStarted();
		
		new Thread(new Runnable() {
		    private Employee employee;
		    public Runnable init(Employee employee) {
		        this.employee = employee;
		        return this;
		    }
		    public void run() {
		        
		        try {
		    		Random r = new Random();
		    		int low = 5;
		    		int high = 11;
		    		int result = (r.nextInt(high-low) + low) * 1000;
		    		
					Thread.sleep(result);
					Dispatcher.callHasFinished();
					this.employee.setAvailable(true);
					System.out.println(this.employee.getClass().getSimpleName()+": The call has finished and took " + result/1000 + " seconds");
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		    }
		}.init(employee)).start();
	}
}
