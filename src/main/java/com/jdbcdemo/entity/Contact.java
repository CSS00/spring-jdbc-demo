package com.jdbcdemo.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Contact Object.
 */
@Data
@NoArgsConstructor
public class Contact {
    /**
     * Contact id.
     */
    @JsonProperty
    private Integer id;
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
