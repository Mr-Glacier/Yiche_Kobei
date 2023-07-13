import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import Analysis.*;
import java.net.URL;
import java.util.ArrayList;

public class TestTwo {
    public static void main(String[] args) {
        try{
//            String KouBeiURL ="https://dianping.yiche.com/xinaodia6l/koubei";
//            //初步访问口碑网页,进行检查是否具有分页
//            Document documentpageKB = Jsoup.parse(new URL(KouBeiURL).openStream(),"UTF-8",KouBeiURL);
//            Elements pageItems1 = documentpageKB.select(".link-list.pg-item");
//            Elements pageItems2 = pageItems1.select("a");
//            System.out.println(pageItems2.size());
//            if (pageItems2.size() == 1){
//                String pageURL = "https://dianping.yiche.com"+pageItems2.get(0).attr("href");
//                System.out.println(pageURL);
//            }else {
//                System.out.println(pageItems2.get(pageItems2.size()-1).text());
//                int number =  Integer.parseInt(pageItems2.get(pageItems2.size()-1).text());
//                for (int i = 0; i < number; i++) {
////                    String
//
//                }
//            }
//
//
//            Analysis_Pages pages = new Analysis_Pages();
//           ArrayList<String> PageList =  pages.Method_Pages("https://dianping.yiche.com/xinaodia6l/koubei");
//            for (int i = 0; i < PageList.size(); i++) {
//                System.out.println(PageList.get(i));
//            }
        }catch (Exception ex){
            System.out.println(ex.toString());
        }

    }
}
