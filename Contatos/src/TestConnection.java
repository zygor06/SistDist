import java.math.BigInteger;

public class TestConnection {

	public static void main(String[] args) {
				
		Database db = new Database();
		db.open();
		db.insere("61999576864", "Hygor");
		db.close();
		
	}
	
}
