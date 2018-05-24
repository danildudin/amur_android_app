package dating_ml.ru.amur;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import dating_ml.ru.amur.adapter.TabsFragmentAdapter;


public class MainActivity extends AppCompatActivity {
    private static final int LAYOUT = R.layout.activity_main;
    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private ViewPager viewPager;

    public String tinder_id;
    public String tinder_token;
    public String base_url;
    public String auth_response;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppDefault);

        super.onCreate(savedInstanceState);
        setContentView(LAYOUT);

        Bundle b = getIntent().getExtras();
        if (b != null) {
            tinder_id = b.getString("tinder_id");
            tinder_token = b.getString("tinder_token");
            base_url = b.getString("base_url");
            auth_response = b.getString("auth_response");
        }

//        initToolbar();

        drawerLayout = findViewById(R.id.drawer_layout);

        initTabs();
    }


    private void initTabs() {
        viewPager = findViewById(R.id.view_pager);

        TabsFragmentAdapter adapter = new TabsFragmentAdapter(this, getSupportFragmentManager());
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(Constants.MAIN_TAB_INDEX).select();
    }
    
    // to delete
    private void initToolbar() {
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                return false;
            }
        });
    }
}
