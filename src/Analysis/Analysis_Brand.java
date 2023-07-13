package Analysis;

import Bean.Bean_T_YBrand;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;


import java.net.URL;
import java.util.ArrayList;
public class Analysis_Brand {
    public ArrayList<Bean_T_YBrand> Method_AS_Brand(){
        ArrayList<Bean_T_YBrand> resultsList= new ArrayList<>();
        try{
            String BeginURL = "https://car.yiche.com/";
            Document documentBrand = Jsoup.parse(new URL(BeginURL).openStream(),"UTF-8",BeginURL);
            Elements Items1 = documentBrand.select(".brand-list-content");
            Elements Items2 = Items1.select(".brand-list");
            Elements Items3 = Items2.select(".brand-list-item");
            Elements Items4 = Items3.select(".item-brand");
            for (int i = 0; i < Items4.size(); i++) {
               String  BrandName = Items4.get(i).attr("data-name");
               String BrandID = Items4.get(i).attr("data-id");
               String BrandURL = "https://car.yiche.com/xuanchegongju/?mid=" + BrandID;
               Bean_T_YBrand beanTYBrand =new Bean_T_YBrand();
               beanTYBrand.set_C_BrandID(BrandID);
               beanTYBrand.set_C_BrandURL(BrandURL);
               beanTYBrand.set_C_BrandName(BrandName);
               resultsList.add(beanTYBrand);
            }
        }catch (Exception ex){
            System.out.println(ex.toString());
        }
        return resultsList;
    }
}
