package Service;



import domain.Aeroplane;
import domain.Flight;
import repository.PlaneRepository;

import java.util.ArrayList;
import java.util.List;




public class PlaneService {


    public static boolean addAeroplane(String name, Integer capacity, String airline){

        PlaneRepository planeRepository = new PlaneRepository();
        List<Aeroplane> aeroplanes = planeRepository.GetAllPlanes();
        Aeroplane aero = aeroplanes.stream().filter(f->f.getAeroplaneName().equalsIgnoreCase(name)
        ).findAny().orElse(null);

         if (aero == null){
             Aeroplane aeroplane = new Aeroplane(name,capacity,airline);
             planeRepository.addplane(aeroplane);
             return true;
         }
        return false;
    }

    public static String[][] getAllAirlineForJTable(int length) {
        PlaneRepository planeRepository = new PlaneRepository();
        List<Aeroplane> aeroplanes = planeRepository.GetAllPlanes();

        String[][] data  = new String[aeroplanes.size()][length];
        for(int row = 0 ; row < aeroplanes.size() ; row++){
            data[row][0] = aeroplanes.get(row).getId().toString();
            data[row][1] = aeroplanes.get(row).getAeroplaneName();
            data[row][2] = aeroplanes.get(row).getCapacity().toString();
            data[row][3] = aeroplanes.get(row).getAirline();

        }

        return data;
    }

//    public static List<Aeroplane> printAllAir() {
//        List<Aeroplane> allAero = new ArrayList<>();
//        for (Aeroplane aero : planes) {
//            allAero.add(aero);
//        }
//        return allAero;
//    }
//public static Boolean findAeroplane(String planeName){
//PlaneRepository planeRepository = new PlaneRepository();
//
//      Aeroplane aero =planeRepository.getPlanesthroughName(planeName);
//      if (aero != null){
//                return true;
//            }
//return false; }

    public static Aeroplane searchAeroplane(String planeName) {
        PlaneRepository planeRepository = new PlaneRepository();
        Aeroplane aero = planeRepository.getPlanesthroughName(planeName);

        return aero;
    }

    public static Boolean PlaneEdit(String name, Integer capacity, String airline, Long id) {
        PlaneRepository planeRepository = new PlaneRepository();
       Boolean pl =  planeRepository.UpdatePlane(name,capacity,airline,id);
       if (pl){return true;}
    return false;}

    public static Boolean DeletePlane(Long planeId) {
        PlaneRepository planeRepository = new PlaneRepository();
        Boolean pl = planeRepository.deletePlaneThroughID(planeId);

        if (pl){return  true;}
    return false;}
//
//
//    public static Aeroplane searchAeroplane(String planeName) {
//        Aeroplane aeroplane = planes.stream().filter(el->el.getName()
//                .equalsIgnoreCase(planeName)).findAny().orElse(null);
//
//
//  return aeroplane;   }
}