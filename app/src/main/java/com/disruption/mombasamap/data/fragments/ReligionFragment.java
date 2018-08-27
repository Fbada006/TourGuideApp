package com.disruption.mombasamap.data.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.disruption.mombasamap.R;
import com.disruption.mombasamap.data.Feature;
import com.disruption.mombasamap.data.FeatureAdapter;

import java.util.ArrayList;
import java.util.Objects;

/**
 * A {@link Fragment} subclass to show the cultural features in Mombasa town.
 */
public class ReligionFragment extends Fragment implements FeatureAdapter.RecyclerViewClickListener {

    /*Empty constructor*/
    public ReligionFragment() {

    }

    /*ArrayList of features*/
    private ArrayList<Feature> mFeatures;

    /*Toast*/
    private Toast mToast;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.feature_list, container, false);

        //Make sure that the user can go back to the landing screen
        final View landingScreen = Objects.requireNonNull(getActivity()).findViewById(R.id.landing_screen);
        Toolbar toolbar = rootView.findViewById(R.id.toolbar_fragment);
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back);
        toolbar.setTitle(getString(R.string.category_religion));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Objects.requireNonNull(getActivity()).onBackPressed();
                landingScreen.setVisibility(View.VISIBLE);
            }
        });

        //Create an ArrayList of features using the constructor declared in the Feature class
        mFeatures = new ArrayList<>();
        mFeatures.add(new Feature(getString(R.string.religion_vineyard), getString(R.string.religion_address_vineyarf), R.drawable.religion_images));
        mFeatures.add(new Feature(getString(R.string.religion_cathedral), getString(R.string.religion_address_cathedral), R.drawable.religion_images));
        mFeatures.add(new Feature(getString(R.string.religion_pentecostal), getString(R.string.religion_address_pentecostal), R.drawable.religion_images));
        mFeatures.add(new Feature(getString(R.string.religion_celebration), getString(R.string.religion_address_celebration), R.drawable.religion_images));
        mFeatures.add(new Feature(getString(R.string.religion_vineyard), getString(R.string.religion_address_vineyarf), R.drawable.religion_images));
        mFeatures.add(new Feature(getString(R.string.religion_cathedral), getString(R.string.religion_address_cathedral), R.drawable.religion_images));
        mFeatures.add(new Feature(getString(R.string.religion_pentecostal), getString(R.string.religion_address_pentecostal), R.drawable.religion_images));
        mFeatures.add(new Feature(getString(R.string.religion_celebration), getString(R.string.religion_address_celebration), R.drawable.religion_images));
        mFeatures.add(new Feature(getString(R.string.religion_vineyard), getString(R.string.religion_address_vineyarf), R.drawable.religion_images));
        mFeatures.add(new Feature(getString(R.string.religion_cathedral), getString(R.string.religion_address_cathedral), R.drawable.religion_images));
        mFeatures.add(new Feature(getString(R.string.religion_pentecostal), getString(R.string.religion_address_pentecostal), R.drawable.religion_images));
        mFeatures.add(new Feature(getString(R.string.religion_celebration), getString(R.string.religion_address_celebration), R.drawable.religion_images));


        //Find the recyclerView
        RecyclerView recyclerView = rootView.findViewById(R.id.list_recycler_view);

        //An instance of the adapter
        FeatureAdapter mFeatureAdapter = new FeatureAdapter(mFeatures, R.color.category_religion, this);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(Objects.requireNonNull(getActivity()), LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        //Set adapter
        recyclerView.setAdapter(mFeatureAdapter);

        // notify adapter about data set changes so that it will render the list with new data
        mFeatureAdapter.notifyDataSetChanged();

        return rootView;
    }

    /*Override this method to ensure that the welcome text is displayed after pressing the back button*/
    @Override
    public void onResume() {
        super.onResume();

        final View landingScreen = Objects.requireNonNull(getActivity()).findViewById(R.id.landing_screen);

        Objects.requireNonNull(getView()).setFocusableInTouchMode(true);
        getView().requestFocus();
        getView().setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_BACK) {
                    Objects.requireNonNull(getActivity()).onBackPressed();
                    landingScreen.setVisibility(View.VISIBLE);
                    return true;
                }
                return false;
            }
        });

    }

    @Override
    public void onRecyclerViewItemClicked(View view, int position) {
        //Get the current feature
        Feature feature = mFeatures.get(position);

        //Cancel a toast is the user clicks rapidly
        if (mToast != null) {
            mToast.cancel();
        }

        //Make a toast
        mToast = Toast.makeText(getActivity(), getString(R.string.clicked_feature_toast) + feature.getFeatureName(), Toast.LENGTH_LONG);
        mToast.show();
    }
}
