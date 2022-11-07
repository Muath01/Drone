package src;
import java.util.Random;

public class EnumGetRandomValueExample {


    private enum BaseColor {
        Red,
        Green,
        Blue;

    	public static BaseColor getRandomColor() {
            Random random = new Random();
            return values()[random.nextInt(values().length)];
        }
    }
}