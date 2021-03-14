import data.ProductSimple;
import managers.UtilsManager;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import utils.CompareUtils;
import utils.ContentUtils;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {



        ArrayList<ProductSimple> productSimples = new ArrayList<ProductSimple>();
        UtilsManager utilsManager = new UtilsManager(productSimples);


        String url = "https://www.avito.ru/rossiya/tovary_dlya_kompyutera/komplektuyuschie-ASgBAgICAUTGB~pm?cd=1&q=rx+580+8";

        Document document = null;
        document = utilsManager.contentUtils.connect(url);

        utilsManager.contentUtils.updateArray(document);
        Element element = document.select(".pagination-root-2oCjZ").get(0);
        for (int i = 1; i < Integer.parseInt(element.child(element.children().size() - 2).text()); i++) {
            Thread.sleep(2000);
            utilsManager.contentUtils.updateArray(utilsManager.contentUtils.connect(url + "&p=" + i));
            System.out.println("Page " + i + " upload");
        }

        System.out.println(productSimples);


//        contentUtils.updateArray(contentUtils.connect(url));
//        System.out.println("<----------ТОВАРЫ---------->");
//        contentUtils.productLog();
//
//        while (true) {
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            Elements elements = contentUtils.getElements(contentUtils.connect(url));
//
////            compareUtils.onSellChecker(elements);
//            compareUtils.onAddChecker(elements);
//
//
//        }

//        for (ProductSimple productSimple : productSimples) {
//            System.out.println("Name: " + productSimple.productName);
//            System.out.println("Price: " + productSimple.price);
//            System.out.println("Id: " + productSimple.id);
//            System.out.println("|--------------------------|");
//        }


    }
}
