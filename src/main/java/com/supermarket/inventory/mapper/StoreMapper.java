package com.supermarket.inventory.mapper;

import com.supermarket.inventory.dto.request.CreateStoreRequest;
import com.supermarket.inventory.dto.response.StoreResponse;
import com.supermarket.inventory.entity.Store;
import org.springframework.stereotype.Component;

@Component
public class StoreMapper {

    public Store toEntity(CreateStoreRequest request) {
        Store store = new Store();
        store.setName(request.getName());
        store.setLocation(request.getLocation());
        store.setAddress(request.getAddress());
        store.setActive(true);
        return store;
    }

    public StoreResponse toResponse(Store store) {
        return StoreResponse.builder()
                .id(store.getId())
                .name(store.getName())
                .location(store.getLocation())
                .address(store.getAddress())
                .active(store.getActive())
                .createdAt(store.getCreatedAt())
                .updatedAt(store.getUpdatedAt())
                .build();
    }
}