import java.util.Scanner;

public class Complinum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter c1");
        int c1r = sc.nextInt();
        int c1i = sc.nextInt();
        System.out.println("Enter c2");
        int c2r = sc.nextInt();
        int c2i = sc.nextInt();
        
        complex c1 = new complex(c1r, c1i);
        complex c2 = new complex(c2r, c2i);
        
        complex a = complex.add(c1, c2);
        complex s = complex.diff(c1, c2);
        complex m = complex.mul(c1, c2);
        
        System.out.println("add "+a.r+"+i"+a.i);
        System.out.println("dif "+s.r+"+i"+s.i);
        System.out.println("mul "+m.r+"+i"+m.i);
        
        sc.close();
    }
}

class complex{
    int r,i;
    public complex(int r, int i){
        this.r = r;
        this.i = i;
    }

    public static complex add(complex c1, complex c2){
        return new complex(c1.r+c2.r, c1.i+c2.i);
    }

    public static complex diff(complex c1, complex c2){
        return new complex(c1.r-c2.r, c1.i-c2.i);
    }
    
    public static complex mul(complex c1, complex c2){
        return new complex(c1.r*c2.r, c1.i*c2.i);
    }
}