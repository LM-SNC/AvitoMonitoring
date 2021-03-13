import data.ProductSimple;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import utils.ContentUtils;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        ArrayList<ProductSimple> productSimples = new ArrayList<ProductSimple>();
        ContentUtils contentUtils = new ContentUtils(productSimples);

        contentUtils.updateArray(contentUtils.connect("https://www.avito.ru/moskva_i_mo/tovary_dlya_kompyutera/komplektuyuschie-ASgBAgICAUTGB~pm?q=rx+580+8&s=104"));
        System.out.println("<----------ТОВАРЫ---------->");
        contentUtils.productLog();

        while (true) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }

//        for (ProductSimple productSimple : productSimples) {
//            System.out.println("Name: " + productSimple.productName);
//            System.out.println("Price: " + productSimple.price);
//            System.out.println("Id: " + productSimple.id);
//            System.out.println("|--------------------------|");
//        }


    }
}
