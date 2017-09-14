package com.example;

import com.xplore.annotation.NewIntent;
import com.xplore.annotation.ParcelAnnotation;


import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;



public class NewIntentAnnotationProcessor extends AbstractProcessor {

    private Messager messager;
    private Types types;
    private Elements elements;
    private Filer filer;

/*
    private static final List<Class<? extends Annotation>> annotations
            = Arrays.asList(NewIntent.class, ParcelAnnotation.class,);
*/

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        messager = processingEnvironment.getMessager();
        types = processingEnvironment.getTypeUtils();
        elements = processingEnvironment.getElementUtils();
        filer = processingEnvironment.getFiler();
    }

    /**
     * Inicia o processo de analise de anotacoes e por fim devolve um arquivo
     * java com codigo gerado automaticamente, dando vida a anotacao
     * */
    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {

        Set<? extends Element> setElements = roundEnvironment
                .getElementsAnnotatedWith(NewIntent.class);
        for(Element e : setElements) {
            if( e.getKind() != ElementKind.CLASS) {

            }
        }
        return true;
    }


    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> sString = new LinkedHashSet<>();
        /*
        for(Class<? extends Annotation> clazz : annotations) {
            sString.add(clazz.getCanonicalName());
        }
        */
        sString.add(NewIntent.class.getCanonicalName());
        return sString;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latestSupported();
    }
}
