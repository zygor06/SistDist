import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {
	
	private Connection con;
	private Log log;
	
	public Database() {
		log = new Log();
		log.show(false);
	}
		
	public void insere(String telefone, String nome) {
		
		String sql = 	"INSERT INTO contatos" +
						"(telefone, nome)"+
						"values(?,?)";
		
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			
			stmt.setString(1, telefone);
			stmt.setString(2, nome);
			stmt.execute();
			
			log.i("Inserido");
			con.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	 
		
	}
	
	public void open() {
		con = new ConnectionFactory().getConnection();
	}
	
	public void close() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
}
