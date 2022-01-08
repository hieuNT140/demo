package Lombok;

public class main {
    public static void main(String[] args) {
        Person p1= new Person();
        p1.setName("A");
        System.out.println( p1.getName());

        System.out.println(p1.toString());

        Teacher tc1 = new Teacher("ha noi");
        tc1.setId(1);
        tc1.setName("A");
        tc1.setAddress("Ha noi2");

        System.out.println(tc1.toString());

        Teacher tc2 = new Teacher("hai phong");
        tc2.setId(1);
        tc2.setName("B");
        tc2.setAddress("Hai Phong");

        System.out.println(tc1.equals(tc2));


    }
}
