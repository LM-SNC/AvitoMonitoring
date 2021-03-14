package utils;

import data.ProductSimple;
import managers.UtilsManager;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class ContentUtils {
    private ArrayList<ProductSimple> productSimples;
    UtilsManager utilsManager;

    public ContentUtils(ArrayList<ProductSimple> productSimples, UtilsManager utilsManager) {
        this.utilsManager = utilsManager;
        this.productSimples = productSimples;
    }

    public Document connect(String url) throws IOException {
        return Jsoup.connect(url).userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.82 Safari/537.36").get();
    }

    public void productLog() {
        for (ProductSimple productSimple : productSimples) {
            System.out.println("Name: " + productSimple.productName + "\n" + "Price: " + productSimple.price + "\n" + "Id: " + productSimple.id);
            System.out.println("|-------------------------------------|");
        }
    }

    public void addItmToArray(Element elem) {
        ProductSimple productSimple = new ProductSimple();
        productSimple.id = elem.attr("data-item-id");
        productSimple.productName = elem.select(".iva-item-titleStep-2bjuh").text();
        productSimple.price = elem.select(".price-price-32bra").text();
        productSimples.add(productSimple);
    }

    public void updateArray(Document document) {
        Elements element = getElements(document);
        for (Element elem : element) {
          addItmToArray(elem);
        }
    }

    public Elements getElements(Document document) {
        return document.select(".items-items-38oUm").get(0).
                getElementsByClass("iva-item-root-G3n7v photo-slider-slider-3tEix iva-item-list-2_PpT items-item-1Hoqq items-listItem-11orH js-catalog-item-enum");

    }

    public Elements getShopItems(Document document) {
        return document.select(".items-items-38oUm").get(0).
                getElementsByClass("iva-item-root-G3n7v photo-slider-slider-3tEix iva-item-list-2_PpT items-item-1Hoqq items-listItem-11orH js-catalog-item-enum");
    }

    public int counter(Document document) {
        return Integer.parseInt(document.select(".page-title-count-1oJOc").text());
    }
}
