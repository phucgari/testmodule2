public class Student {
    private String id="";
    private String name="";
    private int age=-1;
    private boolean gender=true;
    private String address="";
    private double score=-1;

    public Student() {}

    public Student(String id, String name, int age, boolean gender, String address, double score) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender?"male":"female";
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + getGender() +
                ", address='" + address + '\'' +
                ", score=" + score +
                '}';
    }
    public String toCSV(){
        StringBuilder result=new StringBuilder();
        result.append(id).append(",").append(name).append(",").append(age).append(",").append(getGender())
                .append(",").append(address).append(",").append(score).append(",");
        return result.toString();
    }
}
