package ti.developer.com.aventon.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import ti.developer.com.aventon.Fragments.HomeFragment;
import ti.developer.com.aventon.Helper.OnClearFromRecentService;
import ti.developer.com.aventon.R;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    selectFragment(item);
                    return true;
                case R.id.navigation_dashboard:

                    return true;
                case R.id.navigation_notifications:

                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        startService(new Intent(getBaseContext(), OnClearFromRecentService.class));
        selectFragment(navigation.getMenu().getItem(0));

    }

    private void selectFragment(MenuItem item){
        Fragment fragmentoGenerico = null;
        switch (item.getItemId()){
            case R.id.navigation_home:
                fragmentoGenerico = new HomeFragment();
                break;
            case R.id.navigation_dashboard:
                break;
            case R.id.navigation_notifications:
                break;
        }

        if(fragmentoGenerico != null){
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.setCustomAnimations(R.anim.fadein, R.anim.fadeout, R.anim.enter_from_right, R.anim.exit_to_left);
            transaction.replace(R.id.content, fragmentoGenerico);
            transaction.commit();
        }
    }

}
