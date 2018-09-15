package zjj.bwie.com.zk_demo03.presenter;

import zjj.bwie.com.zk_demo03.bean.OneBean;
import zjj.bwie.com.zk_demo03.contract.OneContract;
import zjj.bwie.com.zk_demo03.model.OneModel;

public class OnePresenter implements OneContract.IOnePresenter {
    private OneContract.IOneView iOneView;
    private OneModel oneModel;

    public OnePresenter(OneContract.IOneView iOneView) {
        this.iOneView = iOneView;
        this.oneModel=new OneModel();
    }

    @Override
    public void getOne(String keywords, int page) {
        oneModel.getOneData(keywords, page, new OneContract.IOneModel.OneCallback() {
            @Override
            public void onSuccess(OneBean oneBean) {
                iOneView.onSuccess(oneBean);
            }
        });
    }
}
