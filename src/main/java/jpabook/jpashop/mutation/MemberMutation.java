package jpabook.jpashop.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.domain.input.CreateMemberInput;
import jpabook.jpashop.repository.MemberJpaRepository;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Created by park on 2021/09/20.
 */
@Component
@RequiredArgsConstructor
public class MemberMutation implements GraphQLMutationResolver {

  private final MemberJpaRepository memberJpaRepository;

  public Member saveMember(CreateMemberInput input) {
    return memberJpaRepository.save(new Member(input.getName(), input.getAddress()));
  }

}
