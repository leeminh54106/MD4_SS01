package com.ra.session01.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.text.NumberFormat;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sku;
    @NotBlank
    @Pattern(regexp = "^\\w+$",message = "Khong chua ki tu dac biet")
    private String name;
    private Integer stock;
    private BigDecimal price;
    @NotBlank(message = "Khong duoc de trong")
    private String description;
    public String getPriceFormat(){
        return NumberFormat.getCurrencyInstance().format(price);
    }
}
