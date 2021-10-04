package jpabook.jpashop.resolver;

import graphql.kickstart.tools.GraphQLQueryResolver;
import java.util.List;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Created by park on 2021/09/12.
 */

@Component
@RequiredArgsConstructor
public class MemberResolver implements GraphQLQueryResolver {

  private final MemberRepository memberRepository;

  public List<Member> getMemberList() {
    return memberRepository.findAll();
  }

  public Member member(Long id) {
    return memberRepository.findOne(id);
  }

  public List<Member> memberName(String name) {
    return memberRepository.findByName(name);
  }


}
