package com.example.demoValidation.model;

import com.example.demoValidation.annotation.ValidPhoneNumber;
import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "ITEMS CAN NOT BE EMPTY")
    private String items;

    @Min(value = 100, message = "order value can not be < 100 ")
    @Max(value = 1000, message = "order value can not be > 1000" )
    private Double price;

    @ValidPhoneNumber(message = "phone number is invalid")
    private String phone;
}
