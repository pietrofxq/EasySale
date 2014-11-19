package easysale.util;
import java.util.*;

// Classe de métodos de utilidade estáticos

public abstract class EasyUtil {
	
	// Método para evitar o warning "The expression of type List needs unchecked conversion"
	// Usagem: List<Pessoa> pessoas = castList(Pessoa.class, /* método que retorna a lista */)
	public static <T> List<T> castList(Class<? extends T> clazz, Collection<?> c) {
	    List<T> r = new ArrayList<T>(c.size());
	    for(Object o: c)
	      r.add(clazz.cast(o));
	    return r;
	}
}
