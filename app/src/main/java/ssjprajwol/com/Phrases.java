package ssjprajwol.com;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Phrases extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("namaste", "Hello (General greeting)",R.raw.phrases_hello));
        words.add(new Word("tapaaii lai kasto cha?", "How are you?",R.raw.phrases_how_are_you));
        words.add(new Word("malaai sanchai cha. tapaaiilaaii ni?", "Reply to 'How are you?'",R.raw.phrases_reply_how_are_youu));
        words.add(new Word("lamo samaya samma haraunu bhayo ni!", "Long time no see",R.raw.phrases_long_time_nosee));
        words.add(new Word("tapaaiiko naam ke ho?", "What's your name?",R.raw.phrases_what_is_your_name));
        words.add(new Word("mero naam ... ho", "My name is .....",R.raw.phrases_reply_my_name_is));
        words.add(new Word("tapaaii ko ghara kaaha ho?", "Where are you from?",R.raw.phrases_where_are_you_from));
        words.add(new Word("yaha kohi ... bolchha", "Does anyone here speak ...?",R.raw.phrases_does_anyone_speak));
        words.add(new Word("yo maile bujhna sakina", "I don't understand that.",R.raw.phrases_cannot_understand));
        words.add(new Word("kripaya ekai chhinn ...", "Just a moment please.",R.raw.phrases_please_wait));
        words.add(new Word("Malai sancho chaina", "I feel sick",R.raw.phrases_i_am_sick));
        words.add(new Word("tapaaiilaaii bhetera khushii laagyo", "Pleased to meet you",R.raw.phrases_pleased_to_meet));
        words.add(new Word("tapain le nepalima ... lai kasari bhannu hunchha?", "How do you say ... in Nepali?",R.raw.phrases_how_do_you_say));
        words.add(new Word("Ma .... bata aayeko hun", "I came from ...",R.raw.phrases_i_came_from));



        /*TextView wordView = new TextView(this);
        wordView.setText(words.get(0));
        rootView.addView(wordView);*/

        WordAdapter adapter = new WordAdapter(this, words,R.color.category_phrases);

        ListView listView = (ListView) findViewById(R.id.list);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               Word word= words.get(i);
                MediaPlayer mMediaPlayer = MediaPlayer.create(Phrases.this, word.getAudioResourceId());
                mMediaPlayer.start();
            }
        });

        listView.setAdapter(adapter);

    }
}