package com.supermarket.inventory.dto.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateSupplierRequest {

    @Size(max = 150, message = "name must not exceed 150 characters")
    private String name;

    @Size(max = 150, message = "contact person must not exceed 150 characters")
    private String contactPerson;

    @Email(message = "email must be a valid email address")
    @Size(max = 150, message = "email must not exceed 150 characters")
    private String email;

    @Pattern(regexp = "^\\+?[0-9\\-\\s]{7,20}$", message = "phone must be a valid phone number")
    private String phone;

    @Size(max = 300, message = "address must not exceed 300 characters")
    private String address;

    private Boolean active;
}