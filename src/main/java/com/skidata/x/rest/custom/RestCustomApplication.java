package com.skidata.x.rest.custom;

import com.fasterxml.jackson.databind.Module;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.zalando.jackson.datatype.money.DefaultMonetaryAmountFormatFactory;
import org.zalando.jackson.datatype.money.FastMoneyFactory;
import org.zalando.jackson.datatype.money.MoneyModule;

@SpringBootApplication
public class RestCustomApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestCustomApplication.class, args);
	}

	@Bean
	public Module moneyModule(){
		return new MoneyModule()
				.withAmountFactory(new FastMoneyFactory())
				.withFormatFactory(new DefaultMonetaryAmountFormatFactory());
	}
}
