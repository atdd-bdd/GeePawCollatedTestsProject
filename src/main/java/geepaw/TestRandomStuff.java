package geepaw;

import java.net.URL;
import java.util.regex.Pattern;

class X
{
    public Pattern p =  Pattern.compile("xbc");
    @Override
    public boolean equals(Object o){
        X p1 = (X) o;
        System.out.println("p is " + p1.p);
        System.out.println(" this is " + this.p);
        Pattern pa = Pattern.compile("x");
        Pattern pb = Pattern.compile("x");
        if (pa.equals(pb))
            System.out.println("Patterns are equal");
        if (p1.p.equals(this.p))
            return true;
        System.out.println("Returning false");
        return false;
    }
}
public class TestRandomStuff {
    public static void main(String[] args) {
        testequals();
    }

    public static void  testequals()
    {
        int i; int j;

        X a = new X();
        X b = new X();
        if (a.equals(b))
            System.out.println("Equals");
        else
            System.out.println("NOT EQUALS");
    }
}
