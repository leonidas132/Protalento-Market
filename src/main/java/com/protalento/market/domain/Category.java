package com.protalento.market.domain;

public class Category {

    private int categoriryId;
    private String category;
    private boolean active;

    public int getCategoriryId() {
        return categoriryId;
    }

    public void setCategoriryId(int categoriryId) {
        this.categoriryId = categoriryId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
