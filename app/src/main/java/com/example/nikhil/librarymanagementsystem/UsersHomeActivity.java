package com.example.nikhil.librarymanagementsystem;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.example.nikhil.librarymanagementsystem.Base.View.BaseActivity;
import com.example.nikhil.librarymanagementsystem.helper.PreferenceHelper;

public class UsersHomeActivity extends BaseActivity {

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_home);
        AppConstant.member = "Users";

        drawerLayout = findViewById(R.id.users_drawer_layout);

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.users_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(UsersHomeActivity.this, drawerLayout, toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        AllBooksFragment fragment = new AllBooksFragment();
        setTitle("Books");
        addFragment(fragment);



        NavigationView navigationView = findViewById(R.id.users_nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {

                        int id = menuItem.getItemId();

                        if (id == R.id.users_nav_books){
                            setTitle("Books");
                        }
                        else if(id == R.id.users_nav_logout){
                            mPreferenceHelper.putBoolean(PreferenceHelper.IS_LOGIN,false);
                            AppConstant.member = null;
                            Intent intent = new Intent(UsersHomeActivity.this,LoginActivity.class);
                            startActivity(intent);
                        }

                        menuItem.setChecked(true);
                        drawerLayout.closeDrawers();
                        return true;
                    }
                });
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void addFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.users_frame_layout, fragment)
                .commit();
    }


}
