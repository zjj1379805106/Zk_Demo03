package zjj.bwie.com.zk_demo03.contract;

import zjj.bwie.com.zk_demo03.bean.OneBean;

public interface OneContract {
    public interface IOneView{
        void onSuccess(OneBean oneBean);
    }
    public interface IOneModel{
        public interface OneCallback{
            void onSuccess(OneBean oneBean);
        }
        void getOneData(String keywords,int page,OneCallback oneCallback);
    }
    public interface IOnePresenter{
        void getOne(String keywords,int page);
    }
}
