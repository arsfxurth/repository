import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public void test(){
        Servise server = new Employee();
        Head head = new Head(1,"Иван","Лалала");
        head.setDuty();
        Head heads = new Head(2,"Игорь","Пупупу");
        Developer developer = new Developer(3,"Игорь","Хдхдхд");
        Developer developers = new Developer(4,"Дима","Ъхъхъхъ");
        Superviser superviser = new Superviser(5,"Света","Ккукуук");
        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(head);
        employees.add(heads);
        employees.add(developer);
        employees.add(developers);
        employees.add(superviser);
        boolean loading = true;
        while (loading){
            System.out.println("Введите пароль");
            Scanner sc = new Scanner(System.in);
            int password = sc.nextInt();
            if(server.entrance(password)){
                System.out.println("Верный пароль!");
                head.viewEmployee(3,employees,"Директор");
                loading = false;
            }
            else {System.out.println("Попробуйте еще раз");}
        }
    }
}
