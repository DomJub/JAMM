package app.repository;

import app.model.Genre;
import app.model.PisteMusicale;
import javafx.collections.ObservableList;

/**
 * Created by Jub on 31/05/2017.
 */
public interface PisteMusicaleRepository extends Repository<PisteMusicale> {
    ObservableList<PisteMusicale> getAllByIdOeuvre();
    ObservableList<PisteMusicale> getAllByIdOeuvre(String tableName, String columnName, String nameOeuvre);
}
