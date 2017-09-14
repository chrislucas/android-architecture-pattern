package com.example;

import com.xplore.annotation.ParcelAnnotation;

import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.tools.JavaFileObject;

/**
 * Created by r028367 on 14/09/2017.
 */
@SupportedAnnotationTypes("com.xplore.annotation.ParcelAnnotation")
public class AutoParcelProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> set
            , RoundEnvironment roundEnvironment) {

        Set<? extends Element> annotatedElements =
                roundEnvironment.getElementsAnnotatedWith(ParcelAnnotation.class);
        TypeElement[] t = new TypeElement[annotatedElements.size()];
        for(TypeElement typeElement : Arrays.asList(annotatedElements.toArray(t))) {
            processType(typeElement);
        }

        return true;
    }

    private void processType(TypeElement typeElement) {

    }

    private void writeSourceFile(String className
            , String text, TypeElement originatingType) {
    }
}
