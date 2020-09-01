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

                words.add(new Word("Seto", "White"));
                words.add(new Word("Kalo", "Black"));
                words.add(new Word("Nilo", "Blue"));
                words.add(new Word("Pahelo", "Yellow"));
                words.add(new Word("Rato", "Red"));
                words.add(new Word("Hariyo", "Green"));
                words.add(new Word("Suntala", "Orange"));
                words.add(new Word("Khairo", "Brown"));
                words.add(new Word("Gulabi", "Pink"));
                words.add(new Word("Baijani", "Purple"));
                words.add(new Word("Kharani", "Grey"));
                words.add(new Word("Chadi", "Silver"));
                words.add(new Word("Sunaulo", "Gold"));


        /*TextView wordView = new TextView(this);
        wordView.setText(words.get(0));
        rootView.addView(wordView);*/

                WordAdapter adapter = new WordAdapter(this, words);

                ListView listView = (ListView) findViewById(R.id.list);

                listView.setAdapter(adapter);

        }
}