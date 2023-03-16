package util;

import Characters.AbstractCharacter;

public class DistanceCalculator {

    public static int getDistanceBetweenCharacters(AbstractCharacter ac1, AbstractCharacter ac2) {
        distanceX = Math.abs(ac1.getX - ac2.getX);
        distanceY = Math.abs(ac1.getY - ac2.getY);
        return distanceX + distanceY;
    }

}
