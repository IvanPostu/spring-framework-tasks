package com.ivan.spring_context;

import com.ivan.spring_context.aop_example.IStudent;
import com.ivan.spring_context.aop_example.xml.Student;
import com.ivan.spring_context.java_based_beans.BeanB;
import com.ivan.spring_context.java_based_beans.ComponentScanConfigs;
import com.ivan.spring_context.java_based_beans.DemoConfig;
import com.ivan.spring_context.service.QuizService;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    private final static String CONTEXT_AOP_URL = "/aop-context.xml";
    private final static String CONTEXT_AOP_ANNOTATIONBASED_URL = "/aop-annotation-context.xml";
    private final static String CONTEXT_URL = "/context.xml";

    public static void main(String[] args) {
        
        

        try (
                //Xml based context
        AbstractApplicationContext contextSimple = new ClassPathXmlApplicationContext(CONTEXT_URL);
        ConfigurableApplicationContext contextAopBasedOnXml = new ClassPathXmlApplicationContext(
                CONTEXT_AOP_URL);
        ClassPathXmlApplicationContext contextAopBasedAnnotations = new ClassPathXmlApplicationContext(
                CONTEXT_AOP_ANNOTATIONBASED_URL);
                AnnotationConfigApplicationContext annotationBasedContext = new AnnotationConfigApplicationContext();     
                AnnotationConfigApplicationContext annotationBasedContextWithComponentScan = new AnnotationConfigApplicationContext();     
                ) 
        {
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
            System.out.println(o);

            // ==================

            Object o1 = annotationBasedContext.getBean("bean_A");
            Object o2 = annotationBasedContext.getBean("beanB");
            Object o3 = annotationBasedContext.getBean("getBeanC");
            Object o4 = annotationBasedContext.getBean("getBeanD");

            Object o5 = annotationBasedContextWithComponentScan.getBean("bean_A");
            Object o6 = annotationBasedContextWithComponentScan.getBean(BeanB.class);
            
            QuizService quizService = contextSimple.getBean(QuizService.class);
            String csvData = ResourceReader.readFromResources("/questions.csv");
            ConsoleClient.run(quizService, csvData, true);
        }catch(Exception e ){
                e.printStackTrace();
        }

    }
}
