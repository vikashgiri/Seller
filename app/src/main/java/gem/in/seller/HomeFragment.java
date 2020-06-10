package gem.in.seller;


import android.os.Bundle;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;

import java.util.Timer;

import gem.in.seller.databinding.FragmentHomeBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    public HomeFragment() {
        // Required empty public constructor
    }
    Timer timer=null;
    FragmentHomeBinding binding;

    public static Fragment newInstance() {
        HomeFragment fragment = new HomeFragment();
                return fragment;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
         binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false);
        HomeFragmentItemAdapter adapter = new HomeFragmentItemAdapter(getActivity());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        linearLayoutManager.setStackFromEnd(true);
       //LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, true);
        binding.recyclerView.setLayoutManager(linearLayoutManager);
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.smoothScrollToPosition(0);
        binding.incident.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft2= getActivity().getSupportFragmentManager().beginTransaction();
                ft2.replace(R.id.container, new IncidentStatusFragment());
                ft2.commit();
            }
        });  binding.productAndService.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft2= getActivity().getSupportFragmentManager().beginTransaction();
                ft2.replace(R.id.container, new ProductAndServiceFragment());
                ft2.commit();
            }
        });

        return  binding.getRoot();
    }
    }
