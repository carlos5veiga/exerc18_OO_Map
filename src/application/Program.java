package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Program {

	public static void main(String[] args) {

	
		String path = "D:\\Carlinhos\\Wsp_Java\\Files\\votacao.csv";

		Map<String, Integer> votacao = new HashMap<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line = br.readLine();
			while (line != null) {
				//System.out.println(line);
				String[] fields = line.split(",");
				
				if (votacao.containsKey(fields[0])){
					int soma = votacao.get(fields[0]) + Integer.parseInt(fields[1]);
					votacao.put(fields[0], soma);
				}
				else {
					votacao.put(fields[0], Integer.parseInt(fields[1]));
				}

				line = br.readLine();
			}
		}
		catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		for (String key : votacao.keySet()) {
			System.out.println(key + ": " + votacao.get(key));
		}
	}

}
