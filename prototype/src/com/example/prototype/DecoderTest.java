package com.example.prototype;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import nobleworks.libmpg.MP3Decoder;

import java.nio.ByteBuffer;

public class DecoderTest extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);    //To change body of overridden methods use File | Settings | File Templates.
    }


    public void decode(View v) {
        MP3Decoder mpg = new MP3Decoder("/storage/emulated/0/Audiobooks//Derek Landy - Skulduggery Pleasant 01 - Skulduggery Pleasant/Derek Landy - Skulduggery Pleasant 01 - Skulduggery Pleasant - Unabridged - Part 1.mp3");

        //this returned 1
        int numChannels = mpg.getNumChannels();

        //this returned 22050
        int rate = mpg.getRate();

        //this returned 1000
        int skip = mpg.skipSamples(1000);

        ByteBuffer buf = ByteBuffer.allocateDirect(8192);
        int bytesRead = 2 * mpg.readSamples(buf.asShortBuffer());

        System.out.println("break");
    }
}
