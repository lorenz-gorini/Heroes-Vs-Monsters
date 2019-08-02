package heroes.animation;

import heroes.components.Character;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CharacImage extends ImageView {
	Character imageChar;
	CharacImage(){super();}
	CharacImage(Image image,Character hero){
		super(image);
		this.imageChar=hero;
	}
	public Character getImageChar() {
		return imageChar;
	}
	public void setImageChar(Character imageHero) {
		this.imageChar = imageHero;
	}
	
}
