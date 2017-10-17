package DB;

import Model.Contato;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ContatoDao {

    private Connection connection;

    /**
     * Inicia a classe realizando conexão com o banco
     */
    public ContatoDao(){

        this.connection = new ConnectionFactory().getConnection();

    }

    /**
     * Realiza inserção no banco de dados
     * @param contato Objeto a ser inserido
     */
    public void adiciona(Contato contato){
        String sql = "INSERT INTO tb_contato VALUES (?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);

            stmt.setString(1, contato.getTelefone());
            stmt.setString(2, contato.getNome());

            stmt.execute();
            stmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Remove um objeto específico do banco de dados
     * @param contato Objeto a ser removido do banco de dados
     */
    public void remover(Contato contato){
        String sql = "DELETE FROM tb_contato WHERE telefone = ?";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, contato.getTelefone());

            statement.execute();
            statement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Busca o total de contatos no banco
     * @return Lista de contatos gravados
     */
    public ArrayList<Contato> getAll(){

        ArrayList<Contato> contatos = new ArrayList<>();

        try {
            PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM tb_contato");
            ResultSet result = statement.executeQuery();

            while (result.next()){

                Contato contato = new Contato();
                contato.setTelefone(result.getString("telefone"));
                contato.setNome(result.getString("nome"));

                contatos.add(contato);
            }

            result.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return contatos;
    }

    /**
     * Busca um contato específico da lista
     * @param telefone Número a ser procurado
     * @return Contato relativo a número
     */
    public Contato getByTelefone(String telefone){

        Contato contato = null;

        try {
            PreparedStatement statement = this.connection.prepareStatement("SELECT * FROM tb_agenda WHERE telefone = ?");
            statement.setString(1, telefone);
            ResultSet result = statement.executeQuery();

            while (result.next()){

                contato = new Contato();
                contato.setTelefone(result.getString("telefone"));
                contato.setNome(result.getString("nome"));
            }

            result.close();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return contato;

    }



}
