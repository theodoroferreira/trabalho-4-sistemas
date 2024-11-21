package com.acme.trabalho4sistemas.domain;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

    @JsonAlias("codigo")
    private String code;

    @JsonAlias("nome")
    private String name;

    @JsonAlias("cidade")
    private String city;

    @JsonAlias("telefone")
    private String phoneNumber;

    @JsonAlias("porte")
    private String size;
}
