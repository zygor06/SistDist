package DB;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {


	private Connection connection;
	private final static String URL = "jdbc:mysql://localhost/db_agenda";
	private final static String USER = "root";
	private final static String PASS = "root";

	/**
	 * Inicia a classe de conex�o com o banco de dados
	 */
	public ConnectionFactory() {
		try {
			connection = DriverManager.getConnection(URL, USER, PASS );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

	}

	public Connection getConnection(){
	    return connection;
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
