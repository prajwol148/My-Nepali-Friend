package ssjprajwol.com;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class Colors extends AppCompatActivity {
        private MediaPlayer mMediaPlayer;
        private AudioManager mAudioManager;

        private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                        releaseMediaPlayer();
                }
        };

        AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
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


        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.word_list);

                mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);


                final ArrayList<Word> words = new ArrayList<Word>();

                words.add(new Word("Seto", "White",R.drawable.color_white,R.raw.color_white));
                words.add(new Word("Kalo", "Black",R.drawable.color_black,R.raw.color_black));
                words.add(new Word("Pahelo", "Yellow",R.drawable.color_mustard_yellow,R.raw.color_yellow));
                words.add(new Word("Rato", "Red",R.drawable.color_red,R.raw.color_red));
                words.add(new Word("Hariyo", "Green",R.drawable.color_green,R.raw.color_green));
                words.add(new Word("Dhulo Pahelo", "Dusty Yellow",R.drawable.color_dusty_yellow,R.raw.color_dustyyellow));
                words.add(new Word("Khairo", "Brown",R.drawable.color_brown,R.raw.color_brown));
                words.add(new Word("Gulabi", "Pink",R.drawable.color_pink,R.raw.color_pink));
                words.add(new Word("Baijani", "Purple",R.drawable.color_purple,R.raw.color_purple));
                words.add(new Word("Kharani", "Grey",R.drawable.color_gray,R.raw.color_grey));
                words.add(new Word("Chadi", "Silver",R.drawable.color_silver,R.raw.color_silver));
                words.add(new Word("Sunaulo", "Gold",R.drawable.color_gold,R.raw.color_gold));


        /*TextView wordView = new TextView(this);
        wordView.setText(words.get(0));
        rootView.addView(wordView);*/

                WordAdapter adapter = new WordAdapter(this, words,R.color.category_colors);

                ListView listView = (ListView) findViewById(R.id.list);

                listView.setAdapter(adapter);


                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                                Word word= words.get(i);

                                releaseMediaPlayer();


                                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                                        // Use the music stream.
                                        AudioManager.STREAM_MUSIC,
                                        // Request permanent focus.
                                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                                        // Start playback
                                mMediaPlayer = MediaPlayer.create(Colors.this, word.getAudioResourceId());
                                mMediaPlayer.start();
                                mMediaPlayer.setOnCompletionListener(mCompletionListener);
                        }
                        }
                });


        }

        @Override
        protected void onStop() {
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
                        mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
                }
        }

}