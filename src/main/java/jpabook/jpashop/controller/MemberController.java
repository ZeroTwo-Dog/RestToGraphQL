//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package jpabook.jpashop.controller;

import java.util.List;
import javax.validation.Valid;
import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Member;
import jpabook.jpashop.resolver.MemberResolver;
import jpabook.jpashop.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {
  private final MemberService memberService;

//  private final MemberResolver memberResolver;

  @GetMapping({"/members"})
  public String list(Model model) {
    List<Member> members = this.memberService.findMembers();
    model.addAttribute("members", members);
    return "members/memberList";
  }

  public MemberController(final MemberService memberService) {
    this.memberService = memberService;
  }
}
