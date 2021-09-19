package com.skull1.hackathon1.Home;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.skull1.hackathon1.Front.HomeNew;
import com.skull1.hackathon1.Front.SosActivity;
import com.skull1.hackathon1.Login.Member;
import com.skull1.hackathon1.R;

import java.util.ArrayList;
import java.util.Locale;

public class VoiceRecorder extends AppCompatActivity {
    private static final int REQUEST_CALL = 1;
    private TextView txvResult;

    FirebaseAuth firebaseAuth;
    FirebaseUser member;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voicerecorder);
        txvResult = (TextView) findViewById(R.id.txvResult);

        ImageView button1 = findViewById(R.id.btnSpeak);

        button1.performClick();
    }

    public void getSpeechInput(View view) {

        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, 10);
        } else {
            Toast.makeText(this, "Your Device Don't Support Speech Input", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case 10:
                if (resultCode == RESULT_OK && data != null) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    txvResult.setText(result.get(0));
                    if(result.get(0).equalsIgnoreCase("suraksha")||result.get(0).equalsIgnoreCase("diffuser")||result.get(0).equalsIgnoreCase("raksha")) {
                        makePhoneCall();



                    }

                }
                break;
        }
    }
    /*private void makePhoneCall() {
        String number = "8218521910" ;   //mEditTextNumber.getText().toString();
        if (number.trim().length() > 0) {

            if (ContextCompat.checkSelfPermission(VoiceRecorder.this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(VoiceRecorder.this,
                        new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }

        } else {
            Toast.makeText(VoiceRecorder.this, "Enter Phone Number", Toast.LENGTH_SHORT).show();
        }
    }*/
    private void makePhoneCall(){
        firebaseAuth= FirebaseAuth.getInstance();
        member=firebaseAuth.getCurrentUser();
        databaseReference= FirebaseDatabase.getInstance().getReference().child("Member");
        String key=member.getEmail();
        databaseReference.addValueEventListener(new ValueEventListener() {
            String xyz;String xyz1;
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Member info = snapshot.getValue(Member.class);
                    if (key.equalsIgnoreCase(info.getName())) {
                        xyz = info.getPh().toString();
                        xyz1=info.getPh2().toString();
                        // a[i]=xyz;i=i+1;
                        String number = xyz;   //mEditTextNumber.getText().toString();
                        if (number.trim().length() > 0) {

                            if (ContextCompat.checkSelfPermission(VoiceRecorder.this,
                                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                ActivityCompat.requestPermissions(VoiceRecorder.this,
                                        new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
                            } else {
                                String dial = "tel:" + number;
                                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
                            }

                        } else {
                            Toast.makeText(VoiceRecorder.this, "Enter Phone Number", Toast.LENGTH_SHORT).show();
                        }
//
                    }
                // makePhoneCall2();
                }
            }



            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        // makePhoneCall();
    }
    private void makePhoneCall2(){
        firebaseAuth= FirebaseAuth.getInstance();
        member=firebaseAuth.getCurrentUser();
        databaseReference= FirebaseDatabase.getInstance().getReference().child("Member");
        String key=member.getEmail();
        databaseReference.addValueEventListener(new ValueEventListener() {
            String xyz;
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Member info = snapshot.getValue(Member.class);
                    if (key.equalsIgnoreCase(info.getName())) {
                        xyz = info.getPh2().toString();
                        // a[i]=xyz;i=i+1;
                        String number = xyz;   //mEditTextNumber.getText().toString();
                        if (number.trim().length() > 0) {

                            if (ContextCompat.checkSelfPermission(VoiceRecorder.this,
                                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                                ActivityCompat.requestPermissions(VoiceRecorder.this,
                                        new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
                            } else {
                                String dial = "tel:" + number;
                                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
                            }

                        } else {
                            Toast.makeText(VoiceRecorder.this, "Enter Phone Number", Toast.LENGTH_SHORT).show();
                        }


                    }
//                  makePhoneCall();
                }
            }



            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



        // makePhoneCall();
    }




    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makePhoneCall();makePhoneCall2();
            } else {
                Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }
}