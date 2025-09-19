package Java_Code;

import org.testng.annotations.Test;

class PC {
    //@BeforeMethod
    public void before() {
        System.out.println("before method");
    }

    //@AfterMethod
    public void after() {
        System.out.println("after method");
    }

    public void getText() {
        System.out.println("I am running");
    }
}

class PC3 {
    int num;

    public PC3(int num) {
        this.num = num;
    }

    public int mutiply() {
        return num * 3;
    }
}

class PC1 extends PC3 {
    int num;

    public PC1(int num) {
        super(num);
        this.num = num;
    }

    public int add() {
        num += 2;
        return num;
    }

}

public class Inheritance extends PC {
    @Test
    public void text() {
        getText();

        int num = 5;
        PC1 obj = new PC1(num);
        System.out.println(obj.add());
        System.out.println(obj.mutiply());

    }
}

