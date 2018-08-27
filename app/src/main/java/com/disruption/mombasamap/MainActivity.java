package com.disruption.mombasamap;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;

import com.disruption.mombasamap.data.fragments.CultureFragment;
import com.disruption.mombasamap.data.fragments.HotelsFragment;
import com.disruption.mombasamap.data.fragments.LandmarksFragment;
import com.disruption.mombasamap.data.fragments.ReligionFragment;
import com.disruption.mombasamap.data.fragments.SportsFragment;


public class MainActivity extends AppCompatActivity {

    /*Navigation drawer*/
    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Set the toolbar as the action bar
        android.support.v7.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Enable the app bar's "home" button
        final ActionBar actionbar = getSupportActionBar();
        if (actionbar != null) {
            actionbar.setDisplayHomeAsUpEnabled(true);
        }
        if (actionbar != null) {
            actionbar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }

        mDrawerLayout = findViewById(R.id.drawer_layout);

        //Landing screen
        final View landingScreen = findViewById(R.id.landing_screen);

        //Navigation view
        NavigationView navigationView = findViewById(R.id.nav_view);

        //Listen to clicks on the navigationView and set the appropriate fragment while hiding the landing screen
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);

                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        int position = menuItem.getItemId();
                        switch (position) {
                            case R.id.nav_culture:
                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.content_frame, new CultureFragment())
                                        .addToBackStack(null)
                                        .commit();
                                landingScreen.setVisibility(View.GONE);
                                break;
                            case R.id.nav_religion:
                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.content_frame, new ReligionFragment())
                                        .addToBackStack(null)
                                        .commit();
                                landingScreen.setVisibility(View.GONE);
                                break;
                            case R.id.nav_hotels:
                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.content_frame, new HotelsFragment())
                                        .addToBackStack(null)
                                        .commit();
                                landingScreen.setVisibility(View.GONE);
                                break;
                            case R.id.nav_landmarks:
                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.content_frame, new LandmarksFragment())
                                        .addToBackStack(null)
                                        .commit();
                                landingScreen.setVisibility(View.GONE);
                                break;
                            case R.id.nav_sports:
                                getSupportFragmentManager().beginTransaction()
                                        .replace(R.id.content_frame, new SportsFragment())
                                        .addToBackStack(null)
                                        .commit();
                                landingScreen.setVisibility(View.GONE);
                                break;
                            default:
                                break;
                        }
                        return true;
                    }
                });
    }

    /**
     * To make sure the drawer is opened after clicking the menu icon
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            mDrawerLayout.openDrawer(GravityCompat.START);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
