package com.hellofriendz.messagesapp;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.hellofriendz.messagesapp.databinding.FragmentEmailBinding;

public class EmailFragment extends Fragment {
    private FragmentEmailBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentEmailBinding.inflate(inflater,container,false);
        View v=binding.getRoot();
        return v;
    }

    @Override
    public void onViewCreated(@NonNull  View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onSendButtonClicked();
    }

    private void onSendButtonClicked() {
        binding.sendEmailButtonId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "I am clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }
}