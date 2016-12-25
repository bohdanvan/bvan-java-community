package com.bvan.jc.oop.inheritance;

/**
 * @author bvanchuhov
 */
interface Person {
    void howAreYou();
}

interface Singer {
    void sing();
}

class SimplePerson implements Person { // Company A

    @Override
    public void howAreYou() {
        System.out.println("Hello, I'm fine");
    }
}

class SimpleSinger implements Person, Singer { // Company B

    private final Person person = new SimplePerson();

    @Override
    public void howAreYou() {
        person.howAreYou();
    }

    @Override
    public void sing() {
        person.howAreYou();
        System.out.println("I'm singing");
    }
}
