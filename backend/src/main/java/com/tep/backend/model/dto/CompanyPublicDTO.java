package com.tep.backend.model.dto;

public class CompanyPublicDTO {

    private Long id;
    private String name;
    private String description;
    private String sector;
    private String logoUrl;
    private String website;

    public CompanyPublicDTO() {
    }

    public CompanyPublicDTO(Long id, String name, String description, String sector, String logoUrl, String website) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.sector = sector;
        this.logoUrl = logoUrl;
        this.website = website;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
