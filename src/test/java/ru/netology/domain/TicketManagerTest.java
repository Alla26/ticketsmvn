package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.TicketRepository;

import java.util.Comparator;

public class TicketManagerTest {

    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);
    TicketByTravelTimeAscComparator comparator = new TicketByTravelTimeAscComparator();

    Ticket ticket1 = new Ticket(1, 25_000, "DME", "KGD", 130);
    Ticket ticket2 = new Ticket(2, 22_000, "AER", "VKO", 140);
    Ticket ticket3 = new Ticket(3, 23_000, "SVO", "LED", 120);
    Ticket ticket4 = new Ticket(4, 23_000, "KZN", "GOJ", 150);
    Ticket ticket5 = new Ticket(5, 21_000, "KZN", "VKO", 145);
    Ticket ticket6 = new Ticket(6, 21_000, "AER", "KGD", 145);

    @BeforeEach
    public void setup() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

    }

   /* @Test
    public void shouldFindTicketsWhenNextLess() {


        Ticket[] expected = {ticket3, ticket1};
        Ticket[] actual = manager.findAll("DME", "LED", comparator);


        Assertions.assertArrayEquals(expected, actual);

    }*/

    @Test
    public void shouldFindTicketsWhenNextBigger() {

        Ticket[] expected = {ticket3, ticket2, ticket6};
        Ticket[] actual = manager.findAll("AER", "LED", comparator);


        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindTicketsWhenEqual() {

        Ticket[] expected = {ticket3, ticket4};
        Ticket[] actual = manager.findAll("SVO", "GOJ", comparator);


        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindTicketsMoreThanTwo() {

        Ticket[] expected = {ticket1, ticket5, ticket6, ticket4};
        Ticket[] actual = manager.findAll("KZN", "KGD", comparator);


        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindTicketsWithoutComparator() {

        Ticket[] expected = {ticket5, ticket6, ticket4, ticket1};
        Ticket[] actual = manager.findAllWithoutComparator("KZN", "KGD");


        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindOneTicket() {

        Ticket[] expected = {ticket4};
        Ticket[] actual = manager.findAllWithoutComparator("CEK", "GOJ");


        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldNotFindTickets() {

        Ticket[] expected = {};
        Ticket[] actual = manager.findAllWithoutComparator("SVX", "CEK");


        Assertions.assertArrayEquals(expected, actual);

    }


}
