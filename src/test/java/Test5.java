public class Test5 {

    public static void main(String[] args) {
        print(100);
    }
    public static void print(int j){
        for (int x = 1; x <= j; x++) {
            if ((x % 3 != 0) && (x % 5!= 0)) {
                System.out.println(x);
            } else {
                if ((x % 3 == 0) && (x % 5 != 0)) {
                    System.out.println("MThree");
                }
                if ((x % 5 == 0) && (x % 3 != 0)) {
                    System.out.println("MFive");
                }
                if ((x % 3 == 0) && (x % 5 == 0)) {
                    System.out.println("Resolver");
                }
            }
        }
    }

}
