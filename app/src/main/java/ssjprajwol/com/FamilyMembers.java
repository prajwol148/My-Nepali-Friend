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

        words.add(new Word("hajurbuwā", "Grandfather",R.drawable.family_grandfather));
        words.add(new Word("hajurāmā", "Grandmother ",R.drawable.family_grandmother));
        words.add(new Word("bābā", "Father ",R.drawable.family_father));
        words.add(new Word("āmā", "Mother",R.drawable.family_mother));
        words.add(new Word("dāi", "Elder brother",R.drawable.family_older_brother));
        words.add(new Word("bhāi", "Younger brother",R.drawable.family_younger_brother));
        words.add(new Word("didī", "Elder sister",R.drawable.family_older_sister));
        words.add(new Word("bahinī", "Younger sister",R.drawable.family_younger_sister));
        words.add(new Word("chorī", "Daughter",R.drawable.family_daughter));
        words.add(new Word("chorā", "Son",R.drawable.family_son));


        /*TextView wordView = new TextView(this);
        wordView.setText(words.get(0));
        rootView.addView(wordView);*/

        WordAdapter adapter = new WordAdapter(this, words,R.color.category_family);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

    }
}