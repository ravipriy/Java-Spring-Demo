package com.springdemo.camelroute;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class InventoryRoute extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("direct:updateInventory")
            .log("Received inventory update request: ${body}")
            .to("bean:inventoryUpdateBean?method=updateInventory")
            .log("Inventory updated successfully");
    }
}
