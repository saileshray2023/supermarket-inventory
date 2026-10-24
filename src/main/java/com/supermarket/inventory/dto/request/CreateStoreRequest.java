package com.supermarket.inventory.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateStoreRequest {

    @NotBlank(message = "name is required")
    @Size(max=150,message = "name must not exceed 150 characters")
    private String name;

    @NotBlank(message = "location is required")
    @Size(max=150,message = "location must not exceed 150 characters")
    private String location;

    @Size(max=300, message = "address must not exceed 300 characters")
    private String address;




}
