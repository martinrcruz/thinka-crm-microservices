package cl.thinka.projectmicroservice.v1.dto;

import lombok.Data;


@Data
public class ProjectDTO {
    private Long id;
    private String title;
    private String shortDesc;
    private String longDesc;
    private String objective;
    private String note;
    private String startDate;
    private String endDate;
    private String inCharge;
    private String expirationDate;
    private String documentUrl;
    private String brief;
    private String createdAt;
    private Long createdBy;
    private String lastModifiedAt;
    private Long lastModifiedBy;
    private String deletedAt;
    private Long deletedBy;
    private Integer status;
}