package com.ivan.spring_context;

import com.ivan.spring_context.aop_example.IStudent;
import com.ivan.spring_context.aop_example.xml.Student;
import com.ivan.spring_context.java_based_beans.BeanB;
import com.ivan.spring_context.java_based_beans.ComponentScanConfigs;
import com.ivan.spring_context.java_based_beans.DemoConfig;
import com.ivan.spring_context.localization_and_properties.Foo1;
import com.ivan.spring_context.localization_and_properties.ParentConfig;
import com.ivan.spring_context.service.QuizService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    private final static String CONTEXT_AOP_URL = "/aop-context.xml";
    private final static String CONTEXT_AOP_ANNOTATIONBASED_URL = "/aop-annotation-context.xml";
    private final static String CONTEXT_URL = "/context.xml";

    private static void foo(Object... objs) {

    }

    public static void main(String[] args) {
        AbstractApplicationContext contextSimple = new ClassPathXmlApplicationContext(CONTEXT_URL);
        ConfigurableApplicationContext contextAopBasedOnXml = new ClassPathXmlApplicationContext(
                CONTEXT_AOP_URL);
        ClassPathXmlApplicationContext contextAopBasedAnnotations = new ClassPathXmlApplicationContext(
                CONTEXT_AOP_ANNOTATIONBASED_URL);
        AnnotationConfigApplicationContext annotationBasedContext = new AnnotationConfigApplicationContext();
        AnnotationConfigApplicationContext annotationBasedContextWithComponentScan = new AnnotationConfigApplicationContext();
        AbstractApplicationContext annotationBasedContextWithProperties = new AnnotationConfigApplicationContext(ParentConfig.class);

        try {
            annotationBasedContext.register(DemoConfig.class);
            annotationBasedContext.refresh();

            annotationBasedContextWithComponentScan.register(ComponentScanConfigs.class);
            annotationBasedContextWithComponentScan.refresh();


            // dynamic proxy implementation
            IStudent studentProxy = contextAopBasedAnnotations
                    .getBean("student", IStudent.class);

            studentProxy.setAge(22);
            studentProxy.getName();

            // ==================
            // CGLib proxy implemementation
            Student studentCGLibImpl = contextAopBasedOnXml
                    .getBean("student", Student.class);

            studentCGLibImpl.setAge(22);
            studentCGLibImpl.getName();

            Object o = contextSimple.getBean("questionEntityDummyMapper");

            // ==================

            Object o1 = annotationBasedContext.getBean("bean_A");
            Object o2 = annotationBasedContext.getBean("beanB");
            Object o3 = annotationBasedContext.getBean("getBeanC");
            Object o4 = annotationBasedContext.getBean("getBeanD");

            Object o5 = annotationBasedContextWithComponentScan.getBean("bean_A");
            Object o6 = annotationBasedContextWithComponentScan.getBean(BeanB.class);
            Object o7 = annotationBasedContextWithComponentScan.getBean("personDao");

            Foo1 o8 = annotationBasedContextWithProperties.getBean("foo1", Foo1.class);

            foo(o, o1, o2, o3, o4, o5, o6, o7, o8);

            QuizService quizService = contextSimple.getBean(QuizService.class);
            String csvData = ResourceReader.readFromResources("/questions.csv");
            ConsoleClient.run(quizService, csvData, true);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            contextSimple.close();
            contextAopBasedOnXml.close();
            contextAopBasedAnnotations.close();
            annotationBasedContext.close();
            annotationBasedContextWithComponentScan.close();
            annotationBasedContextWithProperties.close();
        }
    }
}
