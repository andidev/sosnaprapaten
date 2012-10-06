package naprapat.queries;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import siena.Model;
import siena.Query;

public abstract class GenericQuery<T> {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected Query<T> query = Model.all(((Class)((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]));

	private String idFieldName = getIdFieldName();

	protected String getIdFieldName() {
		return "id";
	}

	public GenericQuery<T> filterById(Long id) {
		if (id != null) {
			query.filter(idFieldName, id);
		}
		else {
			query.filter(idFieldName, -1L);
		}

		return this;
	}

	public List<T> fetch() {
		return query.fetch();
	}

	public List<T> fetch(int limit) {
		return query.fetch(limit);
	}

	public T get() {
		return query.get();
	}
}
