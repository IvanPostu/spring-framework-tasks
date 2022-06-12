package com.ivan.other;



public class EqualsAndHashCodeExample1 {

    public static final class A {
        private final int a;

        public A(int a) {
            this.a = a;
        }

        public int getA() {
            return a;
        }

        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + a;
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            A other = (A) obj;
            if (a != other.a)
                return false;
            return true;
        }

    }


}

