package jpabook.jpashop.domain;

import jpabook.jpashop.domain.input.AddressInput;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;


    //FIXME: 현재 Order graphql 조회가 EAGER때만 가능 조치 필요
    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
    private List<Order> orders = new ArrayList<>();


    public Member(String name, AddressInput addressInput) {
        this.name = name;
        this.address = new Address(addressInput.getCity(), addressInput.getStreet(), addressInput.getZipcode());
    }

    public Member(String name) {
        this.name = name;
    }

}
