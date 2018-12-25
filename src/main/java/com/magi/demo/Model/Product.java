package com.magi.demo.Model;

public class Product {
    private Integer id;

    private Integer productDate;

    private String hash;

    private String version;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getProductDate() {
        return productDate;
    }

    public void setProductDate(Integer productDate) {
        this.productDate = productDate;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash == null ? null : hash.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }
}