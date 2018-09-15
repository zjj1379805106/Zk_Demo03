package zjj.bwie.com.zk_demo03.presenter;

import zjj.bwie.com.zk_demo03.bean.ShopCartBean;
import zjj.bwie.com.zk_demo03.contract.ShopCartContract;
import zjj.bwie.com.zk_demo03.model.ShopCartModel;

public class ShopCartPresenter implements ShopCartContract.IShopCartPresenter {

    private ShopCartModel shopCartModel;
    private ShopCartContract.IShopCarView iShopCarView;

    public ShopCartPresenter(ShopCartContract.IShopCarView iShopCarView) {
        this.iShopCarView = iShopCarView;
        this.shopCartModel=new ShopCartModel();
    }

    @Override
    public void getShops(int uid) {
        shopCartModel.requestShops(uid, new ShopCartContract.IShopCartModel.OnRequestListenter() {
            @Override
            public void onSortSuccess(ShopCartBean shopCartBeanBean) {
                iShopCarView.onsuccess(shopCartBeanBean);
            }
        });
    }
}
