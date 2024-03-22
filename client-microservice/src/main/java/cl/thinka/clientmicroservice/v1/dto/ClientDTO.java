package cl.thinka.clientmicroservice.v1.dto;

import lombok.Data;

@Data
public class ClientDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String rut;
    private String email;
    private String city;
    private String contactPlatform;
    private int budget;
    private String projectDescription;
    private String expectedDate;
    private String deliveryStatus;
    private String workLine;
    private String inCharge;
    private String createdAt;
    private Long createdBy;
    private String lastModifiedAt;
    private Long lastModifiedBy;
    private String deletedAt;
    private Long deletedBy;
    private Integer status;
}
