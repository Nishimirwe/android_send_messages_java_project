package com.hellofriendz.messagesapp;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.Contacts;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import 	android.content.pm.PackageManager;
import android.widget.Toast;

import com.hellofriendz.messagesapp.databinding.FragmentMessageBinding;

public class MessageFragment extends Fragment {
    private FragmentMessageBinding binding;
    static final int REQUEST_SELECT_CONTACT = 1;
    String Number,Message;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentMessageBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onChooseContactClicked();
        onSendMessageClicked();

    }

    private void onSendMessageClicked() {
        binding.sendMessageButtonId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                initializeData();
                if(areDataValidated())
                {
                    Intent i=new Intent(getContext(),MessagePreviewActivity.class);
                    getContext().startActivity(i);
                    i.putExtra("Message",binding.phoneNumberTextId.getText().toString());
                    i.putExtra("PhoneNumber",binding.phoneNumberTextId.getText().toString());
                }
                else
                {
                    Toast.makeText(getContext(),"Please fill all fields",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private boolean areDataValidated() {
        if(Message.isEmpty() || Number.isEmpty())
        {
            return false;
        }
        return true;
    }

    private void initializeData() {
        Number=binding.phoneNumberTextId.getText().toString();
        Message=binding.messageValueId.getText().toString();
    }

    private void onChooseContactClicked() {
        binding.chooseContactButtonId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectContact();
            }
        });
    }

    public void selectContact() {
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
        if (intent.resolveActivity(getContext().getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_SELECT_CONTACT);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_SELECT_CONTACT && resultCode == getActivity().RESULT_OK) {
            Uri contactUri = data.getData();
        }
    }
}