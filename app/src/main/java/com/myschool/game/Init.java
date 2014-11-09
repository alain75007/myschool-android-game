package com.myschool.game;

import android.app.Application;

import com.myschool.game.core.Character;

/**
 * Un objet Init sera instancé par le système Android au démarrage de l'application
 * Lors du lancement, le système Android instancie un objet Application pour gérer l'application.
 * Cete objet est accessible à partir d'une activité à l'aide de la méthode
 * this.getApplictionContext(). C'est donc un objet interessant pour stocker des méthodes ou
 * des variables d'instance accessibles quelque soit l'activité.
 * <p/>
 * En spécifiant dans le manifest d'instancier plutôt un objet Init descendant de Application,
 * un objet init sera initié par le système android. Dans cet objet Init seront stockées toutes
 * les méthodes et variables d'instance que je veux pouvoir utiliser dans n'importe-qu'elle
 * activité.
 */
public class Init extends Application {
    /**
     * Ici ont crée une variable d'instance pour stocker l'objet character
     */
    private Character character;

    /**
     * Getter de l'objet character
     *
     * @return character
     */
    public Character getCharacter() {
        return character;
    }

    /**
     * Setter de l'objet character
     *
     * @param character
     */
    public void setCharacter(Character character) {
        this.character = character;
    }


}
