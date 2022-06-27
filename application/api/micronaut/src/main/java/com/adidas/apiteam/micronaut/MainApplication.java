package com.adidas.apiteam.micronaut;

import io.micronaut.runtime.Micronaut;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

@OpenAPIDefinition(
        info = @Info(
                title = "APIContractFirst - Inventory API",
                version = "1.0.0",
                description = "API Contract First - Inventory",
                contact = @Contact(
                        name = "",
                        email = "felipemanuel.solana@adidas.com"
                ),
                license = @License(
                        name = "Apache 2.0",
                        url = "http://www.apache.org/licenses/LICENSE-2.0.html"
                )
        )
)
public class MainApplication {

    public static void main(String[] args) {
        Micronaut.run(MainApplication.class);
    }
}