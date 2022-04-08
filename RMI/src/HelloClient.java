import java.rmi.registry.*;
import java.util.Scanner;

public class HelloClient {
	public static Scanner ler;
	public static void main(String[] args) {
		ler = new Scanner(System.in); 
		
		float h, b;
		try {
			
			// Procura o registro do RMI no Servidor
			// Se o servidor estiver em outro host basta substituir pelo seu IP
			Registry registry = LocateRegistry.getRegistry("localhost");
			// Procura a stub do servidor
			Hello stub= (Hello) registry.lookup("Servidor");
			// Chama o m�todo do servidor e imprime a mensagem
			System.out.println("Invocando metodo do servidor");
			System.out.print("Digite o valor da base (B): ");
			b= ler.nextFloat();
			System.out.print("Digite o valor da altura (H): ");
			h= ler.nextFloat();
			float msg = stub.areaT(b,h);
			System.out.println("O valor da area do triangulo é: " + msg); 
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
	}
}




