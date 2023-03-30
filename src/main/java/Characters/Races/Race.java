package Characters.Races;

import Characters.AbstractCharacter;

public abstract class Race {
    private int intelligenceModifier;
    private int dexterityModifier;
    private int strengthModifier;
    private int constitutionModifier;
    private int wisdomModifier;

    public void applyModifier(AbstractCharacter character){
        character.setIntelligence(character.getIntelligence() + intelligenceModifier);
        character.setDexterity(character.getDexterity() + dexterityModifier);
        character.setStrength(character.getStrength() + strengthModifier);
        character.setConstitution(character.getConstitution() + constitutionModifier);
        character.setWisdom(character.getWisdom() + wisdomModifier);
    }

}
