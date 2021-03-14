package managers;

import data.ProductSimple;
import utils.CompareUtils;
import utils.ContentUtils;

import java.util.ArrayList;

public class UtilsManager {
    public ContentUtils contentUtils;
    public CompareUtils compareUtils;

    ArrayList<ProductSimple> productSimples;
    public UtilsManager(ArrayList<ProductSimple> productSimples) {
        contentUtils = new ContentUtils(productSimples, this);
        compareUtils = new CompareUtils(productSimples, this);

        this.productSimples = productSimples;
    }
}