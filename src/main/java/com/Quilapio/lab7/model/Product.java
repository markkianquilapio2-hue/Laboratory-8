package com.Quilapio.lab7.model;


// Lombok annotations are encouraged for boilerplate code
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // Generates getters, setters, toString, equals, and hashCode
@NoArgsConstructor // Generates a constructor with no arguments
@AllArgsConstructor // Generates a constructor with all arguments
public class Product {

    // Required fields: id (Long), name (String), and price (Double) [cite: 30, 16]
    private Long id;
    private String name;
    private Double price;

    // Note: The Lombok annotations above replace the need to write the constructor,
    // getters, setters, and toString() methods manually[cite: 31].
}