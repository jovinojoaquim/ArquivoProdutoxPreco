import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Aplicacao {

	public static void main(String[] args) {
		String caminho = "c:\\out\\summary.csv";
		Scanner s = new Scanner(System.in);
		
		File arqvuivo = new File(caminho);
		
		try {
			FileReader fr = new FileReader(arqvuivo);
			BufferedReader br = new BufferedReader(fr);
			
			String linha = br.readLine();
			
			while(linha!=null) {
				System.out.println(dividir(linha));
				
				linha = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static String dividir(String linha) {
		String produtoPrecoQuantidade[] = linha.split(",");
		double preco = Double.parseDouble(produtoPrecoQuantidade[1]);
		int quantidade = Integer.parseInt(produtoPrecoQuantidade[2]);
		return produtoPrecoQuantidade[0]+", "+ String.format("%.2f", preco*quantidade);
	}

}
