package util;

import Characters.AbstractCharacter;

public class DistanceCalculator {

    public static int getDistanceBetweenCharacters(AbstractCharacter ac1, AbstractCharacter ac2) {
        int distanceX = Math.abs(ac1.getX() - ac2.getX());
        int distanceY = Math.abs(ac1.getY() - ac2.getY());
        return distanceX + distanceY;
    }

    public static boolean isRange(AbstractCharacter ac1, int range,int x, int y) {
        int distanceX = Math.abs(ac1.getX() - x);
        int distanceY = Math.abs(ac1.getY() - y);
        if(distanceX + distanceY > range) {
            return false;
        } else {
            return true;
        }
    }

}
