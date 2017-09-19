package DB;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {

	
	private Connection connection;
	private static String url = "jdbc:mysql://localhost/db_agenda";
	private static String user = "root";
	private static String pass = "uniceub";
	
	/**
	 * Inicia a classe de conexão com o banco de dados
	 */
	public ConnectionFactory() {
		// TODO Auto-generated constructor stub
		try {
			DriverManager.getConnection(url, user, pass );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
		
	}
	
	/*
	 * Prepara para receber um SQL
	 */
	public PreparedStatement pstatement(String sql) throws SQLException {
		return connection.prepareStatement(sql);
	}
	
	/*
	 * Fecha a conexao com o banco
	 */
	public void fechaConexao() {
		try {
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}
	
}
