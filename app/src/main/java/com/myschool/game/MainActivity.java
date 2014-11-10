package com.myschool.game;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.myschool.game.core.Archer;
import com.myschool.game.core.Character;

import java.lang.reflect.InvocationTargetException;


public class MainActivity extends Activity {

    private static final String DEBUG = "MainActivity";
    private int selectedChar = 0;

    /**
     * Cette méthode est appelée par le système Android lors de la création de l'activité.
     * Ici on indique quel layout il faut utiliser pour l'affichage
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Cette méthode est appelée par le système Android lors de la création de l'activité. Elle
     * permet d'initialiser le menu option
     *
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    /* Cette méthode est appelée par le système Android lorqu'une un option est choisi dans le menu
     * options
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * - Modifie l'image principale selon le type de personnage choisi
     * - enregistre la selection
     *
     * @param view
     */
    public void onCharacterBtnClick(View view) {
        ImageView imageView = (ImageView) findViewById(R.id.act_main_img_character);
        Drawable drawable = null;
        switch (view.getId()) {
            case R.id.act_main_btn_character1:
                selectedChar = 0;
                Log.d(DEBUG, "It's a character");
                /* Récupération de Drawable et affectation à l'image principale */
                drawable = getResources().getDrawable(R.drawable.ic_launcher);
                imageView.setImageDrawable(drawable);
                break;
            case R.id.act_main_btn_character2:
                Log.d(DEBUG, "It's an Archer");
                selectedChar = 1;
                /* Récupération de Drawable et affectation à l'image principale */
                drawable = getResources().getDrawable(R.drawable.img_archer);
                imageView.setImageDrawable(drawable);
                break;
        }
    }

    /**
     * Initialise l'objet init avec la classe correspondante au type de personnage choisi et
     * lance l'activité GameActivity
     *
     * @param view
     * @throws IllegalAccessException
     * @throws InstantiationException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
    public void onGoButtonClick(View view) throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Character character = null;
        EditText editText = (EditText) findViewById(R.id.act_main_edit_character_name);
        String characterName;
        characterName = (String) editText.getText().toString();
        if (characterName.equals("")) {
            Toast.makeText(this, R.string.act_main_toast_missing_character_name, Toast.LENGTH_SHORT).show();
        } else {
            if (selectedChar == 0) {
                Log.d(DEBUG, "It's a character");
                character = new Character(characterName);
            } else {
                Log.d(DEBUG, "It's an Archer");
                character = (Character) new Archer(characterName);
            }
            /**
             * Mise à jour de l'objet Init
             */
            Init init = (Init) this.getApplication();
            init.setCharacter(character);

            /* Lancement de l'activity Game */
            Intent intent = new Intent(this, GameActivity.class);
            startActivity(intent);
        }
    }
}
