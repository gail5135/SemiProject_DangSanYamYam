import java.util.*;

public class FoodCollection {
    ArrayList<Food> allFoodList;   //모든 음식이 들어가있는 음식들 list리스트
    ArrayList<Food> inCartList;      //카트에 담겨져서 결제하기 전까지의 음식들 list리스트 -> 결제 완료되면 clear하기
    ArrayList<Food> orderedList;   //결제된 음식들 list
    private String[] foodName = {"baeksook", "bulgogi", "fish", "junjoo", "kimchistew", "noodle"};   //checkbox 이미지 filename
    private int[] foodPrice = {12000, 12000, 12000, 9000, 5000, 5000};

    public FoodCollection() {

        allFoodList = new ArrayList<Food>();
        inCartList = new ArrayList<Food>();
        orderedList = new ArrayList<Food>();

        for(int i = 0; i < foodName.length; i++) {
            allFoodList.add(new Food(foodName[i], foodPrice[i]));   //모든 음식들 list 초기화
        }

    }

    static public int calculateSum(ArrayList<Food> list) {   //합계 계산 -> 일단 static이고 나중에 필요에 따라 접근지정 변경하거나 다른 위치에서 구현해서 사용해도 문제 없음

        int sum = 0;
        for(int i = 0; i < list.size(); i++) {
            sum += list.get(i).getPrice();
        }

        return sum;
    }

    public void setEmptyInCartList(){
        inCartList.clear();
    }

}