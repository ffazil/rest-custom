package com.skidata.x.rest.custom.product;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.javamoney.moneta.Money;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;

/**
 * @author firoz
 * @since 23/04/17
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class ProductInitializer {

    @NonNull
    private final ProductRepository productRepository;

    @EventListener
    public void init(ApplicationReadyEvent event){
        if(productRepository.count() != 0){
            return;
        }

        Product parotta = new Product("p001", "p100", "Kerala parotta", Money.of(15.00, "INR"));
        Product beefFry = new Product("p002", "p200", "Beef fry", Money.of(80.00, "INR"));


        parotta = productRepository.save(parotta);
        beefFry = productRepository.save(beefFry);

        log.info("Products added = {}", productRepository.count());
    }
}
