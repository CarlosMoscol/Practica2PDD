package Fase_3.Pruebas;

import Fase_3.Produccion.BusinessFlight;
import Fase_3.Produccion.EconomyFlight;
import Fase_3.Produccion.Flight;
import Fase_3.Produccion.Passenger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class AirportTest {
    // Refactorización de la clase AirportTest. Pregunta 3
    @DisplayName("Dado que hay un vuelo economico")
    @Nested
    class EconomyFlightTest {

        private Flight economyFlight;
        private Passenger Jessica;
        private Passenger Cesar;

        @BeforeEach
        void setUp() {
            economyFlight = new EconomyFlight("1");
            Jessica = new Passenger("Jessica", false);
            Cesar = new Passenger("Cesar", true);
        }

        @Nested
        @DisplayName("Cuando tenemos un pasajero regular")
        class RegularPassenger {

            @Test
            @DisplayName("Entonces puede agregarlo y eliminarlo de un vuelo económico")
            public void testEconomyFlightRegularPassenger() {
                assertAll("Verifique todas las condiciones para un pasajero regular y un vuelo económico",
                        () -> assertEquals("1", economyFlight.getId()),
                        () -> assertEquals(true, economyFlight.addPassenger(Jessica)),
                        () -> assertEquals(1, economyFlight.getPassengersList().size()),
                        () -> assertEquals("Jessica", economyFlight.getPassengersList().get(0).getName()),
                        () -> assertEquals(true, economyFlight.removePassenger(Jessica)),
                        () -> assertEquals(0, economyFlight.getPassengersList().size())
                );
            }
        }

        @Nested
        @DisplayName("Cuando tenemos un pasajero VIP")
        class VipPassenger {
            @Test
            @DisplayName("Luego puede agregarlo pero no puede eliminarlo de un vuelo económico")
            public void testEconomyFlightVipPassenger() {
                assertAll("Verifique todas las condiciones para un pasajero VIP y un vuelo económico",
                        () -> assertEquals("1", economyFlight.getId()),
                        () -> assertEquals(true, economyFlight.addPassenger(Cesar)),
                        () -> assertEquals(1, economyFlight.getPassengersList().size()),
                        () -> assertEquals("Cesar", economyFlight.getPassengersList().get(0).getName()),
                        () -> assertEquals(false, economyFlight.removePassenger(Cesar)),
                        () -> assertEquals(1, economyFlight.getPassengersList().size())
                );

            }
        }
    }

    @DisplayName("Dado que hay un vuelo negocios")
    @Nested
    class BusinessFlightTest {
        private Flight businessFlight;
        private Passenger Jessica;
        private Passenger Cesar;

        @BeforeEach
        void setUp() {
            businessFlight = new BusinessFlight("2");
            Jessica = new Passenger("Jessica", false);
            Cesar = new Passenger("Cesar", true);
        }

        @Nested
        @DisplayName("Cuando tenemos un pasajero regular")
        class RegularPassenger {

            @Test
            @DisplayName("Entonces no puede agregarlo o eliminarlo de un vuelo de negocios")
            public void testBusinessFlightRegularPassenger() {
                assertAll("Verifique todas las condiciones para un pasajero regular y un vuelo de negocios",
                        () -> assertEquals(false, businessFlight.addPassenger(Jessica)),
                        () -> assertEquals(0, businessFlight.getPassengersList().size()),
                        () -> assertEquals(false, businessFlight.removePassenger(Jessica)),
                        () -> assertEquals(0, businessFlight.getPassengersList().size())
                );
            }
        }

        @Nested
        @DisplayName("Cuando tenemos un pasajero VIP")
        class VipPassenger {

            @Test
            @DisplayName("Entonces puede agregarlo pero no puede eliminarlo de un vuelo de negocios")
            public void testBusinessFlightVipPassenger() {
                assertAll("Verifique todas las condiciones para un pasajero VIP y un vuelo de negocios",
                        () -> assertEquals(true, businessFlight.addPassenger(Cesar)),
                        () -> assertEquals(1, businessFlight.getPassengersList().size()),
                        () -> assertEquals(false, businessFlight.removePassenger(Cesar)),
                        () -> assertEquals(1, businessFlight.getPassengersList().size())
                );
            }
        }
    }
}
