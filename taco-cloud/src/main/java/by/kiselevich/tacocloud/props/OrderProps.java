package by.kiselevich.tacocloud.props;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Component
@ConfigurationProperties(prefix = "taco.order")
@Data
@Validated
public class OrderProps {

    private static final String INVALID_PAGE_SIZE_MESSAGE = "must be between 5 and 25";
    private static final int MIN_PAGE_SIZE = 5;
    private static final int MAX_PAGE_SIZE = 25;
    private static final int DEFAULT_PAGE_SIZE = 20;

    @Min(value = MIN_PAGE_SIZE, message = INVALID_PAGE_SIZE_MESSAGE)
    @Max(value = MAX_PAGE_SIZE, message = INVALID_PAGE_SIZE_MESSAGE)
    private int pageSize = DEFAULT_PAGE_SIZE;
}