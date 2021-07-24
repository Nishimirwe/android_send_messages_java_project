package com.hellofriendz.messagesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.hellofriendz.messagesapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_holder_id, EmailFragment.class, null)
                .commit();

        binding.bottomNavigationMenuId.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        FragmentManager fragmentExchange=getSupportFragmentManager();
        if(item.getItemId()==R.id.email_bottom_menu_id)
        {
            fragmentExchange.beginTransaction().replace(R.id.fragment_holder_id,EmailFragment.class, null)
            .commit();
            return true;
        }
        else if(item.getItemId()==R.id.message_bottom_menu_id)
        {
            fragmentExchange.beginTransaction().replace(R.id.fragment_holder_id,MessageFragment.class,null)
            .commit();
            return true;
        }
        else
        {
            return false;
        }
    }
}