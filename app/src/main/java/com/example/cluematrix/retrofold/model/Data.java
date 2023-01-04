package com.example.cluematrix.retrofold.model;

public class Data {
    int id;
    String rf_id;
    String created_at;
    String updated_at;

    public Data(int id, String rf_id, String created_at, String updated_at) {
        this.id = id;
        this.rf_id = rf_id;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRf_id() {
        return rf_id;
    }

    public void setRf_id(String rf_id) {
        this.rf_id = rf_id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
