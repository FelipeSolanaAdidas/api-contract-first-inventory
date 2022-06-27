package com.adidas.apiteam.springboot.api;

import com.adidas.apiteam.springboot.model.InventoryItem;
import com.adidas.apiteam.springboot.service.InventoryService;
import com.adidas.apiteam.springboot.service.bean.SearchBean;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.Optional;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2022-06-16T16:53:29.304789800+02:00[Europe/Paris]")
@RestController
public class InventoryApiController implements InventoryApi {

    private static final Logger log = LoggerFactory.getLogger(InventoryApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    private InventoryService inventoryService;


    @Autowired
    public InventoryApiController(ObjectMapper objectMapper, HttpServletRequest request, InventoryService inventoryService) {
        this.objectMapper = objectMapper;
        this.request = request;
        this.inventoryService = inventoryService;
    }

    @Override
    public Optional<ObjectMapper> getObjectMapper() {
        return Optional.ofNullable(objectMapper);
    }

    @Override
    public Optional<HttpServletRequest> getRequest() {
        return Optional.ofNullable(request);
    }

    @Override
    public ResponseEntity<Void> addInventory(@Parameter(in = ParameterIn.DEFAULT, description = "Inventory item to add", schema = @Schema()) @Valid @RequestBody InventoryItem body) {
        String accept = request.getHeader("Accept");

        try {
            inventoryService.addInventory(body);
        } catch (ApiException e) {
            log.error("Error adding item inventary controller", e);
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<InventoryItem>> searchInventory(@Parameter(in = ParameterIn.QUERY, description = "pass an optional search string for looking up inventory", schema = @Schema()) @Valid @RequestParam(value = "searchString", required = false) String searchString, @Min(0) @Parameter(in = ParameterIn.QUERY, description = "number of records to skip for pagination", schema = @Schema(allowableValues = {}
    )) @Valid @RequestParam(value = "skip", required = false) Integer skip, @Min(0) @Max(50) @Parameter(in = ParameterIn.QUERY, description = "maximum number of records to return", schema = @Schema(allowableValues = {}, maximum = "50"
    )) @Valid @RequestParam(value = "limit", required = false) Integer limit) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {

                int numLimit = limit == null ? 0 : limit;
                int numSkip = skip == null ? 0 : skip;
                return new ResponseEntity<List<InventoryItem>>(
                        inventoryService.searchInventory(SearchBean.builder()
                                .skip(numSkip).limit(numLimit).searchString(searchString)
                                .build()),
                        HttpStatus.ACCEPTED);
            } catch (Exception e) {
                log.error("Error searchInventory controller", e);
                return new ResponseEntity<List<InventoryItem>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<InventoryItem>>(HttpStatus.BAD_REQUEST);
    }

}
