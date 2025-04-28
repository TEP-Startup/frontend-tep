package com.tep.backend.model.dto;

public class CompanyMinDTO {

    private Long id;
    private String name;
    private String sector;
    private String logoUrl;

    public CompanyMinDTO() {
    }

    public CompanyMinDTO(Long id, String name, String sector, String logoUrl) {
        this.id = id;
        this.name = name;
        this.sector = sector;
        this.logoUrl = logoUrl;
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

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }
}
