package jpabook.jpashop.service;

import com.graphql.spring.boot.test.GraphQLTestTemplate;
import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * Created by park on 2021/09/20.
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MemberResolverTests {

  @Autowired
  private GraphQLTestTemplate graphQLTestTemplate;

  @Test
  void memberTest() throws IOException {
    // test/resources/member.graphql 파일을 읽어와 해당 쿼리를 전송한다.
    var response = this.graphQLTestTemplate.postForResource("graphql/member.graphql");

    var result = response.readTree().get("data");
    Assertions.assertNotNull(result.asText());
    }
  }