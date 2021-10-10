package jpabook.jpashop.domain.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by park on 2021/10/10.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddressInput {

  private String city;

  private String street;

  private String zipcode;
}
