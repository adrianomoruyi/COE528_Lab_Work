/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package coe528.lab1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author babye
 */
public class FlightTest {
    
    public FlightTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    
      @Test
    public void testConstructor() {
        System.out.println("Constructor Test");
        Flight instance = new Flight (1010, "Toronto", "Miami", "2:00", 200, 500.00);
        
        int expResult1 = 1010;
        int result1 = instance.getFlightNumber();
        assertEquals(expResult1, result1);
        
        String expResult2 = "Toronto";
        String result2 = instance.getOrigin();
        assertEquals(expResult2, result2);
        
        String expResult3 = "Miami";
        String result3 = instance.getDestination();
        assertEquals(expResult3, result3);
        
        String expResult4 = "2:00";
        String result4 = instance.getDepartureTime();
        assertEquals(expResult4, result4);
        
        int expResult5 = 200;
        int result5 = instance.getCapacity();
        assertEquals(expResult5, result5);
        
        int expResult6 = 200;
        int result6 = instance.getNumberOfSeatsLeft();
        assertEquals(expResult6, result6);
        
        double expResult7 = 500.00;
        double result7 = instance.getOriginalPrice();
        assertEquals(expResult7, result7, 0);
        
        
        System.out.println(instance);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testInvalidConstructor() {
        System.out.println("Constructor Test");
        Flight instance = new Flight (1010, "Toronto", "Toronto", "2:00", 200, 500.00);
        
        System.out.println(instance);
    }
    
    /**
     * Test of bookASeat method, of class Flight.
     */
    @Test
    public void testBookASeat() {
        System.out.println("bookASeat");
        Flight instance = new Flight (1010, "Toronto", "Miami", "2:00", 200, 500.00);
        boolean expResult = true;
        boolean result = instance.bookASeat();
        assertEquals(expResult, result);
        System.out.println(result);
    }

    /**
     * Test of getFlightNumber method, of class Flight.
     */
    @Test
    public void testGetFlightNumber() {
        System.out.println("getFlightNumber");
        Flight instance = new Flight (1010, "Toronto", "Miami", "2:00", 200, 500.00);
        int expResult = 1010;
        int result = instance.getFlightNumber();
        assertEquals(expResult, result);
        System.out.println(result);
        
    }

    /**
     * Test of setFlightNumber method, of class Flight.
     */
    @Test
    public void testSetFlightNumber() {
        System.out.println("setFlightNumber");
        int flightNumber = 0;
        Flight instance = new Flight (1010, "Toronto", "Miami", "2:00", 200, 500.00);
        instance.setFlightNumber(flightNumber);
        
    }

    /**
     * Test of getOrigin method, of class Flight.
     */
    @Test
    public void testGetOrigin() {
        System.out.println("getOrigin");
        Flight instance = new Flight (1010, "Toronto", "Miami", "2:00", 200, 500.00);
        String expResult = "Toronto";
        String result = instance.getOrigin();
        assertEquals(expResult, result);
        System.out.println(result);
       
    }

    /**
     * Test of setOrigin method, of class Flight.
     */
    @Test
    public void testSetOrigin() {
        System.out.println("setOrigin");
        String origin = "";
        Flight instance = new Flight (1010, "Toronto", "Miami", "2:00", 200, 500.00);
        instance.setOrigin(origin);
       
    }

    /**
     * Test of getDestination method, of class Flight.
     */
    @Test
    public void testGetDestination() {
        System.out.println("getDestination");
        Flight instance = new Flight (1010, "Toronto", "Miami", "2:00", 200, 500.00);
        String expResult = "Miami";
        String result = instance.getDestination();
        assertEquals(expResult, result);
        System.out.println(result);
        
    }

    /**
     * Test of setDestination method, of class Flight.
     */
    @Test
    public void testSetDestination() {
        System.out.println("setDestination");
        String destination = "";
        Flight instance = new Flight (1010, "Toronto", "Miami", "2:00", 200, 500.00);
        instance.setDestination(destination);
   
    }

    /**
     * Test of getDepartureTime method, of class Flight.
     */
    @Test
    public void testGetDepartureTime() {
        System.out.println("getDepartureTime");
        Flight instance = new Flight (1010, "Toronto", "Miami", "2:00", 200, 500.00);
        String expResult = "2:00";
        String result = instance.getDepartureTime();
        assertEquals(expResult, result);
        System.out.println(result);
        
    }

    /**
     * Test of setDepartureTime method, of class Flight.
     */
    @Test
    public void testSetDepartureTime() {
        System.out.println("setDepartureTime");
        String departureTime = "";
        Flight instance = new Flight (1010, "Toronto", "Miami", "2:00", 200, 500.00);
        instance.setDepartureTime(departureTime);
      
    }

    /**
     * Test of getCapacity method, of class Flight.
     */
    @Test
    public void testGetCapacity() {
        System.out.println("getCapacity");
        Flight instance = new Flight (1010, "Toronto", "Miami", "2:00", 200, 500.00);
        int expResult = 200;
        int result = instance.getCapacity();
        assertEquals(expResult, result);
        System.out.println(result);
    }

    /**
     * Test of setCapacity method, of class Flight.
     */
    @Test
    public void testSetCapacity() {
        System.out.println("setCapacity");
        int capacity = 0;
        Flight instance = new Flight (1010, "Toronto", "Miami", "2:00", 200, 500.00);
        instance.setCapacity(capacity);
      
    }

    /**
     * Test of getNumberOfSeatsLeft method, of class Flight.
     */
    @Test
    public void testGetNumberOfSeatsLeft() {
        System.out.println("getNumberOfSeatsLeft");
        Flight instance = new Flight (1010, "Toronto", "Miami", "2:00", 200, 500.00);
        int expResult = 200;
        int result = instance.getNumberOfSeatsLeft();
        assertEquals(expResult, result);
        System.out.println(result);
    }

    /**
     * Test of setNumberOfSeatsLeft method, of class Flight.
     */
    @Test
    public void testSetNumberOfSeatsLeft() {
        System.out.println("setNumberOfSeatsLeft");
        int numberOfSeatsLeft = 0;
        Flight instance = new Flight (1010, "Toronto", "Miami", "2:00", 200, 500.00);
        instance.setNumberOfSeatsLeft(numberOfSeatsLeft);
        
    }

    /**
     * Test of getOriginalPrice method, of class Flight.
     */
    @Test
    public void testGetOriginalPrice() {
        System.out.println("getOriginalPrice");
        Flight instance = new Flight (1010, "Toronto", "Miami", "2:00", 200, 500.00);
        double expResult = 500.00;
        double result = instance.getOriginalPrice();
        assertEquals(expResult, result, 0);
        System.out.println(result);
    }

    /**
     * Test of setOriginalPrice method, of class Flight.
     */
    @Test
    public void testSetOriginalPrice() {
        System.out.println("setOriginalPrice");
        double originalPrice = 0.0;
        Flight instance = new Flight (1010, "Toronto", "Miami", "2:00", 200, 500.00);
        instance.setOriginalPrice(originalPrice);
       
    }

    /**
     * Test of toString method, of class Flight.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Flight instance = new Flight (1010, "Toronto", "Miami", "2:00", 200, 500.00);
        String expResult = "Flight 1010, Toronto to Miami, 2:00, original price: 500.0$";
        String result = instance.toString();
        assertEquals(expResult, result);
        System.out.println(result);
     
    }
    
}
