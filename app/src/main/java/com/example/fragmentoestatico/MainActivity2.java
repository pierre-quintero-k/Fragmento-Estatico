package com.example.fragmentoestatico;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebViewFragment;
import android.widget.TextView;

import com.example.fragmentoestatico.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {
    private ActivityMain2Binding binding;
    TextView url_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Bundle data= getIntent().getExtras();
        String url_value= data.getString("target");
        WebFragment fragment = WebFragment.newInstance(url_value);
        replaceFragment(fragment);
    }

    private void replaceFragment(WebFragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragmentWebView, fragment);
        transaction.commit();
    }
}