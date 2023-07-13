package Analysis;

import Bean.Bean_T_YModel;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.net.URL;
import java.util.ArrayList;

public class Analysis_Model {

    public ArrayList<Bean_T_YModel> Method_Model(String BrandURL,String BrandName) {
        ArrayList<Bean_T_YModel> resultList = new ArrayList<>();
        try {
            Document documentModel = Jsoup.parse(new URL(BrandURL).openStream(), "UTF-8", BrandURL);
            Element idEL = documentModel.getElementById("pagination-list");
            Elements ItemModel = idEL.select(".pagenation-box.ssr-box");
            Elements ItemModel1 = ItemModel.select(".link-list.pg-item");
            Elements ItemModel2 = ItemModel1.select("a");
            if (ItemModel2.size() == 0) {
                System.out.println("此网址内无车型");
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream("F:/A_易车数据/Error/ERRO1品牌无车型/"+BrandName+"+品牌内无车型.text", true), 165537);//165537
                bufferedOutputStream.write(BrandURL.getBytes());
                bufferedOutputStream.close();
            } else {
                for (int i = 0; i < ItemModel2.size(); i++) {
                    String PagesURL = "https://car.yiche.com" + ItemModel2.get(i).select("a").attr("href");
                    Document documentPages = Jsoup.parse(new URL(PagesURL).openStream(), "UTF-8", PagesURL);
                    //此处进行分页处理.去获取分页后的URL
                    Elements Item1 = documentPages.select(".search-result-wrapper");
                    Elements Item2 = Item1.select(".search-result-list");
                    Elements Item3 = Item2.select(".search-result-list-item");
                    for (int j = 0; j < Item3.size(); j++) {
                        String ModelID = Item3.get(j).attr("data-id");
                        Elements Item4 = Item3.get(j).select(".cx-name.text-hover");
                        String ModelName = Item4.text();
                        String ModelURL = "https://car.yiche.com" + Item3.get(j).select("a").attr("href");
                        Bean_T_YModel beanTYModel = new Bean_T_YModel();
                        beanTYModel.set_C_ModelID(ModelID);
                        beanTYModel.set_C_ModelName(ModelName);
                        beanTYModel.set_C_ModelURL(ModelURL);
                        resultList.add(beanTYModel);
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }
        return resultList;
    }

}
