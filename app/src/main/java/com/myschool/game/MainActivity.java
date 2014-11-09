package com.myschool.game;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.myschool.game.core.Archer;
import com.myschool.game.core.Character;


public class MainActivity extends Activity {

    private Class selectedChar = Archer.class;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void onCharacterBtnClick(View view) {
        ImageView imageView = (ImageView) findViewById(R.id.act_main_img_character);
        switch (view.getId()) {
            case R.id.act_main_btn_character1:
                selectedChar = (Class) Archer.class;
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.ic_launcher));
                break;
            case R.id.act_main_btn_character2:
                selectedChar = (Class) Archer.class;
                imageView.setImageDrawable(getResources().getDrawable(R.drawable.img_archer));
                break;
        }
    }

    public void onGoButtonClick(View view) throws IllegalAccessException, InstantiationException {
        EditText editText = (EditText) findViewById(R.id.act_main_edit_character_name);
        String characterName;
        characterName = (String) editText.getText().toString();
        if (characterName.equals("")) {
            Toast.makeText(this, R.string.act_main_toast_missing_character_name, Toast.LENGTH_SHORT).show();
        } else {
            Character character = (com.myschool.game.core.Character) selectedChar.newInstance();
            Init init = (Init) this.getApplication();
            init.setCharacter(character);
            Intent intent = new Intent(this, GameActivity.class);
            startActivity(intent);
        }
    }
}
