public class Task2_Parametrs {
    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println("Вы ввели " + args.length + " параметров");
        } else {
            System.out.println("Вы не передавали параметров");
        }
    }
}
