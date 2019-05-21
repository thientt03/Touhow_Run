import game.Vector2D;

import java.util.ArrayList;

public class Employee extends Human {
    public static void dosomeThingn(int input) throws Exception{
        if (input > 0){
            System.out.printf("okay");
        }
        else if (input == 0){
            throw new Exception("Not okay");
        }
        else if (input < 0){
            System.out.printf("okay");
        }
    }
    public static void main(String[] args) {
        try {
            dosomeThingn(1);
            dosomeThingn(0);
            dosomeThingn(-1);
        }
        catch (Exception ex){
            System.out.printf(ex.getMessage());
        }
        finally {
            System.out.printf("final!");
        }
        System.out.printf("continue...");
        System.out.printf("continue...");
//        ArrayList<Vector2D> vectors = new ArrayList<>();
//        //add: thêm phần tử, remove: xóa phần tử, size(): lấy độ dài, get(): lấy phần tử
//        vectors.add(new Vector2D(1,2));
//        vectors.add(new Vector2D(2,2));
//        vectors.add(new Vector2D(3,2));
//        vectors.add(new Vector2D(1,4));
//        vectors.add(new Vector2D(3,4));
//
//        double maxtotal = 0;
//        int indexMax = 0;
//        for (int i = 0; i < vectors.size(); i++){
//            Vector2D vector = vectors.get(i);
//            System.out.printf(vector.x + "" + vector.y);
//            if (vector.x + vector.y > maxtotal){
//                maxtotal = vector.x+vector.y;
//                indexMax = i;
//            }
//        }
//        System.out.printf(vectors.get(indexMax).x +""+ vectors.get(indexMax).y);
//
//    }
//    public static void removeElement(ArrayList list, Object element){
//        list.remove(element);
    }
}
