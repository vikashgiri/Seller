package gem.in.seller;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import gem.in.seller.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        activityMainBinding.bottomNavigation.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId())
                        {
                            case R.id.home:
                                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                                ft.replace(R.id.container, new HomeFragment());
                                ft.commit();
                                return true;

                        case R.id.order:
                                FragmentTransaction ft1 = getSupportFragmentManager().beginTransaction();
                                ft1.add(R.id.container, new OrderHomeFragment());
                                ft1.addToBackStack(null);
                                ft1.commit();
                                return true;

                        case R.id.bid:
                            FragmentTransaction ft2= getSupportFragmentManager().beginTransaction();
                            ft2.replace(R.id.container, new BidRaHomeFragment());
                                ft2.commit();
                                return true;

                                case R.id.market:
                            FragmentTransaction ft3= getSupportFragmentManager().beginTransaction();
                            ft3.replace(R.id.container, new MarketFragment());
                                ft3.commit();
                                return true;  case R.id.more:

                                    FragmentTransaction ft4= getSupportFragmentManager().beginTransaction();
                            ft4.replace(R.id.container, new MoreFragment());
                                ft4.commit();
                                return true;
                        }
                        return false;
                    }
                });
        activityMainBinding.bottomNavigation.setSelectedItemId(R.id.home);
    }
}
