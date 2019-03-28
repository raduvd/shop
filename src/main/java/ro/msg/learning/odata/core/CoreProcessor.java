package ro.msg.learning.odata.core;

import org.apache.olingo.odata2.api.ep.EntityProvider;
import org.apache.olingo.odata2.api.ep.EntityProviderReadProperties;
import org.apache.olingo.odata2.api.ep.EntityProviderWriteProperties;
import org.apache.olingo.odata2.api.ep.entry.ODataEntry;
import org.apache.olingo.odata2.api.exception.ODataException;
import org.apache.olingo.odata2.api.processor.ODataResponse;
import org.apache.olingo.odata2.api.processor.ODataSingleProcessor;
import org.apache.olingo.odata2.api.uri.info.PostUriInfo;
import org.apache.olingo.odata2.core.ep.feed.ODataDeltaFeedImpl;
import org.springframework.stereotype.Service;
import ro.msg.learning.SpringApplicationContext;
import ro.msg.learning.entity.Order;
import ro.msg.learning.service.OrderService;
import ro.msg.learning.transitionobject.OrderTO;

import java.io.InputStream;
import java.time.LocalDateTime;
import java.util.*;

import static ro.msg.learning.odata.core.CoreEdmProvider.ENTITY_ORDER_TO;

@Service
public class CoreProcessor extends ODataSingleProcessor {

    private OrderService orderService;

    public CoreProcessor() {

        orderService = (OrderService) SpringApplicationContext.getBean("orderService");
    }

    @Override
    public ODataResponse createEntity(PostUriInfo uriParserResultView, InputStream content, String requestContentType, String contentType) throws ODataException {

        if (uriParserResultView.getNavigationSegments().isEmpty() &&
                ENTITY_ORDER_TO.equals(uriParserResultView.getStartEntitySet().getEntityType().getName())) {

            EntityProviderReadProperties properties = EntityProviderReadProperties.init().mergeSemantic(false).build();
            ODataEntry entry = EntityProvider.readEntry(requestContentType, uriParserResultView.getStartEntitySet(), content, properties);
            final Order order = orderService.createOrder(mapODataEntryToOrderTO(entry));

            return EntityProvider.writeFeed(contentType, uriParserResultView.getTargetEntitySet(),
                    mapOrderForResponse(Arrays.asList(order)), EntityProviderWriteProperties
                            .serviceRoot(getContext().getPathInfo().getServiceRoot()).build());
        }
        return null;
    }


    private List<Map<String, Object>> mapOrderForResponse(List<Order> orderList) {

        List<Map<String, Object>> orders = new ArrayList<>();

        orderList.forEach(order -> {
            Map<String, Object> orderMap = new HashMap<>();
            orderMap.put("StreetAddress", order.getAddress().getStreetAddress());
            orderMap.put("Country", order.getAddress().getCountry());
            orderMap.put("City", order.getAddress().getCity());
            orderMap.put("County", order.getAddress().getCounty());
            orderMap.put("OrderId", order.getId());

            orders.add(orderMap);
        });

        return orders;
    }

    private OrderTO mapODataEntryToOrderTO(ODataEntry entry) {

        OrderTO orderTO = new OrderTO();

        final Map<String, Object> properties = entry.getProperties();

        properties.keySet().forEach(property -> {
            switch (property) {
                case "StreetAddress":
                    orderTO.setStreetAddress(properties.get(property).toString());
                    break;
                case "Country":
                    orderTO.setCountry(properties.get(property).toString());
                    break;
                case "City":
                    orderTO.setCity(properties.get(property).toString());
                    break;
                case "County":
                    orderTO.setCounty(properties.get(property).toString());
                    break;
                case "Product":
                    final List<ODataEntry> productList = ((ODataDeltaFeedImpl) properties.get(property)).getEntries();
                    Map<Long, Integer> productIdQuantityMap = new HashMap<>();

                    productList.forEach(product -> {
                        final Integer quantity = (Integer) product.getProperties().get("Quantity");
                        final Long productId = ((Integer) product.getProperties().get("ProductId")).longValue();
                        productIdQuantityMap.put(productId, quantity);
                    });

                    orderTO.setProductIdQuantityMap(productIdQuantityMap);
                    break;
            }
        });

        orderTO.setDate(LocalDateTime.now());
        return orderTO;
    }
}
