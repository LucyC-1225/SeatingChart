import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String[] seats = {"Moiz", "Angie", "Taran", "Kelvin", "Kyler", "David", "WenHao", "Nicole", "Jennifer", "Michelle", "Beckett", "Raymond", "Lucy", "Apramjot", "Justin Lema", "Sam", "Tristan", "Pradeep", "Mohammad", "Haley", "empty", "Rely", "Cheng Han", "Qihan", "Kevin", "Ryan", "Justin Liu", "Jeffrey", "Danny", "Elliot", "Benson", "Fiona", "Neil", "Kaitlyn"};
        ArrayList<Integer> avaiableSeatNum = new ArrayList<Integer>();
        for (int i = 0; i < 34; i++){
            avaiableSeatNum.add(i + 1);
        }

        //where the empty seat can be
        ArrayList<Integer> generatedSeatNum = new ArrayList<Integer>();
        int[] validSeats = {1, 11, 23, 10, 22, 34};
        int indx = rand(0, 5);
        int emptySeat = validSeats[indx];
        avaiableSeatNum.remove(emptySeat - 1);

        for (int i = 1; i <= 34; i++){
            int index = rand(0, avaiableSeatNum.size() - 1);
            int randSeatNum = avaiableSeatNum.get(index);
            while (randSeatNum == i){
                index = rand(0, avaiableSeatNum.size() - 1);
                randSeatNum = avaiableSeatNum.get(index);
            }
            if (i == 21){
                generatedSeatNum.add(emptySeat);
            } else {
                generatedSeatNum.add(randSeatNum);
                avaiableSeatNum.remove(index);
            }
        }
        System.out.println("Testing");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(generatedSeatNum);
        System.out.println("How to read array example: Moiz's old seat was seat 1. New seat is seat " + generatedSeatNum.get(0));

        String[] newSeats = new String[34];
        for (int i = 0; i < newSeats.length; i++){
            newSeats[generatedSeatNum.get(i) - 1] = seats[i];
        }

        System.out.println("Did everyone get new seats?: " + isnewSeats(seats, newSeats));
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("New seats!!");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        for (int i = 0; i <= 9; i++){
            String str = "|" + (i + 1) + ". " + newSeats[i];
            String extraSpace = "";
            while (str.length() + extraSpace.length() < 16){
                extraSpace += " ";
            }
            System.out.print(str + extraSpace + "| ");
        }
        System.out.println();
        for (int i = 10; i <= 21; i++){
            String str = "|" + (i + 1) + ". " + newSeats[i];
            String extraSpace = "";
            while (str.length() + extraSpace.length() < 16){
                extraSpace += " ";
            }
            System.out.print(str + extraSpace + "| ");
        }
        System.out.println();
        for (int i = 22; i <= 33; i++){
            String str = "|" + (i + 1) + ". " + newSeats[i];
            String extraSpace = "";
            while (str.length() + extraSpace.length() < 16){
                extraSpace += " ";
            }
            System.out.print(str + extraSpace + "| ");
        }
        System.out.println();
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
    public static int rand(int min, int max){
        return (int)(Math.random() * (max - min + 1) + min);
    }
    public static boolean isnewSeats(String[] oldSeats, String[] newSeats){
        for (int i = 0; i < oldSeats.length; i++){
            if (oldSeats[i].equals(newSeats[i])){
                return false;
            }
        }
        return true;
    }
}
