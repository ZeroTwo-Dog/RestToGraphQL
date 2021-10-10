package jpabook.jpashop.resolver;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import java.util.List;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberJpaRepository;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by park on 2021/09/12.
 */

@Component
@RequiredArgsConstructor
public class MemberResolver implements GraphQLQueryResolver {

  private final MemberRepository memberRepository;

  private final MemberJpaRepository memberJpaRepository;

  @Transactional
  public List<Member> getMemberList() {
    return memberJpaRepository.findAll();
  }


  @Transactional
  public Member member(Long id) {
    if (memberJpaRepository.findById(id).isPresent()) {
      return memberJpaRepository.findById(id).get();
    } else {
      return null;
    }
  }


  public List<Member> memberName(String name) {
    return memberRepository.findByName(name);
  }


}
