package ru.netology.ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Ticket;
import ru.netology.repository.Repository;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {
    Repository repo = new Repository();
    Ticket ticket1 = new Ticket(1, 1100, "AAQ", "DME", 200);
    Ticket ticket2 = new Ticket(2, 600, "ACB", "AZO", 100);
    Ticket ticket3 = new Ticket(3, 900, "ACB", "AZO", 600);
    Ticket ticket4 = new Ticket(4, 800, "AGZ", "SVO", 240);
    Ticket ticket5 = new Ticket(5, 900, "AAQ", "DME", 700);
    Ticket ticket6 = new Ticket(6, 900, "AAQ", "DME", 890);


    @Test
    void shouldFindSameTicketsDifferentPrice() {
        Ticket[] expected = new Ticket[]{ticket2, ticket3};
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        Manager manager = new Manager(repo);
        Ticket[] actual = manager.findAllByParameters("ACB", "AZO");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindOneTicket() {
        Ticket[] expected = new Ticket[]{ticket4};
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        Manager manager = new Manager(repo);
        Ticket[] actual = manager.findAllByParameters("AGZ", "SVO");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindNoTickets() {
        Ticket[] expected = new Ticket[0];
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        Manager manager = new Manager(repo);
        Ticket[] actual = manager.findAllByParameters("SVO", "AGZ");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindSameTicketsEqualsPrice() {
        Ticket[] expected = new Ticket[]{ticket5, ticket6, ticket1};
        repo.add(ticket1);
        repo.add(ticket2);
        repo.add(ticket3);
        repo.add(ticket4);
        repo.add(ticket5);
        repo.add(ticket6);
        Manager manager = new Manager(repo);
        Ticket[] actual = manager.findAllByParameters("AAQ", "DME");
        assertArrayEquals(expected, actual);
    }

}