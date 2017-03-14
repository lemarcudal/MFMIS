package com.example.smdojt.manilafame;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.widget.Toast;

import com.example.smdojt.manilafame.Attendees.AttendeesFragment;
import com.example.smdojt.manilafame.Calendar.ScheduleFragment;
import com.example.smdojt.manilafame.Communication.about;
import com.example.smdojt.manilafame.Communication.contact;
import com.example.smdojt.manilafame.Exhibitor.ExhibitorFragment;
import com.example.smdojt.manilafame.ListGalleries.ListGalleryFragment;
import com.example.smdojt.manilafame.Registration_Scanner.QRScanner;
import com.example.smdojt.manilafame.sql_demo.SQLActivity;
import com.example.smdojt.manilafame.sql_demo_2.AndroidPHPMySQL;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    NavigationView navigationView = null;
    Toolbar toolbar = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set the fragment initially
        HomeFragment fragment = new HomeFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction =
                getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.commit();
        //-------------------------'

//        ---Enable fab method in app_bar_main.xml together with these codes------
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //------Below are code declaration for setting font in Navigation Drawer
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        Menu m = navigationView.getMenu();
        for (int i=0;i<m.size();i++) {
            MenuItem mi = m.getItem(i);

            //for aapplying a font to subMenu ...
            SubMenu subMenu = mi.getSubMenu();
            if (subMenu!=null && subMenu.size() >0 ) {
                for (int j=0; j <subMenu.size();j++) {
                    MenuItem subMenuItem = subMenu.getItem(j);
                    applyFontToMenuItem(subMenuItem);
                }
            }

            //the method we have create in activity
            applyFontToMenuItem(mi);
        }
    }

    //set font to use for nav drawer
    private void applyFontToMenuItem(MenuItem mi) {
        Typeface font = Typeface.createFromAsset(getAssets(), "open-sans.regular.ttf"); //raleway or opensans or sourcesanspro
        SpannableString mNewTitle = new SpannableString(mi.getTitle());
        mNewTitle.setSpan(new CustomTypefaceSpan("" , font), 0 , mNewTitle.length(),  Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        mi.setTitle(mNewTitle);
    }

    //default back pressed
    //@Override
    //public void onBackPressed() {
    //    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    //    if (drawer.isDrawerOpen(GravityCompat.END))
    //    {
    //        drawer.closeDrawer(GravityCompat.START);
    //    }
    //    else
    //    {
    //        super.onBackPressed();
    //    }
    //}

    boolean doubleBackToExitPressedOnce = false;
    @Override
    public void onBackPressed()
    {
        //Checking for fragment count on backstack
        if (getSupportFragmentManager().getBackStackEntryCount() > 0)
        {
            getSupportFragmentManager().popBackStack();
        }
        else if (!doubleBackToExitPressedOnce)
        {
            this.doubleBackToExitPressedOnce = true;
            Toast.makeText(this,"Press again to exit.", Toast.LENGTH_SHORT).show();

            new Handler().postDelayed(new Runnable()
            {
                @Override
                public void run() {
                    doubleBackToExitPressedOnce = false;
                }
            }, 2000);
        }
        else
        {
            super.onBackPressed();
            return;
        }
    }

    //----------------The code below displays the 3 dotted settings in the upper right of action bar-----------
    //@Override
    //public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    //   getMenuInflater().inflate(R.menu.main, menu);
    //   return true;
    //}

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home)
        {
            HomeFragment fragment = new HomeFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.addToBackStack(null);//get back to the previous fragment
            fragmentTransaction.commit();
        }
        else if (id == R.id.nav_gallery)
        {
            ListGalleryFragment fragment = new ListGalleryFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.addToBackStack(null);//get back to the previous fragment
            fragmentTransaction.commit();
        }
        else if (id == R.id.nav_exhibitors)
        {
            ExhibitorFragment fragment = new ExhibitorFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.addToBackStack(null);//get back to the previous fragment
            fragmentTransaction.commit();
        }
        else if (id == R.id.nav_attendees)
        {
            AttendeesFragment fragment = new AttendeesFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.addToBackStack(null);//get back to the previous fragment
            fragmentTransaction.commit();
        }
        else if (id == R.id.nav_sched)
        {
            ScheduleFragment fragment = new ScheduleFragment();
            android.support.v4.app.FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
        else if (id == R.id.nav_scanner)
        {
            Intent intent = new Intent(getApplicationContext(), QRScanner.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_about)
        {
            Intent intent = new Intent(getApplicationContext(), about.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_contact)
        {
            Intent intent = new Intent(getApplicationContext(), contact.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_test_db)
        {
            Intent intent = new Intent(getApplicationContext(), SQLActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.nav_test_db_2)
        {
            Intent intent = new Intent(getApplicationContext(), AndroidPHPMySQL.class);
            startActivity(intent);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
