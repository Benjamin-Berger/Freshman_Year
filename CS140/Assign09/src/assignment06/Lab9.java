package assignment06;

interface I {
    //...
}
class A { 
    //...
}
class B extends A {
    //...
}

class E extends B {
    //...
}

class C implements I {
    //...
}
class D extends C {
    //...
}

public class Lab9 {
    public static void main(String[] args) {
        A aRef = new B();
        B bRef = new E();
        C cRef = new C();
        D dRef = new D();
        I iRef = new D();
        I i2Ref = new C();

        System.out.println(aRef instanceof I); 
        System.out.println(aRef instanceof A); 
        System.out.println(aRef instanceof B); 
       // System.out.println(aRef instanceof C); 
        //System.out.println(aRef instanceof D); 
        System.out.println(aRef instanceof E); 

        System.out.println(bRef instanceof I); 
        System.out.println(bRef instanceof A); 
        System.out.println(bRef instanceof B); 
        // System.out.println(bRef instanceof C); 
        // System.out.println(bRef instanceof D); 
        System.out.println(bRef instanceof E); 

        System.out.println(cRef instanceof I); 
        // System.out.println(cRef instanceof A); 
        // System.out.println(cRef instanceof B); 
        System.out.println(cRef instanceof C); 
        System.out.println(cRef instanceof D); 
        // System.out.println(cRef instanceof E); 

        System.out.println(dRef instanceof I); 
        // System.out.println(dRef instanceof A); 
        // System.out.println(dRef instanceof B); 
        System.out.println(dRef instanceof C); 
        System.out.println(dRef instanceof D); 
        // System.out.println(dRef instanceof E); 
        System.out.println(iRef instanceof I); 
        System.out.println(iRef instanceof A); 
        System.out.println(iRef instanceof B); 
        System.out.println(iRef instanceof C); 
        System.out.println(iRef instanceof D); 
        System.out.println(iRef instanceof E); 

        System.out.println(i2Ref instanceof I); 
        System.out.println(i2Ref instanceof A); 
        System.out.println(i2Ref instanceof B); 
        System.out.println(i2Ref instanceof C); 
        System.out.println(i2Ref instanceof D); 
        System.out.println(i2Ref instanceof E); 
    }
}
