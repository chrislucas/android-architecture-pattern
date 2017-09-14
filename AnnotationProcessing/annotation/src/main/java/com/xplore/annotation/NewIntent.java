package com.xplore.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by r028367 on 14/09/2017.
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)
public @interface NewIntent {
}
