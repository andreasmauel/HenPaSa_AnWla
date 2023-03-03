package Characters.Races;

import Characters.Player;

public abstract class Race {
    private int intelligenceModifier;
    private int dexterityModifier;
    private int strengthModifier;
    private int constitutionModifier;
    private int wisdomModifier;

    public void applyModifier(Player player){
        player.setIntelligence(player.getIntelligence() + intelligenceModifier);
        player.setDexterity(player.getDexterity() + dexterityModifier);
        player.setStrenght(player.getStrenght() + strengthModifier);
        player.setConstitution(player.getConstitution() + constitutionModifier);
        player.setWisdom(player.getWisdom() + wisdomModifier);
    }

}
