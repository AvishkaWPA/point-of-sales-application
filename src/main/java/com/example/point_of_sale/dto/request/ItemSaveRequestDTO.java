package com.example.point_of_sale.dto.request;

import com.example.point_of_sale.entity.enums.MeasuringUnitType;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ItemSaveRequestDTO {

    private String itemName;

    private MeasuringUnitType measuringUnitType;

    private double balanceQty;

    private double supplierPrice;

    private double sellingPrice;


}
