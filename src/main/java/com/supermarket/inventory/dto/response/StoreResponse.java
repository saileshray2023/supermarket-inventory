package com.supermarket.inventory.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class StoreResponse {
     private Long id;
     private String name;
     private String location;
     private String address;
     private Boolean active;
     private LocalDateTime createdAt;
     private LocalDateTime updatedAt;
}
