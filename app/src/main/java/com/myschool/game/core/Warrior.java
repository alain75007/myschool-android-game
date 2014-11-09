package com.myschool.game.core;

/**
 * La classe Warrior étend la classe Character. C'est une classe abstraite,
 * c'est à dire quelle ne peut être instanciée.
 * <p/>
 * Cette classe implémente les méthodes de la classe Fight
 */
public abstract class Warrior extends Character implements Fight {
    public Warrior(String name) {
        super(name, 20);
    }

    @Override
    public void disBonjour(Character character) {
        System.out.println("Bonjour les civils! Je suis un " + this.getClass().getSimpleName());
    }

    public void disBigger() {
        this.dit(this.getName() + " dit : JE SUIS LE PLUS FORT!!!!");
    }


}