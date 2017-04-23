package com.skidata.x.rest.custom.product;

import com.skidata.x.rest.custom.core.AbstractAggregateRoot;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.money.MonetaryAmount;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author firoz
 * @since 23/04/17
 */
@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class Product extends AbstractAggregateRoot{

    private String ean;
    private String sku;
    private String name;

    private MonetaryAmount price;

    private LocalDateTime expiry;

    public Product(String ean, String sku, String name, MonetaryAmount price){
        // Expiry at end of day today
        this(ean, sku, name, price, LocalDate.now().atTime(22, 00, 00));
    }
}
