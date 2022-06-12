package com.ivan.other;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import org.mutabilitydetector.unittesting.MutabilityAssert;

public class EqualsAndHashCodeExample1Test {

    @Test
    public void equalsHashCodeContracts() {
        EqualsVerifier.forClass(EqualsAndHashCodeExample1.A.class).verify();
        MutabilityAssert.assertImmutable(EqualsAndHashCodeExample1.A.class); 
    }

}
