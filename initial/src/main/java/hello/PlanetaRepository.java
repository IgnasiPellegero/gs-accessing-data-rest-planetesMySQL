package hello;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "planeta", path = "planeta")
public interface PlanetaRepository extends PagingAndSortingRepository<Planeta, Long> {

	List<Planeta> findByName(@Param("name") String name);

	List<Planeta> findByMassaBetween (@Param("start") int start, @Param("end") int end);

	List<Planeta> findByMassaLessThan (@Param("start") int start);

	List<Planeta> findByMassaGreaterThan (@Param("start") int start);

	List<Planeta> findByNameAndMassaBetween (@Param("name") String name, @Param("start") int start, @Param("end") int end);

	List<Planeta> findByNameOrMassaBetween (@Param("name") String name, @Param("start") int start, @Param("end") int end);

}

//{"name": "", "history": "", "massa": ""}
//{"name": "pluto", "history": "ieeeep", "massa": "800"}
//{"name": "dragon", "history": "hay muchos dragones viviendo felices", "massa": "8000"}
//{"name": "2DAW", "history": "Eran cusrsos de desrrollador web", "massa": "5500"}
//{"name": "marte", "history": "el planeta rojo", "massa": "3000"}
//{"name": "saturno", "history": "el poder del anillo", "massa": "4378"}
//{"name": "jupiter", "history": "la fuerza del dios brouly", "massa": "456"}
//{"name": "urano", "history": "yeeee", "massa": "5678"}

//http://localhost:8080/planeta/search/findByName?name=pluto
//http://localhost:8080/planeta/search/findByMassaBetween?start=4000&end=8000
//http://localhost:8080/planeta/search/findByMassaLessThan?start=5000
//http://localhost:8080/planeta/search/findByMassaGreaterThan?start=2900
//http://localhost:8080/planeta/search/findByNameAndMassaBetween?name=pluto&start=100&end=1000
//http://localhost:8080/planeta/search/findByNameOrMassaBetween?name=mickey&start=100&end=1000