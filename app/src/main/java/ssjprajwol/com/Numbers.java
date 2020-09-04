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

        words.add(new Word("Ek", "One",R.drawable.number_one));
        words.add(new Word("d̪ui", "Two",R.drawable.number_two));
        words.add(new Word("t̪in", "Three",R.drawable.number_three));
        words.add(new Word("chär", "Four",R.drawable.number_four));
        words.add(new Word("pä̃ch", "Five",R.drawable.number_five));
        words.add(new Word("chʰa", "Six",R.drawable.number_six));
        words.add(new Word("sät̪", "Seven",R.drawable.number_seven));
        words.add(new Word("äʈʰ", "Eight",R.drawable.number_eight));
        words.add(new Word("nau", "Nine",R.drawable.number_nine));
        words.add(new Word("d̪as", "Ten",R.drawable.number_ten));


        /*TextView wordView = new TextView(this);
        wordView.setText(words.get(0));
        rootView.addView(wordView);*/

        WordAdapter adapter = new WordAdapter(this, words,R.color.category_numbers);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

    }
}