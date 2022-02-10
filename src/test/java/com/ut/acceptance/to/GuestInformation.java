package com.ut.acceptance.to;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public final class GuestInformation {

    private String name;

    private String surname;

    private String email;

    private String phone;

    private String address;

    private String city;

    private String postCode;

    private String country;

    private String area;
}
