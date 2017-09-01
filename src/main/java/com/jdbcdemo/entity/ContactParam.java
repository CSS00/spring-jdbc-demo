package com.jdbcdemo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Contact Param Object.
 */
@Data
@NoArgsConstructor
public class ContactParam {
    /**
     * Name.
     */
    @JsonProperty
    private String name;
    /**
     * Email address.
     */
    @JsonProperty
    private String email;
    /**
     * Mobile phone number.
     */
    @JsonProperty
    private String mobile;
}

