package jpabook.jpashop;

import graphql.execution.ExecutionStrategy;
import java.util.HashMap;
import java.util.Map;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by park on 2021/11/13.
 */
@Configuration
public class GraphQLConfig {
  @Bean
  public Map<String, ExecutionStrategy> executionStrategies() {
    Map<String, ExecutionStrategy> executionStrategyMap = new HashMap<>();
    executionStrategyMap.put("queryExecutionStrategy", new AsyncTransactionalExecutionStrategy());
    return executionStrategyMap;
  }
}