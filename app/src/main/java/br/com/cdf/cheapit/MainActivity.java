package br.com.cdf.cheapit;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnTabSelectListener;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {

    BottomBar bottomBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        //Remove o menu de 3 bolinhas a direita do toolbar
        //setSupportActionBar(toolbar);

        HomeFragment fragment = new HomeFragment();
        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction
                .replace(R.id.fragment_container, fragment)
                .commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);

        toggle.setDrawerIndicatorEnabled(false); //disable "hamburger to arrow" drawable

        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ImageButton ibHomeLogo = (ImageButton)findViewById(R.id.ibHomeLogo);
        ibHomeLogo.setOnClickListener(this);

        ImageButton ibMyCoupons = (ImageButton)findViewById(R.id.ibMyCoupons);
        ibMyCoupons.setOnClickListener(this);


        bottomBar = (BottomBar) findViewById(R.id.bottomBar);
        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId) {
                    case (R.id.tab_home):
                        HomeFragment fragment = new HomeFragment();
                        android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                        fragmentTransaction
                                .replace(R.id.fragment_container, fragment)
                                .commit();
                        break;
                    case (R.id.tab_coupons):
                        CouponFragment couponFragment = new CouponFragment();
                        android.support.v4.app.FragmentTransaction couponfragmentTransaction = getSupportFragmentManager().beginTransaction();
                        couponfragmentTransaction
                                .replace(R.id.fragment_container, couponFragment)
                                .commit();
                        break;
                    case (R.id.tab_fav):
                        FavoritesFragment favoritesFragment = new FavoritesFragment();
                        android.support.v4.app.FragmentTransaction favfragmentTransaction = getSupportFragmentManager().beginTransaction();
                        favfragmentTransaction
                                .replace(R.id.fragment_container, favoritesFragment)
                                .commit();
                        break;
                    case (R.id.tab_map):
                        GuideFragment guideFragment = new GuideFragment();
                        android.support.v4.app.FragmentTransaction guidefragmentTransaction = getSupportFragmentManager().beginTransaction();
                        guidefragmentTransaction
                                .replace(R.id.fragment_container, guideFragment)
                                .commit();
                        break;
                }
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            bottomBar.getTabAtPosition(0).performClick();

        } else if (id == R.id.nav_coupons) {
            bottomBar.getTabAtPosition(1).performClick();
        } else if (id == R.id.nav_map) {
            bottomBar.getTabAtPosition(3).performClick();
        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ibHomeLogo:
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.openDrawer(GravityCompat.START);

//                HomeFragment fragment = new HomeFragment();
//                android.support.v4.app.FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
//                fragmentTransaction
//                        .replace(R.id.fragment_container, fragment)
//                        .commit();
                break;
            case R.id.ibMyCoupons:
                bottomBar.selectTabAtPosition(1);    //simula o clique sem chamar as acoes
                MyCouponsFragment myCouponsFragment = new MyCouponsFragment();
                android.support.v4.app.FragmentTransaction couponfragmentTransaction = getSupportFragmentManager().beginTransaction();
                couponfragmentTransaction
                        .replace(R.id.fragment_container, myCouponsFragment)
                        .commit();
                break;
            default: break;
        }
    }
}
