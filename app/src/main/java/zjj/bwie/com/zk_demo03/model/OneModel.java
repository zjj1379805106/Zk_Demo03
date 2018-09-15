package zjj.bwie.com.zk_demo03.model;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import zjj.bwie.com.zk_demo03.api.BaseApiInterface;
import zjj.bwie.com.zk_demo03.bean.OneBean;
import zjj.bwie.com.zk_demo03.contract.OneContract;
import zjj.bwie.com.zk_demo03.utils.RetrofitUtils;

public class OneModel implements OneContract.IOneModel {
    @Override
    public void getOneData(String keywords, int page, final OneCallback oneCallback) {
        BaseApiInterface api = RetrofitUtils.getInstence().getApi();
        Observable<OneBean> oneBean = api.getOneBean(keywords, page);
        oneBean.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<OneBean>() {
                    @Override
                    public void accept(OneBean oneBean) throws Exception {
                        oneCallback.onSuccess(oneBean);
                    }
                });
    }
}
