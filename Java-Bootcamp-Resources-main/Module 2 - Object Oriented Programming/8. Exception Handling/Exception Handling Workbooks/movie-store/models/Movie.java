package models;

public class Movie {
    private String name;
    private String format;
    private double rating;
    private double sellingPrice;
    private double rentalPrice;
    private boolean isAvailable;

    
    public Movie(String name, String format, double rating) {
        if(name.isBlank() || name == null) {
            throw new IllegalArgumentException("Name cannot be blank/null");
        }
        if(!(format.equalsIgnoreCase("DVD") || format.equalsIgnoreCase("blue-ray"))){
            throw new IllegalArgumentException("format must be 'dvd' or 'blue-ray'");
        }
        if (rating < 0 || rating > 10) {
            throw new IllegalArgumentException("Rating must be betwwen 0 and 10");
        }
        this.name = name;
        this.format = format;
        this.rating = rating;
        this.sellingPrice = format.equals("bluy-ray") ? 4.25 : 2.25;
        this.rentalPrice = format.equals("bluy-ray") ? 1.99 : 0.99;
        this.isAvailable = true;
    }

    public Movie(Movie source) {
        this.name = source.name;
        this.format = source.format;
        this.rating = source.rating;
        this.sellingPrice = source.sellingPrice;
        this.rentalPrice = source.rentalPrice; 
        this.isAvailable = source.isAvailable;
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        if(name.isBlank() || name == null) {
            throw new IllegalArgumentException("Name cannot be blank/null");
        }
        this.name = name;
    }
    public String getFormat() {
        return format;
    }
    public void setFormat(String format) {
        if(!format.equalsIgnoreCase("DVD") || !format.equalsIgnoreCase("blue-ray") || format.isBlank() || format == null){
            throw new IllegalArgumentException("format must be 'dvd' or 'blue-ray'");
        }
        this.format = format;
        setSellingPrice(format.equals("bluy-ray") ? 4.25 : 2.25);
        setRentalPrice(format.equals("bluy-ray") ? 1.99 : 0.99);
    }
    public double getRating() {
        return rating;
    }
    public void setRating(double rating) {
        if (rating < 0 || rating > 10) {
            throw new IllegalArgumentException("Rating must be betwwen 0 and 10");
        }
        this.rating = rating;
    }
    public double getSellingPrice() {
        return sellingPrice;
    }
    private void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }
    public double getRentalPrice() {
        return rentalPrice;
    }
    private void setRentalPrice(double rentalPrice) {
        this.rentalPrice = rentalPrice;
    }
    public boolean isAvailable() {
        return isAvailable;
    }
    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public String toString() {
        return 
            "\t Name: " + this.name + "\n" + 
            "\t Format: " + this.format + "\n" +
            "\t Rating: " + this.rating + "\n" +
            "\t Selling Price: " + this.sellingPrice + "\n" +
            "\t Rental Price: " + this.rentalPrice + "\n" +
            "\t Availability: " + (this.isAvailable ? "in-stock" : "rented") + "\n";
    }

}
