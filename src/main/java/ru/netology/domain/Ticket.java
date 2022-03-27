package ru.netology.domain;

import lombok.AllArgsConstructor;

@AllArgsConstructor

public class Ticket implements Comparable<Ticket> {
    private int id;
    private int price;
    private String departure;
    private String arrival;
    private int flyTime;

    public boolean matchDeparture(String search) {
        return this.departure.contains(search);
    }

    public boolean matchArrival(String search) {
        return this.arrival.contains(search);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String departure) {
        this.departure = departure;
    }

    public String getArrival() {
        return arrival;
    }

    public void setArrival(String arrival) {
        this.arrival = arrival;
    }

    public int getFlyTime() {
        return flyTime;
    }

    public void setFlyTime(int flyTime) {
        this.flyTime = flyTime;
    }

    @Override
    public int compareTo(Ticket o) {
        return this.price - o.price;
    }
}
