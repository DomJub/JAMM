package app.repository;

import app.model.OeuvreSearch;
import app.repository.impl.Search;

/**
 * Created by Philippe on 22/05/2017.
 */
public interface SearchRepository extends Repository<OeuvreSearch>, Search<OeuvreSearch> {
}
