package jpabook.jpashop.domain.input;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * graphql member save용
 * Created by park on 2021/10/10.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMemberInput {

  private Long id;

  private String name;

  private AddressInput address;


}
