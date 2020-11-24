public class Program {
    public static void main(String []args) {
        int number = 111111;
        int sum = number % 10 + (number / 10) % 10 + (number / 100) % 10 +
                (number / 1000) % 10 + (number / 10000) % 10 + (number / 100000) % 10;
        System.out.println(sum);
    }
}