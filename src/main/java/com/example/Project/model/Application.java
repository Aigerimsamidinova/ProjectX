package com.example.Project.model;

import com.example.Project.enums.Pointer;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.*;

@Entity
@Table(name = "application")
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fio;
    private String phone;
    private String address;
    private String nameItem;
    private double weightItem;
    private Pointer startPoint;
    private Pointer endPoint;

    public Application() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNameItem() {
        return nameItem;
    }

    public void setNameItem(String nameItem) {
        this.nameItem = nameItem;
    }

    public double getWeightItem() {
        return weightItem;
    }

    public void setWeightItem(double weightItem) {
        this.weightItem = weightItem;
    }

    public Pointer getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Pointer startPoint) {
        this.startPoint = startPoint;
    }

    public Pointer getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Pointer endPoint) {
        this.endPoint = endPoint;
    }

    public static class Builder {
        private String fio;
        private String phone;
        private String address;
        private String nameItem;
        private double weightItem;
        private Pointer startPoint;
        private Pointer endPoint;

        public Builder(String phone, String address, Pointer startPoint) {
            this.phone = phone;
            this.address = address;
            this.startPoint = startPoint;
        }

        public Builder withFio(String fio) {
            this.fio = fio;
            return this;
        }

        public Builder withnameItem(String nameItem) {
            this.nameItem = nameItem;
            return this;
        }

        public Builder withWeightItem(double weightItem) {
            this.weightItem = weightItem;
            return this;
        }

        public Builder withEndPoint(Pointer endPoint) {
            this.endPoint = endPoint;
            return this;
        }

        public Application build() {
            Application application = new Application();
            application.fio = this.fio;
            application.weightItem = this.weightItem;
            application.startPoint = this.startPoint;
            application.endPoint = this.endPoint;
            application.phone = this.phone;
            application.address = this.address;
            application.nameItem = this.nameItem;
            return application;
        }
    }
}