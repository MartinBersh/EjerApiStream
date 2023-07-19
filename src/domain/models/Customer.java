package domain.models;

import domain.enumm.ClientTier;

import java.awt.*;
import java.util.List;

public class Customer {

    private Long id;
    private String name;
    private ClientTier tier;
    private List<Customer> customers;

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

    public ClientTier getTier() {
        return tier;
    }

    public void setTier(ClientTier tier) {
        this.tier = tier;
    }
}
