package com.example.Project.model;

import com.example.Project.enums.Pointer;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Courier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fio;
    private String phone;
    private String email;
    private Pointer address;

    public Courier() {
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

    public Pointer getAddress() {
        return address;
    }

    public void setAddress(Pointer address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public static class Builder {
        private String fio;
        private String phone;
        private String email;
        private Pointer address;

        public Builder(Pointer address) {
            this.address = address;
        }

        public Builder withFio(String fio) {
            this.fio = fio;
            return this;
        }

        public Builder withPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;
            return this;
        }

        public Courier build() {
            Courier courier = new Courier();
            courier.fio = this.fio;
            courier.phone = this.phone;
            courier.email = this.email;
            courier.address = this.address;
            return courier;
        }
    }
}
