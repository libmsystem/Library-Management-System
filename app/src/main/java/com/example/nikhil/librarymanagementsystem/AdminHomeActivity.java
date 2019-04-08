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
import android.widget.FrameLayout;

import com.example.nikhil.librarymanagementsystem.Base.View.BaseActivity;
import com.example.nikhil.librarymanagementsystem.helper.PreferenceHelper;

public class AdminHomeActivity extends BaseActivity {

    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);
        drawerLayout = findViewById(R.id.admin_drawer_layout);
        AppConstant.member = "Admin";

        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.admin_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(AdminHomeActivity.this, drawerLayout, toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);

        AllBooksFragment fragment = new AllBooksFragment();
        setTitle("Books");
        addFragment(fragment);

        NavigationView navigationView = findViewById(R.id.admin_nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {

                        int id = menuItem.getItemId();

                        if(id == R.id.admin_nav_books){

                            setTitle("Books");
                            AllBooksFragment allBooksFragment = new AllBooksFragment();
                            replaceFragment(allBooksFragment);

                        }
                        else if (id == R.id.admin_nav_logout){
                            mPreferenceHelper.putBoolean(PreferenceHelper.IS_LOGIN,false);
                            AppConstant.member = null;
                            Intent intent = new Intent(AdminHomeActivity.this,LoginActivity.class);
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
                AllBooksFragment Fragment = new AllBooksFragment();
                addFragment(Fragment);
                setTitle("All Books");
                item.setChecked(true);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void addFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .add(R.id.admin_frame_layout, fragment)
                .commit();
    }

    private void replaceFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.admin_frame_layout, fragment)
                .commit();
    }

}
