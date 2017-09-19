
public class Log {

	private boolean show = false;
	
	public void i(String s) {		
		if(show) {
			System.out.println(s);
		}	
	}
	
	public void show(boolean b) {
		this.show = b;
	}	
}
