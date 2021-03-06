package com.thekadesikhaana;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.thekadesikhaana.adapter.MenuAdapter;

import model.Bengali;
import model.IFoodType;
import model.NorthIndian;
import model.Odia;
import model.Punjabi;

/**
 * Created by ashishchoudhary on 05/02/17.
 */
public class MenuFragment extends Fragment {

    public static final String ARG_MENU = "ARG_MENU";
    private static final String TAG = MenuFragment.class.getSimpleName();

    private RecyclerView recyclerView;
    private IFoodType mFoodStyle;
    private Context mContext;

    public static MenuFragment newInstance() {
        return new MenuFragment();
    }

    public void setFoodStyle(IFoodType foodStyle) {
        mFoodStyle = foodStyle;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(com.thekadesikhaana.R.layout.fragment_menu, container, false);

        recyclerView = (RecyclerView) view.findViewById(com.thekadesikhaana.R.id.menu_recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "ON-RESUME-MENU-FRAGMENT");
        if(mFoodStyle instanceof Bengali) {
            Log.d(TAG, "FoodStyle Bengali");
            recyclerView.setAdapter(new MenuAdapter(mContext, ((Bengali) mFoodStyle).getMenuItems()));
        } else if(mFoodStyle instanceof NorthIndian) {
            Log.d(TAG, "FoodStyle North Indian");
            recyclerView.setAdapter(new MenuAdapter(mContext, ((NorthIndian) mFoodStyle).getMenuItems()));
        } else if(mFoodStyle instanceof Odia) {
            Log.d(TAG, "FoodStyle Odia");
            recyclerView.setAdapter(new MenuAdapter(mContext, ((Odia) mFoodStyle).getMenuItems()));
        } else if(mFoodStyle instanceof Punjabi) {
            Log.d(TAG, "FoodStyle Punjabi");
            recyclerView.setAdapter(new MenuAdapter(mContext, ((Punjabi) mFoodStyle).getMenuItems()));
        } else {
            Log.d(TAG, "INVALID FOOD STYLE");
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
        Log.d(TAG, "ON-ATTACH");
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mContext = activity;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}