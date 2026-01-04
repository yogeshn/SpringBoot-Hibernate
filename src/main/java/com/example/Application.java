package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@SpringBootApplication
@EnableAutoConfiguration
@PropertySource("application.properties")
@ComponentScan(basePackages = {"com.example"})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);			
	}

}

@ControllerAdvice
class ValidationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public Map<String, List<String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        Map<String, List<String>> errors = new HashMap<>();

        errors = fieldErrors.stream().collect(
                Collectors.groupingBy(
                        FieldError::getField,
                        Collectors.mapping(FieldError::getDefaultMessage, Collectors.toList())
                )
        );

        return errors;
    }
}
