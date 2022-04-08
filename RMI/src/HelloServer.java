import java.rmi.*;
import java.rmi.server.*;
import java.rmi.registry.*;

public class HelloServer implements Hello {
	float areaT;
	public HelloServer() {} 
	public static void main(String[] args) {
		try {
			HelloServer server = new HelloServer();
			//Exporta o server para o stub ("apendice ou toco") do RMI na porta 0
			Hello stub = (Hello) UnicastRemoteObject.exportObject(server, 0);
			
			Registry registry = LocateRegistry.getRegistry();
			// Registra a stub no RMI para que ela seja obtida pelos clientes
			registry.bind("Servidor", stub);
			
			System.out.println("Servidor inicializado com sucesso.");
		} catch (Exception ex) {
			ex.printStackTrace();
		} 
	}

	 public float areaT(float b, float h) throws RemoteException {
		areaT = 0;
		areaT= (b*h)/2;
		System.out.println("O valor da area do triangulo é: " + areaT); 
 		return areaT;
	}
}

