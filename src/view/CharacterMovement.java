package view;
/**
 * Importing libraries
 */
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
 * Hold down an arrow key to have your avatar move around the screen.
 * Hold down the shift key to have the avatar run.
 */

public class CharacterMovement  {
	
	/**
	 * Character Movement Class
	 * Attributes for current character objects (images, window).
	 * Handles Key Events to move avatar around the window.
	 */
	
	
	/**
	 * The "room" or window width and height for player movement demo,
	 * the start position for the avatar X and Y values.
	 */
	
	private final int ROOM_WIDTH    = 800;
	private final int ROOM_HEIGHT   = 600;
	private final int START_POSITIONX= 100;
	private final int START_POSITIONY= 100;

	/**
	 * Images for each direction the avatar moves
	 * The image for the avatar changes based on whether it is going up, down, left or right.
	 */
	
    private final String AVATAR_UP =
            "/photos/squibbles.png";
    private final String AVATAR_LEFT =
            "/photos/left.png";
    private final String AVATAR_RIGHT =
            "/photos/right.png";
    private final String AVATAR_DOWN =
            "/photos/down.png";
    
    /**
     * Images for each direction
     * ImageView for the avatar
     */
   
    private Image avatarUp;
    private Image avatarLeft;
    private Image avatarRight;
    private Image avatarDown;
    private ImageView  avatar;
    
    /**
     * Booleans to check which direction avatar is moving
     * Boolean speedy to check if shift button is being pressed
     */

    boolean speedy, moveUp, moveDown, moveRight, moveLeft;

    /**
     * movement: sets up initial images
     * 		  sets scene 
     * 		  handles key events
     * 		  uses switch statements with cases and booleans in event handlers 
     * 		  puts avatar to start position
     * 		  makes avatar a group to inherit the images/positions
     */

    public void movement() {
    	
    	Stage window = new Stage();
    	avatar = new ImageView();
    	
        avatarUp = new Image(AVATAR_UP);
        avatarLeft = new Image(AVATAR_LEFT);
        avatarRight = new Image(AVATAR_RIGHT);
        avatarDown = new Image(AVATAR_DOWN);

        avatar.setImage(avatarLeft);
      

        Group map = new Group(avatar);   
        
       
        
        
        moveAvatarTo(START_POSITIONX , START_POSITIONY);

        
        Scene scene = new Scene(map, ROOM_WIDTH, ROOM_HEIGHT, Color.LIGHTBLUE);
        
        /**
         * handles what program does when key events with each arrow key occur.
         * When up key is pressed move up and change image to up image, 
         * down key pressed move avatar down and change avatar to down image,
         * left key pressed move avatar left and change avatar to left image, 
         * right key pressed move avatar right and change avatar to right image.
         * When shift key is pressed move avatar at faster speed.
         * each case checks a boolean and then
         * @param event is a KeyEvent for the arrow keys and shift button. 
         */
        
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

        /**
         * handles what program does when key events are not occurring.
         * @param event is a KeyEvent for the arrow keys and shift button.
         */
        
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

        /**
         * Times animation 
         * (movement)
         */
        AnimationTimer timer = new AnimationTimer() {
        	/**
             * Here handle method handles the distance in pixels to move the avatar
             * based on the booleans of whether the key events are happening.
             */
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
/**
 * MoveAvatarBy checks how much distance to move the avatar.
 * @param dx distance to move avatar in X direction.
 * @param dy distance to move avatar in Y direction.
 */
    
    private void moveAvatarBy(int dx, int dy) {
        if (dx == 0 && dy == 0) return;

        final double cx = avatar.getBoundsInLocal().getWidth() / 2 ;
        final double cy = avatar.getBoundsInLocal().getHeight() / 2;

        double x = cx + avatar.getLayoutX() + dx;
        double y = cy + avatar.getLayoutY() + dy;

        moveAvatarTo(x, y);
    }

    /**
     * MoveAvatarTo gets location of where to move avatar by checking bounds
     * And calculating X and Y positions.
     * @param x represents X location of avatar.
     * @param y represents Y location of avatar.
     */
    
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