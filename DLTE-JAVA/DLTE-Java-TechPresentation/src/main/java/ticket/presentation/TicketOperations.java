package ticket.presentation;

import lombok.Data;


import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

@Data
public class TicketOperations implements TicketInterface{
    private Scanner sc = new Scanner(System.in);
    private Map<String,Ticket> ticketDetails=new TreeMap<>();

    @Override
    public String createTicket() {
        System.out.println("Enter the ticket id :");
        String tid= sc.next();

        if(ticketDetails.containsKey(tid)){
            System.out.println("Ticket ID exists already! Enter another one :");
            tid= sc.next();
        }
        System.out.println("Enter the issue ");
        String tissue= sc.next();

        System.out.println("Enter the card number :");
        String card_no = sc.next();
        String card_regex ="\\b\\d{4}[ -]?\\d{4}[ -]?\\d{4}[ -]?\\d{4}\\b";
        if (!card_no.matches(card_regex)){
            System.out.println("Invalid Card number, Enter again");
            card_no = sc.next();
        }

        String date_regex = "\\b\\d{4}[ -]?\\d{4}[ -]?\\d{4}[ -]?\\d{4}\\b";
        System.out.println("Enter the date in the format (DDMMYYYY)");
        String dateOfTicket = sc.next();
        if (dateOfTicket.matches(date_regex)){
            System.out.println("Enter the date in correct format :");
            dateOfTicket = sc.next();
        }

        System.out.println("Enter the status of the ticket :");
        String tstatus = sc.next();

        System.out.println(tid+tissue+card_no+dateOfTicket+tstatus);
        Ticket ticket = new Ticket(tid,tissue,card_no,dateOfTicket,tstatus);
        ticketDetails.put(tid,ticket);
        return "A New Ticket has been created";
    }

    @Override
    public void update() {
        System.out.println("Enter the ticket ID of the ticket you wish to update :");
        String tid = sc.next();
        if(!ticketDetails.containsKey(tid)){
            System.out.println("The entered key does not exist! Re-enter an existing one:");
            tid=sc.next();
        }
        System.out.println("Enter the updated details:");
        System.out.println("Enter the issue ");
        String tissue= sc.next();

        System.out.println("Enter the card number :");
        String card_no = sc.next();
        String card_regex ="\\b\\d{4}[ -]?\\d{4}[ -]?\\d{4}[ -]?\\d{4}\\b";
        if (!card_no.matches(card_regex)){
            System.out.println("Invalid Card number, Enter again");
            card_no = sc.next();
        }

        String date_regex = "\\b\\d{4}[ -]?\\d{4}[ -]?\\d{4}[ -]?\\d{4}\\b";
        System.out.println("Enter the date in the format (DDMMYYYY)");
        String dateOfTicket = sc.next();
        if (dateOfTicket.matches(date_regex)){
            System.out.println("Enter the date in correct format :");
            dateOfTicket = sc.next();
        }

        System.out.println("Enter the status of the ticket :");
        String tstatus = sc.next();

        Ticket updatedticket = new Ticket(tid,tissue,card_no,dateOfTicket,tstatus);
        ticketDetails.put(tid,updatedticket);

    }

    public Map<String, Ticket> getTicketDetails() {
        return ticketDetails;
    }

    public void setTicketDetails(Map<String, Ticket> ticketDetails) {
        this.ticketDetails = ticketDetails;
    }
}
