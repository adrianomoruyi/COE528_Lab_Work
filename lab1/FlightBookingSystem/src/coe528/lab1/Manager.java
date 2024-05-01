/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe528.lab1;

/**
 *
 * @author babye
 */
public class Manager {
    
    private Flight[] flightArray;
    private Ticket[] ticketArray = new Ticket [100];

    public Manager() {
    }
    
    public void createFlights() {
        flightArray = new Flight[3];
        flightArray[0] = new Flight (1000, "Toronto", "Toronto", "03/02/24 7:30 am", 200, 1000.00);
        flightArray[1] = new Flight (1020, "Toronto", "Miami", "03/02/24 2:50 pm", 1, 800.00);
        flightArray[2] = new Flight (1080, "Toronto", "Miami", "03/02/24 8:00 pm", 150, 1200.00);
    }
    
    public void displayAvailableFlights(String origin, String destination) {
        System.out.println("AVAILABLE FLIGHTS----------------------------------------------------------");
        for (int i = 0; i < flightArray.length; i++)
        {
            if (origin.equals(flightArray[i].getOrigin()) && destination.equals(flightArray[i].getDestination()) && flightArray[i].getNumberOfSeatsLeft() > 0)
            {
                System.out.println(flightArray[i]);
                 
            }
            
        }
        System.out.println("---------------------------------------------------------------------------");
        
    }
    
    public Flight getFlight(int flightNumber) {
        for (int i = 0; i < flightArray.length; i++)
        {
            if (flightNumber == flightArray[i].getFlightNumber())
            {
                return flightArray[i];
            }
        }
        return null;
    }
    
    public void bookSeat(int flightNumber, Passenger p) {
        for (int i = 0; i < flightArray.length; i++)
        {
            if (flightNumber == flightArray[i].getFlightNumber())
            {
                if (flightArray[i].getNumberOfSeatsLeft() > 0) {
                    flightArray[i].bookASeat();
                    ticketArray[Ticket.getNumberCount()] = new Ticket(p, flightArray[i], p.applyDiscount(flightArray[i].getOriginalPrice()));
                    System.out.println("Ticket Booked!");
                    //Index is Ticket Number Count - 1 since it is incremented by 1 when a new ticket is created.
                    System.out.println(ticketArray[Ticket.getNumberCount() - 1]);
                }           
            }
        }   
    }
    public static void main(String[] args ) {
        //Creating 2 Passengers
        Member guy = new Member (7, "John Doe", 42);
        //NonMember girl = new NonMember ("Jane Doe", 68);
        
        Manager airline = new Manager();
        //Creating the Flights
        airline.createFlights();
        //Displaying the Available Flights
        airline.displayAvailableFlights("Toronto", "Miami");
        airline.flightArray[1].setFlightNumber(1040);
        //Displaying the Available Flights
        airline.displayAvailableFlights("Toronto", "Miami");
        //Priting out Flight 1020's details
        System.out.println(airline.getFlight(1040));
        //Booking Flight 1020, 50% discount due to member status and years of membership
        airline.bookSeat(1040, guy);
        
        
        /*
        //Booking a ticket for the second passenger; Flight 1020 is now full
        System.out.println("PASSENGER 2 ---------------------------------------------------------------------------");
        
        //Displaying the Available Flights
        airline.displayAvailableFlights("Toronto", "Miami");
        //Priting out Flight 1080's details
        System.out.println(airline.getFlight(1080));
        //Booking Flight 1080, 10% discount due to nonmember status and age
        airline.bookSeat(1080, girl);
*/
        
    }
    
}
