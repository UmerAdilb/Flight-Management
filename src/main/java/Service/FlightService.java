package Service;

import domain.Aeroplane;
import domain.Flight;
import domain.Passengerinquiry;
import domain.Pessanger;
import repository.FlightRepository;
import repository.PassengerRepository;
import repository.PlaneRepository;

import java.time.LocalDate;
import java.util.List;

public class FlightService {


    public static String[][] getAllFLightsForJTable(int length, String src, String des) {
        FlightRepository flightRepository = new FlightRepository();
        List<Flight> flights = flightRepository.getAllFlights(src,des);
        String[][] data  = new String[flights.size()][length];
        for(int row = 0 ; row < flights.size() ; row++){
            data[row][0] = flights.get(row).getFlightNumber();
            data[row][1] = flights.get(row).getDate().toString();
            data[row][2] = flights.get(row).getSource();
            data[row][3] = flights.get(row).getDestination();
            data[row][4] = flights.get(row).getFare().toString();
        }
        return data;
    }

    public static Boolean booking(String name, String contact, String address, String flightNumber) {
        FlightRepository flightRepository = new FlightRepository();
        String src = "src";
        String des = "des";
        List<Flight> flights = null;
              flights=  flightRepository.getAllFlights(src,des);
       Flight flight =  flights.stream()
                .filter(f->f.getFlightNumber().equalsIgnoreCase(flightNumber))
                .findAny().orElse(null);
        Long flightid = flights.stream()
                .filter(f->f.getFlightNumber().equalsIgnoreCase(flightNumber))
                .findAny().orElse(null).getId();
        if(flight != null){
            
            Pessanger passenger = new Pessanger(name,contact,address,flightid);
            PassengerRepository passengerRepository = new PassengerRepository();
          Boolean add =  passengerRepository.AddPassenger(passenger);
          if (add){
return true;
        }else {return false;}}




return null;
    }

    public static String[][] getAllPassengerByFlightNumberJTable(int length, String contact) {
       PassengerRepository passengerRepository = new PassengerRepository();
        List<Passengerinquiry> passengers = passengerRepository.getPassengerForInquiry(contact);
        String[][] data  = new String[passengers.size()][length];
        for(int row = 0 ; row < passengers.size() ; row++){
            data[row][0] = passengers.get(row).getName();
            data[row][1] = passengers.get(row).getContact();
            data[row][2] = passengers.get(row).getAddress();
            data[row][3] = passengers.get(row).getAirline();
            data[row][4] = passengers.get(row).getFlightName();
            data[row][5] = passengers.get(row).getFlightDate().toString();
            data[row][6] = passengers.get(row).getSource();
            data[row][7] = passengers.get(row).getDestination();
            data[row][8] = passengers.get(row).getFare().toString();


        }return  data;
}

    public static String[][] getAllFLightsForJTableforadmin(int length) {
        FlightRepository flightRepository = new FlightRepository();
        List<Flight> flights = flightRepository.getAllFlights("src","des");
        String[][] data  = new String[flights.size()][length];
        for(int row = 0 ; row < flights.size() ; row++){

            data[row][0] = flights.get(row).getId().toString();
            data[row][1] = flights.get(row).getFlightNumber();
            data[row][2] = flights.get(row).getDate().toString();
            data[row][3] = flights.get(row).getSource();
            data[row][4] = flights.get(row).getDestination();
            data[row][5] = flights.get(row).getFare().toString();
            data[row][6] = flights.get(row).getAeroplaneId().toString();


        }
        return data;
    }

    public static Boolean addFlightIntoPlane(String flight_number, LocalDate flight_date, String src, String des, Double fare, Long aeroplane_id) {

        PlaneRepository planeRepository = new PlaneRepository();
        List<Aeroplane> aeroplanes = planeRepository.GetAllPlanes();

        Aeroplane aero = aeroplanes.stream().filter(f->f.getId().equals(aeroplane_id)).findAny().orElse(null);

        FlightRepository flightRepository = new FlightRepository();
        List<Flight> flights = flightRepository.getAllFlights("src","des");

        Flight flight =  flights.stream()
                .filter(f->f.getFlightNumber().equalsIgnoreCase(flight_number))
                .findAny().orElse(null);

        if (flight == null && aero != null){
            Flight flight1 = new Flight(flight_number,src,des,fare,flight_date,aeroplane_id);
            flightRepository.AddFlight(flight1);
            return true;
        }
        return false;
    }

    public static Flight searchFlightbyNumber(String flightNumber) {
        FlightRepository flightRepository = new FlightRepository();
        Flight fl = flightRepository.getFlightsthroughName(flightNumber);
        return fl;
    }

    public static Boolean FlightEdit(Long id, String flight_number, String src, String des, LocalDate flight_date, Double fare, Long aeroId) {
            FlightRepository flightRepository = new FlightRepository();
          Boolean flight =   flightRepository.UpdateFlight(id,flight_number,des,src,flight_date,fare,aeroId);



           if (flight){
               return true;
           }

           return false;
    }

    public static Boolean DeleteFlight(Long flightId) {
        FlightRepository flightRepository = new FlightRepository();
        Boolean fl = flightRepository.DeleteFlight(flightId);

        if (fl){
            return true;
        }
    return false;}
}

