package ssjprajwol.com;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class Colors extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.word_list);

                ArrayList<Word> words = new ArrayList<Word>();

                words.add(new Word("Seto", "White",R.drawable.color_white));
                words.add(new Word("Kalo", "Black",R.drawable.color_black));
                words.add(new Word("Pahelo", "Yellow",R.drawable.color_mustard_yellow));
                words.add(new Word("Rato", "Red",R.drawable.color_red));
                words.add(new Word("Hariyo", "Green",R.drawable.color_green));
                words.add(new Word("Dhulo Pahelo", "Dusty Yellow",R.drawable.color_dusty_yellow));
                words.add(new Word("Khairo", "Brown",R.drawable.color_brown));
                words.add(new Word("Gulabi", "Pink",R.drawable.color_pink));
                words.add(new Word("Baijani", "Purple",R.drawable.color_purple));
                words.add(new Word("Kharani", "Grey",R.drawable.color_gray));
                words.add(new Word("Chadi", "Silver",R.drawable.color_silver));
                words.add(new Word("Sunaulo", "Gold",R.drawable.color_gold));


        /*TextView wordView = new TextView(this);
        wordView.setText(words.get(0));
        rootView.addView(wordView);*/

                WordAdapter adapter = new WordAdapter(this, words,R.color.category_colors);

                ListView listView = (ListView) findViewById(R.id.list);

                listView.setAdapter(adapter);

        }
}