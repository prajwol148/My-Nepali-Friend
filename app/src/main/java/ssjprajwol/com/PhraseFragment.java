package ssjprajwol.com;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class PhraseFragment extends Fragment {
    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;



    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if(focusChange == AudioManager.AUDIOFOCUS_GAIN){
                mMediaPlayer.start();
            }
            else if(focusChange ==AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK){
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            }
            else if(focusChange == AudioManager.AUDIOFOCUS_LOSS){
                releaseMediaPlayer();
            }
        }
    };
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            releaseMediaPlayer();
        }
    };

    public PhraseFragment(){

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.word_list, container, false);

        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("namaste", "Hello (General greeting)", R.raw.phrases_hello));
        words.add(new Word("tapaaii lai kasto cha?", "How are you?", R.raw.phrases_how_are_you));
        words.add(new Word("malaai sanchai cha. tapaaiilaaii ni?", "Reply to 'How are you?'", R.raw.phrases_reply_how_are_youu));
        words.add(new Word("lamo samaya samma haraunu bhayo ni!", "Long time no see", R.raw.phrases_long_time_nosee));
        words.add(new Word("tapaaiiko naam ke ho?", "What's your name?", R.raw.phrases_what_is_your_name));
        words.add(new Word("mero naam ... ho", "My name is .....", R.raw.phrases_reply_my_name_is));
        words.add(new Word("tapaaii ko ghara kaaha ho?", "Where are you from?", R.raw.phrases_where_are_you_from));
        words.add(new Word("yaha kohi ... bolchha", "Does anyone here speak ...?", R.raw.phrases_does_anyone_speak));
        words.add(new Word("yo maile bujhna sakina", "I don't understand that.", R.raw.phrases_cannot_understand));
        words.add(new Word("kripaya ekai chhinn ...", "Just a moment please.", R.raw.phrases_please_wait));
        words.add(new Word("Malai sancho chaina", "I feel sick", R.raw.phrases_i_am_sick));
        words.add(new Word("tapaaiilaaii bhetera khushii laagyo", "Pleased to meet you", R.raw.phrases_pleased_to_meet));
        words.add(new Word("tapain le nepalima ... lai kasari bhannu hunchha?", "How do you say ... in Nepali?", R.raw.phrases_how_do_you_say));
        words.add(new Word("Ma .... bata aayeko hun", "I came from ...", R.raw.phrases_i_came_from));



        /*TextView wordView = new TextView(this);
        wordView.setText(words.get(0));
        rootView.addView(wordView);*/

        WordAdapter adapter = new WordAdapter(getActivity(), words, R.color.category_phrases);

        ListView listView = (ListView) rootView.findViewById(R.id.list);


        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                releaseMediaPlayer();
                Word word = words.get(i);

                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        // Use the music stream.
                        AudioManager.STREAM_MUSIC,
                        // Request permanent focus.
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // Start playback
                    mMediaPlayer = MediaPlayer.create(getActivity(), word.getAudioResourceId());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });

        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;
        }
    }
}
