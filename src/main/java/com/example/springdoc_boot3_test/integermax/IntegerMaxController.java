package com.example.springdoc_boot3_test.integermax;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static io.swagger.v3.oas.annotations.enums.ParameterIn.QUERY;

/**
 * https://github.com/springdoc/springdoc-openapi/issues/2827
 */
@RestController
@RequestMapping("indeger/max")
public class IntegerMaxController {
  @GetMapping
  public String index(@ParameterObject IntegerMaxRequest request) {
    return null;
  }

  public class IntegerMaxRequest {
      @Parameter(description = "The number of individual objects that are returned in each page.",
          in = QUERY, allowEmptyValue = true,
          required = false,
          schema = @Schema(defaultValue = "200",
              requiredMode = Schema.RequiredMode.NOT_REQUIRED,
              nullable = true,
              minimum = "1",
              maximum = "200"))
      @Max(value = 200L)
      @Min(value = 1L)
      private Integer limit = Integer.MAX_VALUE;

    public Integer getLimit() {
      return limit;
    }
  }
}
