package jpabook.jpashop.mutation;

import graphql.kickstart.tools.GraphQLMutationResolver;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Created by park on 2021/09/20.
 */
@Component
@RequiredArgsConstructor
public class MemberMutation implements GraphQLMutationResolver {

  private final MemberRepository memberRepository;

  public Member saveMember(String name) {
    Member member = new Member();
    member.setName(name);

    return memberRepository.save(member);
  }


}
