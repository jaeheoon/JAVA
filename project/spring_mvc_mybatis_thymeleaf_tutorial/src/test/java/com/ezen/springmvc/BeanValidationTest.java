package com.ezen.springmvc;

import java.util.Set;
import org.junit.jupiter.api.Test;
import com.ezen.springmvc.domain.member.dto.Item;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BeanValidationTest {
	
	@Test
	void validationTest() {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		Item item = new Item();
		item.setId(10L);
		item.setItemName(" "); // 공백
		item.setPrice(0);
		item.setQuantity(10000);
		
		Set<ConstraintViolation<Item>> violations = validator.validate(item);
		 for (ConstraintViolation<Item> violation : violations) {
			 log.info("violation = {}", violation);
			 log.info("violation.message = {}",violation.getMessage());
		 }
	}
}


