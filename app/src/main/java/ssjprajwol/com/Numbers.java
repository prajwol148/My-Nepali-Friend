package ssjprajwol.com;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class Numbers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("Ek", "One"));
        words.add(new Word("d̪ui", "Two"));
        words.add(new Word("t̪in", "Three"));
        words.add(new Word("chär", "Four"));
        words.add(new Word("pä̃ch", "Five"));
        words.add(new Word("chʰa", "Six"));
        words.add(new Word("sät̪", "Seven"));
        words.add(new Word("äʈʰ", "Eight"));
        words.add(new Word("nau", "Nine"));
        words.add(new Word("d̪as", "Ten"));


        /*TextView wordView = new TextView(this);
        wordView.setText(words.get(0));
        rootView.addView(wordView);*/

        WordAdapter adapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

    }
}