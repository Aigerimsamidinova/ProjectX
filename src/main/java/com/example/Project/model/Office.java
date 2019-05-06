package com.example.Project.model;

import com.example.Project.enums.Pointer;
import javax.persistence.*;
import java.util.List;

@Entity
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Pointer address;
    @OneToMany
    private List<Item> items;

    public Office() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Pointer getAddress() {
        return address;
    }

    public void setAddress(Pointer address) {
        this.address = address;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public static class Builder {
        private Pointer address;
        @OneToMany
        private List<Item> items;

        public Builder(Pointer address) {
            this.address = address;
        }

        public Builder withItems(List<Item> items) {
            this.items = items;
            return this;
        }

        public Office build() {
            Office office = new Office();
            office.address = this.address;
            office.items = this.items;
            return office;
        }
    }
}