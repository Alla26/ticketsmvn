package ru.netology.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;

public class TicketRepositoryTest {

    TicketRepository repo = new TicketRepository();

    Ticket ticket1 = new Ticket(1, 25_000, "DME", "KGD", 130);
    Ticket ticket2 = new Ticket(2, 22_000, "AER", "VKO", 120);
    Ticket ticket3 = new Ticket(3, 22_000, "SVO", "LED", 120);

    @BeforeEach
    public void setup() {
        repo.save(ticket1);
        repo.save(ticket2);
        repo.save(ticket3);

    }

    @Test
    public void shouldSaveTicket() {

        Ticket[] expected = {ticket1, ticket2, ticket3};
        Ticket[] actual = repo.getTickets();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldReturnAllTickets() {

        Ticket[] expected = {ticket1, ticket2, ticket3};
        Ticket[] actual = repo.showAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {
        Ticket[] expected = {ticket1, ticket3};
        Ticket[] actual = repo.removeById(2);

        Assertions.assertArrayEquals(expected, actual);
    }


}
