package zjj.bwie.com.zk_demo03.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import zjj.bwie.com.zk_demo03.R;
import zjj.bwie.com.zk_demo03.adapter.ShopAdapter;
import zjj.bwie.com.zk_demo03.bean.ShopCartBean;
import zjj.bwie.com.zk_demo03.contract.ShopCartContract;
import zjj.bwie.com.zk_demo03.presenter.ShopCartPresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class TwoFragment extends Fragment implements ShopCartContract.IShopCarView {

    @BindView(R.id.xrecycler_shopcart)
    XRecyclerView xrecyclerShopcart;
    @BindView(R.id.cbox_all)
    CheckBox cboxAll;
    @BindView(R.id.tv_money)
    TextView tvMoney;
    Unbinder unbinder;
    private ShopCartPresenter shopCartPresenter;
    private ShopAdapter shopAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_two, container, false);
        unbinder = ButterKnife.bind(this, view);
        xrecyclerShopcart.setLayoutManager(new LinearLayoutManager(getContext()));
        xrecyclerShopcart.setLoadingMoreEnabled(true);
        xrecyclerShopcart.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                shopCartPresenter.getShops(17403);
            }
            @Override
            public void onLoadMore() {
                xrecyclerShopcart.loadMoreComplete();
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        shopCartPresenter = new ShopCartPresenter(this);
        shopCartPresenter.getShops(17403);
    }

    @Override
    public void onsuccess(ShopCartBean shopCartBeanBean) {
        List<ShopCartBean.DataBean> shopcartdata = shopCartBeanBean.getData();
        shopAdapter = new ShopAdapter(getActivity(), shopcartdata);
        xrecyclerShopcart.setAdapter(shopAdapter);
        xrecyclerShopcart.refreshComplete();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
