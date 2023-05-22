package train.dto;

public class FoodDTO {
	
	String food_number;
	String food_type;
	String food_name;
	int food_price;
	String image_location;
	
	public FoodDTO(String food_number, String food_type, String food_name, int food_price, String image_location) {
		this.food_number = food_number;
		this.food_type = food_type;
		this.food_name = food_name;
		this.food_price = food_price;
		this.image_location = image_location;
	}
	
	public String getFood_number() {
		return food_number;
	}
	
	public String getfood_type() {
		return food_type;
	}
	
	
	public String getFood_name() {
		return food_name;
	}
	
	
	public int getFood_price() {
		return food_price;
	}
	
	public String getImage_location() {
		return image_location;
	}	

}