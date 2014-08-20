package forms;

import ninja.params.WithArgumentExtractor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created with IntelliJ IDEA.
 * User: eiryu
 * Date: 2014/08/15
 * Time: 18:08
 * To change this template use File | Settings | File Templates.
 */
@WithArgumentExtractor(SexExtractor.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER, ElementType.FIELD})
public @interface SexParameter {
}
