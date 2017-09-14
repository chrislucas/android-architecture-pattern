package com.xplore.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by r028367 on 14/09/2017.
 */

/**
 * Nossa anotacao recebem outras anotacoes tambem, uma das anotacoes
 * indica ao compilador de 'anotacoes' quem pode utilizar a nossa
 * anotacacao @Target(ElementType.TYPE) por exemplo
 *
 * outra anotacao interessate e a de 'politica de retencao' que diz
 * quando que uma anotacao pode ser usada
 *
 * @Retention(RetentionPolicy.SOURCE) anotacoes existem somente no codigo-fonte
 *
 * ElementType.ANNOTATION_TYPE can be applied to an annotation type.
 * ElementType.CONSTRUCTOR can be applied to a constructor.
 * ElementType.FIELD can be applied to a field or property.
 * ElementType.LOCAL_VARIABLE can be applied to a local variable.
 * ElementType.METHOD can be applied to a method-level annotation.
 * ElementType.PACKAGE can be applied to a package declaration.
 * ElementType.PARAMETER can be applied to the parameters of a method.
 * ElementType.TYPE can be applied to any element of a class.
 * */

@Target(ElementType.TYPE)   // pode ser aplicado a qualquer elemento de uma classe
@Retention(RetentionPolicy.SOURCE)
public @interface ParcelAnnotation {
}
