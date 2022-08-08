package ru.netology.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.TicketRepository;

public class TicketManagerTest {

    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(1, 25_000, "DME", "KGD", 130);
    Ticket ticket2 = new Ticket(2, 22_000, "AER", "VKO", 120);
    Ticket ticket3 = new Ticket(3, 23_000, "SVO", "LED", 120);
    Ticket ticket4 = new Ticket(4, 23_000, "KZN", "GOJ", 120);
    Ticket ticket5 = new Ticket(5, 21_000, "KZN", "VKO", 120);
    Ticket ticket6 = new Ticket(6, 21_000, "HTA", " VVO", 200);

    @BeforeEach
    public void setup() {
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);

    }


    @Test
    public void shouldFindOneTicket() {

        Ticket[] expected = {ticket6};
        Ticket[] actual = manager.findAll("HTA", "SVX");


        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldNotFindTickets() {

        Ticket[] expected = {};
        Ticket[] actual = manager.findAll("SVX", "CEK");


        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindTicketsWhenEqual() {       //тест на билеты с одинаковой ценой

        Ticket[] expected = {ticket3, ticket4};
        Ticket[] actual = manager.findAll("SVO", "GOJ");


        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindTicketsMoreThanTwo() {        //тест на несколько товаров в произвольном порядке

        Ticket[] expected = {ticket5, ticket4, ticket1};
        Ticket[] actual = manager.findAll("KZN", "KGD");


        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void shouldFindTicketsWhenNextBigger() {

        Ticket[] expected = {ticket2, ticket3};
        Ticket[] actual = manager.findAll("AER", "LED");


        Assertions.assertArrayEquals(expected, actual);

    }

     /*  @Test
    public void shouldFindTicketsWhenNextLess() {

        Ticket[] expected = {ticket3, ticket1};
        Ticket[] actual = manager.findAll("DME", "LED");


        Assertions.assertArrayEquals(expected, actual);

    }*/

}
