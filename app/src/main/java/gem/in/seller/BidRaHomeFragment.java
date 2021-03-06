package gem.in.seller;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager.widget.ViewPager;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BidRaHomeFragment extends Fragment {
    private TabLayout tabLayout;
    public ViewPager viewPager;
    TextView bid_ra_status,bidStats,participated;

    public BidRaHomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bid_ra_home, container, false);

        TextView title = (TextView) view.findViewById(R.id.title);
        ImageView back_button = (ImageView) view.findViewById(R.id.back_button);
        back_button.setVisibility(View.GONE);
        title.setText("BID/RA");
        title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().popBackStack();
            }
        });
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        bid_ra_status = (TextView) view.findViewById(R.id.bid_ra_status);
        participated = (TextView) view.findViewById(R.id.participated);
        bidStats = (TextView) view.findViewById(R.id.bidStats);
        setupViewPager(viewPager);
        bid_ra_status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft2= getActivity().getSupportFragmentManager().beginTransaction();
                Bundle args = new Bundle();
                args.putString("type","Bid/RA Status");
                BidRaStatusFragment paymentStatisticsDetailsFragment = new BidRaStatusFragment ();
                paymentStatisticsDetailsFragment.setArguments(args);
                ft2.add(R.id.container, paymentStatisticsDetailsFragment);
                ft2.addToBackStack(null);
                ft2.commit();
            }
        });  bidStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft2= getActivity().getSupportFragmentManager().beginTransaction();
                ft2.add(R.id.container, new BidRaStatsFragment());
                ft2.addToBackStack(null);
                ft2.commit();
            }
        }); participated.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft2= getActivity().getSupportFragmentManager().beginTransaction();
                Bundle args = new Bundle();
                args.putString("type","Participated");
                BidRaStatusFragment paymentStatisticsDetailsFragment = new BidRaStatusFragment ();
                paymentStatisticsDetailsFragment.setArguments(args);
                ft2.add(R.id.container, paymentStatisticsDetailsFragment);
                ft2.addToBackStack(null);
                ft2.commit();
            }
        });
        tabLayout = (TabLayout) view.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        new Handler().postDelayed(
                new Runnable(){
                    @Override
                    public void run() {
                        tabLayout.getTabAt(1).select();
                        tabLayout.getTabAt(0).select();
                    }
                }, 100);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                View view = tab.getCustomView();
                TextView tv = (TextView) view.findViewById(R.id.tvtab1);
                tv.setTextColor(Color.WHITE);
tv.setBackgroundResource(R.drawable.ic_background_edittext_blue);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View view = tab.getCustomView();
                TextView tv = (TextView) view.findViewById(R.id.tvtab1);
                tv.setBackgroundResource(0);
                tv.setTextColor(Color.BLACK);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        for (int i = 0; i < 5; i++)
        {
            View headerView = ((LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                    .inflate(R.layout.custom_tab, null, false);
            TextView tv = (TextView) headerView.findViewById(R.id.tvtab1);
            if (i == 0) {
                tv.setText("Bid/RA");
            }
            if (i == 1) {
                tv.setText("Service");
            }
            if (i == 2) {
                tv.setText("Bunch");
            }if (i == 3) {
                tv.setText("Service Bunch");
            }if (i == 4) {
                tv.setText("Bid to RAs");
            }
            LinearLayout linearLayoutOne = (LinearLayout) headerView.findViewById(R.id.ll);
            tabLayout.getTabAt(i).setCustomView(linearLayoutOne);
        }

        return view;

}

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        adapter.addFragment(new BidFragment(), "");
        adapter.addFragment(new BidFragment(), "");
        adapter.addFragment(new BidFragment(), "");
        adapter.addFragment(new BidFragment(), "");
        adapter.addFragment(new BidFragment(), "");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentStatePagerAdapter
    {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }
}

