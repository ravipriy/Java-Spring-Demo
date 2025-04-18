package com.springdemo.camelroute;

import org.springframework.stereotype.Component;

@Component
public class InventoryUpdateBean {
    public void updateInventory(Object body) {
        System.out.println("Inventory updated with: " + body);
    }
}
