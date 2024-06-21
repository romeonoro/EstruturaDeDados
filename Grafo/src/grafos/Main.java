package grafos;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		//ler o arquivo e montar o grafo
		ArrayList<String> vertices = new ArrayList<>();
		ArrayList<String> linhasDoArquivo = new ArrayList<>();
		String nomeArquivo = "C:\\Users\\laboratorio\\eclipse-workspace\\Grafo\\src\\grafos\\mapaCentral.txt";
		
		Grafo.lerArquivo_montarGrafo(nomeArquivo, vertices, linhasDoArquivo);
		Grafo g = new Grafo(vertices);
		//montar as conexões do arquivo - SIMÉTRICO
		g.montarConexoesSimetricas(linhasDoArquivo);
		//exibir o grafo
		g.mostrarMatriz();
		//ler o arquivo e montar as conexões
		g.montarConexoesSimetricas(linhasDoArquivo);
		g.mostrarGrafo();	
		//System.out.println("Tem caminho entre Agudo e Júlio de Castilhos? " + g.temCaminhoProfundidade);
		g.temCaminhoProfundidade(nomeArquivo, nomeArquivo); //(origem:"AGUDO", destino:"JULIO DE CASTILHOS");
	}
}