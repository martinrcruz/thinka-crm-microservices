package cl.thinka.projectmicroservice.v1.dto.request;

import lombok.Data;

@Data
public class AddProjectRequestDTO {
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
}
