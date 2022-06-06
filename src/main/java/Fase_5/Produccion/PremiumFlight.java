package Fase_5.Produccion;

public class PremiumFlight extends Flight {

   // Diseño de la lógica comercial para los pasajeros VIP.Pregunta 7

       public PremiumFlight(String id) {
           super(id);
       }

       @Override
       public boolean addPassenger(Passenger passenger) {
           if (passenger.isVip()) {
               return passengers.add(passenger);
           }
           return false;
       }

       @Override
       public boolean removePassenger(Passenger passenger) {
           if (passenger.isVip()) {
               return passengers.remove(passenger);
           }
           return false;
       }
}
