package com.supermarket.inventory.controller;

import com.supermarket.inventory.dto.request.CreateStoreRequest;
import com.supermarket.inventory.dto.request.UpdateStoreRequest;
import com.supermarket.inventory.dto.response.StoreResponse;
import com.supermarket.inventory.service.StoreService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stores")
public class StoreController {

    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    public ResponseEntity<StoreResponse> createStore(@Valid @RequestBody CreateStoreRequest request) {
        StoreResponse response = storeService.createStore(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<StoreResponse> getStoreById(@PathVariable Long id) {
        return ResponseEntity.ok(storeService.getStoreById(id));
    }

    @GetMapping
    public ResponseEntity<List<StoreResponse>> getAllStores() {
        return ResponseEntity.ok(storeService.getAllStores());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<StoreResponse> updateStore(
            @PathVariable Long id,
            @Valid @RequestBody UpdateStoreRequest request) {
        return ResponseEntity.ok(storeService.updateStore(id, request));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStore(@PathVariable Long id) {
        storeService.deleteStore(id);
        return ResponseEntity.noContent().build();
    }
}