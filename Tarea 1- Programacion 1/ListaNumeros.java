import java.util.Scanner;
import java.io.*;

public class ListaNumeros {

	/**
	 * @param args
	 */
	public static void main(String[] args)  throws IOException {
		
		// TODO Auto-generated method stub
		int tamaño = 0;
		int a;
		int b; 
		int c;
		int limite[] = new int[100];
		String date[] = new String[100];
		BufferedReader n = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Digite la cantidad de numeros que desse: ");
		String dato = n.readLine();
		tamaño = Integer.parseInt(dato);
		
		for(a = 0; a<tamaño; a++){
		
			int x = a + 1;
			System.out.print("Ingrese el numero " + x + ": ");
			date[a] = n.readLine();
			limite[a] = Integer.parseInt(date[a]);
			
			
		}
		
		
		for(a = 0; a<tamaño; a++){
		
			for(b = a+1; b<tamaño; b++){
			
				if(limite[b] < limite[a]){
				
					c = limite[a];
					limite[a] = limite[b];
					limite[b] = c;
				}
			}
			
			
		}
		
		System.out.println();
		System.out.println("El orden de menor a mayor es: ");
		
		for(a= 0; a<tamaño; a++)
		System.out.println(limite[a]);
		
		
		
		
	    
	    
	}

}
