package ru.netology.ru.netology.manager;

import ru.netology.domain.Ticket;
import ru.netology.repository.Repository;

import java.util.Arrays;

public class Manager {

    private Repository repo = new Repository();

    public Manager(Repository repo) {
        this.repo = repo;
    }

    public Ticket[] findAllByParameters(String from, String to) {
        Ticket[] tmp = new Ticket[0];
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.getAll()) {
            if (ticket.matchDeparture(from) && ticket.matchArrival(to)) {
                tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = new Ticket[tmp.length];
                System.arraycopy(tmp, 0, result, 0, tmp.length);

            }
        }
        Arrays.sort(result);
        return result;
    }
}
