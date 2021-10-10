package jpabook.jpashop.domain;

import jpabook.jpashop.domain.input.AddressInput;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.Embeddable;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String city;
    private String street;
    private String zipcode;

    public Address (AddressInput addressInput) {
        this.city = addressInput.getCity();
        this.street = addressInput.getStreet();
        this.zipcode = addressInput.getZipcode();
    }

}
