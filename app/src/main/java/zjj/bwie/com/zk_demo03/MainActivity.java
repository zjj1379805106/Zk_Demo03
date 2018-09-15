package zjj.bwie.com.zk_demo03;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hjm.bottomtabbar.BottomTabBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import zjj.bwie.com.zk_demo03.fragment.OneFragment;
import zjj.bwie.com.zk_demo03.fragment.ThreeFragment;
import zjj.bwie.com.zk_demo03.fragment.TwoFragment;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btb)
    BottomTabBar btb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        btb.init(getSupportFragmentManager()).setImgSize(130,130)
                .setFontSize(16)
                .setTabPadding(0,0,0)
                .setChangeColor(Color.RED,Color.BLACK)
                .addTabItem("新品",R.drawable.new_icon_press,R.drawable.new_icon,OneFragment.class)
                .addTabItem("精选",R.drawable.choice_icon_press,R.drawable.choice_icon,ThreeFragment.class)
                .addTabItem("分类",R.drawable.classify_icon_press,R.drawable.classify_icon,ThreeFragment.class)
                .addTabItem("我的衣橱",R.drawable.wardrobe_icon_press,R.drawable.wardrobe_icon,TwoFragment.class)
                .addTabItem("个人中心",R.drawable.person_icon_press,R.drawable.person_icon,ThreeFragment.class)
                .isShowDivider(true);
    }
}
