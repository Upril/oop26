public class Main {
    public static void main(String[] args){
        System.out.println("Hello world");
        Point p = new Point();

        p.x = 50F;
        p.y = 75.5F;

        System.out.println(p.toSvg());
    }
}
