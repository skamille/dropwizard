package com.yammer.dropwizard.validation;

import javax.validation.Constraint;
import javax.validation.OverridesAttribute;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * The annotated element has to be in the appropriate range. Apply on {@link Duration}
 */
@Documented
@Constraint(validatedBy = { })
@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@MinDuration(0)
@MaxDuration(value = Long.MAX_VALUE, unit = TimeUnit.DAYS)
@ReportAsSingleViolation
public @interface DurationRange {
    @OverridesAttribute(constraint = MinDuration.class, name = "value")
    long min() default 0;

    @OverridesAttribute(constraint = MaxDuration.class, name = "value")
    long max() default Long.MAX_VALUE;

    @OverridesAttribute.List({
        @OverridesAttribute(constraint = MinDuration.class, name = "unit"),
        @OverridesAttribute(constraint = MaxDuration.class, name = "unit")
    })
    TimeUnit unit() default TimeUnit.SECONDS;

    String message() default "must be between {min} {unit} and {max} {unit}";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    /**
     * Defines several {@code @DurationRange} annotations on the same element.
     */
    @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
    @Retention(RUNTIME)
    @Documented
    public @interface List {
        DurationRange[] value();
    }
}