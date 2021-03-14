package utils;

import data.ProductSimple;
import managers.UtilsManager;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;

public class CompareUtils {
    ArrayList<ProductSimple> productSimples;
    UtilsManager utilsManager;
    public CompareUtils(ArrayList<ProductSimple> productSimples, UtilsManager utilsManager) {
        this.productSimples = productSimples;
        this.utilsManager = utilsManager;
    }

    public void onSellChecker(Elements elements) {
        boolean isSell;
        for (ProductSimple productSimple : productSimples) {
            isSell = true;
            for(Element element : elements) {
                if(productSimple.id.equals(element.attr("data-item-id"))) {
                    isSell = false;
                    break;
                }
            }
            if(isSell) {
                System.out.println("Товар " + productSimple.productName + " продан");
            }
        }
    }

    public void onAddChecker(Elements elements) {
        boolean isAdded;
        for(Element element : elements) {
            isAdded = true;
            for (ProductSimple productSimple : productSimples) {
                if(productSimple.id.equals(element.attr("data-item-id"))) {
                    isAdded = false;
                }
            }
            if (isAdded) {
                System.out.println("Товар " + element.select(".iva-item-titleStep-2bjuh").text() + " был добавлен!");
                utilsManager.contentUtils.addItmToArray(element);
            }
        }
    }
}
