package com.filtro.demo.ciudad.domain.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.filtro.demo.cliente.domain.models.Customer;
import com.filtro.demo.pais.domain.models.Country;
import com.filtro.demo.proveedor.domain.models.Supplier;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ciudades")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
    @OneToMany(mappedBy = "city",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Supplier> supplier;
    @OneToMany(mappedBy = "city",cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Customer> customer;
}
