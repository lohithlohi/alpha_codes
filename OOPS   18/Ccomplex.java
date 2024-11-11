import java.util.*;

public class Ccomplex{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        complexnum a = new complexnum(2, 5);
        complexnum b = new complexnum(3, 4);
        
        complexnum c = complexnum.add(a, b);
        complexnum d = complexnum.sub(a, b);
        complexnum e = complexnum.multiply(a, b);

        System.out.print("ADD: ");c.getcomplex();
        System.out.print("SUB: ");d.getcomplex();
        System.out.print("MUL: ");e.getcomplex();

        sc.close();
    }
}

class complexnum{
    int real;
    int img;

    public complexnum(int real, int img){
        this.real = real;
        this.img = img;
    }

    public void getcomplex(){
        System.out.println(real+"+i"+img);
    }

    public static complexnum add(complexnum a, complexnum b){
        complexnum res = new complexnum(a.real+b.real, a.img+b.img);
        return res;
    }

    public static complexnum sub(complexnum a, complexnum b){
        complexnum res = new complexnum(a.real-b.real, a.img-b.img);
        return res;
    }
    
    public static complexnum multiply(complexnum a, complexnum b){
        complexnum res = new complexnum(a.real*b.real, a.img*b.img);
        return res;
    }
    
}