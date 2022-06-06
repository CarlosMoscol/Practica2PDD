package Fase_5.Pruebas;

import Fase_4.Produccion.PremiumFlight;
import Fase_5.Produccion.BusinessFlight;
import Fase_5.Produccion.EconomyFlight;
import Fase_5.Produccion.Flight;
import Fase_5.Produccion.Passenger;
import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AirportTest {

    @DisplayName("Dado que hay un vuelo economico")
    @Nested
    class EconomyFlightTest {

        private Flight economyFlight;
        private Passenger jessica;
        private Passenger cesar;

        @BeforeEach
        void setUp() {
            economyFlight = new EconomyFlight("1");
            jessica = new Passenger("Jessica", false);
            cesar = new Passenger("Cesar", true);
        }

        @Nested
        @DisplayName("Cuando tenemos un pasajero regular")
        class RegularPassenger {

            @Test
            @DisplayName("Luegos puedes agregarlo y eliminarlo de un vuelo economico")
            public void testEconomyFlightRegularPassenger() {
                assertAll("Verifica todas las condiciones para un pasajero regular y un vuelo economico",
                        () -> assertEquals("1", economyFlight.getId()),
                        () -> assertEquals(true, economyFlight.addPassenger(jessica)),
                        () -> assertEquals(1, economyFlight.getPassengersSet().size()),
                        () -> assertEquals("Jessica", new ArrayList<>(economyFlight.getPassengersSet()).get(0).getName()),
                        () -> assertEquals(true, economyFlight.removePassenger(jessica)),
                        () -> assertEquals(0, economyFlight.getPassengersSet().size())
                );
            }

            @DisplayName("Entonces no puedes agregarlo a un vuelo economico mas de una vez")
            @RepeatedTest(5)
            public void testEconomyFlightRegularPassengerAddedOnlyOnce(RepetitionInfo repetitionInfo) {
                // Completar el código. Pregunta 8
                for (int i = 0; i < repetitionInfo.getCurrentRepetition(); i++) {
                    economyFlight.addPassenger(jessica);
                }
                assertAll("Verifique que un pasajero regular pueda agregarse a un vuelo económico solo una vez",
                        () -> assertEquals(1, economyFlight.getPassengersSet().size()),
                        () -> assertTrue(economyFlight.getPassengersSet().contains(jessica)),
                        () -> assertTrue(new ArrayList<>(economyFlight.getPassengersSet()).get(0).getName().equals("Jessica"))
                );
            }

            @Nested
            @DisplayName("Cuando tenemos un pasajero VIP")
            class VipPassenger {
                @Test
                @DisplayName("Luego puedes agregarlo pero no puedes eliminarlo de un vuelo economico")
                public void testEconomyFlightVipPassenger() {
                    assertAll("Verifica todas las condiciones para un pasajero VIP y un vuelo economico",
                            () -> assertEquals("1", economyFlight.getId()),
                            () -> assertEquals(true, economyFlight.addPassenger(cesar)),
                            () -> assertEquals(1, economyFlight.getPassengersSet().size()),
                            () -> assertEquals("Cesar", new ArrayList<>(economyFlight.getPassengersSet()).get(0).getName()),
                            () -> assertEquals(false, economyFlight.removePassenger(cesar)),
                            () -> assertEquals(1, economyFlight.getPassengersSet().size())
                    );
                }

                @DisplayName("Entonces no puedes agregarlo a un vuelo economico mas de una vez")
                @RepeatedTest(5)
                public void testEconomyFlightVipPassengerAddedOnlyOnce(RepetitionInfo repetitionInfo) {
                    for (int i = 0; i < repetitionInfo.getCurrentRepetition(); i++) {
                        economyFlight.addPassenger(cesar);
                    }
                    assertAll("Verifica que un pasajero VIP se pueda agregar a un vuelo económico solo una vez",
                            () -> assertEquals(1, economyFlight.getPassengersSet().size()),
                            () -> assertTrue(economyFlight.getPassengersSet().contains(cesar)),
                            () -> assertTrue(new ArrayList<>(economyFlight.getPassengersSet()).get(0).getName().equals("Cesar"))
                    );
                }
            }
        }

        @DisplayName("Dado que hay un vuelo de negocios")
        @Nested
        class BusinessFlightTest {
            private Flight businessFlight;
            private Passenger jessica;
            private Passenger cesar;

            @BeforeEach
            void setUp() {
                businessFlight = new BusinessFlight("2");
                jessica = new Passenger("Jessica", false);
                cesar = new Passenger("Cesar", true);
            }

            @Nested
            @DisplayName("Cuando tenemos un pasajero regular")
            class RegularPassenger_1 {

                @Test
                @DisplayName("Entonces no puedes agregarlo o eliminarlo de un vuelo de negocios")
                public void testBusinessFlightRegularPassenger() {
                    assertAll("Verifica todas las condiciones para un pasajero regular y un vuelo de negocios",
                            () -> assertEquals(false, businessFlight.addPassenger(jessica)),
                            () -> assertEquals(0, businessFlight.getPassengersSet().size()),
                            () -> assertEquals(false, businessFlight.removePassenger(jessica)),
                            () -> assertEquals(0, businessFlight.getPassengersSet().size())
                    );
                }
            }

            @Nested
            @DisplayName("Cuando tenemos un pasajero VIP")
            class VipPassenger {

                @Test
                @DisplayName("Luego puedes agregarlo pero no puedes eliminarlo de un vuelo de negocios")
                public void testBusinessFlightVipPassenger() {
                    assertAll("Verifica todas las condiciones para un pasajero VIP y un vuelo de negocios",
                            () -> assertEquals(true, businessFlight.addPassenger(cesar)),
                            () -> assertEquals(1, businessFlight.getPassengersSet().size()),
                            () -> assertEquals(false, businessFlight.removePassenger(cesar)),
                            () -> assertEquals(1, businessFlight.getPassengersSet().size())
                    );
                }

                @DisplayName("Entonces no puedes agregarlo a un vuelo de negocios mas de una vez.")
                @RepeatedTest(5)
                public void testBusinessFlightVipPassengerAddedOnlyOnce(RepetitionInfo repetitionInfo) {
                    for (int i = 0; i < repetitionInfo.getCurrentRepetition(); i++) {
                        businessFlight.addPassenger(cesar);
                    }
                    assertAll("Verifica que un pasajero VIP se pueda agregar a un vuelo de negocios solo una vez",
                            () -> assertEquals(1, businessFlight.getPassengersSet().size()),
                            () -> assertTrue(businessFlight.getPassengersSet().contains(cesar)),
                            () -> assertTrue(new ArrayList<>(businessFlight.getPassengersSet()).get(0).getName().equals("Cesar"))
                    );
                }
            }
        }

        @DisplayName("Dado que hay un vuelo de clase PREMIUM")
        @Nested
        class PremiumFlightTest {
            private Fase_4.Produccion.Flight premiumFlight;
            private Fase_4.Produccion.Passenger Jessica;
            private Fase_4.Produccion.Passenger Cesar;

            @BeforeEach
            void setUp() {
                premiumFlight = new PremiumFlight("3");
                Jessica = new Fase_4.Produccion.Passenger("Jessica", false);
                Cesar = new Fase_4.Produccion.Passenger("Cesar", true);
            }

            @Nested
            @DisplayName("El caso cuando se tiene a un pasajero de clase regular")
            class RegularPassenger {

                @Test
                @DisplayName("Entonces no puedes ni añadirlo ni retirarlo del vuelo de clase premium")
                public void testPremiumFlightRegularPassenger() {
                    assertAll("Se verifican todas las condiciones para un pasajero de clase regular y un vuelo de clase premium",
                            () -> assertEquals(false, premiumFlight.addPassenger(Jessica)),
                            () -> assertEquals(0, premiumFlight.getPassengersList().size()),
                            () -> assertEquals(false, premiumFlight.removePassenger(Jessica)),
                            () -> assertEquals(0, premiumFlight.getPassengersList().size())
                    );
                }
            }

            @Nested
            @DisplayName("El caso cuando el pasajero es de clase VIP")
            class VipPassenger {

                @Test
                @DisplayName("Ya que es un VIP puedes añadirlo o removerlo del vuelvo de clase premium")
                public void testPremiumFlightVipPassenger() {
                    assertAll("Se verifican todas las condiciones para un pasajero de clase VIP y un vuelo de clase premium",
                            () -> assertEquals(true, premiumFlight.addPassenger(Cesar)),
                            () -> assertEquals(1, premiumFlight.getPassengersList().size()),
                            () -> assertEquals(true, premiumFlight.removePassenger(Cesar)),
                            () -> assertEquals(0, premiumFlight.getPassengersList().size())
                    );
                }


                @DisplayName("Entonces no puedes agregarlo a un vuelo premium mas de una vez")
                @RepeatedTest(5)
                public void testPremiumFlightVipPassengerAddedOnlyOnce(RepetitionInfo repetitionInfo) {
                    for (int i = 0; i < repetitionInfo.getCurrentRepetition(); i++) {
                        PremiumFlight.addPassenger(cesar);
                    }
                    assertAll("Verifica que un pasajero VIP se pueda agregar a un vuelo premium solo una vez",
                            () -> assertEquals(1, premiumFlight.getPassengersSet().size()),
                            () -> assertTrue(premiumFlight.getPassengersSet().contains(cesar)),
                            () -> assertTrue(new ArrayList<>(premiumFlight.getPassengersSet()).get(0).getName().equals("Cesar"))
                    );
                }
            }
        }
    }
}



