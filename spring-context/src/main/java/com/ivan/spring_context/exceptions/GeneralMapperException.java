
package com.ivan.spring_context.exceptions;

/**
 *
 * @author ivan
 */
public class GeneralMapperException extends Exception {
    public GeneralMapperException(Exception e){
        super(e);
    }

    public GeneralMapperException(String message){
        super(message);
    }
}
