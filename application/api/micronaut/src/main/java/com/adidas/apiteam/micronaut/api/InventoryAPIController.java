package com.adidas.apiteam.micronaut.api;

import com.adidas.apiteam.micronaut.model.InventoryItem;
import com.adidas.apiteam.micronaut.service.InventoryService;
import com.adidas.apiteam.micronaut.service.bean.SearchBean;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Controller;
import io.reactivex.Single;

import javax.annotation.Nullable;
import javax.inject.Inject;
import java.util.List;

@Controller
public class InventoryAPIController implements InventoryApi {

    @Inject
    private InventoryService service;

    @Override
    public Single<HttpResponse<Void>> addInventory(InventoryItem body) {
        return Single.fromCallable(() -> {

            try {
                service.addInventory(body);
            } catch (ApiException e) {
                return HttpResponse.serverError();
            }
            return HttpResponse.accepted();
        });
    }

    @Override
    public Single<HttpResponse<List<InventoryItem>>> searchInventory(@Nullable String searchString, @Nullable Integer skip, @Nullable Integer limit) {
        return Single.fromCallable(() -> {
            int numLimit = limit == null ? 0 : limit;
            int numSkip = skip == null ? 0 : skip;
            List<InventoryItem> value = service.searchInventory(SearchBean.builder()
                    .searchString(searchString)
                    .limit(numLimit)
                    .skip(numSkip)
                    .build());

            return HttpResponse.ok(value);
        });
    }
}
