package com.example.administrator.myapplication.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.myapplication.R;
import com.example.administrator.myapplication.adapter.MenuAdapter;
import com.example.administrator.myapplication.net.HttpResult;
import com.example.administrator.myapplication.net.HttpUtil;
import com.example.administrator.myapplication.net.entity.Menu;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class LifeFragment extends Fragment {
private View mView;
private RecyclerView mRecyclerView;
private List<Menu> mMenus;
private MenuAdapter mMenuAdapter;
    public LifeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView=inflater.inflate(R.layout.fragment_life, container, false);
        initView();
        init();
        return mView;
    }

    private void initView() {
        mRecyclerView=(RecyclerView)mView.findViewById(R.id.recycler_view);
    }
    private void init(){
      mMenus=new ArrayList<>();
      mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
      mMenuAdapter=new MenuAdapter(R.layout.item_view,mMenus);
        mRecyclerView.setAdapter(mMenuAdapter);
     HttpUtil.getInstance().getMenu(new Callback<HttpResult<List<Menu>>>() {
       @Override
       public void onResponse(Call<HttpResult<List<Menu>>> call, Response<HttpResult<List<Menu>>> response) {
         HttpResult<List<Menu>> result=response.body();
         List<Menu> data=result.getData();
           mMenuAdapter.addData(data);
       }

       @Override
       public void onFailure(Call<HttpResult<List<Menu>>> call, Throwable t) {
           Log.i("TAG",t.toString());
       }
   });
    }


}
