package com.ivan.spring_context;

import com.ivan.spring_context.aop_example.IStudent;
import com.ivan.spring_context.aop_example.xml.Student;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
    private final static String CONTEXT_AOP_URL = "/aop-context.xml";
    private final static String CONTEXT_AOP_ANNOTATIONBASED_URL = "/aop-annotation-context.xml";
    private final static String CONTEXT_URL = "/context.xml";

    public static void main(String[] args) {

        try (
                ClassPathXmlApplicationContext contextSimple = new ClassPathXmlApplicationContext(CONTEXT_URL);
                ClassPathXmlApplicationContext contextAopBasedOnXml = new ClassPathXmlApplicationContext(
                        CONTEXT_AOP_URL);
                ClassPathXmlApplicationContext contextAopBasedAnnotations = new ClassPathXmlApplicationContext(
                        CONTEXT_AOP_ANNOTATIONBASED_URL);) {

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

            // QuizService quizService = contextSimple.getBean(QuizService.class);
            // String csvData = ResourceReader.readFromResources("/questions.csv");
            // ConsoleClient.run(quizService, csvData);
        }

    }
}
