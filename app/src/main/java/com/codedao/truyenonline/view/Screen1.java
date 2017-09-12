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

import com.codedao.materialsearchview.MaterialSearchView;
import com.codedao.materialsearchview.Story;
import com.codedao.truyenonline.R;
import com.codedao.truyenonline.base.BaseActivity;
import com.codedao.truyenonline.model.ApiConnect;
import com.codedao.truyenonline.model.MessageEvent;
import com.codedao.truyenonline.model.Truyen;
import com.codedao.truyenonline.view.fragment.Screen1Fragment;
import com.codedao.truyenonline.view.fragment.StoryChapterFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

public class Screen1 extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    MaterialSearchView searchView;
    //private FrameLayout mFrameLayoutSetting;
    //private CustomSettingView mCustomSettingView;



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

    }

    private void attachScreen1Fragment() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.content, new Screen1Fragment());
        fragmentTransaction.addToBackStack("Screen1Fragment");
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
            final List<Truyen> truyenList = event.getmTruyens();
            int size = event.getmTruyens().size();
            List<Story> stories=new ArrayList<>();
            for (int i=0;i<size;i++){
                stories.add(new Story(truyenList.get(i).getmIdTruyen()
                        ,truyenList.get(i).getmTenTruyen()));
            }


            final String[] suggestionListName = new String[event.getmTruyens().size()];
            final String[] suggestionListID = new String[event.getmTruyens().size()];
            for (int i = 0; i < suggestionListName.length; i++) {
                suggestionListName[i] = event.getmTruyens().get(i).getmTenTruyen();
                suggestionListID[i] = event.getmTruyens().get(i).getmIdTruyen();
            }
            searchView.setSuggestions(stories);
            searchView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                 Story a = (Story) adapterView.getItemAtPosition(i);
                    Log.d("Nam","name="+a.getValue().toString()+" id="+a.getKey().toString());
                }
            });
        }
    }


    @Override
    protected void setContenView() {
        setContentView(R.layout.activity_screen1);
    }

    @Override
    protected void registerEventView() {
//        mFrameLayoutSetting = findViewById(R.id.frame_setting);
//        mCustomSettingView = findViewById(R.id.float_setting);
//
//        mFrameLayoutSetting.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(mCustomSettingView.isOutsite()){
//                    mFrameLayoutSetting.setVisibility(View.GONE);
//                }else {
//                    mCustomSettingView.setOutsite(true);
//                    mFrameLayoutSetting.setVisibility(View.GONE);
//                }
//            }
//        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else if (searchView.isSearchOpen()) {
            searchView.closeSearch();
        } else {
            if (StoryChapterFragment.adapter != null) {
                getSupportFragmentManager().beginTransaction()
                        .remove(StoryChapterFragment.adapter.getItem(0))
                        .remove(StoryChapterFragment.adapter.getItem(1))
                        .commit();
            }
            int fragments = getSupportFragmentManager().getBackStackEntryCount();
            if (fragments == 1) {
                finish();
            } else {
                if (getFragmentManager().getBackStackEntryCount() > 1) {
                    getFragmentManager().popBackStack();
                } else {
                    super.onBackPressed();
                }
            }
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

        if (id == R.id.nav_read_offline) {
            // Handle the camera action
            Toast.makeText(this, "Chờ phiên bản tiếp nhé !", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_like) {
            Toast.makeText(this, "Đã bảo chờ phiên bản tiếp rồi !", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_night_mode) {
            //mFrameLayoutSetting.setVisibility(View.VISIBLE);
        } else if (id == R.id.nav_setting) {
            Toast.makeText(this, "Mệt em vl, chờ phiên bản sau nhé !", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_version) {
            Toast.makeText(this, "I am sorry ! Đừng gỡ app", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_policy) {
            Toast.makeText(this, "Dừng lại tại đây thôi !", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_vote) {
            //SystemClock.sleep(1000);
            Toast.makeText(this, "Em nhây vl !", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_feedback) {
            Toast.makeText(this, "Em gỡ mịa app đi !", Toast.LENGTH_SHORT).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }





}
