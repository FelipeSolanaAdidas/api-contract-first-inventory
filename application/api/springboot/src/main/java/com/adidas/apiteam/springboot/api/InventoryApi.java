/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.34).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.adidas.apiteam.springboot.api;

import com.adidas.apiteam.springboot.model.InventoryItem;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-06-16T16:53:29.304789800+02:00[Europe/Paris]")
@Validated
public interface InventoryApi {

    Logger log = LoggerFactory.getLogger(InventoryApi.class);

    default Optional<ObjectMapper> getObjectMapper() {
        return Optional.empty();
    }

    default Optional<HttpServletRequest> getRequest() {
        return Optional.empty();
    }

    default Optional<String> getAcceptHeader() {
        return getRequest().map(r -> r.getHeader("Accept"));
    }

    @Operation(summary = "adds an inventory item", description = "Adds an item to the system", tags = {"admins"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "item created"),

            @ApiResponse(responseCode = "400", description = "invalid input, object invalid"),

            @ApiResponse(responseCode = "409", description = "an existing item already exists")})
    @RequestMapping(value = "/inventory",
            consumes = {"application/json"},
            method = RequestMethod.POST)
    default ResponseEntity<Void> addInventory(@Parameter(in = ParameterIn.DEFAULT, description = "Inventory item to add", schema = @Schema()) @Valid @RequestBody InventoryItem body) {
        if (getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default InventoryApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }


    @Operation(summary = "searches inventory", description = "By passing in the appropriate options, you can search for available inventory in the system ", tags = {"developers"})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "search results matching criteria", content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = InventoryItem.class)))),

            @ApiResponse(responseCode = "400", description = "bad input parameter")})
    @RequestMapping(value = "/inventory",
            produces = {"application/json"},
            method = RequestMethod.GET)
    default ResponseEntity<List<InventoryItem>> searchInventory(@Parameter(in = ParameterIn.QUERY, description = "pass an optional search string for looking up inventory", schema = @Schema()) @Valid @RequestParam(value = "searchString", required = false) String searchString, @Min(0) @Parameter(in = ParameterIn.QUERY, description = "number of records to skip for pagination", schema = @Schema(allowableValues = {}
    )) @Valid @RequestParam(value = "skip", required = false) Integer skip, @Min(0) @Max(50) @Parameter(in = ParameterIn.QUERY, description = "maximum number of records to return", schema = @Schema(allowableValues = {}, maximum = "50"
    )) @Valid @RequestParam(value = "limit", required = false) Integer limit) {
        if (getObjectMapper().isPresent() && getAcceptHeader().isPresent()) {
            if (getAcceptHeader().get().contains("application/json")) {
                try {
                    return new ResponseEntity<>(getObjectMapper().get().readValue("[ {\r\n  \"releaseDate\" : \"2016-08-29T09:12:33.001Z\",\r\n  \"name\" : \"Widget Adapter\",\r\n  \"availableItems\" : 10,\r\n  \"id\" : \"d290f1ee-6c54-4b01-90e6-d701748f0851\",\r\n  \"manufacturer\" : {\r\n    \"phone\" : \"408-867-5309\",\r\n    \"name\" : \"ACME Corporation\",\r\n    \"homePage\" : \"https://www.acme-corp.com\"\r\n  }\r\n}, {\r\n  \"releaseDate\" : \"2016-08-29T09:12:33.001Z\",\r\n  \"name\" : \"Widget Adapter\",\r\n  \"availableItems\" : 10,\r\n  \"id\" : \"d290f1ee-6c54-4b01-90e6-d701748f0851\",\r\n  \"manufacturer\" : {\r\n    \"phone\" : \"408-867-5309\",\r\n    \"name\" : \"ACME Corporation\",\r\n    \"homePage\" : \"https://www.acme-corp.com\"\r\n  }\r\n} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
                } catch (IOException e) {
                    log.error("Couldn't serialize response for content type application/json", e);
                    return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
                }
            }
        } else {
            log.warn("ObjectMapper or HttpServletRequest not configured in default InventoryApi interface so no example is generated");
        }
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }

}

