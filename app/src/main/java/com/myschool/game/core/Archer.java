package com.myschool.game.core;

/**
 * La classe Archer étend la classe abstraite Warrior dont elle implemente les méthodes
 */
public class Archer extends Warrior {
    protected int arrowCount = 2;
    protected boolean weaponInUse = false;
    protected boolean hasWeapon = true;

    public Archer(String name) {
        super(name);
    }

    @Override
    public void disBonjour() {
        dit("Je suis le plus habile des archer");
    }

    protected void getArrow() {
        if (arrowCount > 0) {
            dit("Je prends une flèche");
        }
    }

    @Override
    public void getWeapon() {
        if (weaponInUse || !hasWeapon) return;
        dit("Je prends mon arc");
        weaponInUse = true;

    }


    @Override
    public void rangerWeapon() {
        if (hasWeapon) dit("Je remets mon arc à l'épaule");

    }


    @Override
    public void fight() {
        if (hasWeapon) {
            getWeapon();
            if (arrowCount > 0) {
                getArrow();
                dit("Je tire la flèche");
                arrowCount--;
            } else {
                dit("Je lance mon arc à la tête de mon adversaire");
                hasWeapon = false;
            }
        } else {
            dit("Je m'enfuis!!!");
        }
    }


}
