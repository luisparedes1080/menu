package com.example.clasepractica;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    FrameLayout frm_home;
    BottomNavigationView btn_navigation;

    InicioFragment inicioFragment = new InicioFragment();
    ContactosFragment contactosFragment = new ContactosFragment();
    CuentaFragment cuentaFragment = new CuentaFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        frm_home = findViewById(R.id.frm_home);
        btn_navigation = findViewById(R.id.btn_navigation);
        loadFragment(inicioFragment);
        btn_navigation.setOnItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId()==R.id.nav_inicio) {
                    loadFragment(inicioFragment);
                    return true;
                } else (item.getItemId()==R.id.nav_contactos){
                    loadFragment(contactosFragment);
                    return true;
                }
                return false;
            }
        });
    }
    public void loadFragment (Fragment fr){
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frm_home,fr);
        transaction.commit();
    }
}