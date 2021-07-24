package com.hellofriendz.messagesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.hellofriendz.messagesapp.databinding.ActivityMessagePreviewBinding;

public class MessagePreviewActivity extends AppCompatActivity {
    private ActivityMessagePreviewBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMessagePreviewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        String PhoneNumber="No number";
        String Message="No Message";
        String setMessage="Nothing";
        Intent intent=getIntent();
        if(intent != null)
        {
//            MessageClass MessageFromIntent= (MessageClass) intent.getSerializableExtra("Message");
//            PhoneNumber=MessageFromIntent.getNumber();
            Message=intent.getStringExtra("Message");
            PhoneNumber=intent.getStringExtra("PhoneNumber");
        }
        binding.previewTextViewId.setText(intent.getStringExtra("Message"));

    }
}