package ssjprajwol.com;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyMembers extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("hajurbuwā", "Grandfather"));
        words.add(new Word("hajurāmā", "Grandmother "));
        words.add(new Word("bābā", "Father "));
        words.add(new Word("āmā", "Mother"));
        words.add(new Word("dāi", "Elder brother"));
        words.add(new Word("bhāi", "Younger brother"));
        words.add(new Word("didī", "Elder sister"));
        words.add(new Word("bahinī", "Younger sister"));
        words.add(new Word("chorī", "Daughter"));
        words.add(new Word("chorā", "Son"));
        words.add(new Word("nātinī", "Granddaughter"));
        words.add(new Word("nāti", "Grandson"));
        words.add(new Word("śrīmān", "Husband"));
        words.add(new Word("śrīmatī", "Wife"));


        /*TextView wordView = new TextView(this);
        wordView.setText(words.get(0));
        rootView.addView(wordView);*/

        WordAdapter adapter = new WordAdapter(this, words);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

    }
}