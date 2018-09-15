package zjj.bwie.com.zk_demo03.api;




import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;
import zjj.bwie.com.zk_demo03.bean.OneBean;
import zjj.bwie.com.zk_demo03.bean.ShopCartBean;


public interface BaseApiInterface {
    //商品
    @GET("searchProducts")
    Observable<OneBean> getOneBean(@Query("keywords") String keywords,@Query("page") int page);
    //查询购物车
    @GET("product/getCarts")
    Observable<ShopCartBean> getShopCartBean(@Query("uid") int uid);

}
