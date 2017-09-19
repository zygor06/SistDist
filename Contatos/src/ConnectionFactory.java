import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection() {
		
		//Utilizando try with resources para que a conexão seja finalizada automaticamente. (Ver interface java.lang.AutoCloseable)
		try {
			return DriverManager.getConnection("jdbc:mysql://localhost/db_agenda", "root", "uniceub");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
	
}
