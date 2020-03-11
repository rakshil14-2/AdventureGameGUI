package application;

//Import libraries

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Hold down an arrow key to have your hero move around the screen.
 * Hold down the shift key to have the hero run.
 */
public class CharacterMovement {
	
	private final int ROOM_WIDTH    = 800;
	private final int ROOM_HEIGHT   = 600;
	private final int START_POSITIONX= 100;
	private final int START_POSITIONY= 100;

    private final String AVATAR_UP =
            "squibbles.png";
    private final String AVATAR_LEFT =
            "left.png";
    private final String AVATAR_RIGHT =
            "right.png";
    private final String AVATAR_DOWN =
            "down.png";
    
   
    private Image avatar1;
    private Image avatarUp;
    private Image avatarLeft;
    private Image avatarRight;
    private Image avatarDown;
    private ImageView  avatar;
    private Node avatarU;
    private Node avatarL;
    private Node avatarR;
    private Node avatarD;
    

    boolean speedy, moveUp, moveDown, moveRight, moveLeft;


    public void movement(){
    	
    	//Image avatar1 = new Image();
        Stage window = new Stage();
    	avatar = new ImageView();
    	
        avatarUp = new Image(AVATAR_UP);
        avatarLeft = new Image(AVATAR_LEFT);
        avatarRight = new Image(AVATAR_RIGHT);
        avatarDown = new Image(AVATAR_DOWN);
        avatarU= new ImageView(avatarUp);
        avatarL = new ImageView(avatarLeft);
        avatarR = new ImageView(avatarRight);
        avatarD = new ImageView(avatarDown);

        avatar.setImage(avatarLeft);
      

        Group map = new Group(avatar);   
        
        
        
        
        
        moveAvatarTo(START_POSITIONX , START_POSITIONY);

     
        Scene scene = new Scene(map, ROOM_WIDTH, ROOM_HEIGHT, Color.LIGHTBLUE);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
            	
 
            	
                switch (event.getCode()) {
                case UP:    moveUp = true; avatar.setImage(avatarUp) ;break;
                case DOWN:  moveDown = true; avatar.setImage(avatarDown); break;
                case LEFT:  moveLeft  = true; avatar.setImage(avatarLeft); break;
                case RIGHT: moveRight  = true; avatar.setImage(avatarRight); break;
                case SHIFT: speedy = true; break;
                
                }
            }
        });

        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                switch (event.getCode()) {
                    case UP:    moveUp = false; break;
                    case DOWN:  moveDown = false; break;
                    case LEFT:  moveLeft  = false; break;
                    case RIGHT: moveRight  = false; break;
                    case SHIFT: speedy = false; break;
                }
            }
            
            
        });

        window.setScene(scene);
        window.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                int dx = 0, dy = 0;

                if (moveUp) dy -= 1;
                if (moveDown) dy += 1;
                if (moveRight)  dx += 1;
                if (moveLeft)  dx -= 1;
                if (speedy) { dx *= 3; dy *= 3; }

                moveAvatarBy(dx, dy);
            }
        };
        timer.start();
	}

    private void moveAvatarBy(int dx, int dy) {
        if (dx == 0 && dy == 0) return;

        final double cx = avatar.getBoundsInLocal().getWidth() / 2 ;
        final double cy = avatar.getBoundsInLocal().getHeight() / 2;

        double x = cx + avatar.getLayoutX() + dx;
        double y = cy + avatar.getLayoutY() + dy;

        moveAvatarTo(x, y);
    }

    private void moveAvatarTo(double x, double y) {
        final double cx = avatar.getBoundsInLocal().getWidth() / 2;
        final double cy = avatar.getBoundsInLocal().getHeight() / 2;

        if (x - cx >= 0 &&
            x + cx <= ROOM_WIDTH &&
            y - cy >= 0 &&
            y + cy <= ROOM_HEIGHT) {
            avatar.relocate(x - cx, y - cy);
        }
    }
}
