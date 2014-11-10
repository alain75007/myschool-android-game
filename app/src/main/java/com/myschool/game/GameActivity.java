package com.myschool.game;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.myschool.game.core.Archer;
import com.myschool.game.core.Character;


public class GameActivity extends Activity {

    private Character character;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        /* Récupération de l'enregistrement Init */
        character = ((Init) this.getApplication()).getCharacter();

        /* Afficher l'image correspondant au personnage choisi */
        Drawable drawable;
        if (character instanceof Archer) {
            drawable = getResources().getDrawable(R.drawable.ic_archer);
        } else {
            drawable = getResources().getDrawable(R.drawable.ic_launcher);
        }
        ImageView imageView = (ImageView) findViewById(R.id.act_game_img_character);
        imageView.setImageDrawable(drawable);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game, menu);
        return true;
    }

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
}
