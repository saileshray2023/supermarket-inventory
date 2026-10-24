package com.supermarket.inventory.service;

import com.supermarket.inventory.dto.request.CreateStoreRequest;
import com.supermarket.inventory.dto.request.UpdateStoreRequest;
import com.supermarket.inventory.dto.response.StoreResponse;
import com.supermarket.inventory.entity.Store;
import com.supermarket.inventory.exception.ResourceNotFoundException;
import com.supermarket.inventory.mapper.StoreMapper;
import com.supermarket.inventory.repository.StoreRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StoreService {

    private final StoreRepository storeRepository;
    private final StoreMapper storeMapper;

    public StoreService(StoreRepository storeRepository, StoreMapper storeMapper) {
        this.storeRepository = storeRepository;
        this.storeMapper = storeMapper;
    }

    public StoreResponse createStore(CreateStoreRequest request) {
        Store store = storeMapper.toEntity(request);
        Store saved = storeRepository.save(store);
        return storeMapper.toResponse(saved);
    }

    @Transactional(readOnly = true)
    public StoreResponse getStoreById(Long id) {
        Store store = storeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Store not found with id: " + id));
        return storeMapper.toResponse(store);
    }

    @Transactional(readOnly = true)
    public List<StoreResponse> getAllStores() {
        return storeRepository.findAll()
                .stream()
                .map(storeMapper::toResponse)
                .toList();
    }

    public StoreResponse updateStore(Long id, UpdateStoreRequest request) {
        Store store = storeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Store not found with id: " + id));

        if (request.getName() != null) store.setName(request.getName());
        if (request.getLocation() != null) store.setLocation(request.getLocation());
        if (request.getAddress() != null) store.setAddress(request.getAddress());
        if (request.getActive() != null) store.setActive(request.getActive());

        Store updated = storeRepository.save(store);
        return storeMapper.toResponse(updated);
    }

    public void deleteStore(Long id) {
        if (!storeRepository.existsById(id)) {
            throw new ResourceNotFoundException("Store not found with id: " + id);
        }
        storeRepository.deleteById(id);
    }
}