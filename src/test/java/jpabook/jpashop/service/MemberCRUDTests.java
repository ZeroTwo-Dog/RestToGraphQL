package jpabook.jpashop.service;

import com.graphql.spring.boot.test.GraphQLTestTemplate;
import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Created by park on 2021/09/20.
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MemberCRUDTests {

  @Autowired
  private GraphQLTestTemplate graphQLTestTemplate;

  @Test
  @DisplayName("멤버 한건 저장")
  @Order(1)
  void memberPost() throws IOException {
    // test/resources/member.graphql 파일을 읽어와 해당 쿼리를 전송한다.
    var response = this.graphQLTestTemplate.postForResource("graphql/memberPost.graphql");

    var result = response.readTree().get("data");
    Assertions.assertNotNull(result.asText());
  }


  @Test
  @DisplayName("멤버 한건 수정")
  @Order(2)
  void memberPut() throws IOException {
    // test/resources/member.graphql 파일을 읽어와 해당 쿼리를 전송한다.
    var response = this.graphQLTestTemplate.postForResource("graphql/memberPut.graphql");

    var result = response.readTree().get("data");
    Assertions.assertNotNull(result.asText());
  }

  @Test
  @DisplayName("멤버 단건 조회")
  @Order(3)
  void memberRead() throws IOException {
    // test/resources/member.graphql 파일을 읽어와 해당 쿼리를 전송한다.
    var response = this.graphQLTestTemplate.postForResource("graphql/member.graphql");

    var result = response.readTree().get("data");
    Assertions.assertNotNull(result.asText());
    }


  @Test
  @DisplayName("멤버 단건 삭제")
  @Order(4)
  void memberDelete() throws IOException {
    // test/resources/member.graphql 파일을 읽어와 해당 쿼리를 전송한다.
    var response = this.graphQLTestTemplate.postForResource("graphql/memberDelete.graphql");

    var result = response.readTree().get("data");
    Assertions.assertNotNull(result.asText());
  }

  }
