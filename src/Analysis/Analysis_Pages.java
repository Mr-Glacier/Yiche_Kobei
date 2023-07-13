package Analysis;

import Bean.Bean_Pages;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import static java.lang.System.currentTimeMillis;

public class Analysis_Pages {
    public ArrayList<String> Method_Pages(String KBURL) throws IOException {
        ArrayList<String> PageList = new ArrayList<>();
        try {
            Document documentpageKB = Jsoup.parse(new URL(KBURL).openStream(), "UTF-8", KBURL);
            Elements pageItems1 = documentpageKB.select(".link-list.pg-item");
            Elements pageItems2 = pageItems1.select("a");
            System.out.println("是否有分页:  " + pageItems2.size());
            if (pageItems2.size() == 1) {
                String pageURL = "https://dianping.yiche.com" + pageItems2.get(0).attr("href");
                PageList.add(pageURL);
            } else {
                System.out.println("实际分页个数: "+pageItems2.get(pageItems2.size() - 1).text());
                int number = Integer.parseInt(pageItems2.get(pageItems2.size() - 1).text());
                for (int i = 1; i <= number; i++) {
                    if (i == 1) {
                        String pageURL = "https://dianping.yiche.com" + pageItems2.get(0).attr("href");
                        PageList.add(pageURL);
                    } else {
                        //https://dianping.yiche.com/xinaodia6l/koubei-3.html
                        String pageURLFirst = "https://dianping.yiche.com" + pageItems2.get(0).attr("href");
                        String pageURLSecond = pageURLFirst.substring(0, pageURLFirst.length() - 1) + "-" + i + ".html";
                        PageList.add(pageURLSecond);
                    }
                }
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(Files.newOutputStream(Paths.get("F:/A_易车数据/Error/ERRO3口碑无网址/"+currentTimeMillis()+"ERROR.text")), 165537);
            bufferedOutputStream.write(KBURL.getBytes());
            bufferedOutputStream.close();
        }
        return PageList;
    }
}
