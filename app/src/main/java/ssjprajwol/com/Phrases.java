package ssjprajwol.com;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class Phrases extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("namaste", "Hello (General greeting)"));
        words.add(new Word("tapaaii lai kasto cha?", "How are you?"));
        words.add(new Word("malaai sanchai cha. tapaaiilaaii ni?", "Reply to 'How are you?'"));
        words.add(new Word("lamo samaya samma haraunu bhayo ni!", "Long time no see"));
        words.add(new Word("tapaaiiko naam ke ho?", "What's your name?"));
        words.add(new Word("My name is ...", "mero naam ... ho"));
        words.add(new Word("tapaaiikii ghara kaaham ho?", "Where are you from?"));
        words.add(new Word("yaha kohi ... bolchha", "Does anyone here speak ...?"));
        words.add(new Word("yo maile bujhna sakina", "I don't understand that."));
        words.add(new Word("kripaya ekai chhinn ...", "Just a moment please."));
        words.add(new Word("Malai sancho chaina", "I feel sick"));
        words.add(new Word("tapaaiilaaii bhetera khushii laagyo", "Pleased to meet you"));
        words.add(new Word("tapain le nepalima ... lai kasari bhannu hunchha?", "How do you say ... in Nepali?"));
        words.add(new Word("Ma .... bata aayeko hun", "I came from ..."));



        /*TextView wordView = new TextView(this);
        wordView.setText(words.get(0));
        rootView.addView(wordView);*/

        WordAdapter adapter = new WordAdapter(this, words,R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(adapter);

    }
}