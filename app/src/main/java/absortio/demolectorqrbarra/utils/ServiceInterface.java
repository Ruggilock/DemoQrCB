package absortio.demolectorqrbarra.utils;


import java.util.ArrayList;

import absortio.demolectorqrbarra.model.Client;
import absortio.demolectorqrbarra.model.Product;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by ruggi on 11/22/17.
 */

public interface ServiceInterface {
    @GET("finddni/{dni}")
    Call<ArrayList<Client>>getClient(@Path("dni") String cliente);

    @GET("findcodebar/{barcode}")
    Call<ArrayList<Product>>getProduct(@Path("barcode") String barcode);



}
