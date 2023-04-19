package us.peaksoft.gadgetarium.service;
import us.peaksoft.gadgetarium.dto.BasketResponse;
import us.peaksoft.gadgetarium.dto.ProductRequest;
import us.peaksoft.gadgetarium.dto.ProductResponse;
import us.peaksoft.gadgetarium.dto.SimpleResponse;

import java.util.List;

public interface BasketService {

    ProductResponse saveProductIntoBasket(Long id, ProductRequest productRequest);

    BasketResponse getById(Long id);

    SimpleResponse removeProductFromBasket(Long id, ProductRequest productRequest);

    List<ProductResponse> getProductsByBasketId(Long id, int page, int size);

    SimpleResponse removeAllProductFromBasket(Long id, ProductRequest productRequest);
}
