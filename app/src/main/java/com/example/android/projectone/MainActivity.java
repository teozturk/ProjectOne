package com.example.android.projectone;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    String workingHoursText ="Monday	10:00–23:00"
            +"\nTuesday10:00–23:00"
            +"\nWednesday 10:00–23:00"
            +"\nThursday 10:00–23:00"
            +"\nFriday 10:00–23:00"
            +"\nSaturday 10:00–23:00"
            +"\nSunday 10:00–23:00";
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mediaPlayer = MediaPlayer.create(this, R.raw.thema);
        mediaPlayer.start();

    }

    public void call(View v)
    {
        String phone = "+902320000000";
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
        startActivity(intent);

    }

    public void workingHours(View v)
    {
        TextView workTextView = (TextView)findViewById(R.id.workText);
        int emre = workTextView.getVisibility();

        if ( emre == 4   )
        {
            workTextView.setVisibility(View.VISIBLE);
            workTextView.setText(workingHoursText);
        }
        else

        {
            workTextView.setVisibility(View.INVISIBLE);
            workTextView.setText("");

        }

    }

    public void coffeeShopLocation(View v)
    {



        Uri locUri = Uri.parse("geo:0,0?q=38.46144981653572,27.21322998404503(Android Coffee Shop)");
        Intent mapIntent =new Intent(Intent.ACTION_VIEW, locUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        if (mapIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(mapIntent);
        }
    }

    public void share(View v)

    {
        String Emre = "My Favorite Coffee Shop Informations" +
                "\nName=Android Coffee Shop" +
                "\nTel= 902320000000" +
                "\nAdress= Izmır Turkey" +
                "\nWorkingHours= "+
                "\n"+workingHoursText;

        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, Emre);
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }

    public void muteSong(View v)

    {
        mediaPlayer.stop();

    }

    public void contactUs(View v)

    {
        String[] mailAdress ={"tugayemreozturk@gmail.com"};

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:"));
        intent.putExtra(Intent.EXTRA_EMAIL, mailAdress);
        intent.putExtra(Intent.EXTRA_SUBJECT, "contactUs");
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }


}







