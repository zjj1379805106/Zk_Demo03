package zjj.bwie.com.zk_demo03.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.List;

import zjj.bwie.com.zk_demo03.R;
import zjj.bwie.com.zk_demo03.bean.OneBean;

public class MyOneAdapter extends XRecyclerView.Adapter<MyOneAdapter.MyViewHolder> {
    private Context context;
    private List<OneBean.DataBean> list;

    public MyOneAdapter(Context context, List<OneBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.one_item_layout, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        OneBean.DataBean dataBean = list.get(position);
        holder.img_one.setImageURI(dataBean.getImages().split("\\|")[0]);
        holder.tv_one_name.setText(dataBean.getCreatetime());
        holder.tv_one_cname.setText(dataBean.getPid()+"");
        holder.tv_one_price.setText("￥"+dataBean.getPrice());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView img_one;
        private final TextView tv_one_name;
        private final TextView tv_one_cname;
        private final TextView tv_one_price;

        public MyViewHolder(View itemView) {
            super(itemView);
            img_one = itemView.findViewById(R.id.img_one);
            tv_one_name = itemView.findViewById(R.id.tv_one_name);
            tv_one_cname = itemView.findViewById(R.id.tv_one_cname);
            tv_one_price = itemView.findViewById(R.id.tv_one_price);
        }
    }
}
