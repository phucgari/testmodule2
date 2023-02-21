import java.io.*;
import java.util.*;

public class StudentManager {
    private List<Student> list = new ArrayList<>();

    public StudentManager() {
        readCSV();
    }

    public List<Student> getList() {
        return list;
    }

    public void add(Student student) {
        list.add(student);
    }

    public void edit(String id, Student student) {
        delete(id);
        list.add(student);
    }

    public void delete(String id) {
        for (Student std :
                list) {
            if (std.getId().equals(id)) {
                list.remove(std);
                break;
            }
        }
    }
    public void sortByScore(boolean b){
        Comparator<Student>comparator=new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                return (int) (o1.getScore()-o2.getScore());
            }
        };
        if(b)Collections.sort(list,comparator);
        else Collections.sort(list,Collections.reverseOrder(comparator));
    }
    public void writeCSV(){
        try(FileWriter writer=new FileWriter("data/students.csv")){
            for (Student student:
                 list) {
                writer.write(student.toCSV()+"\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void readCSV() {
        int count = 0;
        String file = "bank-Detail.txt";
        List<Student> content = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader("data/students.csv"))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                String[]arr=line.split(",");
                content.add(new Student(arr[0],arr[1],Integer.parseInt(arr[2]), arr[3].equals("male"),arr[4],Double.parseDouble(arr[5])));
            }
        } catch (FileNotFoundException e) {
            //Some error logging
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        list=content;
    }
}
