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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class BidResultFragment extends Fragment {

    public BidResultFragment() {
        // Required empty public constructor
    }

ViewPager viewPager;
    TabLayout tabLayout;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_bid_result, container, false);
        TextView title = (TextView) view.findViewById(R.id.title);
        title.setText(R.string.bid_result);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        setupViewPager(viewPager);

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
                tv.setBackgroundResource(R.drawable.ic_background_edittext_gray);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                View view = tab.getCustomView();
                TextView tv = (TextView) view.findViewById(R.id.tvtab1);
                tv.setBackgroundResource(0);
                tv.setTextColor(Color.WHITE);
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        for (int i = 0; i < 3; i++)
        {
            View headerView = ((LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                    .inflate(R.layout.custom_tab, null, false);
            TextView tv = (TextView) headerView.findViewById(R.id.tvtab1);
            tv.setTextColor(Color.WHITE);
            if (i == 0) {
                tv.setText("Bid Details");
            }
            if (i == 1) {
                tv.setText("Technical Evalution");
            }
            if (i == 2) {
                tv.setText("Financial Evalution");
            }
            LinearLayout linearLayoutOne = (LinearLayout) headerView.findViewById(R.id.ll);
            tabLayout.getTabAt(i).setCustomView(linearLayoutOne);
        }

        return view;

    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getActivity().getSupportFragmentManager());
        adapter.addFragment(new BidResultDetailFragment(), "");
        adapter.addFragment(new BidResultTechnicalEvaluationFragment(), "");
        adapter.addFragment(new BidResultFinancialEvaluationFragment(), "");
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

