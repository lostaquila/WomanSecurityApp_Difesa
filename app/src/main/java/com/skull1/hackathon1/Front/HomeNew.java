package com.skull1.hackathon1.Front;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.skull1.hackathon1.Adapter.ScreenSlidePagerAdapter;
import com.skull1.hackathon1.R;
//import com.tomer.fadingtextview.FadingTextView;

public class HomeNew extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

//    private FadingTextView fadingTextView;

    ViewPager pager;
    BottomNavigationView navigation;
    Toolbar toolbar;


    DrawerLayout drawer;
    NavigationView navigationView;

    boolean firstOpen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_new);

        navigation = findViewById(R.id.navigation);


        Intent intent = getIntent();
        firstOpen = intent.getBooleanExtra("firstOpen", false);
        navigation.setOnNavigationItemSelectedListener(this::onNavigationItemSelected);

        toolbar = findViewById(R.id.toolbar);
//        fadingTextView = findViewById(R.id.fading_text_view);

        setSupportActionBar(toolbar);

        getSupportActionBar().setTitle("Home");

        Toolbar toolbar2 = findViewById(R.id.toolbar);
        getSupportActionBar().setTitle("Home");


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        pager = getViewPager();
        pager.setAdapter(new ScreenSlidePagerAdapter(getSupportFragmentManager()));

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {


                if (position == 0) {
                    navigation.setSelectedItemId(R.id.navigation_home);
                    toolbar.setTitle("Home");
                } else if (position == 1) {
                    navigation.setSelectedItemId(R.id.navigation_dashboard);
                    toolbar.setTitle("Dashboard");
                } else if (position == 2) {
                    navigation.setSelectedItemId(R.id.navigation_Profile);
                    toolbar.setTitle("Profile");
                } else if (position == 3) {
                    navigation.setSelectedItemId(R.id.navigation_fourth);
                    toolbar.setTitle("Information Board");
                }
                else if (position == 4) {
                    toolbar.setTitle("Self Defense");
                }
                else if (position == 5) {
                    toolbar.setTitle("News");
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        if (firstOpen == true) {
            Intent loginIntent = new Intent(this, loginpage.class);

            startActivity(loginIntent);
        } else {
            loadFragment(new HomeFragment());
        }


        //getting bottom navigation view and attaching the listener


    }


    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Fragment fragment = null;
        int id = item.getItemId();

        switch (id) {

            case R.id.register: {

                DrawerLayout drawer = findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);

                pager.setCurrentItem(2);

                //do somthing
                return true;
            }
            case R.id.maps: {

                Intent h = new Intent(HomeNew.this, PermissionsActivity.class);
                startActivity(h);

                DrawerLayout drawer = findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);

                //do somthing
                return true;
            }
            case R.id.det: {

                pager.setCurrentItem(4);
                toolbar.setTitle("Self Defense");
                /*fragment = new InfantFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).addToBackStack(null).commit();*/
                DrawerLayout drawer = findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;

                //do somthing
            }
            /*case R.id.schedule: {

                fragment = new EmailActivity();
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).addToBackStack(null).commit();
                DrawerLayout drawer = findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }*/

            /*case R.id.calan: {

                Intent h = new Intent(HomeNew.this, CalendarActivity.class);
                startActivity(h);
                DrawerLayout drawer = findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                //do somthing
                return true;
            }*/

            case R.id.sosmenu: {

                Intent h = new Intent(HomeNew.this, SosActivity.class);
                startActivity(h);
                DrawerLayout drawer = findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                //do somthing
                return true;
            }
            case R.id.shake: {

                Intent h = new Intent(HomeNew.this, MainXActivity.class);
                startActivity(h);
                DrawerLayout drawer = findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                //do somthing
                return true;
            }
            /*case R.id.message: {

                Intent h= new Intent( HomeNew.this,MessageMainActivity.class);
                startActivity(h);
                DrawerLayout drawer = findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                //do somthing
                break;
            }*/

            case R.id.news: {

                pager.setCurrentItem(5);
                toolbar.setTitle("News");

                /*Fragment newsFragment = new NewsActivity();

                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment_container, newsFragment).addToBackStack(null).commit();
                */

                DrawerLayout drawer = findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;

                //do somthing
            }
/*
            case R.id.hard: {

                Intent i = getPackageManager().getLaunchIntentForPackage("com.dev.methk.arduinoandroid");
                startActivity(i);
                //do somthing
                break;
            }
            */


            case R.id.navigation_home: {
                pager.setCurrentItem(0);
                /*fragment = new HomeFragment();*/
                DrawerLayout drawer = findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);

                return true;

            }

            case R.id.navigation_dashboard: {

                pager.setCurrentItem(1);

                return true;
                /*fragment = new DashboardFragment();

                FragmentManager fragmentManager = getSupportFragmentManager();



                fragmentManager
                        .beginTransaction()
                        .replace(R.id.fragment_container, fragment)
                        .commit();*/

                // fragmentManager.popBackStack(fragmentManager.getBackStackEntryAt(0).getId(),FragmentManager.POP_BACK_STACK_INCLUSIVE);

            }

            case R.id.navigation_Profile: {

                pager.setCurrentItem(2);

                return true;
                /*fragment = new ProfileFragment();
                DrawerLayout drawer = findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return loadFragment(fragment);*/
            }

            case R.id.navigation_fourth: {
                pager.setCurrentItem(3);

                return true;
                /*fragment = new FourthFragment();
                DrawerLayout drawer = findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return loadFragment(fragment);*/
            }


        }


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return false;
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } /*else {
            super.onBackPressed();
        }*/

        else {
            pager.setCurrentItem(0);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home_new, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.action_logout) {
            Intent intent = new Intent(HomeNew.this, loginpage.class);
            startActivity(intent);
            finish();



            return true;

        }

        return super.onOptionsItemSelected(item);
    }


    private boolean loadFragment(Fragment fragment) {
        //switching fragment
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    public ViewPager getViewPager() {
        if (null == pager) {
            pager = (ViewPager) findViewById(R.id.fragment_container);
        }
        return pager;
    }

}







