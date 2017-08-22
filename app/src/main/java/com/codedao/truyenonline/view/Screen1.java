package com.codedao.truyenonline.view;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import com.codedao.truyenonline.R;
import com.codedao.truyenonline.base.BaseActivity;
import com.codedao.truyenonline.model.ApiConnect;
import com.codedao.truyenonline.model.MessageEvent;
import com.codedao.truyenonline.view.fragment.Screen1Fragment;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class Screen1 extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    MaterialSearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        searchView = findViewById(R.id.search_view);
        setSupportActionBar(toolbar);


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        attachScreen1Fragment();
        eventBusInit();
       searchView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               Log.d("minhtq","ahihi");
           }
       });
    }

    private void attachScreen1Fragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content, new Screen1Fragment());
        fragmentTransaction.commit();
    }

    private void eventBusInit() {
        EventBus eventBus = EventBus.getDefault();
        eventBus.register(this);
        ApiConnect apiConnect = new ApiConnect();
        apiConnect.getAllTitleStory();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        if (event.getmEvent().equals("GET_SUCCSESS_LIST")) {
            String[] suggestionListName = new String[event.getmTruyens().size()];
            String[] suggestionListID = new String[event.getmTruyens().size()];
            for (int i = 0; i < suggestionListName.length; i++) {
                suggestionListName[i] = event.getmTruyens().get(i).getmTenTruyen();
                suggestionListID[i] = event.getmTruyens().get(i).getmIdTruyen();
            }
            searchView.setSuggestions(suggestionListName);
        }
    }




    @Override
    protected void setContenView() {
        setContentView(R.layout.activity_screen1);
    }

    @Override
    protected void registerEventView() {

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START) ) {
            drawer.closeDrawer(GravityCompat.START);
        } else  if (searchView.isSearchOpen()){
            searchView.closeSearch();
        }

        else {
            super.onBackPressed();
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.screen1, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (item.getItemId() == R.id.action_searchBar) {
            searchView.showSearch(true);
            searchView.setVisibility(View.VISIBLE);
        }
        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            startActivity(new Intent(Screen1.this,ReaderActivity.class));
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
