public class Main {
    public static void main(String[] args){
        System.out.println("Hello world");
        Point p = new Point();

        p.x = 50F;
        p.y = 75.5F;

        System.out.println(p);
        p.translate(20, -5);
        System.out.println(p);

        Point p2 = p.translated(-30F, -0.5F);
        System.out.println(p2);
    }
}
