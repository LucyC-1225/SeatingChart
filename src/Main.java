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
            if (i - 1 == 0 || i - 1 == 11 || i - 1 == 23){
                while (randSeatNum == i || randSeatNum == i + 1){
                    index = rand(0, avaiableSeatNum.size() - 1);
                    randSeatNum = avaiableSeatNum.get(index);
                }
            } else if (i - 1 == 10 || i - 1 == 22 || i - 1 == 34){
                while (randSeatNum == i || randSeatNum == i - 1){
                    index = rand(0, avaiableSeatNum.size() - 1);
                    randSeatNum = avaiableSeatNum.get(index);
                }
            } else {
                while (randSeatNum == i){
                    index = rand(0, avaiableSeatNum.size() - 1);
                    randSeatNum = avaiableSeatNum.get(index);
                }
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
        String[][] seatingChart = new String[3][12];
        int index = 0;
        for (int r = 0; r < seatingChart.length; r++){
            for (int c = 0; c < seatingChart[0].length; c++){
                if (r == 0 && c == 10 || r == 0 && c == 11){
                    seatingChart[r][c] = "";
                } else {
                    seatingChart[r][c] = newSeats[index];
                    index++;
                }
            }
        }
        System.out.println("Did everyone get new seats?: " + isnewSeats(seats, newSeats));
        System.out.println("Did everyone get new partners?: " + newPartners(seats, newSeats));
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("New seats!!");
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
        int ind = 0;
        for (int r = 0; r < seatingChart.length; r++){
            for (int c = 0; c < seatingChart[0].length; c++){
                if (r == 0 && c == 10 || r == 0 && c == 11){
                    System.out.print("|               | ");
                } else {
                    String str = "|" + (ind + 1) + ". " + seatingChart[r][c];
                    String extraSpace = "";
                    while (str.length() + extraSpace.length() < 16){
                        extraSpace += " ";
                    }
                    System.out.print(str + extraSpace + "| ");
                    ind++;
                }
            }
            System.out.println();
        }
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
    public static boolean newPartners(String[] oldSeats, String[] newSeats){
        for (int i = 0; i < oldSeats.length; i++){
            if (i == 0 || i == 10 || i == 22){
                if (oldSeats[i].equals(newSeats[i]) || oldSeats[i + 1].equals(newSeats[i + 1])){
                    return false;
                }
            } else if (i == 9 || i == 21 || i == 33){
                if (oldSeats[i].equals(newSeats[i]) || oldSeats[i - 1].equals(newSeats[i - 1])){
                    return false;
                }
            } else {
                if (oldSeats[i].equals(newSeats[i]) || oldSeats[i + 1].equals(newSeats[i + 1]) || oldSeats[i - 1].equals(newSeats[i - 1])){
                    return false;
                }
            }
        }
        return true;
    }
}
