package com.yaoc.inclassassignment04_yaoc;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    String gender = "";
    String emotion = "";

    public void genderClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radio_male:
                if (checked)
                    gender = "male";
                    break;
            case R.id.radio_female:
                if (checked)
                    gender = "female";
                    break;
        }
    }

    public void motionClicked(View view){
        boolean checked = ((RadioButton)view).isChecked();
        switch (view.getId()){
            case R.id.radio_happy:
                if(checked)
                    emotion = "happy";
                    break;
            case R.id.radio_sad:
                if(checked)
                    emotion = "sad";
                    break;
            case R.id.radio_angry:
                if(checked)
                    emotion = "angry";
                    break;
        }
    }

    public void go(View view){
        String userName = ((EditText)findViewById(R.id.userName)).getText().toString();
        CheckBox checkInvite = (CheckBox)findViewById(R.id.InviteFriends);
        boolean hasCheckedInvite = checkInvite.isChecked();

        if(hasCheckedInvite){
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:")); // only email apps should handle this
            intent.putExtra(Intent.EXTRA_SUBJECT,"Something Interesting You Must Try!");
            intent.putExtra(Intent.EXTRA_TEXT,"");
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        }else{

        }
    }


}
