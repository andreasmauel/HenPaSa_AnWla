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
        assertTrue( battleAxe.useWeapon() >= 1 && battleAxe.useWeapon() <= 6 );
    }
    @Test
    public void bowDamage() {
        assertTrue( bow.useWeapon() >= 1 && bow.useWeapon() <= 8 );
    }
    @Test
    public void daggerDamage() {
        assertTrue( dagger.useWeapon() >= 1 && dagger.useWeapon() <= 4 );
    }
    @Test
    public void dartDamage() {
        assertTrue( dart.useWeapon() >= 1 && dart.useWeapon() <= 4 );
    }
    @Test
    public void handAxeDamage() {
        assertTrue( handAxe.useWeapon() >= 1 && handAxe.useWeapon() <= 6 );
    }
    @Test
    public void rapierDamage() {
        assertTrue( rapier.useWeapon() >= 1 && rapier.useWeapon() <= 8 );
    }
    @Test
    public void spearDamage() {
        assertTrue( spear.useWeapon() >= 1 && spear.useWeapon() <= 6 );
    }
    @Test
    public void swordDamage() {
        assertTrue( sword.useWeapon() >= 1 && sword.useWeapon() <= 8 );
    }

}