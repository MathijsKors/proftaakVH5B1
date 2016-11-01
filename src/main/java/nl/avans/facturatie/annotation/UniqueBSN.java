/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.avans.facturatie.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;


/**
 *
 * @author Tom
 */
@Target(value = {ElementType.FIELD})
@Retention(value = RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {UniqueBSNValidator.class})
public @interface UniqueBSN {
    
    /**
     *
     * @return
     */
    public String message();

    /**
     *
     * @return
     */
    public Class<?>[] groups() default {};

    /**
     *
     * @return
     */
    public Class<? extends Payload>[] payload() default {};
    
}
