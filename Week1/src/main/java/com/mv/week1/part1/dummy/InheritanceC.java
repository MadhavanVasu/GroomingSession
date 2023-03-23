package com.mv.week1.part1.dummy;

import com.mv.week1.part1.questions.InheritanceA;

class Child extends InheritanceA {

    public static void main(String[] args) {
        Child child = new Child();

        // Can access public method of the parent class
        // Can access protected method of Parent class only inside the child class
        // Cannot access default and private members of parent class
        child.displayPublicMethod();
        child.displayProtectedMethod();

    }

}


