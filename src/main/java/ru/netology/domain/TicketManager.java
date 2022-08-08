package ru.netology.domain;

import ru.netology.repository.TicketRepository;

import java.util.Arrays;
import java.util.Comparator;

public class TicketManager {

    private TicketRepository repo;

    public TicketManager(TicketRepository repo) {    //конструктор
        this.repo = repo;
    }

    public Ticket[] getTickets() {
        Ticket[] all = repo.getTickets();
        return all;
    }

    public void add(Ticket ticket) {                 //добавляет продукты
        repo.save(ticket);
    }


    public Ticket[] findAll(String from, String to, Comparator<Ticket> comparator) {
        Ticket[] result = new Ticket[0];               // тут будем хранить подошедшие запросу продукты
        for (Ticket ticket : repo.showAll()) {
            if (matches(ticket, from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
            Arrays.sort(result, comparator);
        }
        return result;
    }

    public boolean matches(Ticket ticket, String from, String to) {
        if (ticket.getFrom().contains(from)) {
            return true;
        } else if (ticket.getTo().contains(to)) {
            return true;
        } else {
            return false;
        }
    }

    public Ticket[] findAllWithoutComparator(String from, String to) {
        Ticket[] result = new Ticket[0];               // тут будем хранить подошедшие запросу продукты
        for (Ticket ticket : repo.showAll()) {
            if (matches(ticket, from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }

        }
        Arrays.sort(result);
        return result;
    }


}
















