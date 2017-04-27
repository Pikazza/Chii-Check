package com.haochii.ws.filter;

import javax.ws.rs.NameBinding;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @author webwerks Custom annotation to secure methods
 */
@NameBinding
@Retention(RUNTIME)
@Target({ TYPE, METHOD }) // use at method level only
public @interface Secured {
    
}