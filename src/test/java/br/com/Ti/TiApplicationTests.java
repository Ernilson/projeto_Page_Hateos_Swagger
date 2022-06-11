package br.com.Ti;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;

import br.com.Ti.entities.AutomoveisModel;
import br.com.Ti.exceptions.EntityNotFoundException;
import br.com.Ti.services.impl.AutomovelServiceImplemts;

@SpringBootTest
class TiApplicationTests {

	@Autowired
	private AutomovelServiceImplemts car;
	 
//	@Test
//	void contextLoads() {
//		AutomoveisModel auto = new AutomoveisModel();	
//		auto.setNome("Duster");
//		auto.setPreco(50.00);
//		auto.setPlaca("pae1198");
//		auto.setChaci(123456789);
//		auto.setquantidade(1);
//		
//		car.salvar(auto);		
//		
//	}
//	
	@Test
	public void listar(Pageable pageable) {
		List<AutomoveisModel> auto = car.listAll(pageable);
		System.out.println("Total de Registros" + auto.size());
		for (AutomoveisModel aut : auto) {
			System.out.println(aut.getNome()+"-"+ aut.getPlaca());
		}
		
	}
	
// Metodo para Bucar por id
//  @Test
//  public void buscar () {
//      Long t= 2L;
//      Optional<AutomoveisModel> p = car.getId(t);
//      if (p.isEmpty()) {
//		throw new EntityNotFoundException("Erro: o Id não pode ser vazio");
//	}
//       System.out.println (p.get().getNome() + "-" + p.get().getPlaca() + "-" + p.get().getChaci());
//  }
  
  //Metodo para Excluir
//@Test
//public void excluir () {    
//  Long id = 2L; 
//    car.delete(id);;
//}

}
