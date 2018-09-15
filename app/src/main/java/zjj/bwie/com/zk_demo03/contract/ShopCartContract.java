package zjj.bwie.com.zk_demo03.contract;

import zjj.bwie.com.zk_demo03.bean.ShopCartBean;

public interface ShopCartContract {
    public interface IShopCarView {
        void onsuccess(ShopCartBean shopCartBeanBean);
    }
    public interface IShopCartModel{
        void requestShops(int uid, OnRequestListenter onRequestListenter);
        interface OnRequestListenter{
            void onSortSuccess(ShopCartBean shopCartBeanBean);
        }
    }
    public interface IShopCartPresenter{
        void getShops(int uid);
    }

}
