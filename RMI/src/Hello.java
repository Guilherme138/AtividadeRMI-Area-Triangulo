import java.rmi.*;
 
public interface Hello extends Remote {
   public float areaT(float b, float h) throws RemoteException;

}