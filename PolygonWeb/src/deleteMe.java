import Domain.DomainFacade;
import data.DatabaseFacade;
import entity.Address;
import entity.Building;
import entity.ZipCode;
import java.sql.SQLException;

public class deleteMe {

    public static void main(String[] args) throws SQLException {
        DomainFacade df = new DomainFacade();
        DatabaseFacade dbf = new DatabaseFacade();

//  
//  for(int i = 1; i<3; i++){
//  Address adr = dbf.loadAddress(i);
//      System.out.println("////+\n"+adr.toString());
//  
//  }
        //loadBuilding
        //System.out.println( dbf.getBuildings().get(0).getAddress().getZipCode().getCity());
        //Load address
// Address adr = dbf.loadAddress(1);
// System.out.println( adr.getAddressline() + " - " +adr.getZipCode().getCity() + " - " +adr.getZipCode().getZip() );
//         
        //add building 
//        if(dbf.loadZip(0)==null){System.out.println("null"); }
//        
//        else{System.out.println(dbf.loadZip(0).getCity());}
//         for (Building b : df.getBuildings()) {
//System.out.println(b.getAddress().getAddressline()+" "+b.getAddress().getZipCode().getZip()+" "+b.getAddress().getZipCode().getCity());
//         }
//
//  //       df.addBuilding(new Building(4,4,4,"rapoort4",4));
//                 
//               
// df.addBuilding("Messi","Camp nou street","09771","Barcelona","009182739");
//
//
//     
        for (Building b : df.getBuildings()) {
            System.out.println(b.getAddress().getAddressline() + " " + b.getAddress().getZipCode().getZip() + " " + b.getAddress().getZipCode().getCity());
        }
    }
}
