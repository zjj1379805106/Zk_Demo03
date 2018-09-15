package zjj.bwie.com.zk_demo03.model;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import zjj.bwie.com.zk_demo03.api.BaseApiInterface;
import zjj.bwie.com.zk_demo03.bean.ShopCartBean;
import zjj.bwie.com.zk_demo03.contract.ShopCartContract;
import zjj.bwie.com.zk_demo03.utils.RetrofitUtils;


public class ShopCartModel implements ShopCartContract.IShopCartModel {
    @Override
    public void requestShops(int uid, final OnRequestListenter onRequestListenter) {
        BaseApiInterface api = RetrofitUtils.getInstence().getApi();
        Observable<ShopCartBean> shopCartBean = api.getShopCartBean(uid);
        shopCartBean.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ShopCartBean>() {
                    @Override
                    public void accept(ShopCartBean shopCartBean) throws Exception {
                        onRequestListenter.onSortSuccess(shopCartBean);
                    }
                });
    }
}
