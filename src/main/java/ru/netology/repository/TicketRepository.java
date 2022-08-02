package ru.netology.repository;

import ru.netology.domain.Ticket;

public class TicketRepository {

    private Ticket[] tickets = new Ticket[0];

    public Ticket[] getTickets() {
        return tickets;
    }

    public void save(Ticket product) {                      //сохраняет билет
        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = product;
        tickets = tmp;
    }

    public Ticket[] showAll() {                          //возвращает все билеты
        Ticket[] all = getTickets();
        Ticket[] list = new Ticket[all.length];
        for (int i = 0; i < list.length; i++) {
            list[i] = all[i];
        }
        return list;
    }

    public Ticket[] removeById(int id) {                    //удаляет билеты по ID
        Ticket[] tmp = new Ticket[tickets.length - 1];
        int copyToIndex = 0;
        for (Ticket product : tickets) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        tickets = tmp;
        return tmp;
    }


}
