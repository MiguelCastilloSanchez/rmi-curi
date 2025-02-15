import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

/**
 * ProvinceClient: client application
 */
public class ProvinceClient { 

  public static void main(String[] args) { 
    try { 
      // Get reference to RMI registry server
      Registry registry = LocateRegistry.getRegistry("127.0.0.1"); 

      // Lookup server object
      IRemoteProvince rp = (IRemoteProvince) registry.lookup("Province"); 

      // Save province
      Province mid = new Province(1, "MID", "Mérida"); 
      Province ens = new Province(2, "ENS", "Ensenada"); 
      Province cdmx = new Province(3, "CMX", "Ciudad de México"); 
      Province cam = new Province(4, "CAM", "Ciudad de Campeches"); 
      Province mty = new Province(5, "MTY", "Monterrey"); 

      System.out.println("Saving provinces...");
      rp.save(mid); 
      rp.save(ens); 
      rp.save(cdmx); 
      rp.save(cam); 
      rp.save(mty); 

      System.out.println("Update Campeches to Campeche");
      Province updatedCAM = new Province(4, "CAM", "Ciudad de Campeche"); 
      rp.update(updatedCAM); 

      System.out.println("Display all provinces");
      ArrayList<Province> arrProv = rp.findAll(); 
      for (Province p : arrProv) { 
        System.out.println(p.toString()); 
      } 

      System.out.println("Delete CAM"); 
      rp.delete(cam); 

      System.out.println("Display province starts by \"Ciu\"");
      arrProv = rp.findByName("Ciu"); 
      for (Province p : arrProv) { 
        System.out.println(p.toString()); 
      }  

      System.out.println("Delete all provinces"); 
      rp.deleteAll(); 

    } catch (Exception e) { 
      System.out.println(e); 
    } 
  } 
}
