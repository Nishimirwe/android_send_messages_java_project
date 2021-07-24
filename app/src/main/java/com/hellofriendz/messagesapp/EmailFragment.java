package com.hellofriendz.messagesapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hellofriendz.messagesapp.databinding.FragmentEmailBinding;

public class EmailFragment extends Fragment {
    private FragmentEmailBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding=FragmentEmailBinding.inflate(getLayoutInflater());
        View v=binding.getRoot();
        return v;
    }
}