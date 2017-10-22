package Test;

import DB.ContatoDao;
import Model.Contato;

import java.util.ArrayList;
import java.util.Random;

public class TestConnection {

	public static void main(String[] args) {
				
		//Database db = new Database();
		//db.open();
		//db.insere("61999576864", "Hygor");
		//db.close();

		ContatoDao contatoDao = new ContatoDao();

		//Contato contato = new Contato();
		//contato.setTelefone("61999998888");
		//contato.setNome("Hygor");

		//contatoDao.adiciona(contato); //adicionado com sucesso!
		//contatoDao.remover(contato); //removido com sucesso!

		//Adicionar 60 contatos aleatórios

		
		/*for(int i = 0; i < 60; i++){

			StringBuilder sb = new StringBuilder();
			Random random = new Random();

			for(int j = 0; j < 12 ; j++){
				sb.append(random.nextInt(9));
			}

			Contato c = new Contato();
			c.setNome("Contato " + i);
			c.setTelefone(sb.toString());

			contatoDao.adiciona(c);
		}*/

		// Imprimir todos os contatos  **funcionando!**

		ArrayList<Contato> contatos = contatoDao.getAll();
		for(Contato c : contatos){
			System.out.print("Telefone: " + c.getTelefone());
			System.out.println("\tNome: " + c.getNome());
		}
	}
}
