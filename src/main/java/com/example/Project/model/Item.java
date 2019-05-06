package com.example.Project.model;

import com.example.Project.enums.Pointer;
import com.example.Project.enums.StatusItem;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double weight;
    private Pointer startPoint;
    private StatusItem statusItem;

    public Item() {
    }

    public Pointer getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Pointer startPoint) {
        this.startPoint = startPoint;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public StatusItem getStatusItem() {
        return statusItem;
    }

    public void setStatusItem(StatusItem statusItem) {
        this.statusItem = statusItem;
    }

    public static class Builder{
        private String name;
        private double weight;
        private Pointer startPoint;
        private StatusItem statusItem;

        public Builder(Pointer startPoint, StatusItem statusItem) {
            this.startPoint = startPoint;
            this.statusItem = statusItem;
        }
        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withWeight(double weight) {
            this.weight = weight;
            return this;
        }

        public Item build() {
            Item item = new Item();
            item.name = this.name;
            item.weight = this.weight;
            item.startPoint = this.startPoint;
            item.statusItem = this.statusItem;
            return item;
        }
    }
}
