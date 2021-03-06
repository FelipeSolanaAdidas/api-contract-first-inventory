/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.34).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.adidas.apiteam.micronaut.api;

import com.adidas.apiteam.micronaut.model.InventoryItem;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micronaut.http.*;
import io.micronaut.http.annotation.*;
import io.reactivex.Single;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.responses.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nullable;
import javax.validation.Valid;
import javax.validation.constraints.*;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.MicronautCodegen", date = "2022-06-21T15:28:41.111466800+02:00[Europe/Paris]")
@Controller
public interface InventoryApi {


    @Operation(summary = "adds an inventory item", operationId = "addInventory", description = "Adds an item to the system" , tags = {"admins"})
    @ApiResponse(responseCode = "201", description = "item created")
    @ApiResponse(responseCode = "400", description = "invalid input, object invalid")
    @ApiResponse(responseCode = "409", description = "an existing item already exists")
    @Post(value = "/inventory", consumes = {"application/json"})
    default Single<HttpResponse<Void>> addInventory(@Parameter(description = "Inventory item to add") @Valid @Body InventoryItem body
) {
        return Single.fromCallable(() -> {
            throw new UnsupportedOperationException();
        });
    }


    @Operation(summary = "searches inventory", operationId = "searchInventory", description = "By passing in the appropriate options, you can search for available inventory in the system " , tags = {"developers"})
    @ApiResponse(responseCode = "200", description = "search results matching criteria")
    @ApiResponse(responseCode = "400", description = "bad input parameter")
    @Get(value = "/inventory", produces = { "application/json" })
    default Single<HttpResponse<List<InventoryItem>>> searchInventory(@Nullable @Parameter(description = "pass an optional search string for looking up inventory") @Valid @QueryValue(value = "searchString") String searchString
,@Nullable @Min(0)@Parameter(description = "number of records to skip for pagination") @Valid @QueryValue(value = "skip") Integer skip
,@Nullable @Min(0) @Max(50) @Parameter(description = "maximum number of records to return") @Valid @QueryValue(value = "limit") Integer limit
) {
        return Single.fromCallable(() -> {
            throw new UnsupportedOperationException();
        });
    }

}
