package zjj.bwie.com.zk_demo03.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import zjj.bwie.com.zk_demo03.R;
import zjj.bwie.com.zk_demo03.bean.ShopCartBean;

public class ShopsAdapter extends RecyclerView.Adapter<ShopsAdapter.MyViewHolder> {

    private Context context;
    private List<ShopCartBean.DataBean.ListBean> shopslist;

    public ShopsAdapter(Context context, List<ShopCartBean.DataBean.ListBean> shopslist) {
        this.context = context;
        this.shopslist = shopslist;
    }

    @NonNull
    @Override
    public ShopsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.shopsitem_layout, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ShopsAdapter.MyViewHolder holder, final int position) {
        final ShopCartBean.DataBean.ListBean listBean = shopslist.get(position);
        holder.tv_title.setText(listBean.getTitle());
        holder.tv_price.setText("优惠价：￥"+listBean.getBargainPrice());
        holder.img_shops.setImageURI(shopslist.get(position).getImages().split("\\|")[0]);


    }

    @Override
    public int getItemCount() {
        return shopslist.size() ==0?0:shopslist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final CheckBox cbox_shops;
        private final SimpleDraweeView img_shops;
        private final TextView tv_price;
        private final TextView tv_title;

        public MyViewHolder(View itemView) {
            super(itemView);
            cbox_shops = itemView.findViewById(R.id.cbox_shops);
            img_shops = itemView.findViewById(R.id.img_shops);
            tv_price = itemView.findViewById(R.id.tv_price);
            tv_title = itemView.findViewById(R.id.tv_title);
        }
    }
}
