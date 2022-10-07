package data;

public class PostApiDetails {
	
	float price;
	String category;
	String title;
	String size;
	int stock;
	
	static int id;
	
	public int getId() {
		return PostApiDetails.id;
		
	}
	public void setId(int id) {
		PostApiDetails.id=id;
	}
	
	
    public float getPrice() {
	    return price;
}
	public String getCategory() {
		return category;
	}
	
	public String getTitle() {
		return title;
	}
	public String getSize() {
		return size;
	}
	
	public int getStock() {
		return stock;
	
    }
	
	public void setPrice(float price) {
		this.price=price;
	}
	
	public void setCategory(String category) {
		this.category=category;
	}
	
	public void setTitle(String title) {
		this.title=title;
	}
	
	public void setSize(String size) {
		this.size=size;
	}
	
	public void setStock(int stock) {
		this.stock=stock;	
    }
}
