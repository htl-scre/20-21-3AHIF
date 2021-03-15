package users.presentation;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import users.domain.User;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private ListView<User> listView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        listView.getItems()
                .addAll(new User("Bob", "https://refactoring.guru/images/content-public/logos/logo-covid-2x.png"),
                        new User("Abby", "https://images.webuntis.com/image/7053500/ngKyk2oxXb4q9Z89cmbjae7pYVmBR6vP"),
                        new User("Hugo", "https://i.pinimg.com/originals/63/87/4b/63874bf0109712f70991f193e3ba01ea.jpg"));

        listView.setCellFactory(lv -> new UserListCell());
    }
}
