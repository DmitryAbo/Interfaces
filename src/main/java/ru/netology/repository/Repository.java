package ru.netology.repository;

import ru.netology.domain.Ticket;

public class Repository {

    Ticket[] tickets = new Ticket[0];

    public void add(Ticket ticket) {
        Ticket[] tmp = new Ticket[tickets.length + 1];
        for (int i = 0; i < tickets.length; i++) {
            tmp[i] = tickets[i];
        }
        tmp[tmp.length - 1] = ticket;
        tickets = new Ticket[tmp.length];
        System.arraycopy(tmp, 0, tickets, 0, tmp.length);
    }

    public Ticket[] getAll() {
        Ticket[] result = new Ticket[tickets.length];
        System.arraycopy(tickets, 0, result, 0, tickets.length);
        return result;
    }

    public void removeById(int id) {
        Ticket[] tmp = new Ticket[tickets.length - 1];
        int copyToIndex = 0;
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i].getId() != id) {
                tmp[copyToIndex] = tickets[i];
                copyToIndex++;
            }
        }
        tickets = new Ticket[tmp.length];
        System.arraycopy(tmp, 0, tickets, 0, tmp.length);
    }
}
