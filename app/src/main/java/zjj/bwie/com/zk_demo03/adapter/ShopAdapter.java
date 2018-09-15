package zjj.bwie.com.zk_demo03.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import zjj.bwie.com.zk_demo03.R;
import zjj.bwie.com.zk_demo03.bean.ShopCartBean;

public class ShopAdapter extends XRecyclerView.Adapter<ShopAdapter.MyViewHolder> {

    private Context context;
    private List<ShopCartBean.DataBean> list;
    public ShopAdapter(Context context, List<ShopCartBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }



    @NonNull
    @Override
    public ShopAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.shopitem_layout, parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ShopAdapter.MyViewHolder holder, int position) {
        final ShopCartBean.DataBean dataBean = list.get(position);
        holder.tv_shopName.setText("我是"+dataBean.getSellerName());
        holder.recycle_shops.setLayoutManager(new LinearLayoutManager(context));
         ShopsAdapter shopsAdapter = new ShopsAdapter(context, dataBean.getList());
        holder.recycle_shops.setAdapter(shopsAdapter);
    }

    @Override
    public int getItemCount() {
        return list.size() == 0 ?0:list.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final RecyclerView recycle_shops;
        private final CheckBox cbox_shop;
        private final TextView tv_shopName;

        public MyViewHolder(View itemView) {
            super(itemView);
            tv_shopName = itemView.findViewById(R.id.tv_shopName);
            cbox_shop = itemView.findViewById(R.id.cbox_shop);
            recycle_shops = itemView.findViewById(R.id.recycle_shops);
        }
    }
}
