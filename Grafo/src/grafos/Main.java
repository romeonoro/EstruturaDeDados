package grafos;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		//LER O ARQUIVO E MONTAR GRAFO
		ArrayList<String> vertices = new ArrayList<>();
		ArrayList<String> linhasDoArquivo = new ArrayList<>();
		String nomeArquivo = "C:\\Users\\laboratorio\\eclipse-workspace\\Grafo\\src\\grafos\\mapaCentral.txt";
		
		Grafo.lerArquivo_montarGrafo(nomeArquivo, vertices, linhasDoArquivo);
		Grafo g = new Grafo(vertices);
		//MONTAR AS CONEXÕES DO ARQUIVO - SIMÉTRICO 
		g.montarConexoesSimetricas(linhasDoArquivo);
		//EXIBIR O GRAFO
		g.mostrarMatriz();
		//g.mostrarGrafo();	
		//LER O ARQUIVO E MONTAR AS CONEXÕES
		//System.out.println("Tem caminho entre Agudo e Julio de Castilhos? " + g.temCaminhoProfundidade("AGUDO", "JULIO DE CASTILHOS"));
		g.temCaminhoProfundidade("AGUDO", "JULIO DE CASTILHOS"); //g.temCaminhoProfundidade(nomeArquivo, nomeArquivo); 
	}
}
