package users.presentation;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import users.domain.User;

import java.io.IOException;

public class UserListCell extends ListCell<User> {

    @FXML
    private Text text;

    @FXML
    private ImageView imageView;

    private FXMLLoader loader;

    @Override
    protected void updateItem(User user, boolean empty) {
        super.updateItem(user, empty);
        if (empty || user == null) {
            setGraphic(null);
            setText(null);
            return;
        }
        boolean fxmlLoaded = loader != null;
        if (!fxmlLoaded) {
            loader = new FXMLLoader(getClass().getResource("/single-user.fxml"));
            loader.setController(this);
            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        bindUser(user);
        setGraphic(loader.getRoot());
    }

    private void bindUser(User user) {
        text.setText(user.name());
        var image = new Image(user.imageUrl());
        imageView.setImage(image);
    }
}
