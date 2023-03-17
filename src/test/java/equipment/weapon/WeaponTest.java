package equipment.weapon;

import org.junit.Test;

import static org.junit.Assert.*;

public class WeaponTest {

    BattleAxe battleAxe = new BattleAxe();
    Bow bow = new Bow();
    Dagger dagger = new Dagger();
    Dart dart = new Dart();
    HandAxe handAxe = new HandAxe();
    Rapier rapier = new Rapier();
    Spear spear = new Spear();
    Sword sword = new Sword();

    @Test
    public void battleAxeDamage() {
        assertEquals(6, battleAxe.useWeapon());
    }

    @Test
    public void bowDamage() {
        assertEquals(8, bow.useWeapon());
    }
    @Test
    public void daggerDamage() {
        assertEquals(4, dagger.useWeapon());
    }
    @Test
    public void dartDamage() {
        assertEquals(4, dart.useWeapon());
    }
    @Test
    public void handAxeDamage() {
        assertEquals(6, handAxe.useWeapon());
    }
    @Test
    public void rapierDamage() {
        assertEquals(8, rapier.useWeapon());
    }
    @Test
    public void spearDamage() {
        assertEquals(6, spear.useWeapon());
    }
    @Test
    public void swordDamage() {
        assertEquals(8, sword.useWeapon());
    }

}