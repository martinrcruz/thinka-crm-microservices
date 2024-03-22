package cl.thinka.salemicroservice.v1.dto;

import lombok.Data;

@Data
public class SaleDTO {
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
    private String createdAt;
    private Long createdBy;
    private String lastModifiedAt;
    private Long lastModifiedBy;
    private String deletedAt;
    private Long deletedBy;
    private Integer status;
}
