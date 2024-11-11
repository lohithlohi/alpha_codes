

public class trials {
    public static void main(String[] args) {
        vehicle v = new car();
        v.moves();
        System.out.println(v.vhcl);
        // this dosen't work because vehicle's v -> c, v can access v's properties in c object
        // System.out.println(v.chcl);

        car c = new car();
        c.moves();
        System.out.println(c.vhcl);
        // this will work because car's c -> c, c can access both v's & c's properties in c object
        System.out.println(c.chcl);
        // vehicle v = new car();

    }
}

class vehicle{
    int vhcl = 13;
    public void moves(){
        System.out.println("Vehicle moves");
    }
}

class car extends vehicle{
    int chcl = 17;
    public void moves(){
        System.out.println("car has 4 wheels");
    }
}

