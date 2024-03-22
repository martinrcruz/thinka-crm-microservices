package cl.thinka.salemicroservice.v1.dto.request;

import lombok.Data;

@Data
public class EditSaleRequestDTO {
    private Long id;
    private String title;
    private String shortDesc;
    private String longDesc;
    private String startDate;
    private String endDate;
    private String inCharge;
    private String saleStatus;
    private String expirationDate;
    private String budget;
    private String price;
    private String documentUrl;
    private String brief;
    private String taskId;
    private int payedAmount;
}
