public class Human {
    String name;
    int age;
    String sex;

    //hàm tạo
    public Human(){ // hàm tạo rỗng
        name = "New";
        age = 20;
        sex = "nam";
    }
    // hàm tạo đầy đủ
    public Human(String name, int age, String sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    //phương thức
    public void eat(){
        System.out.print(name + "Đói");
    }
    public void sleep(){
        System.out.print(name+"Ngủ");
    }

}
