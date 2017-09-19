package DB;

import Util.Log;

import java.sql.PreparedStatement;
import java.sql.SQLException;
/**
 * @Deprecated
 * Classes não será mais utilizada, foi substituida pela classe ContatoDao
 */
public class Database {
	
	private ConnectionFactory con;
	private Log log;
	
	public Database() {
		con = new ConnectionFactory();
		log = new Log();
		log.show(false);
	}
		
	public void insere(String telefone, String nome) {
		
		String sql = 	"INSERT INTO contatos" +
						"(telefone, nome)"+
						"values(?,?)";
		
		try {
			PreparedStatement stmt = con.pstatement(sql);
			
			stmt.setString(1, telefone);
			stmt.setString(2, nome);
			stmt.execute();
			
			log.i("Inserido");
			stmt.close();
			con.fechaConexao();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}	 
		
	}
	
		
}
