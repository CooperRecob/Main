package edu.apcs.testReview;

import java.util.ArrayList;

public class ReviewCollector {
    private ArrayList<ProductReview> reviewList;
    private ArrayList<String> productList;

    /**
     * Constructs a ReviewCollector object and initializes the instance variables.
     */
    public ReviewCollector() {
        reviewList = new ArrayList<ProductReview>();
        productList = new ArrayList<String>();
    }

    /**
     * Write the addReview method, which adds a single product review, represented
     * by a ProductReview object, to the ReviewCollector object. The addReview
     * method does the following when it adds a product review.
     *
     * The ProductReview object is added to the reviewList instance variable.
     * The product name from the ProductReview object is added to the productList
     * instance variable if the product name is not already found in productList.
     */
    public void addReview(ProductReview prodReview) {
        reviewList.add(prodReview);
        if (!productList.contains(prodReview.getName())) {
            productList.add(prodReview.getName());
        }
    }

    /**
     * Write the getNumGoodReviews method, which returns the number of good reviews
     * for a given product name. A review is considered good if it contains the
     * string "best" (all lowercase). If there are no reviews with a matching
     * product name, the method returns 0. Note that a review that contains "BEST"
     * or "Best" is not considered a good review (since not all the letters of
     * "best" are lowercase), but a review that contains "asbestos" is considered a
     * good review (since all the letters of "best" are lowercase).
     */

    public int getNumGoodReviews(String prodName) {
        int numGoodReviews = 0;
        for (ProductReview review : reviewList) {
            if (review.getName().equals(prodName)) {
                if (review.getReview().contains("best")) {
                    numGoodReviews++;
                }
            }
        }
        return numGoodReviews;
    }

    // There may be instance variables, constructors, and methods not shown.
}
