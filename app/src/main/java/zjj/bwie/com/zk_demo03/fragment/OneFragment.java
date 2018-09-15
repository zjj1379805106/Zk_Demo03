package zjj.bwie.com.zk_demo03.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import zjj.bwie.com.zk_demo03.R;
import zjj.bwie.com.zk_demo03.adapter.MyOneAdapter;
import zjj.bwie.com.zk_demo03.bean.OneBean;
import zjj.bwie.com.zk_demo03.contract.OneContract;
import zjj.bwie.com.zk_demo03.presenter.OnePresenter;

/**
 * A simple {@link Fragment} subclass.
 */
public class OneFragment extends Fragment implements OneContract.IOneView {


    @BindView(R.id.xrecycler_one)
    XRecyclerView xrecyclerOne;
    Unbinder unbinder;
    private OnePresenter onePresenter;

    private int page=1;
    private List<OneBean.DataBean> list=new ArrayList<>();
    private MyOneAdapter myOneAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        onePresenter = new OnePresenter(this);
        onePresenter.getOne("笔记本",page);
        xrecyclerOne.setLayoutManager(new GridLayoutManager(getContext(),2));
        myOneAdapter = new MyOneAdapter(getActivity(), list);
        xrecyclerOne.setAdapter(myOneAdapter);

        xrecyclerOne.setLoadingMoreEnabled(true);
        xrecyclerOne.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                page=1;
                onePresenter.getOne("笔记本",page);

            }
            @Override
            public void onLoadMore() {
                page++;
                if(page==3){
                    page=2;
                }
                onePresenter.getOne("笔记本",page);
            }
        });
    }


    @Override
    public void onSuccess(OneBean oneBean) {
        List<OneBean.DataBean> data = oneBean.getData();
        if(page==1) {
            list.clear();
        }
        list.addAll(data);

        myOneAdapter.notifyDataSetChanged();
        xrecyclerOne.refreshComplete();
        xrecyclerOne.loadMoreComplete();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

}
