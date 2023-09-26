import java.util.ArrayList;
public class Employee implements Servise {
    int id;
    int levelAdmission;
    String name;
    String surname;
    String place;
    String duty;
    int countEmployees;
    int password = 1234;

    public Employee() {

    }

    private void duty(String duty) {
        this.duty = duty;
    }

    public Employee(int id, int levelAdmission, String name, String surname, String place) {
        this.id = id;
        this.levelAdmission = levelAdmission;
        this.name = name;
        this.surname = surname;
        this.place = place;
        countEmployees++;
    }

    public String setDuty() {
        String line = "";
        switch (place) {
            case "Директор":
                line = ("1. Руководить "+"2. Следить " + "3. Назначать " + " 4. Просматривать всех сотрудников");
                return line;
            case "Руководитель проекта":
                line ="1. Давать задания " + " 2. Следить" + " 3. Назначать";
                return line;
            default:
                line ="1. Давать задания " + " 2. Следить";
                return line;
        }
    }

    private int searchEmp(String place, ArrayList<Employee> arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            Employee employee = arrayList.get(i);
            if (place.equals(employee.place)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void viewEmployee(int levelAdmission, ArrayList<Employee> arrayList, String place) {
        switch (levelAdmission) {
            case 1:
                for (int i = 0; i < arrayList.size(); i++) {
                    arrayList.remove(searchEmp("Директор", arrayList));
                    arrayList.remove(searchEmp("Руководитель проекта", arrayList));
                    if (place.equals("Разработчик")) {
                        arrayList.remove(searchEmp("Менеджер", arrayList));
                        arrayList.remove(searchEmp("Бухгалтер", arrayList));
                    }
                    if (place.equals("Аналитик")) {
                        arrayList.remove(searchEmp("Менеджер", arrayList));
                        arrayList.remove(searchEmp("Бухгалтер", arrayList));
                        arrayList.remove(searchEmp("Разработчик", arrayList));
                    }
                    if (place.equals("Менеджер")) {
                        arrayList.remove(searchEmp("Бухгалтер", arrayList));
                        arrayList.remove(searchEmp("Разработчик", arrayList));
                        arrayList.remove(searchEmp("Аналитик", arrayList));
                    }
                    if (place.equals("Бухгалтер")) {
                        arrayList.remove(searchEmp("Разработчик", arrayList));
                        arrayList.remove(searchEmp("Аналитик", arrayList));
                        arrayList.remove(searchEmp("Менеджер", arrayList));
                    }
                }
                System.out.println( arrayList.size());
                for (int j = 0; j < arrayList.size(); j++) {

                    System.out.print(arrayList.get(j));
                }
                break;
            case 2:
                for (int i = 0; i < arrayList.size(); i++) {
                    arrayList.remove(searchEmp("Директор", arrayList));
                    arrayList.remove(searchEmp("Руководитель проекта", arrayList));
                }
                for (int j = 0; j < arrayList.size(); j++) {
                    System.out.print(arrayList.get(j));
                }
                break;
            case 3:
                for (int j = 0; j < arrayList.size(); j++) {
                    System.out.print(arrayList.get(j));
                    break;
                }
        }
    }
        @Override
        public boolean entrance(int passwords){
            return passwords == password;
        }
        @Override
        public String toString(){
        return "id: " + id + ". Имя: " + name + ". Обязанности: " + setDuty();
        }
    }