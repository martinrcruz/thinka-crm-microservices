package cl.thinka.clientmicroservice.v1.dto.request;

import lombok.Data;

@Data
public class AddClientRequestDTO {
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
}
