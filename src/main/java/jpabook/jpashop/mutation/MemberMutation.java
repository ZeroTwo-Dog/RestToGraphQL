package jpabook.jpashop.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.input.CreateMemberInput;
import jpabook.jpashop.domain.input.UpdateMemberInput;
import jpabook.jpashop.repository.MemberJpaRepository;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by park on 2021/09/20.
 */
@Component
@RequiredArgsConstructor
public class MemberMutation implements GraphQLMutationResolver {

  private final MemberJpaRepository memberJpaRepository;

  @Transactional
  public Member saveMember(CreateMemberInput input) {
    return memberJpaRepository.save(
        Member.builder()
            .name(input.getName())
            .address(new Address(input.getAddress()))
            .build()
    );
  }

  @Transactional
  public Member updateMember(UpdateMemberInput input) {
    return memberJpaRepository.save(Member.builder()
        .id(input.getId())
        .name(input.getName())
        .address(new Address(input.getAddress()))
        .build()
    );

  }
  @Transactional
  public boolean deleteMember(Long id) {
    memberJpaRepository.deleteById(id);
    return memberJpaRepository.findById(id).isPresent();
  }

}
